package com.app.api.service;

import java.util.List;

import com.app.api.dto.PessoaDTO;
import com.app.api.dto.PessoaListDTO;
import com.app.api.model.Pessoa;

public interface PessoaService {

    Pessoa createPessoa(PessoaDTO pessoa);

    Pessoa updatePessoa(PessoaDTO pessoaDTO, Integer id);

    List<PessoaListDTO> getPessoaById(Integer idPessoa);

    List<PessoaListDTO> getAllPessoa();

    void deletePessoa(Integer idPessoa);

    List<PessoaListDTO> getPessoaEnderecoPrincipal();


}
