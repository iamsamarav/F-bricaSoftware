package com.fabrica.avabank.avabank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabrica.avabank.avabank.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	
	Optional<Administrador> findByUsername(String username);

}
