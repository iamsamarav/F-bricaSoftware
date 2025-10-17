package com.fabrica.avabank.avabank.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.avabank.avabank.entities.Transacao;
import com.fabrica.avabank.avabank.service.TransacaoService;

@RequestMapping("/transacoes")
@RestController
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		try {
			return new ResponseEntity<List<Transacao>>(transacaoService.listar(), HttpStatus.OK);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/deposito/incluir")
	public ResponseEntity<?> incluirDeposito(@RequestBody Map<String, String> transacao){
		try {	
			return new ResponseEntity<Transacao>(transacaoService.incluirDeposito(transacao), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/boleto/incluir")
	public ResponseEntity<?> incluirBoleto(@RequestBody Map<String, String> transacao){
		try {	
			return new ResponseEntity<Transacao>(transacaoService.pagarBoleto(transacao), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/saque/incluir")
	public ResponseEntity<?> incluirSaque(@RequestBody Map<String, String> transacao){
		try {	
			return new ResponseEntity<Transacao>(transacaoService.incluirSaque(transacao), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/pix/incluir")
	public ResponseEntity<?> incluirPix(@RequestBody Map<String, String> transacao){
		try {	
			return new ResponseEntity<Transacao>(transacaoService.incluirSaque(transacao), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/transferencia/incluir")
	public ResponseEntity<?> incluirTransferencia(@RequestBody Map<String, String> transacao){
		try {	
			return new ResponseEntity<Transacao>(transacaoService.incluirSaque(transacao), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
