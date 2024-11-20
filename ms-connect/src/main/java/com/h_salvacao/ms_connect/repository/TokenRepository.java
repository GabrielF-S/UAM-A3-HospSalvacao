package com.h_salvacao.ms_token.repository;

import com.h_salvacao.ms_token.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
