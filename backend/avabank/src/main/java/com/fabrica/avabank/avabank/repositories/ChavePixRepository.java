package com.avanade.avabank.avabank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avanade.avabank.avabank.dtos.ChavePixDTO;
import com.avanade.avabank.avabank.entities.ChavePix;

public interface ChavePixRepository extends JpaRepository<ChavePix, Integer> {
	
	
	@Query("SELECT new com.avanade.avabank.avabank.dtos.ChavePixDTO(cp.id, ct.numero, a.numero, cl.nome, cp.tipoPix, cp.chave)  \r\n"
			+ " FROM ChavePix cp JOIN cp.conta ct ON cp.conta.id = ct.id JOIN ct.agencia a ON ct.agencia.id = a.id  \r\n"
			+ " JOIN ct.cliente cl ON ct.cliente.id = cl.id")
	List<ChavePixDTO> listarChavesPixDTO();
	
	@Query("SELECT new com.avanade.avabank.avabank.dtos.ChavePixDTO(cp.id, ct.numero, a.numero, cl.nome, cp.tipoPix, cp.chave)  \r\n"
			+ " FROM ChavePix cp JOIN cp.conta ct ON cp.conta.id = ct.id JOIN ct.agencia a ON ct.agencia.id = a.id  \r\n"
			+ " JOIN ct.cliente cl ON ct.cliente.id = cl.id WHERE ct.numero = :numeroConta")
	List<ChavePixDTO> listarChavesPixDTOPorConta(@Param("numeroConta") String numero);
	
}
