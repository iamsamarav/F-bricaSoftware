
package com.avanade.avabank.avabank.enumeracoes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoPix {
    CPF ("C", "CPF"),
    EMAIL ("E", "Email"),
    TELEFONE ("T", "Telefone"),
    ALEATORIA ("A", "Aleatoria");

	private String codigo;
	private String descricao;
	
	private TipoPix (String codigo, String descricao) {
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
	public static TipoPix doValor(String codigo) {
		if (codigo.equals("C")) {
			return CPF;
		} else if (codigo.equals("E")) {
			return EMAIL;
		} else if (codigo.equals("T")) {
			return TELEFONE;
		} else if (codigo.equals("A")) {
			return ALEATORIA;
		} else {
			return null;
		}
	}
}