package com.photoapp.api.users.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoapp.api.users.dto.UserDto;
import com.photoapp.api.users.entities.UserEntity;
import com.photoapp.api.users.model.CreateUserRequestModel;
import com.photoapp.api.users.model.CreateUserResponseModel;
import com.photoapp.api.users.model.UserResponseModel;
import com.photoapp.api.users.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/status/check")
	public String status()
	{
		return "Working on port: " + env.getProperty("local.server.port") + ", with token = " + env.getProperty("token.secret");		
	}
	@PostMapping
	public ResponseEntity createUser(@Valid @RequestBody CreateUserRequestModel userDetails)
	{
		var mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		var userDto = mapper.map(userDetails, UserDto.class);
		var createdUser = usersService.createUser(userDto);
		var responseModel = mapper.map(createdUser, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}
	@GetMapping(value="/{userId}")
	public ResponseEntity<UserResponseModel>getUser(@PathVariable String userId){
		
		UserDto userDto = usersService.getUserByUserId(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDto,UserResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	

}
