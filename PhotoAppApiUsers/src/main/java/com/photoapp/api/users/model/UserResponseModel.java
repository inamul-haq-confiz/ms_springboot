package com.photoapp.api.users.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseModel {

	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private List<AlbumResponseModel> albums;
}
