package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.dto.PessoaDTO;
import com.app.api.dto.PessoaListDTO;
import com.app.api.model.Pessoa;

import com.app.api.service.PessoaService;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoas")
    public ResponseEntity<List<PessoaListDTO>> getAllPessoa(){
        return ResponseEntity.ok().body(pessoaService.getAllPessoa());
    }


    @PostMapping("/pessoas")
    public ResponseEntity<Pessoa> createPessoa(@RequestBody PessoaDTO pessoa){

        return ResponseEntity.ok().body(this.pessoaService.createPessoa(pessoa));

    }

    @GetMapping("/pessoasenderecoprincipal")
    public ResponseEntity<List<PessoaListDTO>> getPessoaEnderecoPrincipal(){
        return ResponseEntity.ok().body(pessoaService.getPessoaEnderecoPrincipal());
    }
    
    @GetMapping("/pessoas/{id}")
    public ResponseEntity<List<PessoaListDTO>> getPessoaById(@PathVariable Integer id){
        return ResponseEntity.ok().body(pessoaService.getPessoaById(id));
    }


    @PutMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Integer id, @RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.ok().body(this.pessoaService.updatePessoa(pessoaDTO, id));
    }

    @DeleteMapping("/pessoas/{id}")
    public HttpStatus deletePessoa (@PathVariable Integer id){
        this.pessoaService.deletePessoa(id);

        return HttpStatus.OK;

    }

    
}
