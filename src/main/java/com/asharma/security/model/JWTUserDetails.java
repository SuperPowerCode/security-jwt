package com.asharma.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTUserDetails implements UserDetails {
	
	String userName;
	Long userId;
	String token;
	Collection<? extends GrantedAuthority> authorities;
	
	public JWTUserDetails(String userName, Long userId, String token, List<GrantedAuthority> grantedAuthority) {
		this.userName = userName;
		this.userId = userId;
		this.token = token;
		this.authorities = grantedAuthority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	public Long getUserId() {
		return this.userId;
	}

	public String getToken() {
		return this.token;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
