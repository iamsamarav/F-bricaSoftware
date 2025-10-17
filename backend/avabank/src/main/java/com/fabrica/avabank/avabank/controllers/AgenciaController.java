package com.fabrica.avabank.avabank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.avabank.avabank.entities.Agencia;
import com.fabrica.avabank.avabank.service.AgenciaService;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {
	
	@Autowired(required = true)
	private AgenciaService agenciaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Agencia>> listar(){
		return new ResponseEntity<List<Agencia>>(
				agenciaService.listarAgencias(), HttpStatus.OK);
	}
	
	@GetMapping("/lista/{id}")
	public ResponseEntity<Agencia> listarPorId(@PathVariable int id){
		return new ResponseEntity<Agencia>(
				agenciaService.listarAgenciaPorId(id), HttpStatus.OK);
	}
	
	@PostMapping("/incluir")
	public ResponseEntity<?> incluir(@RequestBody Agencia agencia){
		try {
			return new ResponseEntity<Agencia>(agenciaService.incluirAgencia(agencia), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}