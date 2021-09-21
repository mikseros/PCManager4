package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import com.amalmikolaj.AdminFrame2;
import com.amalmikolaj.model.User;

	// Listener for adding new user in administrator panel for users managing.

public class AddNewUserListen implements ActionListener {
	
	AdminFrame2 frame;
	
	public AddNewUserListen(AdminFrame2 frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		User user = new User();
		user.setName(frame.getAddUserName().getText());
		user.setSurname(frame.getAddUserSurname().getText());
		user.setDateOfBirth(Date.valueOf(frame.getAddUserDob().getText()));
		if(frame.getUserPost().isSelected()) {
			user.setPost("user");
		} else if(frame.getAdminPost().isSelected()) {
			user.setPost("admin");
		} else {
			JOptionPane.showMessageDialog(null, "Select post for new user!");
		}
		user.setPassword(frame.getAddUserPass().getText());
		user.setEmail(frame.getAddUserMail().getText());
		if(frame.getDao().getUserDao().getUserByMail(frame.getAddUserMail().getText())==null) {
			frame.getDao().getUserDao().addUser(user);
		} else {
			JOptionPane.showMessageDialog(null, "This e-mail is already in use!");
		}
		frame.getAddUserName().setText("");
		frame.getAddUserName().setEditable(false);
		frame.getAddUserSurname().setText("");
		frame.getAddUserSurname().setEditable(false);
		frame.getAddUserDob().setText("1900-01-01");
		frame.getAddUserDob().setEditable(false);
		frame.getUserPost().setSelected(false);
		frame.getUserPost().setEnabled(false);
		frame.getAdminPost().setSelected(false);
		frame.getAdminPost().setEnabled(false);
		frame.getAddUserPass().setText("");
		frame.getAddUserPass().setEditable(false);
		frame.getAddUserMail().setText(null);
		frame.getAddUserMail().setEditable(false);
		frame.getAddUser().setEnabled(false);
		frame.refreshList();
	}
}
