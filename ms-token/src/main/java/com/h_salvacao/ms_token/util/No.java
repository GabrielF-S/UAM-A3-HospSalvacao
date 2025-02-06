package com.h_salvacao.ms_token.util;

import com.h_salvacao.ms_token.model.Token;

public class No {
    private Token data;
    private No proximo;

    public No(Token value){
        this(value,null);
    }

    public No(Token value, No no) {
        this.data = value;
        proximo = no;
    }

    public Token getObject(){
        return data;
    }
    public  No getNext(){
        return proximo;
    }

    public void setObject(Token token){
        this.data = token;
    }

    public void setNext(No next){
        this.proximo = next;
    }
}