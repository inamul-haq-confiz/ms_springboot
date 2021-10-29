package com.test.demo.dtos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenDto {

	public TokenDto(String token, Date issuedAt, Date expireAt) {
		this.token = token;
		this.issuedAt = issuedAt;
		this.expireAt = expireAt;
	}
	private String token;
	private Date issuedAt;
	private Date expireAt;
}
