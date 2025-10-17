package com.fabrica.avabank.avabank.enumeracoes;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SituacaoConta {
	ABERTA ("A", "Aberta"),
	FECHADA ("F", "Fechada");
	
	private String codigo;
	private String descricao;
	
	private SituacaoConta (String codigo, String descricao) {
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
	
	
//	@JsonCreator
	public static SituacaoConta doValor(String codigo) {
		if (codigo.equals("A")) {
			return ABERTA;
		} else if (codigo.equals("F")) {
			return FECHADA;
		} else {
			return null;
		}
	}
}
