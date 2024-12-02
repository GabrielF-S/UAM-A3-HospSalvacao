package com.h_salvacao.ms_guiche.model;

public class No {
    public No next;
    public Token dado;

    public <T> No(Token value) {
        this.dado = value;

    }

    public void displayNo() {
        System.out.print(dado);
    }
}
