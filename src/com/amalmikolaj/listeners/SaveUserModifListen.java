package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.amalmikolaj.AdminFrame2;
import com.amalmikolaj.model.User;

public class SaveUserModifListen implements ActionListener {
	
	// ActionListener for saving user-modifications button in administrator-users-managing panel.
	
	AdminFrame2 frame;
	
	public SaveUserModifListen(AdminFrame2 frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			User u = new User();
			u.setId(Integer.valueOf(frame.getEditUserId().getText()));
			u.setName(frame.getEditUserName().getText());
			u.setSurname(frame.getEditUserSurname().getText());
			u.setDateOfBirth(Date.valueOf(frame.getEditUserDob().getText()));
			u.setPost(frame.getEditUserPost().getText());
			u.setEmail(frame.getEditUserMail().getText());
			
			frame.getDao().getUserDao().updateUser(u);
		} catch(Exception x) {
			System.out.println(x.getMessage());
		}
		frame.refreshList();
		
	}	
}

/*
 * if(frame.getDao().getUserDao().getUserByMail(frame.getEditUserMail().getText())==null ||
			  (frame.getEditUserMail().getText())==frame.getMail()){
				u.setEmail(frame.getEditUserMail().getText());
			} else if (frame.getDao().getUserDao().getUserById(Integer.valueOf(frame.getEditUserId().toString()))==
					frame.getDao().getUserDao().getUserByMail(frame.getEditUserMail().getText())) {
				u.setEmail(frame.getEditUserMail().getText());
			} else {
				JOptionPane.showMessageDialog(null, "This e-mail is already in use!");
			}
 */