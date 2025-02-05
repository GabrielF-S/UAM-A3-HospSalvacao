package com.h_salvacao.ms_connect.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@JsonSerialize(using = QueueSerializer.class)
@JsonDeserialize(using = QueueDeserializer.class)
public class Queue<T> {
    private No  inicio, fim;
    private int tamanho;

    public Queue() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    public boolean isEmpty(){
        return  (inicio ==null);
    }
    public  void enqueue(T value){
        No novoNo = new No(value);
      if (inicio==null){
          inicio = novoNo;
          fim = inicio;
      }else {
          fim.setNext(novoNo);
          fim = novoNo;
      }
       tamanho++;
    }
    public T dequeue(){
        if (isEmpty()){
            return  null;
        }
        No temp = inicio;
        inicio = inicio.getNext();
        if (inicio==null){
            fim = null;
        }
        tamanho--;
        return (T) temp.getObject();
    }
    //consultar o primeiro da fila
    public T checkFirst(){
        if (inicio !=null){
            return (T) inicio.getObject();
        }
        return null;
    }
    public int size(){
        return tamanho;
    }
    public List<No> display(){

        List<No> list = new ArrayList<>();
        No atual = inicio;
            while (atual!= null){
                atual.displayNo();
                list.add(atual);
                atual.setNext(atual.getNext());
            }
        return list;
    }

    @JsonIgnore
    public No getInicio() { return inicio; }
}