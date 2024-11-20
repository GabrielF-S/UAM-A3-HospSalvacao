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
    List<Token> tokenList= new ArrayList<>();

    public  void adicionarToken(Token token){
        tokenList.add(token);
    }


}
