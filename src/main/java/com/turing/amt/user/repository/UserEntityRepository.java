package com.turing.amt.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.amt.user.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
