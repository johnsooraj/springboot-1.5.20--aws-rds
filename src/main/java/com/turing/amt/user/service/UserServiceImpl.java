package com.turing.amt.user.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turing.amt.user.entity.UserEntity;
import com.turing.amt.user.entity.UserRoleEntity;
import com.turing.amt.user.repository.UserAddressRepository;
import com.turing.amt.user.repository.UserCredentialsRepository;
import com.turing.amt.user.repository.UserEntityRepository;
import com.turing.amt.user.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserEntityRepository userRepository;

	@Autowired
	UserAddressRepository userAddressRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Override
	public UserEntity createUser(UserEntity userEntity) {

		userEntity.getUserCredentials()
				.setPassword(passwordEncoder.encode(userEntity.getUserCredentials().getPassword()));
		if (!userEntity.getUserCredentials().getRoles().isEmpty()) {
			Set<UserRoleEntity> newRoleList = new HashSet<>();
			for (UserRoleEntity role : userEntity.getUserCredentials().getRoles()) {
				UserRoleEntity newRole = userRoleRepository.findByRole(role.getRole());
				if (newRole != null)
					newRoleList.add(newRole);
			}
			userEntity.getUserCredentials().setRoles(newRoleList);
		}

		userRepository.save(userEntity);
		return userEntity;
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		return null;
	}

	@Override
	public boolean deleteUser(UserEntity userEntity) {
		return false;
	}

	@Override
	public UserEntity getUserById(Long id) {
		return null;
	}

	@Override
	public UserEntity findUserByUsername(String username) {
		return userCredentialsRepository.findByUsername(username).get().getUserEntity();
	}

}
