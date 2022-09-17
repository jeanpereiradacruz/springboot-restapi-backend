package com.onsafety.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onsafety.restapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
