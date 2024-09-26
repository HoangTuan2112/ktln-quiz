package org.do_an.quiz_java.services;

import lombok.RequiredArgsConstructor;
import org.do_an.quiz_java.model.Token;
import org.do_an.quiz_java.model.User;
import org.do_an.quiz_java.repositories.TokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    @Transactional
    public Token addToken(User user, String token){
        Token userToken = tokenRepository.findByUser(user);

        if(userToken != null){
            tokenRepository.delete(userToken);
        }

        long expiration = 86400;

        Token newToken = new Token();
        newToken.setUser(user);
        newToken.setToken(token);
        newToken.setExpirationDate(LocalDateTime.now().plusSeconds(expiration));
        return tokenRepository.save(newToken);
    }
}