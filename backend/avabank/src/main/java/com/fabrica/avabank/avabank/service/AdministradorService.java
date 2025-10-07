package com.avanade.avabank.avabank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avanade.avabank.avabank.entities.Administrador;
import com.avanade.avabank.avabank.repositories.AdministradorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
    @Autowired
    private BCryptPasswordEncoder encoder;

	
	public Administrador incluir(Administrador administrador) {
		administrador.setSenha(encoder.encode(administrador.getSenha()));
        return administradorRepository.save(administrador);
	}
	
	public List<Administrador> listar(){
		return administradorRepository.findAll();
	}
	
	public Administrador buscarAdministrador(int id) {
		return administradorRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Administrador não encontrado para o ID: " + id));
	}
}
