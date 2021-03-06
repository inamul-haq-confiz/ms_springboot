package com.photoapp.api.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.core.env.Environment;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.photoapp.api.users.dto.UserDto;
import com.photoapp.api.users.entities.UserEntity;
import com.photoapp.api.users.interfaces.AlbumsServiceClient;
import com.photoapp.api.users.model.AlbumResponseModel;
import com.photoapp.api.users.repository.UsersRepository;

import feign.FeignException;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	//@Autowired 
	//RestTemplate restTemplate;
	@Autowired
	Environment env;
	@Autowired
	AlbumsServiceClient albumsServiceClient;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	public UserDto createUser(UserDto userdetails) {
		userdetails.setUserId(UUID.randomUUID().toString());
		var mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		var userEntity = mapper.map(userdetails, UserEntity.class);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userdetails.getPassword()));
		usersRepository.save(userEntity);
		return  mapper.map(userEntity, UserDto.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var userEntity = usersRepository.findByEmail(username);
		if (userEntity == null) throw new UsernameNotFoundException(username);
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}
	@Override
	public UserDto getUserByEmail(String email) {
		
		UserEntity userEntity = usersRepository.findByEmail(email);
		if (userEntity == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}
	@Override
	public UserDto getUserByUserId(String userId) {
		
		UserEntity userEntity = usersRepository.findByUserId(userId);
			if(userEntity == null) {
				throw new UsernameNotFoundException("User not found");
			}
			
		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		
//	    Use these lines with RestTemplate:	
//		String albumsUrl = String.format(env.getProperty("albums.url"), userId);
//		
//		ResponseEntity<List<AlbumResponseModel>>albumsListResponse = restTemplate
//				  		  .exchange(albumsUrl, HttpMethod.GET, null, 
//						  new ParameterizedTypeReference<List<AlbumResponseModel>>() {					  
//				  });
//		List<AlbumResponseModel>albumList =albumsListResponse.getBody();


		logger.info("BEFORE calling Albums Ms");
//		And this line with Feign Client:
		List<AlbumResponseModel> albumList = albumsServiceClient.getAlbums(userId);		
		logger.info("AFTER calling Albums Ms");
		
		userDto.setAlbums(albumList);
		
		return userDto;
	}
}
