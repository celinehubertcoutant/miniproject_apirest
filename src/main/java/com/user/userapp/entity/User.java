package com.user.userapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER")
public class User {

	public User(){}

	@Id
	@GeneratedValue
	private Long id;


	@Column(name = "LOGIN", length = 30, nullable = false)
	private String login;


	@Column(name = "NOM", length = 30, nullable = false)
	private String nom;

	
	@Column(name = "AGE", length = 30, nullable = false)
	private String age;


	@Column(name = "COUNTRY", length = 30, nullable = false)
	private String country;

	@Column(name = "PHONE", columnDefinition = "varchar(30) default 'unknomn'")
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", nom=" + nom + ", age=" + age + ", country=" + country
				+ ", phone=" + phone + "]";
	} 









}
