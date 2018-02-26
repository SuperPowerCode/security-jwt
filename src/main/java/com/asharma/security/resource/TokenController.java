package com.asharma.security.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asharma.security.model.JwtUser;
import com.asharma.security.secure.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Autowired 
	JwtGenerator jwtGenerator;
	
	@PostMapping
	public String generateToken(@RequestBody final JwtUser jwtUser) {
		String token = null;
		token = jwtGenerator.generate(jwtUser);		
		return token;
	}

}
