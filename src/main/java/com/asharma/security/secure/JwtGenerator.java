package com.asharma.security.secure;

import org.springframework.stereotype.Component;

import com.asharma.security.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JwtUser jwtUser) {
		
		Claims claim = Jwts.claims().setSubject(jwtUser.getUserName());
		claim.put("userId", String.valueOf(jwtUser.getUserId()));
		claim.put("role", jwtUser.getRole());		
		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, "anutest").compact();
		
	}

	
}
