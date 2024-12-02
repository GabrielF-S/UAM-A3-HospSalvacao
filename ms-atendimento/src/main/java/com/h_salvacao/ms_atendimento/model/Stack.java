package com.h_salvacao.ms_atendimento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@JsonSerialize(using = StackSerializer.class)
public class Stack<T> implements Serializable {
    private No topo;
    private int tamanho = 0;
    public Stack() {
        this.topo = null;
    }
    public boolean isEmpty() {
        return (topo == null);
    }
    public void push(Token value) {
        No newNo = new No(value);
        newNo.proximo = topo;
        topo = newNo;
        tamanho++;
    }
    public Token pop() {
        if (isEmpty()) {
            return null;
        }
        No temp = topo;
        topo = topo.proximo;
        return temp.dado;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            No atual = topo;
            while (atual != null) {
                atual.dispayNo();
                ;
                atual = atual.proximo;
            }
        }
        System.out.println();
    }gi
    @JsonIgnore
    public Integer lenth() {
        return tamanho;
    }
    @JsonIgnore
    public No getTopo() {
        return topo;}
}
