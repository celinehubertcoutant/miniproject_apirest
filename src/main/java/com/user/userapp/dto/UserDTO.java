package com.user.userapp.dto;

import javax.validation.constraints.NotNull;


public class UserDTO {

	public UserDTO(){}

	public UserDTO(String login, String nom, String age, String country, String phone) {
		super();
		this.login = login;
		this.nom = nom;
		this.age = age;
		this.country = country;
		this.phone = phone;
	}



	@NotNull
	private String login;

	@NotNull
	private String nom;

	@NotNull
	private String age;

	@NotNull
	private String country;

	private String phone;


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

