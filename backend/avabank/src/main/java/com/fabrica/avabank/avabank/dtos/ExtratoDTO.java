
package com.avanade.avabank.avabank.dtos;

import java.util.Date;

import com.avanade.avabank.avabank.enumeracoes.TipoTransacao;

public class ExtratoDTO {
	
	private long numeroConta;
	private String nomeTitular;
	private TipoTransacao tipoTransacao;
	private String descricao;
	private Date dataTransacao;
	private double saldoAnterior;
	private double valor;
	private double saldoPosterior;
	
	
	public ExtratoDTO(long numeroConta, String nomeTitular, TipoTransacao tipoTransacao, String descricao, Date dataTransacao,
			double saldoAnterior, double valor, double saldoPosterior) {
		this.setNumeroConta(numeroConta);
		this.setNomeTitular(nomeTitular);
		this.setTipoTransacao(tipoTransacao);
		this.setDescricao(descricao);
		this.setDataTransacao(dataTransacao);
		this.setSaldoAnterior(saldoAnterior);
		this.setValor(valor);
		this.setSaldoPosterior(saldoPosterior);
	}
	
	
	public long getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}


	public String getNomeTitular() {
		return nomeTitular;
	}


	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}


	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}
	
	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getDataTransacao() {
		return dataTransacao;
	}
	
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	
	public double getSaldoAnterior() {
		return saldoAnterior;
	}
	
	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getSaldoPosterior() {
		return saldoPosterior;
	}
	
	public void setSaldoPosterior(double saldoPosterior) {
		this.saldoPosterior = saldoPosterior;
	}
	
	
}
