package com.h_salvacao.ms_connect.util;

public class No<T> {
    private T data;
    private No proximo;

    public No(T value){
        this(value,null);
    }

    public No(T value, No no) {
        this.data = value;
        proximo = no;
    }

    public T getObject(){
        return data;
    }
    public  No getNext(){
        return proximo;
    }

    public void setObject(T token){
        this.data = token;
    }

    public void setNext(No next){
        this.proximo = next;
    }

    public void displayNo() {
        System.out.print(data);
    }
}