package com.photoapp.api.users.dto;
import java.util.List;

import com.photoapp.api.users.model.AlbumResponseModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encryptedPassword;
	private List<AlbumResponseModel> albums;
}
