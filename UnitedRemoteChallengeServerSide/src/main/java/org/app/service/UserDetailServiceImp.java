package org.app.service;

import java.util.ArrayList;
import java.util.Collection;

import org.app.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		AppUser user = accountService.findUserByUsername(username);
		if(user == null) throw new UsernameNotFoundException(username + " not found!");
		Collection<GrantedAuthority> authority = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authority.add(new SimpleGrantedAuthority(role.getRolename()));
		});
		return new User(user.getUsername(), user.getPassword(), authority);
	}

}
