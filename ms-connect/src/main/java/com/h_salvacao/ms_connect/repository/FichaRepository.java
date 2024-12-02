package com.h_salvacao.ms_connect.repository;

import com.h_salvacao.ms_connect.entity.Ficha;
import com.h_salvacao.ms_connect.entity.Token;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FichaRepository extends JpaRepository<Ficha, Long> {

    @Query("SELECT f FROM Ficha f WHERE f.token.id = :tokenId")
    Optional<Ficha> findByNumToken(@Param("tokenId") Long tokenId);
}
