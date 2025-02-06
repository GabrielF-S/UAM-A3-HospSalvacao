package com.h_salvacao.ms_guiche.model;

import com.h_salvacao.ms_guiche.util.Queue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Triagem {
    private  long id;
    Queue<Token> fila = new Queue<>();

    public  void adicionarFila(Token token){
        fila.enqueue(token);
    }
}
