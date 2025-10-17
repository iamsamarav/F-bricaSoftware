package com.fabrica.avabank.avabank.dtos;

import java.util.Date;

import com.fabrica.avabank.avabank.enumeracoes.SituacaoConta;
import com.fabrica.avabank.avabank.enumeracoes.TipoConta;

public class ContaDTO {

	private int agencia;
	private int cliente;
	private int admin;
	private String numero;
	private TipoConta tipoConta;
	private double saldo;
	private Date dataAbertura;
	//private Date dataUltimoAcesso;
	private SituacaoConta situacao;
	
	public ContaDTO() {
		
	}
	
	public ContaDTO(int agencia, int cliente, int admin, String numero, TipoConta tipoConta,
			Date dataAbertura, SituacaoConta situacao) {
		this.setAgencia(agencia); 
		this.setCliente(cliente);
		this.setAdmin(admin);
		this.setNumero(numero);
		this.setTipoConta(tipoConta);
		this.setSaldo(0);
		this.setDataAbertura(dataAbertura);
		this.setSituacao(situacao);
	}
	

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
//	public Date getDataUltimoAcesso() {
//		return dataUltimoAcesso;
//	}
//	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
//		this.dataUltimoAcesso = dataUltimoAcesso;
//	}
	public SituacaoConta getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoConta situacao) {
		this.situacao = situacao;
	}
	
	
}
