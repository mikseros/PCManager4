package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.amalmikolaj.model.ModelFrame;
import com.amalmikolaj.model.Workstation;

public class SavePcModification implements ActionListener {
	
	// ActionListener for saving PC modifications in user & administrator panels.
	
	ModelFrame frame;
	
	public SavePcModification(ModelFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Workstation w = new Workstation();
			w.setId(Integer.valueOf(frame.getEditId().getText()));
			w.setBrand(frame.getEditBrand().getText());
			w.setModel(frame.getEditModel().getText());
			w.setTag(frame.getEditTag().getText());
			w.setStudentName(frame.getEdStudName().getText());
			w.setStudentSurname(frame.getEdStudSurn().getText());
			w.setCourse(frame.getEditCourse().getText());
			w.setDateOfBorrow(Date.valueOf(frame.getEditDob().getText()));
			w.setCheque(Boolean.parseBoolean(frame.getEditCheque().getText()));
			w.setReturnComment(frame.getEditRetComm().getText());
			frame.getDao().getWorkstationDao().modifyPC(w);
		} catch(Exception x) {
			System.out.println(x.getMessage());
		}
		
		frame.getEditId().setText("0");
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
