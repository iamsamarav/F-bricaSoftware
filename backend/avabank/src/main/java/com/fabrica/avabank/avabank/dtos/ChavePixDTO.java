package com.avanade.avabank.avabank.dtos;

import com.avanade.avabank.avabank.enumeracoes.TipoPix;

public class ChavePixDTO {
	
	private int idChave;
	private long numeroConta;
	private String numeroAgencia;
	private String nomeTitular;
	private TipoPix tipoPix;
	private String chave;
	
	public ChavePixDTO(int idChave, long numeroConta, String numeroAgencia, String nomeTitular, TipoPix tipoPix, String chave) {
		this.setIdChave(idChave);
		this.setNumeroConta(numeroConta);
		this.setNumeroAgencia(numeroAgencia);
		this.setNomeTitular(nomeTitular);
		this.setTipoPix(tipoPix);
		this.setChave(chave);
	}
	
	public long getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
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

	public int getIdChave() {
		return idChave;
	}

	public void setIdChave(int idChave) {
		this.idChave = idChave;
	}
}
