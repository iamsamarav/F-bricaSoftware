package com.fabrica.avabank.avabank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fabrica.avabank.avabank.entities.Cliente;
import com.fabrica.avabank.avabank.entities.Conta;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
    Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> findByContaNumero(Long numeroConta);

}
