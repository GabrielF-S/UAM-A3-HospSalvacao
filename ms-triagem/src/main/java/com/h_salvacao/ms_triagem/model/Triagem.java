package com.h_salvacao.ms_triagem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Triagem {

    private Long id;
    Queue<Token> filaComum = new Queue<>();
    Queue<Token> filaPreferencial = new Queue<>();
    Queue<Token> filaUrgente = new Queue<>();


    public  void adicionarFilaComum(Token token){
        filaComum.enqueue(token);
    }


    public void adicionarFilaPreferencial(Token token) {
        filaPreferencial.enqueue(token);
    }

    public void adicionarFilaUrgente(Token token) {
        filaUrgente.enqueue(token);
    }
}
