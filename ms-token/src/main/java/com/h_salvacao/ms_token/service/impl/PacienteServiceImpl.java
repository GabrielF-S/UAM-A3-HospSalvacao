package com.h_salvacao.ms_token.service.impl;

import com.h_salvacao.ms_token.feigClients.TokenFeignClient;
import com.h_salvacao.ms_token.model.Paciente;
import com.h_salvacao.ms_token.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PacienteServiceImpl implements PacienteService {

    private  final TokenFeignClient feignClient;

    @Override
    public Paciente buscarPaciente(String cpf) {

      Paciente paciente = feignClient.getPaciente(cpf).getBody();
      if (paciente!= null){
          return paciente;
      }else {
          throw new RuntimeException("CPF não cadastrado na base de dados");
      }

    }

    @Override
    public Paciente pacienteSemCadastro() {
        return Paciente.builder().nome("Não identificado").build();

    }


}
