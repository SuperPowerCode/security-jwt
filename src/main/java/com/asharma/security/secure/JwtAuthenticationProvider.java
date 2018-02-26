package com.asharma.security.secure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.asharma.security.model.JWTUserDetails;
import com.asharma.security.model.JwtAuthenticationToken;
import com.asharma.security.model.JwtUser;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	
	@Autowired
	JwtValidator  validator;
	@Override
	public boolean supports(Class<?> authentication) {
		
		return JwtAuthenticationToken.class.isAssignableFrom(authentication);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authentication;
		String token = jwtToken.getToken();
		JwtUser user = validator.validate(token); 
		if(user == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}
		
		List<GrantedAuthority> grantedAuthority = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
		return new JWTUserDetails(user.getUserName(),user.getUserId(),token,grantedAuthority);
		
	
	}

}
