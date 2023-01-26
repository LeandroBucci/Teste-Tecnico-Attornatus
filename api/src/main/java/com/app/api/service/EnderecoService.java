package com.app.api.service;

import com.app.api.dto.EnderecoDTO;
import com.app.api.model.Endereco;

public interface EnderecoService {

    Endereco createEndereco (EnderecoDTO endereco);

    void setEnderecoPrincipal (Integer id_pessoa, Integer id_endereco);

    
}
