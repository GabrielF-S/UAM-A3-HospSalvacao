package com.h_salvacao.ms_connect.repository;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TempoAtendimentoRepository extends JpaRepository<TempoAtendimento, Long> {

    Optional<TempoAtendimento> findBynumToken(String numToken);
}
