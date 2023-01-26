package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.dto.EnderecoDTO;
import com.app.api.model.Endereco;
import com.app.api.service.EnderecoService;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @PostMapping("/endereco")
    public ResponseEntity<Endereco> createEndereco(@RequestBody EnderecoDTO enderecoDTO){

        return ResponseEntity.ok().body(this.enderecoService.createEndereco(enderecoDTO));

    }

    @PutMapping("/endereco/{id_pessoa}/{id_endereco}")

    public HttpStatus setEnderecoPrincipal(@PathVariable Integer id_pessoa, @PathVariable Integer id_endereco){

        this.enderecoService.setEnderecoPrincipal(id_pessoa, id_endereco);
        return HttpStatus.OK;

    }

    
}
