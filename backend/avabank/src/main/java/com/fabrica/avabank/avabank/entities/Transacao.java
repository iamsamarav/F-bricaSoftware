package com.fabrica.avabank.avabank.entities;

import java.util.Date;

import com.fabrica.avabank.avabank.enumeracoes.TipoPix;
import com.fabrica.avabank.avabank.enumeracoes.TipoTransacao;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_TRANSACOES")
public class Transacao {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;
	
	@Column(name = "TIPO_TRANSACAO")
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipoTransacao;
	
	@Column(name = "VALOR")
	private double valor;
	
	@Column(name = "DATA_TRANSACAO")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataTransacao;
	
	@Column(name = "NUMERO_PROTOCOLO")
	private String numeroProtocolo;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "CHAVE_DESTINO")
	private String chaveDestino;
	
	@Column(name = "TIPO_PIX")
	private TipoPix tipoPix;
	
	@Column(name = "CODIGO_BARRAS")
	private String codigoBarras;
	
	@Column(name = "DATA_VENCIMENTO")
	private Date dataVencimento;
	
	@Column(name = "ID_CONTA_DESTINO")
	private Integer idContaDestino;
	
	public Transacao() {
		
	}
	
	public Transacao(Conta conta, TipoTransacao tipoTransacao, double valor, Date dataTransacao, String numeroProtocolo,
				String descricao) {
		this.setConta(conta);
		this.setTipoTransacao(tipoTransacao);
		this.setValor(valor);
		this.setDataTransacao(dataTransacao);
		this.setNumeroProtocolo(numeroProtocolo);
		this.setDescricao(descricao);
	}


	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getChaveDestino() {
		return chaveDestino;
	}

	public void setChaveDestino(String chaveDestino) {
		this.chaveDestino = chaveDestino;
	}

	public TipoPix getTipoPix() {
		return tipoPix;
	}

	public void setTipoPix(TipoPix tipoPix) {
		this.tipoPix = tipoPix;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getIdContaDestino() {
		return idContaDestino;
	}

	public void setIdContaDestino(Integer idContaDestino) {
		this.idContaDestino = idContaDestino;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	
	
	
}