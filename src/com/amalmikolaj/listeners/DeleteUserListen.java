package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.amalmikolaj.AdminFrame2;

	//Action Listener for user deletion
	public class DeleteUserListen implements ActionListener {
		
		AdminFrame2 frame;
		
		public DeleteUserListen(AdminFrame2 frame) {
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Integer.valueOf(frame.getEditUserId().getText())!=0) {
				frame.getDao().getUserDao().deleteUserDao(Integer.valueOf(frame.getEditUserId().getText()));
			}
			frame.getEditUserId().setText("");
			frame.getEditUserName().setText("");
			frame.getEditUserSurname().setText("");
			frame.getEditUserDob().setText("");
			frame.getEditUserPost().setText("");
			frame.getEditUserMail().setText("");
			frame.refreshList();
		}
	}
