package com.photoapp.api.users.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequestModel {

	@NotNull(message = "First Name can't be null")
	@Size(min = 2, message = "First Name can't be less than 2 characters")
	private String firstName;
	@NotNull(message = "Last Name can't be null")
	@Size(min = 2, message = "Last Name can't be less than 2 characters")
	private String lastName;
	@NotNull(message = "Password can't be blank")
	@Size(min = 6, message = "Password can't be less than 2 characters")
	private String password;
	@NotNull(message = "Email can't be blank")
	@Email
	private String email;

}
