package com.amalmikolaj.model;

import java.util.Date;

public class User extends AbstractUser {
	
	// Model for User.
	
	public User() {
		
	}
	
	public User(int id, String name, String surname, Date dateOfBirth, String post, String password, String email, boolean isDeleted) {
		super(id, name, surname, dateOfBirth, post, password, email, isDeleted);
		// TODO Auto-generated constructor stub
	}
	
}
