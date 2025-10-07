package com.avanade.avabank.avabank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avanade.avabank.avabank.entities.Cliente;
import com.avanade.avabank.avabank.entities.Conta;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
    Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> findByContaNumero(Long numeroConta);

}
