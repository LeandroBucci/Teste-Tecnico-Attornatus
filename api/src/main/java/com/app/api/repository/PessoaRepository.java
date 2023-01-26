package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {


    
}
