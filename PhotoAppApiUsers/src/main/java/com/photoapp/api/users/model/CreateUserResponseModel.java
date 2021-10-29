package com.photoapp.api.users.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserResponseModel {
	private String firstName;
	private String lastName;
	private String userId;
	private String email;
}
