package com.fabrica.avabank.avabank.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabrica.avabank.avabank.dtos.ContaDTO;
import com.fabrica.avabank.avabank.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
	
	@Query(value = "SELECT COALESCE(MAX(NUMERO), 0) + 1 FROM TB_CONTAS", nativeQuery = true)
	public Long gerarNumeroConta();
	
	@Query("SELECT c FROM Conta c WHERE c.numero = :numero AND c.agencia.numero = :agenciaNumero")
	Optional<Conta> findByNumeroAndAgencia_Numero(@Param("numero") long numeroConta, @Param("agenciaNumero") String agenciaNumero);
	
	Optional<Conta> findByNumero(Long numero);

	@Query("SELECT c.id FROM Conta c WHERE c.numero = :numeroConta AND c.agencia.numero = :agenciaNumero")
	int findByNumeroAndAgencia(@Param("numeroConta") String numeroConta, @Param("agencia") String agenciaNumero);
	
	@Query("SELECT c FROM Conta c WHERE c.cliente.cpf = :cpf")
	Conta findByContaByCPF(@Param("cpf") String cpf);

	@Query(value = "SELECT\r\n"
			+ "	A.NOME AS AGENCIA,\r\n"
			+ "	CL.NOME AS TITULAR,\r\n"
			+ "	C.NUMERO AS [NUMERO DA CONTA],\r\n"
			+ "	C.TIPO AS [TIPO DA CONTA],\r\n"
			+ "	C.SALDO,\r\n"
			+ "	C.DATA_ABERTURA AS [DATA DE ABERTURA],\r\n"
			+ "	C.SITUACAO AS SITUAÇÃO\r\n"
			+ " FROM TB_CONTAS C\r\n"
			+ " INNER JOIN TB_CLIENTES CL ON C.ID_CLIENTE = CL.ID\r\n"
			+ " INNER JOIN TB_AGENCIAS A ON C.ID_AGENCIA = A.ID\r\n"
			+ " INNER JOIN TB_ADMINS AD ON C.ID_ADMIN = AD.ID\r\n"
			+ " WHERE AD.USERNAME = :username", nativeQuery = true)
	List<ContaDTO> listarContasPorAdmin(@Param("username") String username);
}
