package com.turing.amt.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turing.amt.user.entity.CustomUserDetails;
import com.turing.amt.user.entity.UserCredentialsEntity;
import com.turing.amt.user.repository.UserCredentialsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCredentialsEntity> optionalCredentials = userCredentialsRepository.findByUsername(username);
		optionalCredentials.orElseThrow(() -> new UsernameNotFoundException("no user exist with " + username));
		return optionalCredentials.map(CustomUserDetails::new).get();
	}

}
