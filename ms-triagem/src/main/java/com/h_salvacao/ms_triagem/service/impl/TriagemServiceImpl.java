package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_triagem.model.Triagem;
import com.h_salvacao.ms_triagem.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriagemServiceImpl implements TriagemService {
    @Autowired
    Triagem triagem;

    @Override
    public void adcionarFila(Token token) {

        switch (token.getAtendimento()){
            case COMUM -> {
                triagem.adicionarFilaComum(token);
                System.out.println("Fila Comum: "+ triagem.getFilaComum());
                break;
            }
            case PREFERENCIAL -> {
                triagem.adicionarFilaPreferencial(token);
                System.out.println("Fila Preferencial: "+ triagem.getFilaPreferencial());
                break;
            }
            case URGENTE -> {
                triagem.adicionarFilaUrgente(token);
                System.out.println("Fila Urgente: "+ triagem.getFilaUrgente());
                break;
            }


        }



    }

    @Override
    public List<Token> exibirFila() {
        return triagem.getFilaComum();
    }

    @Override
    public Integer pegarTotal() {
        return triagem.getFilaComum().size() + triagem.getFilaPreferencial().size() + triagem.getFilaUrgente().size();
    }

    @Override
    public Token chamarProximo() {
        //TODO
        //implementar as 3 filas
        //verificar se as filas estão vazias
        //criar logica de comparação de tempo de espera urgente 10min, preferencial 15min, comum 30min
        Token token = verificarFilas();
        return  null;

    }

    private Token verificarFilas() {
        return  null;


    }
}
