package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.amalmikolaj.*;

	//Action Listener for deleting workstation
	public class DeletePcListener implements ActionListener {
		
		AdminFrame frame;
		
		public DeletePcListener(AdminFrame frame) {
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Integer.valueOf(frame.getEditId().getText())!=0) {
				frame.getDao().getWorkstationDao().deletePC(Integer.valueOf(frame.getEditId().getText()));
			}
			frame.getEditId().setText("");
			frame.getEditBrand().setText("");
			frame.getEditModel().setText("");
			frame.getEditTag().setText("");
			frame.getEdStudName().setText("");
			frame.getEdStudSurn().setText("");
			frame.getEditCourse().setText("");
			frame.getEditDob().setText("");
			frame.getEditCheque().setText("");
			frame.getEditRetComm().setText("");
			frame.refreshList();
		}
	}
	
