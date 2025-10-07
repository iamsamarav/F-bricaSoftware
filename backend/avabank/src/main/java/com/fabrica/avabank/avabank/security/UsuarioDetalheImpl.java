package com.avanade.avabank.avabank.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avanade.avabank.avabank.entities.Conta;
import com.avanade.avabank.avabank.repositories.AdministradorRepository;
import com.avanade.avabank.avabank.repositories.ContaRepository;

@Service
public class UsuarioDetalheImpl implements UserDetailsService{
	
	
    private final AdministradorRepository administradorRepository;
    private final ContaRepository contaRepository;
      

	public UsuarioDetalheImpl(AdministradorRepository administradorRepository, ContaRepository contaRepository) {
		super();
		this.administradorRepository = administradorRepository;
		this.contaRepository = contaRepository;
	}


	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return administradorRepository.findByUsername(username)
            .map(admin -> (UserDetails) admin)
            .orElseGet(() -> loadCliente(username));
    }

    private UserDetails loadCliente(String username) {
        try {
            var parts = username.split("-");
            return contaRepository.findByNumeroAndAgencia_Numero(
                Integer.parseInt(parts[1]), parts[0]
            )
            .map(Conta::getCliente)
            .orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado"));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuário não encontrado", e);
        }
    }
}
