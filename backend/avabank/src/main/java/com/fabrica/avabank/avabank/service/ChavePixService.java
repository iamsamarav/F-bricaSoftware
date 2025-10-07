package com.avanade.avabank.avabank.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.avabank.avabank.common.RandomStrGenerator;
import com.avanade.avabank.avabank.dtos.ChavePixDTO;
import com.avanade.avabank.avabank.entities.ChavePix;
import com.avanade.avabank.avabank.entities.Conta;
import com.avanade.avabank.avabank.enumeracoes.TipoPix;
import com.avanade.avabank.avabank.repositories.ChavePixRepository;
import com.avanade.avabank.avabank.repositories.ContaRepository;

@Service
public class ChavePixService {
	

	@Autowired
	private ChavePixRepository chavePixRepository;

	@Autowired
	private ContaRepository contaRepository;

	public List<ChavePix> listarChavesPix() {
		return chavePixRepository.findAll();
	}

	public List<ChavePixDTO> listarChavesPixDTO() {
		return chavePixRepository.listarChavesPixDTO();
	}

	public List<ChavePixDTO> listarChavesPixDTOPorConta(String numero) {
		return chavePixRepository.listarChavesPixDTOPorConta(numero);
	}

	public String incluirChave(Map<String, String> dados) throws ParseException {

		Conta conta = contaRepository.getReferenceById(Integer.parseInt(dados.get("idConta")));
		TipoPix tipoPix = TipoPix.doValor(dados.get("tipo"));
		String chave = dados.get("chave");

		ChavePix chavePix = new ChavePix();
		chavePix.setConta(conta);
		chavePix.setTipoPix(tipoPix);
		
		RandomStrGenerator generator = new RandomStrGenerator();

		if (tipoPix.equals(TipoPix.doValor("C"))) {
			chavePix.setChave(conta.getCliente().getCpf());
		} else if(tipoPix.equals(TipoPix.doValor("E"))) {
			chavePix.setChave(conta.getCliente().getEmail());
		} else if(tipoPix.equals(TipoPix.doValor("T")) && chave.equals("")) {
			chavePix.setChave(conta.getCliente().getTelefone());
		} else {
			chave = generator.usingRandomUUID();
			chavePix.setChave(conta.getCliente().getNome()+"@"+chave);
		}

		chavePixRepository.save(chavePix);
		return "Chave Pix criada com MUITO sucesso";
	}

	public String removerChavePix(int id) {

		chavePixRepository.deleteById(id);
		return "Chave Pix removida com MUITO sucesso";
	}
}
