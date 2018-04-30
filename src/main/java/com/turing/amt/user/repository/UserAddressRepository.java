package com.turing.amt.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.amt.user.entity.UserAddressEntity;

public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {

}
