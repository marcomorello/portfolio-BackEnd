/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mm.Security.jwt;

import com.portfolio.mm.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sari
 */


@Component
public class JwtProvider {
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	@Value("${Jwt.secret}")
	private Key secret;
	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(this.secret.toString());
		return Keys.hmacShaKeyFor(keyBytes);
	}
	@Value("${Jwt.expiration}")
	private int expiration;

	public String generateToken(Authentication authentication){
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+expiration*1000))
				.signWith(secret) //cambiar secret por getSigningKey()
				.compact();
	}

	public String getNombreUSuarioFromToken(String token){
		return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token){
		try{
			((JwtParser) Jwts.parserBuilder().setSigningKey(secret)).parseClaimsJws(token);
			return true;
		}catch (MalformedJwtException e){
			logger.error("Token mal formado");
		}catch (UnsupportedJwtException e){
			logger.error("Token no soportado");
		}catch (ExpiredJwtException e){
			logger.error("Token expirado");
		}catch (IllegalArgumentException e){
			logger.error("Token vacio");
		}catch (SecurityException e){
			logger.error("Firma no válida");
		}
		return false;
	}
}