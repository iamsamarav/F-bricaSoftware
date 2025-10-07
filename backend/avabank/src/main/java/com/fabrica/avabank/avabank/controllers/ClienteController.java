package com.avanade.avabank.avabank.controllers;

import java.util.List;

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

import com.avanade.avabank.avabank.entities.Cliente;
import com.avanade.avabank.avabank.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/lista")
	public ResponseEntity<List<Cliente>> listar() {
		return new ResponseEntity<List<Cliente>>(clienteService.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/lista/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable int id) {
		return new ResponseEntity<Cliente>(clienteService.buscarCliente(id), HttpStatus.OK);
	}
	
	@PostMapping("/incluir")
	public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
		try {
			Cliente client = clienteService.cadastrarCliente(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(client);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/alterar/{cpf}")
	public ResponseEntity<Cliente> alterar(
			@RequestBody Cliente cliente, @PathVariable String cpf){
		return new ResponseEntity<Cliente>(
				clienteService.alterarCliente(cliente, cpf), HttpStatus.ACCEPTED);
	}

}
