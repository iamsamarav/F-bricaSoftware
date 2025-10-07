package com.avanade.avabank.avabank.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avanade.avabank.avabank.entities.Endereco;

@Service
public class EnderecoService {

	    private static final String BASE_URL = "https://brasilapi.com.br/api/cep/v1/";

	    public Endereco buscarEnderecoPorCep(String cep) {
	        RestTemplate restTemplate = new RestTemplate();

	        
	        String url = String.format("%s%s", "https://viacep.com.br/ws/"+cep+"/json/");
	        

	        try {
	            return restTemplate.getForObject(url, Endereco.class);
	        } catch (Exception e) {
	            throw new RuntimeException("Erro ao buscar endereço pelo CEP: " + cep, e);
	        }
	    }
	}


