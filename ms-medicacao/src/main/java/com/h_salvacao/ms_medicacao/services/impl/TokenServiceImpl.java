package com.h_salvacao.ms_medicacao.services.impl;

import com.h_salvacao.ms_medicacao.feingClient.TokenFeignClient;
import com.h_salvacao.ms_medicacao.util.AtendimentoStatus;
import com.h_salvacao.ms_medicacao.model.Token;
import com.h_salvacao.ms_medicacao.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenFeignClient tokenFeignClient;

    @Override
    public void updateToken(Token token) {

        tokenFeignClient.updateToken(token);

    }

    @Override
    public Token getToken(String numToken) {
        return tokenFeignClient.getToken(numToken).getBody();
    }

    @Override
    public Token setRetorno(Token token) {
        token.setRetorno(true);
        return token;
    }

    @Override
    public Token setStatus(Token token ,AtendimentoStatus atendimentoStatus) {
        token.setStatus(atendimentoStatus);
        return token;
    }
}
