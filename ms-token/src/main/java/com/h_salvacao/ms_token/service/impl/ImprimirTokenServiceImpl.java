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
import java.time.format.DateTimeFormatter;


@Service
public class ImprimirTokenServiceImpl implements ImprimirTokenService {
    @Autowired
    PacienteService pacienteService;

    @Override
    public void Imprimir(Token token)  {

//        new Thread();
//
        criarArquivo(token);
//        try {
//            imprimirArquivo();
//        }finally {
//
//            excluirArquivo();
//        }


    }

    @Override
    public void criarArquivo(Token token) {
        Token dadosFicha = Token.builder()
                .numToken(token.getNumToken())
                .dataEntrada(token.getDataEntrada())
                .atendimento(token.getAtendimento())
                .build();
        Path path = Path.of("C:\\Users\\gabri\\OneDrive\\Documentos\\Faculdade 2024.2\\Algoritomos\\A3\\UAM-A3-HospSalvacao\\ms-token\\Tokens");
        if (token.getPaciente() == null){
            dadosFicha.setPaciente(pacienteService.pacienteSemCadastro());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        try {

            Path fichaImpressao = Files.createFile(path.resolve("token-"+ dadosFicha.getNumToken() +".txt"));
            Files.writeString(fichaImpressao, "Hospital Salvação\n"
                    +"Data de entrada: "+ dadosFicha.getDataEntrada().format(formatter)+"\n"
                    +"Paciente: " + dadosFicha.getPaciente().getNome() +"\n"
                    +"Ficha: "+ dadosFicha.getNumToken()+"\n"
                    +"Tipo de atendimento: " + dadosFicha.getAtendimento() );



        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar arquivo");
        }
    }

    @Override
    public void imprimirArquivo() {
        Desktop desktop = Desktop.getDesktop();

        File arquivo = new File("C:\\Users\\gabri\\OneDrive\\Documentos\\Faculdade 2024.2\\Algoritomos\\A3\\UAM-A3-HospSalvacao\\ms-token\\Fichas\\ficha.txt");
        try {
            desktop.print(arquivo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao imprimir arquivo");
        }

    }

    @Override
    public void excluirArquivo() {
        Path path = Path.of("C:\\Users\\gabri\\OneDrive\\Documentos\\Faculdade 2024.2\\Algoritomos\\A3\\UAM-A3-HospSalvacao\\ms-token\\Fichas\\ficha.txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao excluir arquivo");
        }
    }
}
