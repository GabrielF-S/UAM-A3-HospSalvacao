package com.h_salvacao.ms_connect.exceptions;

public class ReceitaException extends RuntimeException{
    @Override
    public String getMessage() {
        return String.format("Receita fornecido igual a nulo");
    }

}
