package com.avanade.avabank.avabank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avanade.avabank.avabank.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
