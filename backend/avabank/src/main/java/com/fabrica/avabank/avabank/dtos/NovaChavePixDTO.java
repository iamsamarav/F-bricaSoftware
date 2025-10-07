package com.avanade.avabank.avabank.dtos;

import com.avanade.avabank.avabank.enumeracoes.TipoPix;

public class NovaChavePixDTO {
	private int idConta;
	private TipoPix tipoPix;
	private String chave;
	
	public int getIdConta() {
		return idConta;
	}
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	public TipoPix getTipoPix() {
		return tipoPix;
	}
	
	public void setTipoPix(TipoPix tipoPix) {
		this.tipoPix = tipoPix;
	}
	
	public String getChave() {
		return chave;
	}
	
	public void setChave(String chave) {
		this.chave = chave;
	}
	
	
}
