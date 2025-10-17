package com.fabrica.avabank.avabank.enumeracoes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoTransacao {
	DEPOSITO ("D", "Deposito"),
	SAQUE ("S", "Saque"),
	PIX ("P", "Pix"),
	BOLETO ("B", "Boleto"),
	TRANSFERENCIA ("T", "Transferencia");
	
	private String codigo;
	private String descricao;
	
	private TipoTransacao (String codigo, String descricao) {
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
	public static TipoTransacao doValor(String codigo) {
		if (codigo.equals("DEP")) {
			return DEPOSITO;
		} else if (codigo.equals("S")) {
			return SAQUE;
		} else if (codigo.equals("P")) {
			return PIX;
		} else if (codigo.equals("B")) {
			return BOLETO;
		}  else if (codigo.equals("T")) {
			return TRANSFERENCIA;
		} else {
			return null;
		}
	}
}
