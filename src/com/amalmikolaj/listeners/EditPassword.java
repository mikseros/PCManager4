package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.amalmikolaj.model.ModelFrame;
import com.amalmikolaj.model.User;

public class EditPassword implements ActionListener {
	
	// ActionListener for self-account password change in user & administrator panel.
	
	ModelFrame frame;
	
	public EditPassword(ModelFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			User user = new User();
			user.setId(Integer.valueOf(frame.getEditId().getText()));
			user.setName(frame.getUserName().getText());
			user.setSurname(frame.getSurname().getText());
			user.setDateOfBirth(Date.valueOf(frame.getDateOfBirth().getText()));
			user.setPost(frame.getPost().getText());
			user.setPassword(frame.getPassword().getText());
			user.setEmail(frame.getEmail().getText());
			frame.getDao().getUserDao().modifyPassword(user, frame.getMail());
		} catch(Exception x) {
			System.out.println(x.getMessage());
		}
		frame.getPassword().setText(null);
		frame.getPassword().setEditable(false);
		frame.getSaveNewPassButtonPanel().setVisible(false);
	}
}
