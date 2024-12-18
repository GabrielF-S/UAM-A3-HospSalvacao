package com.h_salvacao.ms_token.service.impl;

import com.h_salvacao.ms_token.model.Token;
import com.h_salvacao.ms_token.service.ImprimirTokenService;
import com.h_salvacao.ms_token.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;


@Service
public class ImprimirTokenServiceImpl implements ImprimirTokenService {
    @Autowired
    PacienteService pacienteService;

    @Override
    public void Imprimir(Token token)  {

//
       String arquivo = criarArquivo(token);
//        try {
//            imprimirArquivo(arquivo);
//        }finally {
//
//            excluirArquivo(arquivo);
//        }


    }

    @Override
    public String criarArquivo(Token token) {
        Token dadosFicha = Token.builder()
                .numToken(token.getNumToken())
                .dataEntrada(token.getDataEntrada())
                .atendimento(token.getAtendimento())
                .build();
        Path relativePath = Paths.get("Tokens");
        Path absolutePath = relativePath.toAbsolutePath();

        StringBuilder nomeArquivo = new StringBuilder();
        nomeArquivo.append("token-"+ dadosFicha.getNumToken() +".txt");


        if (token.getPaciente() == null){
            dadosFicha.setPaciente(pacienteService.pacienteSemCadastro());
        }else{
            dadosFicha.setPaciente(token.getPaciente());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        try {

            Path fichaImpressao = Files.createFile(absolutePath.resolve(nomeArquivo +".txt"));
            Files.writeString(fichaImpressao, "Hospital Salvação\n"
                    +"Data de entrada: "+ dadosFicha.getDataEntrada().format(formatter)+"\n"
                    +"Paciente: " + dadosFicha.getPaciente().getNome() +"\n"
                    +"Token: "+ dadosFicha.getNumToken()+"\n"
                    +"Tipo de atendimento: " + dadosFicha.getAtendimento() );


            nomeArquivo.append(".txt");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar arquivo");
        }

        return nomeArquivo.toString();
    }

    @Override
    public void imprimirArquivo(String nomeArquivo) {
        Path relativePath = Paths.get("Tokens");
        Path absolutePath = relativePath.toAbsolutePath();
        Desktop desktop = Desktop.getDesktop();

        File arquivo = new File(absolutePath+nomeArquivo);
        try {
            desktop.print(arquivo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao imprimir arquivo");
        }

    }

    @Override
    public void excluirArquivo(String nomeArquivo) {
        Path relativePath = Paths.get("Tokens");
        Path absolutePath = relativePath.toAbsolutePath();

        Path path = Path.of(absolutePath+nomeArquivo);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao excluir arquivo");
        }
    }
}
