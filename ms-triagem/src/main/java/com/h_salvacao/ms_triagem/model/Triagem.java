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
    List<Token> filaComum = new ArrayList<>();
    List<Token> filaPreferencial = new ArrayList<>();
    List<Token> filaUrgente = new ArrayList<>();

    public  void adicionarFilaComum(Token token){
        filaComum.add(token);
    }


    public void adicionarFilaPreferencial(Token token) {
        filaPreferencial.add(token);
    }

    public void adicionarFilaUrgente(Token token) {
        filaUrgente.add(token);
    }
}
