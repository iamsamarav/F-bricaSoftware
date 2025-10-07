package com.avanade.avabank.avabank.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.avabank.avabank.dtos.ContaDTO;
import com.avanade.avabank.avabank.entities.Administrador;
import com.avanade.avabank.avabank.entities.Agencia;
import com.avanade.avabank.avabank.entities.Cliente;
import com.avanade.avabank.avabank.entities.Conta;
import com.avanade.avabank.avabank.enumeracoes.SituacaoConta;
import com.avanade.avabank.avabank.enumeracoes.TipoConta;
import com.avanade.avabank.avabank.repositories.AdministradorRepository;
import com.avanade.avabank.avabank.repositories.AgenciaRepository;
import com.avanade.avabank.avabank.repositories.ClienteRepository;
import com.avanade.avabank.avabank.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private AgenciaRepository agenciaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EmailService emailService;
	
	
	public List<Conta> listarContas(){
		return contaRepository.findAll();
	}
	
	public List<ContaDTO> buscarConta(String username) {
		return contaRepository.listarContasPorAdmin(username);
	}

	public String incluir(Map<String, String> dados) throws ParseException{
		
		Administrador admin = administradorRepository.getReferenceById(Integer.parseInt(dados.get("idAdmin")));
		Agencia agencia = agenciaRepository.getReferenceById(Integer.parseInt(dados.get("idAgencia")));
		Cliente cliente = clienteRepository.getReferenceById(Integer.parseInt(dados.get("idCliente")));
		TipoConta tipoConta = TipoConta.doValor("S"); 
	    SituacaoConta situacaoConta = SituacaoConta.doValor("A"); 
	    Date dataAbertura = new Date();
	    Date dataAtual = new Date();
		
	    Conta conta = new Conta();
	    conta.setAdmin(admin);
	    conta.setAgencia(agencia);
	    conta.setCliente(cliente);

	    if(contaRepository.gerarNumeroConta() < 10000) {
	    	conta.setNumero(10000);
	    } else {
	    	conta.setNumero(contaRepository.gerarNumeroConta());	    	
	    }

	    conta.setTipo(tipoConta);
	    conta.setDataAbertura(dataAbertura);
	    conta.setDataUltimoAcesso(dataAtual);
	    conta.setSituacao(situacaoConta);
	    
	    contaRepository.save(conta);
	    
        emailService.notificarCliente(cliente, conta.getNumero(), conta.getAgencia().getNumero());

	    
		return "Conta criada com MUITO sucesso";

	}

	public Conta buscarConta(int id) {
		Conta conta = contaRepository.getReferenceById(id);
		return new Conta(conta.getAgencia(), conta.getCliente(), conta.getAdmin(), conta.getNumero(), 
				conta.getTipo(), conta.getSaldo(), conta.getDataAbertura(), null, conta.getSituacao());

	}
	
	
	public Conta alterarConta(Conta conta, long numeroConta) {

	    Optional<Conta> contaExistente = contaRepository.findByNumero(numeroConta);

	    if (contaExistente.isPresent()) {
	        Conta contaAtualizada = contaExistente.get(); 

	        contaAtualizada.setAdmin(contaExistente.get().getAdmin());
	        contaAtualizada.setAgencia(contaExistente.get().getAgencia());
	        contaAtualizada.setCliente(contaExistente.get().getCliente());
	        contaAtualizada.setNumero(contaExistente.get().getNumero()); 
	        contaAtualizada.setDataAbertura(contaExistente.get().getDataAbertura());
	        contaAtualizada.setSaldo(contaExistente.get().getSaldo());
	        
	        contaAtualizada.setSituacao(conta.getSituacao());
	        contaAtualizada.setTipo(conta.getTipo());
	        contaAtualizada.setDataUltimoAcesso(new Date());

	        return contaRepository.save(contaAtualizada);
	    } else {
	        throw new RuntimeException("Conta com número " + numeroConta + " não encontrada.");
	    }
	}



}
