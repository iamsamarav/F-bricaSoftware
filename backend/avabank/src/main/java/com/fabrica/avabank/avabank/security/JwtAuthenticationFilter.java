package com.avanade.avabank.avabank.security;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.avanade.avabank.avabank.dtos.AdminLoginDTO;
import com.avanade.avabank.avabank.dtos.ClienteLoginDTO;
import com.avanade.avabank.avabank.entities.Conta;
import com.avanade.avabank.avabank.repositories.AdministradorRepository;
import com.avanade.avabank.avabank.repositories.ContaRepository;
import com.avanade.avabank.avabank.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private UsuarioService usuarioService;
    private AdministradorRepository administradorRepository;
    private ContaRepository contaRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioService usuarioService,AdministradorRepository administradorRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ContaRepository contaRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
        this.administradorRepository = administradorRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.contaRepository = contaRepository;

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            String body = new String(request.getInputStream().readAllBytes());
            ObjectMapper mapper = new ObjectMapper();

            if (body.contains("numeroAgencia") && body.contains("numeroConta")) {
                ClienteLoginDTO login = mapper.readValue(body, ClienteLoginDTO.class);
                return authenticateCliente(login);
            } else if (body.contains("username")) {
                AdminLoginDTO login = mapper.readValue(body, AdminLoginDTO.class);
                return authenticateAdmin(login);
            }

            throw new AuthenticationException("Formato de login inválido") {};
        } catch (IOException e) {
            throw new AuthenticationServiceException("Erro ao processar autenticação", e);
        }
    }

    private Authentication authenticateCliente(ClienteLoginDTO login) {
        String username = String.format("%s-%s", login.getNumeroAgencia(), login.getNumeroConta()); 
        validateClienteCredentials(username, login.getSenha());
        
        Optional<Conta> conta = contaRepository.findByNumeroAndAgencia_Numero(login.getNumeroConta(), login.getNumeroAgencia());

        if (conta.isPresent()) {
            conta.get().setDataUltimoAcesso(new Date());
            contaRepository.save(conta.get());
            
        }
        return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, login.getSenha())
        );
        
    }

    private Authentication authenticateAdmin(AdminLoginDTO login) {
        validateAdminCredentials(login.getUsername(), login.getSenha());
        return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(login.getUsername(), login.getSenha())
        );
    }
    
    private void validateClienteCredentials(String username, String senha) {
        String[] parts = username.split("-");
//        String agencia = parts[0];
//        long numeroConta = Long.parseLong(parts[1]);
        
        if (parts.length != 2) {
            throw new BadCredentialsException("O username não está no formato esperado (agência-numeroConta).");
        }
        var conta = contaRepository.findByNumeroAndAgencia_Numero(Long.parseLong(parts[1]), parts[0])
            .orElseThrow(() -> new BadCredentialsException("Credenciais inválidas"));

        if (!bCryptPasswordEncoder.matches(senha, conta.getCliente().getSenha())) {
            throw new BadCredentialsException("Senha incorreta");
        }
    }

    private void validateAdminCredentials(String username, String senha) {
        var admin = administradorRepository.findByUsername(username)
            .orElseThrow(() -> new BadCredentialsException("Credenciais inválidas"));

        if (!bCryptPasswordEncoder.matches(senha, admin.getSenha())) {
            throw new BadCredentialsException("Senha incorreta");
        }
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                             Authentication authResult) throws IOException, ServletException {
        String username = ((UserDetails) authResult.getPrincipal()).getUsername();
        String role = authResult.getAuthorities().stream().findFirst().get().toString();
        String nome;

        if (role.equals("ADMIN")) {
            var admin = administradorRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Admin não encontrado"));
            nome = admin.getNome();
        } else {
            String[] parts = username.split("-");
            
            if (parts.length != 2) {
                throw new IllegalArgumentException("O username não está no formato esperado (agência-numeroConta).");
            }
            String agencia = parts[0]; 
            String numeroConta = parts[1]; 
            
            var cliente = contaRepository.findByNumeroAndAgencia_Numero(Long.parseLong(numeroConta), agencia)
                    .get().getCliente();

            nome = cliente.getNome();
        }

        try {
            String token = jwtUtil.generateToken(username, role, nome);        
            response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            response.addHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.AUTHORIZATION);
        } catch (Exception e) {
            System.out.println("Erro ao gerar token: " + e.getMessage());
            e.printStackTrace();
        }

}
}
    
    

