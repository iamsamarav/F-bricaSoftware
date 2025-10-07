package com.avanade.avabank.avabank.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.avabank.avabank.dtos.ContaDTO;
import com.avanade.avabank.avabank.entities.Cliente;
import com.avanade.avabank.avabank.entities.Conta;
import com.avanade.avabank.avabank.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Conta>> listar(){
		return new ResponseEntity<List<Conta>>(
				contaService.listarContas(), HttpStatus.OK);
	}
	
	@GetMapping("/lista/{username}")
	public ResponseEntity<List<ContaDTO>> listarPorAdmin(@PathVariable String username){
		return new ResponseEntity<List<ContaDTO>>(
				contaService.buscarConta(username), HttpStatus.OK);
	}
	
	@PostMapping("/incluir")
	public ResponseEntity<?> incluir(@RequestBody Map<String, String> dados){
		try {
			return new ResponseEntity<String>(contaService.incluir(dados), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/alterar/{numero}")
	public ResponseEntity<Conta> alterar(
			@RequestBody Conta conta, @PathVariable long numero){
		return new ResponseEntity<Conta>(
				contaService.alterarConta(conta, numero), HttpStatus.ACCEPTED);
	}
}
