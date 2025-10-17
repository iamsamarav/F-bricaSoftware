package com.fabrica.avabank.avabank.entities;

import java.util.Date;
import java.util.List;

import com.fabrica.avabank.avabank.enumeracoes.SituacaoConta;
import com.fabrica.avabank.avabank.enumeracoes.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_CONTAS")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_AGENCIA")
	private Agencia agencia;
	
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ADMIN")
	private Administrador admin;
	
	@Column(name = "NUMERO")
	private long numero;
	
	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private TipoConta tipo;
	
	@Column(name = "SALDO")
	private double saldo;

	@Column(name = "DATA_ABERTURA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;
	
	@Nullable
	@Column(name = "DATA_ENCERRAMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEncerramento;
	
	@Column(name = "DATA_ULTIMO_ACESSO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimoAcesso;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "conta")
	private List<Transacao> transacoes;
  
	@Column(name = "SITUACAO")
	@Enumerated(EnumType.STRING)
	private SituacaoConta situacao;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,fetch =FetchType.LAZY, mappedBy = "conta")
	private List<ChavePix> chavesPix;
	
	
	@OneToMany(mappedBy = "conta")
	private List<Extrato> extratos;
	
	public Conta() {}
		
	public Conta(
			Agencia agencia, 
			Cliente cliente, 
			Administrador admin, 
			long numero, 
			TipoConta tipo, 
			double saldo, 
			Date dataAbertura,  
			Date dataUltimoAcesso, 
			SituacaoConta situacao){
		
		this.setAgencia(agencia);
		this.setCliente(cliente);
		this.setAdmin(admin);
		this.setNumero(numero);
		this.setTipo(tipo);
		this.setSaldo(saldo);
		this.setDataAbertura(dataAbertura);
		this.setDataUltimoAcesso(dataUltimoAcesso);

	}
	
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}


	public TipoConta getTipo() {
		return tipo;
	}


	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
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

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public SituacaoConta getSituacao() {
		return situacao;
	}


	public void setSituacao(SituacaoConta situacao) {
		this.situacao = situacao;
	}

	public List<ChavePix> getChavesPix() {
		return chavesPix;
	}


	public void setChavesPix(List<ChavePix> chavesPix) {
		this.chavesPix = chavesPix;
	}


	public List<Extrato> getExtratos() {
		return extratos;
	}

	public void setExtratos(List<Extrato> extratos) {
		this.extratos = extratos;
	}
	
}
