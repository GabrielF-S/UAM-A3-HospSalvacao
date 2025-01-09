package com.h_salvacao.ms_raiox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@JsonSerialize(using = QueueSerializer.class)
@JsonDeserialize(using = QueueDeserializer.class)
public class  Queue<T> {
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
//Adicionar ao final da fila
    public  void enqueue(T value){
        No novoNo = new No(value);
      if (inicio==null){
          inicio = novoNo;
          fim = inicio;
      }else {
          fim.next = novoNo;
          fim = novoNo;
      }
       tamanho++;
    }
//retirar do inicio da fila
    public T dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Fila vazia");
        }
        No temp = inicio;
        inicio = inicio.next;

        if (inicio==null){
            fim = null;
        }

        tamanho--;
        return (T) temp.dado;
    }


    //consultar o primeiro da fila
    public T checkFirst(){
        if (inicio !=null) return (T) inicio.dado;
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
                atual=atual.next;
            }
        return list;
    }

    @JsonIgnore
    public No getInicio() { return inicio; }

}