package com.fabrica.avabank.avabank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabrica.avabank.avabank.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
