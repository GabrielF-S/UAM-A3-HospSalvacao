package com.h_salvacao.ms_connect.repository;

import com.h_salvacao.ms_connect.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findBynumToken(String numToken);
}
