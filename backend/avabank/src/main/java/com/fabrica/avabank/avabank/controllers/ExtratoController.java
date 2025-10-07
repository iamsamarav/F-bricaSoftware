package com.avanade.avabank.avabank.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.avabank.avabank.dtos.ExtratoDTO;
import com.avanade.avabank.avabank.service.ExtratoService;

@RestController
@RequestMapping("/extratos")
public class ExtratoController {

	@Autowired
	private ExtratoService extratoService;
	
//	@GetMapping("/lista")
//	public ResponseEntity<List<Extrato>> listar(){
//		return new ResponseEntity<List<Extrato>>(
//				extratoService.listarExtratos(), HttpStatus.OK);
//	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ExtratoDTO>> listarExtratosDTO(){
		return new ResponseEntity<List<ExtratoDTO>>(
				extratoService.listarExtratosDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/lista/{numero}")
	public ResponseEntity<List<ExtratoDTO>> listarExtratosDTOPorConta(@PathVariable(name = "numero") long numero){
		return new ResponseEntity<List<ExtratoDTO>>(
				extratoService.listarExtratosDTOPorConta(numero), HttpStatus.OK);
	}
	
	
	// EXEMPLO DE ROTA: http://localhost:8080/extratos/lista/datas?dataInicio=2025-01-01&dataFinal=2025-01-31
	@GetMapping("/lista/datas")
	public ResponseEntity<List<ExtratoDTO>> listarExtratosDTOPorData(
			@RequestParam("dataInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicio,
            @RequestParam("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal){
		
		return new ResponseEntity<List<ExtratoDTO>>(
				extratoService.listarExtratosDTOPorData(dataInicio, dataFinal), HttpStatus.OK);
	}
	
	@GetMapping("/lista/transacoes/{tipo}")
	public ResponseEntity<List<ExtratoDTO>> listarExtratosDTOPorTipo(@PathVariable(name = "tipo") String tipo){
		return new ResponseEntity<List<ExtratoDTO>>(
				extratoService.listarExtratosDTOPorTipo(tipo), HttpStatus.OK);
	}
	
}
