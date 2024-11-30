package com.h_salvacao.ms_atendimento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Atendimento {
    private Long id;
    Stack<Token> tokenStack = new Stack<>();

    public void adicionarPilha(Token token){
        tokenStack.push(token);
    }


    public Stack<Token> getStack(){
        return tokenStack;
    }

    public Integer getSize(){
        return  tokenStack.lenth();
    }
}
