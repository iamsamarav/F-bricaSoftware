package com.fabrica.avabank.avabank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrica.avabank.avabank.dtos.ExtratoDTO;
import com.fabrica.avabank.avabank.entities.Extrato;
import com.fabrica.avabank.avabank.enumeracoes.TipoTransacao;
import com.fabrica.avabank.avabank.repositories.ExtratoRepository;

@Service
public class ExtratoService {

	@Autowired
	private ExtratoRepository extratoRepository;
	
	public List<Extrato> listarExtratos(){
		return extratoRepository.findAll();
	}
	
	public List<ExtratoDTO> listarExtratosDTO(){
		return extratoRepository.listarExtratosDTO();
	}
	
	public List<ExtratoDTO> listarExtratosDTOPorConta(long numero){
		return extratoRepository.listarExtratosDTOPorConta(numero);
	}
	
	public List<ExtratoDTO> listarExtratosDTOPorData(Date dataInicio, Date dataFinal){
		return extratoRepository.listarExtratosDTOPorData(dataInicio, dataFinal);
	}
	
	public List<ExtratoDTO> listarExtratosDTOPorTipo(String tipo){
		return extratoRepository.listarExtratosDTOPorTipo(TipoTransacao.doValor(tipo));
	}
}
