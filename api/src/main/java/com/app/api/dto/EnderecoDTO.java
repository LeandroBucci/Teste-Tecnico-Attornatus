package com.app.api.dto;

public class EnderecoDTO {

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;

    private Boolean fl_main_address;

    private Integer fk_id_pessoa;
    
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

    public Boolean getFl_main_address() {
        return fl_main_address;
    }

    public void setFl_main_address(Boolean fl_main_address) {
        this.fl_main_address = fl_main_address;
    }

    public Integer getFk_id_pessoa() {
        return fk_id_pessoa;
    }

    public void setFk_id_pessoa(Integer fk_id_pessoa) {
        this.fk_id_pessoa = fk_id_pessoa;
    }

    
    
}
