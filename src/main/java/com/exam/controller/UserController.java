package com.exam.controller;

import java.util.HashSet;


import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.UserDTO;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exception.UserAlreadyExistsException;
import com.exam.exception.UserNotFoundException;
import com.exam.service.UserService;




@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	//creating user
	@PostMapping("/")//FOR SAVING 
	public User createUser(@Valid @RequestBody User user  ) throws UserAlreadyExistsException{
		    if (user == null) {
		        throw new IllegalArgumentException("User cannot be null");
		    }
		    if (user.getUsername() == null || user.getUsername().isEmpty()) {
		        throw new IllegalArgumentException("Username cannot be empty");
		    }
		    if (user.getPassword() == null || user.getPassword().isEmpty()) {
		        throw new IllegalArgumentException("Password cannot be empty");
		    }
		Set<UserRole> roles=new HashSet<>();
	Role role=new Role();
	role.setRoleId(45L);
	role.setRoleName("NORMAL");

	UserRole userRole=new UserRole();
	userRole.setUser(user);
	userRole.setRole(role);
	
	roles.add(userRole);
return this.userService.createUser(user, roles);
//return new ResponseEntity<UserDTO>(user, userRole);
	}
	@GetMapping("/{id}")
	public UserDTO getUserById(@PathVariable("id")Long id) throws UserNotFoundException {
		UserDTO user=userService.getUserById(id);
		return user;
	}
	@GetMapping("/")
	public ResponseEntity<?> getUsers()
	{
		return ResponseEntity.ok(this.userService.getUsers());
		
	}
		//del user by userid
		@DeleteMapping("/{userId}")
		public void deleteUser(@PathVariable("userId") long userId) 
		{
			this.userService.deleteUser(userId);
		}
		
		@PutMapping(value = "/{userId}")
		public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserDTO user)throws UserNotFoundException
				 {
			userService.updateUser(userId, user.getEmail()  );
			//String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
			return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
		}
	}