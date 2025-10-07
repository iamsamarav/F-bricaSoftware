package com.avanade.avabank.avabank.entities;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Embeddable
public class Endereco {
	
	
	@NotBlank
	@Size(min = 8, max = 9, message = "CEP deve conter apenas 8 digitos")
	@Column(length = 9, nullable = false)
	private String cep;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String rua;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String bairro;
	
	@NotBlank
	@Size(min = 1, max = 50)
	@Column(length = 50)
	private String cidade;
	
	@NotBlank
	@Size(min = 1, max = 10)
	@Column(length = 10)
	private String numero;
	
	@Size(max = 50)
	@Column(length = 50)
	private String complemento;
	
	@NotBlank
	@Size(min = 2, max = 2)
	@Column(length = 2)
	private String uf;

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
