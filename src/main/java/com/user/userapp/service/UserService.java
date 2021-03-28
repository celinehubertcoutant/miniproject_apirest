package com.user.userapp.service;

import org.springframework.stereotype.Service;

import com.user.userapp.dto.UserDTO;


@Service
public abstract interface UserService {

	public void createUser(UserDTO user);
	
	public UserDTO readUser(String login);
	
	public boolean checkLogin (String login);
}
