package com.avanade.avabank.avabank.entities;

import com.avanade.avabank.avabank.enumeracoes.TipoPix;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CHAVES_PIX")
public class ChavePix {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;
	
	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private TipoPix tipoPix;
	
	@Column(name = "CHAVE")
	private String chave;
	
	public ChavePix() {}
	
	public ChavePix(int id, Conta conta, TipoPix tipoPix, String chave) {
		this.setId(id);
		this.setConta(conta);
		this.setTipoPix(tipoPix);
		this.setChave(chave);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
