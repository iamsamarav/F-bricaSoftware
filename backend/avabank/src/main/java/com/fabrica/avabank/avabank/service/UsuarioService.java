package com.avanade.avabank.avabank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.avabank.avabank.entities.Administrador;
import com.avanade.avabank.avabank.entities.Conta;
import com.avanade.avabank.avabank.repositories.AdministradorRepository;
import com.avanade.avabank.avabank.repositories.ContaRepository;

@Service
public class UsuarioService {
	
    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private ContaRepository contaRepository;


    public String getNomeByUsername(String username) {
    	
        Optional<Administrador> administrador = administradorRepository.findByUsername(username);
        if (administrador.isPresent()) {
            return administrador.get().getNome();
        }
        return buscarNomeCliente(username);
    }

    
    private String buscarNomeCliente(String identificador) {
        try {
            String[] parts = identificador.split("-");
            if (parts.length != 2) {
                return null;
            }

            String numeroAgencia = parts[0];
            int numeroConta = Integer.parseInt(parts[1]);

            Optional<Conta> conta = contaRepository.findByNumeroAndAgencia_Numero(numeroConta, numeroAgencia);
            if (conta.isPresent()) {
                Conta contaEncontrada = conta.get();
                if (contaEncontrada.getCliente() != null) {
                    return contaEncontrada.getCliente().getNome();
                }
            }
        } catch (NumberFormatException e) {
            return null; 
        }
        return null; 
    }

}
