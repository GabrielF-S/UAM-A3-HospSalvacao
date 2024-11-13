package com.h_salvacao.ms_token.service.impl;

import com.h_salvacao.ms_token.entity.Ficha;
import com.h_salvacao.ms_token.service.ImprimirFichaService;
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
public class ImprimirFichaServiceImpl implements ImprimirFichaService {
    @Autowired
    PacienteService pacienteService;

    @Override
    public void Imprimir(Ficha ficha)  {

//        new Thread();
//
        criarArquivo(ficha);
//        try {
//            imprimirArquivo();
//        }finally {
//
//            excluirArquivo();
//        }


    }

    @Override
    public void criarArquivo(Ficha ficha) {
        Ficha dadosFicha = Ficha.builder()
                .token(ficha.getToken())
                .dataEntrada(ficha.getDataEntrada())
                .atendimento(ficha.getAtendimento())
                .build();
        Path path = Path.of("C:\\Users\\gabri\\OneDrive\\Documentos\\Faculdade 2024.2\\Algoritomos\\A3\\UAM-A3-HospSalvacao\\ms-token\\Fichas");
        if (ficha.getPaciente() == null){
            dadosFicha.setPaciente(pacienteService.pacienteSemCadastro());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        try {
            Path fichaImpressao = Files.createFile(path.resolve("ficha.txt"));
            Files.writeString(fichaImpressao, "Hospital Salvação\n"
                    +"Data de entrada: "+ dadosFicha.getDataEntrada().format(formatter)+"\n"
                    +"Paciente: " + dadosFicha.getPaciente().getNome() +"\n"
                    +"Ficha: "+ dadosFicha.getToken()+"\n"
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
