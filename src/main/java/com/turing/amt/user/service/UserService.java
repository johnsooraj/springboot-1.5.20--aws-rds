package com.turing.amt.user.service;

import com.turing.amt.user.entity.UserEntity;

public interface UserService {

	public UserEntity createUser(UserEntity userEntity);

	public UserEntity updateUser(UserEntity userEntity);

	public boolean deleteUser(UserEntity userEntity);

	public UserEntity getUserById(Long id);
	
	public UserEntity findUserByUsername(String username);

}
