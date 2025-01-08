package com.h_salvacao.ms_connect.exceptions;

public class EncaminhamentoException extends RuntimeException{

    @Override
    public String getMessage() {
        return String.format("Encaminhamento fornecido igual a nulo");
    }
}
