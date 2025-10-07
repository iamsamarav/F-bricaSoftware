package com.avanade.avabank.avabank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
	
    @Column(name = "CEP", length = 8, nullable = false)
    private String cep;
    
    @Column(name = "LOGRADOURO", length = 80, nullable = false)
    private String logradouro;
    
    @Column(name = "COMPLEMENTO", length = 20)
    private String complemento;
    
    @Column(name = "BAIRRO", length = 20, nullable = false)
    private String bairro;
    
    @Column(name = "CIDADE", length = 20, nullable = false)
    private String cidade;
    
    @Column(name = "UF", length = 2, nullable = false)
    private String uf;
    
    @Column(name = "ESTADO", length = 20, nullable = false)
    private String estado;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
