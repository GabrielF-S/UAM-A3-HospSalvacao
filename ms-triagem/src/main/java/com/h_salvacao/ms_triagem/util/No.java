package com.h_salvacao.ms_triagem.util;

import com.h_salvacao.ms_triagem.model.Token;

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
