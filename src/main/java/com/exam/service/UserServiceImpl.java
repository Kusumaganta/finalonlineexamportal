package com.exam.service;

import java.util.LinkedHashSet;
import java.util.Optional;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.UserDTO;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exception.UserAlreadyExistsException;
import com.exam.exception.UserNotFoundException;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;
private static final Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);
@Autowired
private RoleRepository roleRepository;


	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws UserAlreadyExistsException {

	 User local=this.userRepository.findByUserName(user.getUsername());
	if(local!=null) {

		throw new UserAlreadyExistsException();
	}else {
		//user create
	for(UserRole ur:userRoles) {		
		roleRepository.save(ur.getRole());//for saving role if not exit 
	}
	user.getUserRole().addAll(userRoles);//setting roles in user
	local=this.userRepository.save(user);
	

	}
	logger.info("create User");
	return local;
	}
	//getting user by username
	@Override
	public UserDTO getUserById(long id) throws UserNotFoundException {

		Optional<User> optional=userRepository.findById(id) ;
		User user= optional.orElseThrow(()-> new UserNotFoundException());
		UserDTO user2=new UserDTO();
		user2.setUsername(user.getUsername());
			user2.setPassword(user.getPassword());
			user2.setEmail(user.getEmail());
			user2.setId(user.getId());
			user2.setProfile(user.getProfile());
			logger.info("getUserById");
			return user2;
		
	}
	
	@Override
	public void deleteUser(long userId) {
		this.userRepository.deleteById(userId);
		logger.info("deleteUser");	
	}
	@Override
	public void updateUser(Long userId, String emailId  ) throws UserNotFoundException {
		if(userRepository.existsById(userId)) {
       User user = userRepository.findById(userId).get();
       user.setEmail(emailId);
     
       userRepository.save(user);	
	}
		else {
			throw new UserNotFoundException();
		}
		logger.info("updateUser");
	}
	
@Override
public Set<User> getUsers() {
	logger.info("get AllUsers");
	return  new LinkedHashSet<>(this.userRepository.findAll());
}
}