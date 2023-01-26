package com.app.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.api.errors.ApiErros;
import com.app.api.exceptions.RegraNegocioException;

@ControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRengraNegocioException(RegraNegocioException erro ){
        String mensagemErro = erro.getMessage();

        return new ApiErros(mensagemErro);
    }
    
}
