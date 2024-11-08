package com.h_salvacao.ms_token.service.impl;

import com.h_salvacao.ms_token.entity.*;
import com.h_salvacao.ms_token.repository.FichaRepository;
import com.h_salvacao.ms_token.service.FichaService;
import com.h_salvacao.ms_token.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FichaServiceImpl implements FichaService {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    FichaRepository fichaRepository;

    private Long sequnciaComum = 0L;
    private Long sequnciaPreferencial = 0L;
    private Long sequnciaEmergencial = 0L;
    private Long sequnciaUrgencia = 0L;

    @Override
    public Ficha abrirFicha(String cpf, TipoAtendimento tipoAtendimento) {
        Paciente paciente = pacienteService.buscarPaciente(cpf);
        return Ficha.builder()
                .token(gerarToken(tipoAtendimento))
                .paciente(paciente)
                .status(AtendimentoStatus.AGUARD_TRIAGEM)
                .atendimento(tipoAtendimento)
                .build();
    }

    @Override
    public Ficha abrirFichaSemCadastro(TipoAtendimento atendimento) {
        return Ficha.builder()
                .token(gerarToken(atendimento))
                .status(AtendimentoStatus.AGUARD_TRIAGEM)
                .atendimento(atendimento)
                .build();
    }

    @Override
    public void salvarFicha(Ficha ficha) {
        fichaRepository.save(ficha);
    }

    private String gerarToken(TipoAtendimento atendimento) {
        return   gerarSequencia(4) + gerarSufixo(atendimento) ;


    }

    private String gerarSequencia(int tamanho) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sequencia = new StringBuilder(tamanho);
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            sequencia.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return sequencia.toString();
    }

    private String gerarSufixo(TipoAtendimento atendimento) {
        switch (atendimento) {
            case COMUM -> {
                sequnciaComum++;
                return "C" + sequnciaComum;
            }
            case PREFERENCIAL -> {
                sequnciaPreferencial++;
                return "P" + sequnciaPreferencial;
            }
            case URGENTE -> {
                sequnciaUrgencia++;
                return "U" + sequnciaUrgencia;
            }
            case EMERGENCIAL -> {
                sequnciaEmergencial ++;
                return "E" + sequnciaEmergencial;
            }
            default -> throw new IllegalArgumentException("Tipo de atendimento inválido: " + atendimento);

        }
    }
}
