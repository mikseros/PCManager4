package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.amalmikolaj.AdminFrame2;
import com.amalmikolaj.model.User;

public class ChangePassListen implements ActionListener {
	
	// Listener for changing password for the user in the administrator-user managing panel.
	
	AdminFrame2 frame;
	
	public ChangePassListen(AdminFrame2 frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			User user = new User();
			user.setId(Integer.valueOf(frame.getEditUserId().getText()));
			user.setName(frame.getEditUserName().getText());
			user.setSurname(frame.getEditUserSurname().getText());
			user.setDateOfBirth(Date.valueOf(frame.getEditUserDob().getText()));
			user.setPost(frame.getEditUserPost().getText());
			user.setPassword(frame.getEditUserPass().getText());
			user.setEmail(frame.getEditUserMail().getText());
			frame.getDao().getUserDao().changePass(user, user.getId());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		frame.getEditUserPass().setText(null);
		frame.getEditUserPass().setEditable(false);
		frame.getSaveNewPassButtonPanel().setVisible(false);
		frame.refreshList();
	}

}