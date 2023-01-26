package com.app.api.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dto.EnderecoDTO;
import com.app.api.exceptions.RegraNegocioException;
import com.app.api.model.Endereco;
import com.app.api.model.Pessoa;
import com.app.api.repository.EnderecoRepository;
import com.app.api.repository.PessoaRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private PessoaRepository  pessoaRepository;


    @Override
    public Endereco createEndereco(EnderecoDTO enderecoDTO) {

        Endereco endereco = new Endereco();

        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCidade(enderecoDTO.getCidade());

        Optional<Pessoa> pessoaDb = this.pessoaRepository.findById(enderecoDTO.getFk_id_pessoa());
        Pessoa pessoaUpdate = pessoaDb.get();
        endereco.setPessoa(pessoaUpdate);
        

        return enderecoRepository.save(endereco);

    }



    @Override
    public void setEnderecoPrincipal(Integer id_pessoa, Integer id_endereco) {

        Optional<Endereco> enderecoDb = this.enderecoRepository.findById(id_endereco);
        Optional<Pessoa> pessoaDb = this.pessoaRepository.findById(id_pessoa);

        Endereco endereco = enderecoDb.get();
        Pessoa pessoa = pessoaDb.get();

        if(endereco.getPessoa().getId() != pessoa.getId()){
            throw new RegraNegocioException("Esse endereco pertence a outra pessoa, tente um endereco ou pessoa diferente");
        }

        else if(enderecoRepository.selectidEnderecoPrincipal(id_pessoa) == null){

            endereco.setFl_main_address(true);

        }
        else{

            Integer idEnderecoPrincipalAntigo = enderecoRepository.selectidEnderecoPrincipal(id_pessoa);
            Optional<Endereco> enderecoAntigoDb = this.enderecoRepository.findById(idEnderecoPrincipalAntigo);
            Endereco enderecoAntigo = enderecoAntigoDb.get();
            enderecoAntigo.setFl_main_address(false);
            endereco.setFl_main_address(true);

        }

    }
    
}

