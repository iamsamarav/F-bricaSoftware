package com.fabrica.avabank.avabank.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fabrica.avabank.avabank.dtos.ExtratoDTO;
import com.fabrica.avabank.avabank.entities.Extrato;
import com.fabrica.avabank.avabank.enumeracoes.TipoTransacao;

public interface ExtratoRepository extends JpaRepository<Extrato, Integer>{
	
	@Query("SELECT new com.fabrica.avabank.avabank.dtos.ExtratoDTO("
	           + " e.conta.numero, "
	           + " cl.nome," 
	           + " t.tipoTransacao, "
	           + " t.descricao, "
	           + " t.dataTransacao, "
	           + " e.saldoAnterior, "
	           + " t.valor, "
	           + " e.saldoPosterior) "
	           + " FROM Extrato e "
	           + " JOIN e.conta c "
	           + " JOIN c.cliente cl "
	           + " JOIN e.transacao t")
	public List<ExtratoDTO> listarExtratosDTO();
	
	@Query("SELECT new com.fabrica.avabank.avabank.dtos.ExtratoDTO("
			+ " e.conta.numero, "
			+ " cl.nome," 
			+ " t.tipoTransacao, "
			+ " t.descricao, "
			+ " t.dataTransacao, "
			+ " e.saldoAnterior, "
			+ " t.valor, "
			+ " e.saldoPosterior) "
			+ " FROM Extrato e "
			+ " JOIN e.conta c "
			+ " JOIN c.cliente cl "
			+ " JOIN e.transacao t "
			+ " WHERE e.conta.numero = :numeroConta")
	public List<ExtratoDTO> listarExtratosDTOPorConta(@Param("numeroConta") long numeroConta);

	
	@Query("SELECT new com.fabrica.avabank.avabank.dtos.ExtratoDTO("
	        + " e.conta.numero, "
	        + " cl.nome," 
	        + " t.tipoTransacao, "
	        + " t.descricao, "
	        + " t.dataTransacao, "
	        + " e.saldoAnterior, "
	        + " t.valor, "
	        + " e.saldoPosterior) "
	        + " FROM Extrato e "
	        + " JOIN e.conta c "
	        + " JOIN c.cliente cl "
	        + " JOIN e.transacao t "
	        + " WHERE t.dataTransacao BETWEEN :dataInicio AND :dataFinal")
	public List<ExtratoDTO> listarExtratosDTOPorData(@Param("dataInicio") Date dataInicio, @Param("dataFinal") Date dataFinal);

	
	@Query("SELECT new com.fabrica.avabank.avabank.dtos.ExtratoDTO("
	        + " e.conta.numero, "
	        + " cl.nome," 
	        + " t.tipoTransacao, "
	        + " t.descricao, "
	        + " t.dataTransacao, "
	        + " e.saldoAnterior, "
	        + " t.valor, "
	        + " e.saldoPosterior) "
	        + " FROM Extrato e "
	        + " JOIN e.conta c "
	        + " JOIN c.cliente cl "
	        + " JOIN e.transacao t "
	        + " WHERE t.tipoTransacao = :tipo")
	public List<ExtratoDTO> listarExtratosDTOPorTipo(@Param("tipo") TipoTransacao tipo);

}
