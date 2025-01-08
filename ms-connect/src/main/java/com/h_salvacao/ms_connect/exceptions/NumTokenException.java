package com.h_salvacao.ms_connect.exceptions;

public class NumTokenException extends RuntimeException{

    @Override
    public String getMessage() {
        return String.format("Numero do Token fornecido igual a nulo");
    }
}
