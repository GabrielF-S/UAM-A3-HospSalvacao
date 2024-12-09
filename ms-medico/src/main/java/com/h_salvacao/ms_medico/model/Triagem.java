package com.h_salvacao.ms_medico.model;

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

    public void adicionarMedicacao(Medicacao medicacao) {

    }
}
