package com.fabrica.avabank.avabank.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.avabank.avabank.dtos.ChavePixDTO;
import com.fabrica.avabank.avabank.service.ChavePixService;

@RestController
@RequestMapping("/chavespix")
public class ChavePixController {

	@Autowired
	private ChavePixService chavePixService;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<ChavePixDTO>> listarChavesPixDTO(){
		return new ResponseEntity<List<ChavePixDTO>>(
				chavePixService.listarChavesPixDTO(), HttpStatus.OK);
	}
	
	@PostMapping("/incluir")
	public ResponseEntity<?> incluir(@RequestBody Map<String, String> dados){
		try {
			return new ResponseEntity<String>(chavePixService.incluirChave(dados), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/lista/{numero}")
	public ResponseEntity<List<ChavePixDTO>> listarChavePixPorConta(@PathVariable(name = "numero") String numero){
		
		return new ResponseEntity<List<ChavePixDTO>>(
					chavePixService.listarChavesPixDTOPorConta(numero), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> remover(@PathVariable(name = "id") int id){
		try {
			return new ResponseEntity<String>(chavePixService.removerChavePix(id), HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
