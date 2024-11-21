package com.h_salvacao.ms_triagem.model;

public class No {
    public No next;
    public No dado;

    public <T> No(T value) {
    }

    public void displayNo() {
        System.out.print(dado);
    }
}
