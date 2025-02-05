package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.ReceitaFeignClient;
import com.h_salvacao.ms_medico.util.Medicacao;
import com.h_salvacao.ms_medico.model.Receita;
import com.h_salvacao.ms_medico.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ReceitaServiceImpl implements ReceitaService {
    private final ReceitaFeignClient receitaFeignClient;

    @Override
    public void imprimir(Receita receita) {
        String nomeArquivo = criarArquivo(receita);
//        try {
//            imprimirArquivo(nomeArquivo);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }finally {
//            excluirArquivo(nomeArquivo);
//        }

    }

    @Override
    public String criarArquivo(Receita receita) {

        Path relativePath = Paths.get("Receitas");
        Path absolutePath = relativePath.toAbsolutePath();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        StringBuilder medicacoes = new StringBuilder();
        StringBuilder nomeArquivo = new StringBuilder();

        nomeArquivo.append("Receita " + receita.getNumToken());

        while (!receita.getMedicacoes().isEmpty()) {
            Medicacao atual = receita.getMedicacoes().dequeue();
            medicacoes.append(atual.getNome() + " " + atual.getFrequencia() + " Durente: " + atual.getTempoDeUso() + " dias\n"
            );
        }

        try {
            Path receitaImpressao = Files.createFile(absolutePath.resolve(nomeArquivo +".txt"));
            Files.writeString(receitaImpressao, "Hospital Salvação\n" +
                    "Paciente: " + receita.getNomePaciente() + "\n" +
                    "Token: " + receita.getNumToken() + "\n" +
                    "Medicamentos: " + medicacoes + "\n"
            );
            nomeArquivo.append(".txt");

        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar arquivo");
        }


        return nomeArquivo.toString();

    }

    @Override
    public void imprimirArquivo(String nomeArquivo) {
        Path relativePath = Paths.get("Receitas");
        Path absolutePath = relativePath.toAbsolutePath();
        Desktop desktop = Desktop.getDesktop();


        File arquivo  =new File(absolutePath+nomeArquivo);
        try {
            desktop.print(arquivo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao imprimir arquivo");
        }

    }

    @Override
    public void excluirArquivo(String nomeArquivo) {
        Path relativePath = Paths.get("Receitas");
        Path absolutePath = relativePath.toAbsolutePath();
        Path path = Path.of(absolutePath+nomeArquivo);

        Desktop desktop = Desktop.getDesktop();

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao excluir arquivo");
        }

    }

    @Override
    public Receita salvarReceita(Receita receita) {
        return receitaFeignClient.salvarReceita(receita);
    }
}
