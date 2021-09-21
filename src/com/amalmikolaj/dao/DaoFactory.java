package com.amalmikolaj.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoFactory {

	private Connection con;
	private String uname = "PCMAnagerCSM";
	private String pass = "5LxN5h0b)g_[)1(c";
	
	public DaoFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://212.227.107.178:3306/PCMAnagerCSM", uname, pass);
			//System.out.println(this.con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public UserDao getUserDao() {
		 return new UserDao(con);
	}
	
	public WorkstationDao getWorkstationDao() {
		return new WorkstationDao(con);
	}

	public Connection getCon() {
		return con;
	}
}
