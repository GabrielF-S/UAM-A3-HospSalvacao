package com.h_salvacao.ms_connect.exceptions;

public class TempoAtendimentoException extends  RuntimeException{

    @Override
    public String getMessage() {
        return String.format("Valor fornecido igual a nulo");
    }
}
