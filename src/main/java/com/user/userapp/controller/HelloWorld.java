package com.user.userapp.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorld {
	@RequestMapping(value="/HelloWorld", method=RequestMethod.GET)
	public String helloWorld() {
        return "Hello World";
    }
}

