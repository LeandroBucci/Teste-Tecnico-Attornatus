package com.app.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_endereco;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private String numero;


    @Column(name = "cidade")
    private String cidade;

    @Column(name = "fl_main_address")
    private Boolean fl_main_address = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pessoa pessoa;

    

    public Endereco(Integer id_endereco, String logradouro, String cep, String numero, String cidade, Pessoa pessoa) {
        this.id_endereco = id_endereco;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public Endereco(){

    };

    


    public Integer getId_endereco() {
        return id_endereco;
    }


    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }


    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


    public String getCep() {
        return cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }


    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getFl_main_address() {
        return fl_main_address;
    }

    public void setFl_main_address(Boolean fl_main_address) {
        this.fl_main_address = fl_main_address;
    }


}
