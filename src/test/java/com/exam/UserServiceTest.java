package com.exam;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.exam.controller.UserController;
import com.exam.dto.UserDTO;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exception.UserAlreadyExistsException;
import com.exam.exception.UserNotFoundException;
import com.exam.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserService userService;

    @Mock
    private Environment environment;

    @InjectMocks
    private UserController userController;

//    @Test
//    public void testCreateUser() throws UserAlreadyExistsException {
//        // Prepare test data
//        User user = new User();
//        user.setUsername("john_doe");
//        user.setPassword("password");
//        user.setEmail("john.doe@example.com");
//        UserRole userRole = new UserRole();
//        Role role = new Role();
//        role.setRoleId(45L);
//        role.setRoleName("NORMAL");
//        userRole.setUser(user);
//        userRole.setRole(role);
//        Set<UserRole> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//
//        // Prepare mock behavior
//        when(userService.createUser(user, userRoles)).thenReturn(user);
//
//        // Call the API
//        User createdUser = userController.createUser(user);
//
//        // Verify the result
//        assertEquals(user, createdUser);
//        verify(userService, times(1)).createUser(user, userRoles);
//    }

    @Test
    public void testGetUserById() throws UserNotFoundException {
        // Prepare test data
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUsername("john_doe");
        userDTO.setPassword("password");
        userDTO.setEmail("john.doe@example.com");

        // Prepare mock behavior
        when(userService.getUserById(1L)).thenReturn(userDTO);

        // Call the API
        UserDTO result = userController.getUserById(1L);

        // Verify the result
        assertEquals(userDTO, result);
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    public void testGetUsers() {
        // Prepare test data
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("john_doe");
        user1.setPassword("password");
        user1.setEmail("john.doe@example.com");
        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("jane_doe");
        user2.setPassword("password");
        user2.setEmail("jane.doe@example.com");
        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);

        // Prepare mock behavior
        when(userService.getUsers()).thenReturn(users);

        // Call the API
        ResponseEntity<?> responseEntity = userController.getUsers();

        // Verify the result
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(users, responseEntity.getBody());
        verify(userService, times(1)).getUsers();
    }

    @Test
    public void testDeleteUser() {
        // Call the API
        userController.deleteUser(1L);

        // Verify the behavior
        verify(userService, times(1)).deleteUser(1L);
    }

//    @Test
//    public void testUpdateUser() throws UserNotFoundException {
//        // Call the API
//        ResponseEntity<String> responseEntity = userController.updateUser(1L, "john.doe@example.com");
//
//        // Verify the result
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Email Updated successfully", responseEntity.getBody());
//        verify(userService, times(1)).updateUser(1L, "john.doe@example.com");
//    }
}

