package com.app.api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query(value = "SELECT id_endereco FROM ENDERECO e inner join pessoa p on e.pessoa = p.id " +
    "where fl_main_address = true and p.id = :id_pessoa " , nativeQuery = true)
    Integer selectidEnderecoPrincipal(@Param("id_pessoa") Integer id_pessoa);


    @Query(value = "SELECT * FROM ENDERECO E INNER JOIN PESSOA P ON E.PESSOA = P.ID WHERE E.PESSOA = :id", nativeQuery = true)
    List<Endereco> selectEnderecoPessoa(@Param("id") Integer id);

    @Query(value = "Select * from endereco e inner join pessoa p on e.pessoa = p.id where fl_main_address = true and e.pessoa = :id", nativeQuery = true)
    List<Endereco> selectEnderecoPrincipal(@Param("id") Integer id);

}
