package com.app.api.errors;

import java.util.Arrays;
import java.util.List;

public class ApiErros {

    private List<String> errors;

    

    public ApiErros(List<String> errors) {
        this.errors = errors;
    }



    public ApiErros(String mensagemError){
        this.errors = Arrays.asList(mensagemError);
    }



    public List<String> getErrors() {
        return errors;
    }



    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    
}
