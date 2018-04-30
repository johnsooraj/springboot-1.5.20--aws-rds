package com.turing.amt.user.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.turing.amt.user.entity.UserAddressEntity;
import com.turing.amt.user.entity.UserCredentialsEntity;
import com.turing.amt.user.entity.UserEntity;
import com.turing.amt.user.entity.UserRoleEntity;
import com.turing.amt.user.repository.UserRoleRepository;

@Component
public class InsertDummyData {

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserService userService;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		userRoleRepository.save(new UserRoleEntity("ADMIN"));
		userRoleRepository.save(new UserRoleEntity("USER"));
		userRoleRepository.save(new UserRoleEntity("SUPERADMIN"));
		userRoleRepository.save(new UserRoleEntity("DBA"));

		UserEntity user = new UserEntity();
		user.setFirstName("Harry");
		user.setMiddileName("N");
		user.setLastName("Storey");
		user.setAge(25);
		user.setEmail("harrynstore1y@gmail.com");
		user.setPhoneNumber("07926035007");
		user.setBirthday(new Date());
		user.setGender("male");
		
		UserAddressEntity address = new UserAddressEntity();
		address.setStreet("71 Pilgrim Avenue");
		address.setCity("Chevy Chase");
		address.setCountry("MD");
		address.setPincode("20815");
		user.setUserAddress(Arrays.asList(address));
		
		UserCredentialsEntity credentials = new UserCredentialsEntity();
		credentials.setUsername("john");
		credentials.setPassword("john");
		
		UserRoleEntity role = new UserRoleEntity();
		role.setRole("SUPERADMIN");
		credentials.setRoles(new HashSet<>(Arrays.asList(role)));
		user.setUserCredentials(credentials);
		
		userService.createUser(user);

	}
}
