package com.playing.cards.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.playing.cards.dao.UserRepository;
import com.playing.cards.dao.UserRolesRepository;
import com.playing.cards.domain.User;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private  UserRolesRepository userRolesRepository;
	
	
	
        
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+email);
		}else{
			List<String> userRoles=userRolesRepository.findRoleByEmail(email);
			return new AuthenticationService(user,userRoles);
		}
	}
		
}
