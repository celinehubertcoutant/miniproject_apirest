package com.user.userapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.userapp.entity.User;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

	public User findByLogin(String login);
	
}
