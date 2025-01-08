package com.h_salvacao.ms_connect.exceptions;

public class PacienteException extends RuntimeException{
    @Override
    public String getMessage() {
        return String.format("Paciente fornecido igual a nulo");
    }
}
