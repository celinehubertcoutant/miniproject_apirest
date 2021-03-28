package com.user.userapp.mapper;

import org.mapstruct.Mapper;

import com.user.userapp.dto.UserDTO;
import com.user.userapp.entity.User;


@Mapper
public interface UserMapper {

	User dtoToEntity(UserDTO userDTO);
	
	UserDTO entityToDto(User user);
	
}

