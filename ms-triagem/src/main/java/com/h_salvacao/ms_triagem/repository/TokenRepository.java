package com.h_salvacao.ms_triagem.repository;

import com.h_salvacao.ms_triagem.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TokenRepository  extends JpaRepository<Token, Long> {

    @Query(value = "select * from tb_token where atendimento =1", nativeQuery = true)
    List<Token> findTokenTriagem();
}
