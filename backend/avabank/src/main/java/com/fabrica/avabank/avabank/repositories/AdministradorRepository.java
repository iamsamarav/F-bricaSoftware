package com.avanade.avabank.avabank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avanade.avabank.avabank.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	
	Optional<Administrador> findByUsername(String username);

}
