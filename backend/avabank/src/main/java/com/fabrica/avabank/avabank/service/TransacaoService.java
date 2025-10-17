package com.fabrica.avabank.avabank.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrica.avabank.avabank.common.RandomStrGenerator;
import com.fabrica.avabank.avabank.entities.Conta;
import com.fabrica.avabank.avabank.entities.Transacao;
import com.fabrica.avabank.avabank.entities.ChavePix;
import com.fabrica.avabank.avabank.enumeracoes.TipoPix;
import com.fabrica.avabank.avabank.enumeracoes.TipoTransacao;
import com.fabrica.avabank.avabank.repositories.ContaRepository;
import com.fabrica.avabank.avabank.repositories.TransacaoRepository;
import com.fabrica.avabank.avabank.repositories.ChavePixRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ChavePixRepository chavePixRepository;

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
		String chaveDestino = dados.get("chaveDestino");
		TipoPix tipoPix = TipoPix.doValor(dados.get("tipoPix"));

		// Buscar conta de destino pela chave PIX
		Optional<ChavePix> chavePixOpt = chavePixRepository.findByChave(chaveDestino);
		Integer idContaDestino = null;
		if (chavePixOpt.isPresent()) {
			idContaDestino = chavePixOpt.get().getConta().getId();
		}

		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setTipoTransacao(tipoTransacao);
		transacao.setValor(valor);
		transacao.setDataTransacao(dataTransacao);
		transacao.setNumeroProtocolo(numeroProtocolo);
		transacao.setDescricao(dados.get("descricao"));
		transacao.setChaveDestino(chaveDestino);
		transacao.setTipoPix(tipoPix);
		transacao.setIdContaDestino(idContaDestino);

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

		Conta conta = contaRepository.getReferenceById(Integer.parseInt(dados.get("idConta")));
		TipoTransacao tipoTransacao = TipoTransacao.doValor(dados.get("tipoTransacao"));
		double valor = Double.parseDouble(dados.get("valor"));
		Date dataTransacao = new Date();
		String numeroProtocolo = generator.usingRandomUUID();
		Integer idContaDestino = Integer.parseInt(dados.get("idContaDestino"));

		Transacao transacao = new Transacao();
		transacao.setConta(conta);
		transacao.setTipoTransacao(tipoTransacao);
		transacao.setValor(valor);
		transacao.setDataTransacao(dataTransacao);
		transacao.setNumeroProtocolo(numeroProtocolo);
		transacao.setDescricao(dados.get("descricao"));
		transacao.setIdContaDestino(idContaDestino);

		return transacaoRepository.save(transacao);
	}

	public List<Transacao> listar() {
		return transacaoRepository.findAll();
	}
}
