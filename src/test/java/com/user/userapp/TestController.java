package com.user.userapp;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.user.userapp.controller.UserController;
import com.user.userapp.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@WebAppConfiguration
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestController {

	@Autowired 
	UserController userController;
	
	@Test
	public void testCreateUserNominalCase() {
		
		//expected 
		UserDTO user = new UserDTO("login1", "nom", "20", "FRANCE", "phone");
		
		ResponseEntity<UserDTO> expected = new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
		
		//result
		ResponseEntity<UserDTO> result = userController.createUser(user);
		
		// Assert
        assertEquals(expected, result);
	}
	
	
	@Test
	public void testCreateUserMiners() {
		
		//expected 
		UserDTO user = new UserDTO("login2", "nom", "9", "FRANCE", "phone");
		
		ResponseEntity<UserDTO> expected = new ResponseEntity<UserDTO>(user, HttpStatus.PRECONDITION_FAILED);
		
		//result
		ResponseEntity<UserDTO> result = userController.createUser(user);
		
		// Assert
        assertEquals(expected, result);
	}
	
	@Test
	public void testCreateUserNotFrenchPeople() {
		
		//expected 
		UserDTO user = new UserDTO("login3", "nom", "9", "GERMANY", "phone");
		
		ResponseEntity<UserDTO> expected = new ResponseEntity<UserDTO>(user, HttpStatus.PRECONDITION_FAILED);
		
		//result
		ResponseEntity<UserDTO> result = userController.createUser(user);
		
		// Assert
        assertEquals(expected, result);
	}
	
//	@Test
//	public void testReadUserNominalCase() {
//		
//		//Test login
//		String login = "login1";
//		
//		//expected 
//		UserDTO user = new UserDTO("login1", "nom", "20", "FRANCE", "phone");
//		
//		ResponseEntity<UserDTO> expected = new ResponseEntity<UserDTO>(user, HttpStatus.OK);
//		
//		//result
//		ResponseEntity<UserDTO> result = userController.readUser(login);
//		
//		// Assert
//        assertEquals(expected, result);
//	}
	
}
