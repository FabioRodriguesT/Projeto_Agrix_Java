package com.betrybe.agrix.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Class: Token Service.
 */
@Service
public class TokenService {

  private final Algorithm algorithm;

  public TokenService(@Value("jabuticaba") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Method: Generate Token.
   */
  public String generateToken(String username) {
    return JWT.create()
            .withSubject(username)
            .withExpiresAt(generateExpiration())
            .sign(algorithm);
  }

  private Instant generateExpiration() {
    return Instant.now().plus(2, ChronoUnit.HOURS);
  }

  /**
   * Method: Validate Token.
   */
  public String validateToken(String token) {
    return JWT.require(algorithm)
            .build()
            .verify(token)
            .getSubject();
  }
}
