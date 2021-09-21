package com.amalmikolaj.model;

import java.util.Date;

public class Admin extends AbstractUser {
	
	// Model for Administrator.
	
	Admin() {
		
	}
	
	Admin(int id, String name, String surname, Date dateOfBirth, String post, String password, String email, boolean isDeleted) {
		super(id, name, surname, dateOfBirth, post, password, email, isDeleted);
		// TODO Auto-generated constructor stub
	}

}