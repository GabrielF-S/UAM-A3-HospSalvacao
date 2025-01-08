package com.h_salvacao.ms_connect.exceptions;

public class TokenException extends RuntimeException{



    @Override
    public String getMessage() {
        return String.format("Token fornecido igual a nulo");
    }
}
