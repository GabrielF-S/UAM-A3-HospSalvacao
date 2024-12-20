package com.h_salvacao.ms_raiox.model;

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
    Queue<Encaminhamento> fila = new Queue<>();


    public  void adicionarFila(Encaminhamento token){
        fila.enqueue(token);
    }


}
