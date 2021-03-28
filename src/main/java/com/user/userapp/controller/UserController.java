package com.user.userapp.controller;


import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.userapp.dto.UserDTO;
import com.user.userapp.service.UserService;

@Controller
@Configuration
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired 
	UserService userService;


	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO newUser) {

		long time = System.currentTimeMillis();
		
		logger.info("Creating new user with login : " + newUser.getLogin());

		String age = newUser.getAge();
		String login = newUser.getLogin();
		String country = newUser.getCountry().toUpperCase();
		
		//checking if login already exists in DB
		if (userService.checkLogin(login) == false) {
			time = System.currentTimeMillis() - time;
			logger.error("Creation impossible because user with login " + login + " already exists");
			logger.info("Processing time for user creation : " + time +  "ms");
			return new ResponseEntity<UserDTO> (newUser, HttpStatus.PRECONDITION_FAILED); 
		}

		//checking if user is French and not miner before user creation
		if (Integer.parseInt(age)>=18 && country.equals("FRANCE")) {
			
			userService.createUser(newUser);
			time = System.currentTimeMillis() - time;
			
			logger.info("User with login : " + newUser.getLogin() + " successfully created");
			logger.info("Processing time for user creation : " + time +  "ms");
			return new ResponseEntity<UserDTO> (newUser, HttpStatus.CREATED);
		}

		else {
			time = System.currentTimeMillis() - time;
			logger.error("Error during user creation" + newUser.toString());
			logger.error("Creation impossible for user who are not living in France and/or miners");
			logger.info("Processing time for user creation : " + time +  " ms");
			return new ResponseEntity<UserDTO> (newUser, HttpStatus.PRECONDITION_FAILED); 
		}

	}


	@GetMapping("/readUser/{login}")
	public ResponseEntity<UserDTO> readUser(@PathVariable (value = "login", required = true)  String login) {
		
		long time = System.currentTimeMillis();

		logger.info("Reading user with login : " + login);

		UserDTO user = userService.readUser(login);
		time = System.currentTimeMillis() - time;
		
		logger.info("Successfully reading user : " + user.toString());
		logger.info("Processing time for user reading : " + time +  "ms");
		return new ResponseEntity<UserDTO> (user, HttpStatus.OK);
	}


}
