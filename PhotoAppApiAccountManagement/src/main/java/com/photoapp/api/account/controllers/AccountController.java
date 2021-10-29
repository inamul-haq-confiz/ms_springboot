package com.photoapp.api.account.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	@GetMapping("/status/check")
	public String status()
	{
		return "Welcome to Account Mangement";
		
	}
}
