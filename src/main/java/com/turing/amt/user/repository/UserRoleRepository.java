package com.turing.amt.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.amt.user.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

	public UserRoleEntity findByRole(String role);
}
