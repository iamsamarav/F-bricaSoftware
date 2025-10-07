package com.avanade.avabank.avabank.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.avabank.avabank.common.RandomStrGenerator;
import com.avanade.avabank.avabank.entities.Conta;
import com.avanade.avabank.avabank.entities.Transacao;
import com.avanade.avabank.avabank.enumeracoes.TipoPix;
import com.avanade.avabank.avabank.enumeracoes.TipoTransacao;
import com.avanade.avabank.avabank.repositories.ContaRepository;
import com.avanade.avabank.avabank.repositories.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ContaRepository contaRepository;

	public Transacao incluirDeposito(Map<String, String> dados) {

		RandomStrGenerator generator = new RandomStrGenerator();

		Conta conta = contaRepository.getReferenceById(Integer.parseInt(dados.get("idConta")));
		TipoTransacao tipoTransacao = TipoTransacao.doValor(dados.get("tipoTransacao"));
		double valor = Double.parseDouble(dados.get("valor"));
		Date dataTransacao = new Date();
		String numeroProtocolo = generator.usingRandomUUID();

		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setTipoTransacao(tipoTransacao);
		transacao.setValor(valor);
		transacao.setDataTransacao(dataTransacao);
		transacao.setNumeroProtocolo(numeroProtocolo);
		transacao.setDescricao(dados.get("descricao"));

		return transacaoRepository.save(transacao);
	}

	public Transacao incluirSaque(Map<String, String> dados) {

		RandomStrGenerator generator = new RandomStrGenerator();

		Conta conta = contaRepository.getReferenceById(Integer.parseInt(dados.get("idConta")));
		TipoTransacao tipoTransacao = TipoTransacao.doValor(dados.get("tipoTransacao"));
		double valor = Double.parseDouble(dados.get("valor"));
		Date dataTransacao = new Date();
		String numeroProtocolo = generator.usingRandomUUID();

		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setTipoTransacao(tipoTransacao);
		transacao.setValor(valor);
		transacao.setDataTransacao(dataTransacao);
		transacao.setNumeroProtocolo(numeroProtocolo);
		transacao.setDescricao(dados.get("descricao"));

		return transacaoRepository.save(transacao);
	}

	public Transacao pagarPix(Map<String, String> dados) {

		RandomStrGenerator generator = new RandomStrGenerator();

		Conta conta = contaRepository.getReferenceById(Integer.parseInt(dados.get("idConta")));
		TipoTransacao tipoTransacao = TipoTransacao.doValor(dados.get("tipoTransacao"));
		double valor = Double.parseDouble(dados.get("valor"));
		Date dataTransacao = new Date();
		String numeroProtocolo = generator.usingRandomUUID();
		TipoPix tipoPix = TipoPix.doValor(dados.get("tipoPix"));

		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setTipoTransacao(tipoTransacao);
		transacao.setValor(valor);
		transacao.setDataTransacao(dataTransacao);
		transacao.setNumeroProtocolo(numeroProtocolo);
		transacao.setDescricao(dados.get("descricao"));
		transacao.setChaveDestino(dados.get("chaveDestino"));
		transacao.setTipoPix(tipoPix);

		return transacaoRepository.save(transacao);
	}

	public Transacao pagarBoleto(Map<String, String> dados) {

		RandomStrGenerator generator = new RandomStrGenerator();

		Conta conta = contaRepository.getReferenceById(Integer.parseInt(dados.get("idConta")));
		TipoTransacao tipoTransacao = TipoTransacao.doValor(dados.get("tipoTransacao"));
		Date dataTransacao = new Date();
		String numeroProtocolo = generator.usingRandomUUID();
		String codigoBarras = dados.get("codigoBarras");

		if (codigoBarras.length() != 44) {
			throw new IllegalArgumentException("Código de barras inválido. Deve conter 44 dígitos.");
		}

		int fatorVencimento = Integer.parseInt(codigoBarras.substring(33, 37));
		Date dataVencimento = null;

		if (fatorVencimento > 1000) {
			long dias = fatorVencimento * 86400000L;
			dataVencimento = new Date(852134400000L + dias);
		}
		
		double valorBoleto = Double.parseDouble(codigoBarras.substring(37));
		
		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setTipoTransacao(tipoTransacao);
		transacao.setValor(valorBoleto);
		transacao.setDataTransacao(dataTransacao);
		transacao.setNumeroProtocolo(numeroProtocolo);
		transacao.setDescricao(dados.get("descricao"));
		transacao.setCodigoBarras(codigoBarras);
		transacao.setDataVencimento(dataVencimento);

		return transacaoRepository.save(transacao);
	}
	
	public Transacao incluirTransferencia(Map<String, String> dados) {

		RandomStrGenerator generator = new RandomStrGenerator();

		Conta conta = contaRepository.findByContaByCPF(dados.get("cpf"));
		TipoTransacao tipoTransacao = TipoTransacao.doValor(dados.get("tipoTransacao"));
		double valor = Double.parseDouble(dados.get("valor"));
		Date dataTransacao = new Date();
		String numeroProtocolo = generator.usingRandomUUID();
		
		int idConta = contaRepository.findByNumeroAndAgencia(dados.get("numeroConta"),dados.get("agencia"));

		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setTipoTransacao(tipoTransacao);
		transacao.setValor(valor);
		transacao.setDataTransacao(dataTransacao);
		transacao.setNumeroProtocolo(numeroProtocolo);
		transacao.setDescricao(dados.get("descricao"));
		transacao.setIdContaDestino(idConta);

		return transacaoRepository.save(transacao);
	}

	public List<Transacao> listar() {
		return transacaoRepository.findAll();
	}
}
