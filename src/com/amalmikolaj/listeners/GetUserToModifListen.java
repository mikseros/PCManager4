package com.amalmikolaj.listeners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.amalmikolaj.AdminFrame2;
import com.amalmikolaj.model.User;

public class GetUserToModifListen implements ListSelectionListener {
	
	// Listener for item selection of users-list in administrator-users-managing panel.
	
	AdminFrame2 frame;
	
	public GetUserToModifListen(AdminFrame2 frame) {
		this.frame = frame;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(frame.getUserJList().isSelectionEmpty()) {
			//JOptionPane.showMessageDialog(null, "Nothing selected on the list!");
		} else {
			try {
				User u = frame.getUserJList().getSelectedValue();
				frame.getEditUserId().setText(String.valueOf(u.getId()));
				frame.getEditUserName().setText(u.getName());
				frame.getEditUserSurname().setText(u.getSurname());
				frame.getEditUserDob().setText(String.valueOf(u.getDateOfBirth()));
				frame.getEditUserPost().setText(u.getPost());
				frame.getEditUserMail().setText(u.getEmail());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
