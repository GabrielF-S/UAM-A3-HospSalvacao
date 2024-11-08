package com.h_salvacao.ms_token.service.impl;

import com.h_salvacao.ms_token.entity.Paciente;
import com.h_salvacao.ms_token.repository.PacienteRepository;
import com.h_salvacao.ms_token.service.PacienteService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository repository;
    @Override
    public Paciente buscarPaciente(String cpf) {

      Paciente paciente = repository.findByCpf(cpf).get();
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
