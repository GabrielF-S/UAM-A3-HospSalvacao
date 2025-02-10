package com.h_salvacao.ms_connect.repository;

import com.h_salvacao.ms_connect.entity.TempoAtendimento;
import com.h_salvacao.ms_connect.entity.Token;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TempoAtendimentoRepository extends JpaRepository<TempoAtendimento, Long> {

    Optional<TempoAtendimento> findBynumToken(String numToken);

    @Query(value = "SELECT * FROM finalDate WHERE DATE(data_entrada) = :diaEntrada", nativeQuery = true)
    Optional<List<TempoAtendimento>> getBydiaEntrada(@Param("diaEntrada")LocalDate diaEntrada);

    @Query(value = "SELECT * FROM finalDate WHERE DATE(data_entrada) BETWEEN :startDate AND :finalDate", nativeQuery = true)
    Optional<List<TempoAtendimento>> getAtendimentoPorPeriodo(@Param("startDate")LocalDate inicio, @Param("finalDate") LocalDate finalDate);
}
