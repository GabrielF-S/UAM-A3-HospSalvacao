package com.h_salvacao.ms_atendimento.model;

public class No {
    public Token dado;
    public No proximo;

    public No(Token token){
        this.dado = token;
        this.proximo = null;
    }

    public void dispayNo(){
        System.out.println(dado);
    }
}
