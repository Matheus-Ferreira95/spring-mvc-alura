package com.matheusf.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheusf.mvc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
		
	User findByUsername(String username);	
}
