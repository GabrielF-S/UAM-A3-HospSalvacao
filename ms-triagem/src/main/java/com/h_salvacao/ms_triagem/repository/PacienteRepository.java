package com.h_salvacao.ms_triagem.repository;

import com.h_salvacao.ms_triagem.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
