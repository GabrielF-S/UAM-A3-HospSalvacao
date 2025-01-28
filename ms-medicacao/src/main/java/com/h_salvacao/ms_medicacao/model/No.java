package com.h_salvacao.ms_medicacao.model;

public class No<T> {
    public No next;
    public T dado;

    public No(T value) {
        this.dado = value;

    }

    public void displayNo() {
        System.out.print(dado);
    }
}
