package com.app.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.api.dto.PessoaDTO;
import com.app.api.dto.PessoaListDTO;
import com.app.api.exceptions.RegraNegocioException;
import com.app.api.model.Pessoa;
import com.app.api.repository.EnderecoRepository;
import com.app.api.repository.PessoaRepository;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired 
    private EnderecoRepository enderecoRepository;


    @Override
    public Pessoa createPessoa(PessoaDTO pessoaDTO) {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa updatePessoa(PessoaDTO pessoaDTO, Integer id) {

        Optional<Pessoa> pessoaDb = this.pessoaRepository.findById(id);
        
        if(pessoaDb.isPresent()){
            Pessoa pessoaUpdate = pessoaDb.get();
            pessoaUpdate.setNome(pessoaDTO.getNome());
            pessoaUpdate.setDataNascimento(pessoaDTO.getDataNascimento());
            return pessoaUpdate;
        }
        else{
            throw new RegraNegocioException("Registro não encontrado");
        }

        
    }

    @Override
    public List<PessoaListDTO> getPessoaById(Integer idPessoa) {
        Optional<Pessoa> pessoaDb = this.pessoaRepository.findById(idPessoa);

        
        
        if(pessoaDb.isPresent()){
            Pessoa pessoa = pessoaDb.get();
            PessoaListDTO pessoaListDto = new PessoaListDTO(pessoa.getId(),pessoa.getNome(),pessoa.getDataNascimento(),enderecoRepository.selectEnderecoPessoa(pessoa.getId()));
            List<PessoaListDTO> pessoaList = new ArrayList<>();
            pessoaList.add(pessoaListDto);
            return pessoaList;
        }
        else{
            throw new RegraNegocioException("Registro não encontrado");
        }
    }



    @Override
    public void deletePessoa(Integer idPessoa) {
        Optional<Pessoa> pessoaDb = this.pessoaRepository.findById(idPessoa);
        
        if(pessoaDb.isPresent()){
            this.pessoaRepository.delete(pessoaDb.get());
        }
        else{

            throw new RegraNegocioException("Registro não encontrado");
        }
    }


    @Override
    public List<PessoaListDTO> getAllPessoa(){

        List<Pessoa> listapessoa = pessoaRepository.findAll();


        List<PessoaListDTO> PessoaListDTOreturn = new ArrayList<>();

        for (Pessoa pessoa : listapessoa) {
            PessoaListDTO pessoaListDto = new PessoaListDTO(pessoa.getId(),pessoa.getNome(),pessoa.getDataNascimento(),enderecoRepository.selectEnderecoPessoa(pessoa.getId()));
            PessoaListDTOreturn.add(pessoaListDto);

            
        }

        return PessoaListDTOreturn;

    }



    @Override
    public List<PessoaListDTO> getPessoaEnderecoPrincipal() {

   
        List<Pessoa> listapessoa = pessoaRepository.findAll();


        List<PessoaListDTO> PessoaListDTOreturn = new ArrayList<>();

        for (Pessoa pessoa : listapessoa) {
            PessoaListDTO pessoaListDto = new PessoaListDTO(pessoa.getId(),pessoa.getNome(),pessoa.getDataNascimento(),enderecoRepository.selectEnderecoPrincipal(pessoa.getId()));
            if(!pessoaListDto.getEnderecos().isEmpty()){
                PessoaListDTOreturn.add(pessoaListDto);
            }
            
        }

        return PessoaListDTOreturn;
    }

    
}
