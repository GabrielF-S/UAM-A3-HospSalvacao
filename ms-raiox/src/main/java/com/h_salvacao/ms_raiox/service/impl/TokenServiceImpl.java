package com.h_salvacao.ms_raiox.service.impl;

import com.h_salvacao.ms_raiox.feingClient.TokenFeignClient;
import com.h_salvacao.ms_raiox.model.Token;
import com.h_salvacao.ms_raiox.service.TokenService;
import com.h_salvacao.ms_raiox.util.AtendimentoStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenFeignClient tokenFeignClient;
    @Override
    public Token getToken(String numToken) {
        Token token = tokenFeignClient.getToken(numToken).getBody();
        return token;
    }

    @Override
    public Token setStatus(Token token, AtendimentoStatus atendimentoStatus) {
        token.setStatus(atendimentoStatus);
        return token;
    }

    @Override
    public Token setRetorno(Token token) {
        token.setRetorno(true);
        return token;
    }

    @Override
    public void updateToken(Token token) {
        tokenFeignClient.updateToken(token);
    }
}
