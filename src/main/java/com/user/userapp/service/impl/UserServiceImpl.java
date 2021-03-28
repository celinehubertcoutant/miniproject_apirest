package com.user.userapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userapp.dao.UserDao;
import com.user.userapp.dto.UserDTO;
import com.user.userapp.entity.User;
import com.user.userapp.mapper.UserMapper;
import com.user.userapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserMapper userMapper;
	
	
	/**
	 * Service for user creation
	 * @param userDTO from http request
	 * @since 1.0
	 */
	public void createUser(UserDTO userDTO) {
  
		User user = userMapper.dtoToEntity(userDTO);
        userDao.save(user);
  
	}
	
	/**
	 * <p>Service for user reading</p>
	 * @param String login
	 * @return UserDTO
	 * @since 1.0
	 */
	public UserDTO readUser(String login) {
		User user = userDao.findByLogin(login);
		UserDTO userDTO = userMapper.entityToDto(user);
		return userDTO;
	}
	
	/**
	 * <p>Service for check if login already exists in DB</p>
	 * @param String login
	 * @return boolean
	 * @since 1.0
	 */
	public boolean checkLogin(String login) {
		 User user = userDao.findByLogin(login);
		 
		 if (user == null) {
			 return true;
		 }
		 
		 else return false;	
	}
}
