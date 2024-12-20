package com.h_salvacao.ms_connect.repository;

import com.h_salvacao.ms_connect.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> findByCpf(String cpf);
}
