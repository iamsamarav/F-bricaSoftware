package com.avanade.avabank.avabank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EXTRATO")
public class Extrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "SALDO_ANTERIOR")
	private double saldoAnterior;
	
	@Column(name = "SALDO_POSTERIOR")
	private double saldoPosterior;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;

	@ManyToOne
	@JoinColumn(name = "ID_TRANSACAO")
	private Transacao transacao;
	
//	  @OneToMany(mappedBy = "extrato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	    private List<Transacao> transacao; 
//	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public double getSaldoPosterior() {
		return saldoPosterior;
	}
	public void setSaldoPosterior(double saldoPosterior) {
		this.saldoPosterior = saldoPosterior;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
}
