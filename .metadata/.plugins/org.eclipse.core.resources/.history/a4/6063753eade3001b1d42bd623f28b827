package com.test.demo.services.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import com.test.demo.constants.Messages;
import com.test.demo.dtos.UserDto;
import com.test.demo.exceptions.UserAlreadyExistsException;
import com.test.demo.model.User;
import com.test.demo.repository.UserRepository;
import com.test.demo.services.AccountsService;

@SpringBootTest
public class UserDetailsServiceImplTests {
   
    @Autowired
    private UserDetailsService service;
    @MockBean
    private UserRepository repository;
    
    @Test
    @DisplayName("Test loadUserByUsername Success")
    void testloadUserByUsernameSuccess() {
    	var user = new User("1","username", "password", "fullname");
    	when(repository.findByUsername(any())).thenReturn(user);
    	
        // Execute the service call
        var response = service.loadUserByUsername(any());
        
        // Assert the response
        Assertions.assertNotNull(response);
    }    
    
    @Test
    @DisplayName("Test loadUserByUsername Invalid")
    void testloadUserByUsernameInvalid() {
    	when(repository.findByUsername(any())).thenReturn(null);
    	
        // Execute the service call
        var exception = assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("inam@gmail.com"));
        
        // Assert the response
        Assertions.assertTrue(exception.getMessage().contains("inam@gmail.com"));
    }
}