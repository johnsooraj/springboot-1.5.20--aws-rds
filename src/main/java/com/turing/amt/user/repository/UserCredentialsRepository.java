package com.turing.amt.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.amt.user.entity.UserCredentialsEntity;

public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, Long> {

	public Optional<UserCredentialsEntity> findByUsername(String username);

}
