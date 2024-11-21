package com.h_salvacao.ms_triagem.model;

import lombok.AllArgsConstructor;
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

    public No dequeue(){
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

    public int size(){
        return tamanho;
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Fila vazia");
        }else {
            No atual = inicio;
            while (atual!= null){
                atual.displayNo();
                atual=atual.next;
            }
            System.out.println();
        }
    }


}