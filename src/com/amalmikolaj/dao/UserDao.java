package com.amalmikolaj.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.amalmikolaj.UserFrame;
import com.amalmikolaj.AdminFrame;
import com.amalmikolaj.LoginFrame;
import com.amalmikolaj.model.User;
//import com.amalmikolaj.dao.DaoFactory;

public class UserDao {
	
	private Connection connection;

	public UserDao(Connection con) {
		this.connection = con;
	}
	
	
	public List<User> showAllUsers() throws Exception {
		
		// "The getter" for all users in the database.
		
        List<User> usersList = new ArrayList<User>();
        String query = "SELECT * FROM user;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            User u  = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getBoolean(8));
            usersList.add(u);
        }
        st.close();
        //connection.close();
        return usersList;

    }
	

	public User getUserById(int id) {
		
		// Method for getting an user from the database by his ID.
		
		User user = null;
		String userQuery = ("SELECT * FROM user WHERE user_id = ?;");
		try {
			PreparedStatement ps = connection.prepareStatement(userQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}

			ps.close();
//			connection.close();
			//System.out.println(user.toString());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return user;
	}
	
	public User getUserByMail(String mail) {
		
		// Method for getting the user by his e-mail address.
		
		User user = null;
		String userQuery = ("SELECT * FROM user WHERE mailAdress = ?;");
		try {
			PreparedStatement ps = connection.prepareStatement(userQuery);
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}

		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return user;
	}

	enum Post {
		Admin, User
	};
	private StringBuilder EncryptPassword(String password) {
		
		// Method for password-protection.
		
	    MessageDigest msg = null;
	    StringBuilder s = new StringBuilder();
		try {
			msg = MessageDigest.getInstance("SHA-256");
		    byte[] hash = msg.digest(password.getBytes(StandardCharsets.UTF_8));
		    // convertir bytes en hexadécimal
		    
		    for (byte b : hash) {
		        s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
		    
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		return s;
	}
	public void addUser(User user) {
		
		// Method for new-user addition.
		
		String userQuery = "INSERT INTO user (name, surname, date_of_birth, post ,password, mailAdress) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(userQuery);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setDate(3, (Date) user.getDateOfBirth());
			ps.setString(4,user.getPost());
			ps.setString(5, EncryptPassword(user.getPassword()).toString());
			ps.setString(6, user.getEmail());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "User addition successful!");
			//connection.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void modifyUser(User user, String mail) throws Exception{
		
		// Method for self-account modifications in the user & administrator panels.
		
			String modify = "UPDATE user SET name = ?, surname = ?, date_of_birth = ?, "
					+ "post = ?, mailAdress = ? WHERE mailAdress = ?";
			PreparedStatement ps = connection.prepareStatement(modify);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setDate(3, (java.sql.Date) user.getDateOfBirth());
			ps.setString(4, user.getPost());
			//ps.setString(5, EncryptPassword(user.getPassword()).toString());
			ps.setString(5, user.getEmail());
			ps.setString(6, mail);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Update successful!");
	}
	
	public void modifyPassword(User user, String mail) throws Exception {
		
		// Method for self-account password changing in the user & administrator panels.
		
		String modPass = "UPDATE user SET password = ? WHERE mailAdress = ?;";
		PreparedStatement ps = connection.prepareStatement(modPass);
		ps.setString(1, EncryptPassword(user.getPassword()).toString());
		ps.setString(2, mail);
		
		ps.executeUpdate();
		ps.close();
		JOptionPane.showMessageDialog(null, "Password update successful!");
		
	}
	
	public void changePass(User user, int id) throws Exception{
		
		// Method for users password changing in administrator-users-managing panel.
		
		String modPass = "UPDATE user SET password = ? WHERE user_id = ?;";
		PreparedStatement ps = connection.prepareStatement(modPass);
		ps.setString(1, EncryptPassword(user.getPassword()).toString());
		ps.setInt(2, user.getId());
		
		ps.executeUpdate();
		ps.close();
		JOptionPane.showMessageDialog(null, "Password update successful!");
		
	}
	
	
	public void updateUser(User user) throws Exception{
		
		// Method for modify user details.
		
		String SQLString = "UPDATE user SET name = ?, surname = ?, date_of_birth = ?, post = ?, mailAdress = ? WHERE user_id = ?;";
		
			PreparedStatement ps = connection.prepareStatement(SQLString);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setDate(3, (java.sql.Date) user.getDateOfBirth());
			ps.setString(4, user.getPost());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getId());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Update successfull!");
			//connection.close();
		
	}
	
	public void deleteUser(int id) {
		String SQLString = ("DELETE FROM user WHERE user_id = ?;");
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SQLString);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			//connection.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		
	}
	
	public void login(LoginFrame frame) {
			
		// Method for displaying the message about wrong login-data, and for hiding LoginFrame after successful logging in.
			@SuppressWarnings("deprecation")
			String passwordText = frame.passwordField.getText();
			
			try {
				
				StringBuilder  pass = EncryptPassword(passwordText);
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT mailAdress, password FROM user WHERE mailAdress=? AND password=?;");
				ps.setString(1, frame.userTextField.getText());
				ps.setString(2, pass.toString());
				//frame.passwordField.getText()pass.toString()
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong username or password");
					//frame.userTextField.setText("");
					frame.passwordField.setText("");
				}
			
			} catch (Exception ex){
				System.out.println(ex.getMessage());
			}
	}
	
	public void checkPost(LoginFrame frame) {
		
		// Method: for checking correctness of login data; for checking deletion of user; for checking user-post; for opening right panel after login.
		
		@SuppressWarnings("deprecation")
		String passwordText = frame.passwordField.getText();
		
		try {
			StringBuilder  pass = EncryptPassword(passwordText);
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT post, isDeleted FROM user WHERE mailAdress = ? AND password = ?;");
			ps.setString(1, frame.userTextField.getText());
			ps.setString(2, pass.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("isDeleted")==0) {
					switch(rs.getString("post")) {
					case "user":
						UserFrame uFrame = new UserFrame(frame.userTextField.getText());
						uFrame.setVisible(true);
						break;
					case "admin":
						AdminFrame aFrame = new AdminFrame(frame.userTextField.getText());
						aFrame.setVisible(true);
						break;
					}
				} else {
					JOptionPane.showMessageDialog(frame, "You can't log in!");
				}
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		};
	}
	
	public void deleteUserDao(int id) {
		
		// Method for user deletion in administrator panel (soft-deletion).
		
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("UPDATE user SET isDeleted = 1 WHERE user_id = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "User deleted!");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}