package com.avanade.avabank.avabank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avanade.avabank.avabank.dtos.ClienteDTO;
import com.avanade.avabank.avabank.entities.Cliente;
import com.avanade.avabank.avabank.entities.Endereco;
import com.avanade.avabank.avabank.repositories.ClienteRepository;
import com.avanade.avabank.avabank.security.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtUtil jwtUtil;
	
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	public Cliente cadastrarCliente(Cliente cliente) {
		
	    if (cliente.getEndereco() == null) {
	        throw new IllegalArgumentException("O campo 'endereco' é obrigatório.");
	    }
	    
	    cliente.setSenha(encoder.encode(cliente.getSenha()));
	    
//        emailService.notificarCliente(cliente, "567643", "763557");
	    return clienteRepository.save(cliente);
	}
	
	public ClienteDTO clienteToken() {
		String token = request.getHeader("Authorization");
        token = token.substring(7);
        String email = jwtUtil.getUserName(token);
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(email);  

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            return ClienteDTO.toDto(cliente);
        }

        return null;  
    }

	
	public Cliente buscarCliente(int id) {
		return clienteRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para o ID: " + id));
		}
	
	
	public Cliente alterarCliente(Cliente cliente, String cpf) {

	    Optional<Cliente> clienteExistente = clienteRepository.findByCpf(cpf);

	    	if (clienteExistente.isPresent()) {
	        Cliente clienteAtualizado = clienteExistente.get(); 

	        clienteAtualizado.setNome(cliente.getNome());
	        clienteAtualizado.setDataNascimento(cliente.getDataNascimento());
	        clienteAtualizado.setEmail(cliente.getEmail());
	        clienteAtualizado.setTelefone(cliente.getTelefone());

	        if (cliente.getSenha() != null && !cliente.getSenha().isEmpty()) {
	            clienteAtualizado.setSenha(encoder.encode(cliente.getSenha()));
	        }


	        if (cliente.getEndereco() != null) {
	            Endereco enderecoAtualizado = clienteAtualizado.getEndereco(); 
	            
	            enderecoAtualizado.setBairro(cliente.getEndereco().getBairro());
	            enderecoAtualizado.setCep(cliente.getEndereco().getCep());
	            enderecoAtualizado.setCidade(cliente.getEndereco().getCidade());
	            enderecoAtualizado.setComplemento(cliente.getEndereco().getComplemento());
	            enderecoAtualizado.setEstado(cliente.getEndereco().getEstado());
	            enderecoAtualizado.setLogradouro(cliente.getEndereco().getLogradouro());
	            enderecoAtualizado.setUf(cliente.getEndereco().getUf());

	            clienteAtualizado.setEndereco(enderecoAtualizado); 
	        }

	        return clienteRepository.save(clienteAtualizado); 
	    } else {
	        throw new RuntimeException("Cliente com CPF " + cpf + " não encontrado.");
	    }
	}




	

}
