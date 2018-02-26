package com.asharma.security.secure;

import org.springframework.stereotype.Component;

import com.asharma.security.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret ="anutest";
	
	public JwtUser validate(String token) {
	 JwtUser jwtUser = null;
	 try {
	 Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	 jwtUser = new JwtUser();
	 jwtUser.setUserName(claims.getSubject());
	 jwtUser.setUserId(Long.getLong(claims.getId()));
	 jwtUser.setRole((String)claims.get("role"));
	 } catch( Exception e) {
		System.out.println("Error"+ e); 
	 }
	return jwtUser;
	}

}
