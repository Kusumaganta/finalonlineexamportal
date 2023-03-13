package com.exam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	@Query("Select u from User u where u.username=:username")
	public  User findByUserName(@Param(value="username") String username) ;

	@Query("Select u from User u where u.id=:id")
	public Optional<User> findById(@Param(value="id")Long id);
	
	
}
