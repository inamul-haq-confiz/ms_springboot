package com.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.photoapp.api.users.dto.UserDto;

public interface UsersService extends UserDetailsService {
	UserDto createUser(UserDto userdetails);
	UserDto getUserByEmail(String email);
	UserDto getUserByUserId(String userId);

}
