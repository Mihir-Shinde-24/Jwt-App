package com.grt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grt.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
    User findByUserName(String username);
}