package com.h_salvacao.ms_connect.exceptions;

public class FichaException extends  RuntimeException{
    @Override
    public String getMessage() {
        return String.format("Ficha fornecido igual a nulo");
    }
}
