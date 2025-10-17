package com.fabrica.avabank.avabank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.avabank.avabank.entities.Administrador;
import com.fabrica.avabank.avabank.service.AdministradorService;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {
	
	@Autowired
	private AdministradorService administradorService;
	
	@GetMapping("/lista")
	public ResponseEntity<?> listar(){
		try {
			return new ResponseEntity<List<Administrador>>(administradorService.listar(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/incluir")
	public ResponseEntity<?> incluir(@RequestBody Administrador administrador){
		try {
			return new ResponseEntity<Administrador>(administradorService.incluir(administrador), HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
