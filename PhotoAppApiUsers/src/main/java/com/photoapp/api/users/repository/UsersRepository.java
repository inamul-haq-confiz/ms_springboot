package com.photoapp.api.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.photoapp.api.users.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);

}
