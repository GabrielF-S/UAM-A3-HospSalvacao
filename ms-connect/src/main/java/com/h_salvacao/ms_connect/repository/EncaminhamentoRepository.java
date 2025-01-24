package com.h_salvacao.ms_connect.repository;

import com.h_salvacao.ms_connect.entity.Encaminhamento;
import com.h_salvacao.ms_connect.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EncaminhamentoRepository extends JpaRepository<Encaminhamento, Long> {
    Encaminhamento findBynumToken(String numToken);
}
