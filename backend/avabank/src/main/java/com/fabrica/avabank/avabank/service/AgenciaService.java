package com.fabrica.avabank.avabank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrica.avabank.avabank.entities.Agencia;
import com.fabrica.avabank.avabank.repositories.AgenciaRepository;

@Service
public class AgenciaService {
  
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public List<Agencia> listarAgencias() {
		return agenciaRepository.findAll();
	}
	
	public Agencia listarAgenciaPorId(int id) {
		return agenciaRepository.getReferenceById(id);
	}
	
	public Agencia incluirAgencia(Agencia agencia) {
		return agenciaRepository.save(agencia);
	}

}