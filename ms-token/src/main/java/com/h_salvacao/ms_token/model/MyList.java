package com.h_salvacao.ms_token.model;

import org.apache.kafka.streams.processor.To;

public class MyList {
    private No primeiro;
    private No ultimo;
    private String nomeLista;

    public MyList(){
        this("list");
    }

    public MyList(String nome){
        this.nomeLista = nome;
        primeiro = ultimo = null;

    }

    public void inserirInicio(Token token){
        if (isEmpty()){
            this.primeiro = ultimo  =new No(token);
        }else {
            primeiro = new No(token, primeiro);
        }
    }

    public void inserirFim(Token token){
        if (isEmpty()){
            this.primeiro = ultimo  =new No(token);
        }else{
            No temp = new No(token);
            ultimo.setNext(temp);
            ultimo = ultimo.getNext();
        }

    }

    public Token removerInicio(){
        if (isEmpty()){
            return  null;
        }
        Token tRemovido = primeiro.getObject();

        if(primeiro == ultimo){
            primeiro= ultimo = null;
        }else {
            primeiro=primeiro.getNext();
        }
        return tRemovido;
    }

    public Token removerFinal(){
        if (isEmpty()){
            return  null;
        }
        Token tRemovido = ultimo.getObject();

        if (primeiro==ultimo) {
            primeiro = ultimo = null;
        }else {
            No atual = primeiro;
            while( atual.getNext() != ultimo){
                atual.getNext();
            }
            ultimo = atual;
            atual.setNext(null);
        }

        return  tRemovido;
    }


    public boolean isEmpty(){
        return  primeiro==null;
    }


}
