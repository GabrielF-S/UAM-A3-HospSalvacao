package com.h_salvacao.ms_medico.model;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
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
    public  void enqueue(Token value){
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
    public Token dequeue(){
        if (isEmpty()){
            return  null;
        }
        No temp = inicio;
        inicio = inicio.next;

        if (inicio==null){
            fim = null;
        }

        tamanho--;
        return temp.dado;
    }


    //consultar o primeiro da fila
    public Token checkFirst(){
        if (inicio !=null){
            return inicio.dado;
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
                atual=atual.next;
            }
        return list;
    }


}