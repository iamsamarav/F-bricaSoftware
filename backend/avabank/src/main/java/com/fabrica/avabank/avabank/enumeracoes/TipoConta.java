package com.fabrica.avabank.avabank.enumeracoes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoConta {
	SIMPLES ("S", "Simples"),
	PREMIUM ("P", "Premium");
	
	private String codigo;
	private String descricao;
	
	private TipoConta (String codigo, String descricao) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}

	@JsonValue
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@JsonCreator
	public static TipoConta doValor(String codigo) {
		if (codigo.equals("S")) {
			return SIMPLES;
		} else if (codigo.equals("P")) {
			return PREMIUM;
		} else {
			return null;
		}
	}
}
