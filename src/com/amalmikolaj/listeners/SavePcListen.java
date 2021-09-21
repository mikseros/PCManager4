package com.amalmikolaj.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.amalmikolaj.model.ModelFrame;
import com.amalmikolaj.model.Workstation;

public class SavePcListen implements ActionListener {
	
	// ActionListener for saving the new PC addition button in user & administrator panel.
	
	ModelFrame frame;
	
	public SavePcListen(ModelFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Workstation workstation = new Workstation();
		workstation.setBrand(frame.getBrand().getText());
		workstation.setModel(frame.getModel().getText());
		workstation.setTag(frame.getTag().getText());
		workstation.setStudentName(frame.getStudentName().getText());
		workstation.setStudentSurname(frame.getStudentSurname().getText());
		workstation.setCourse(frame.getCourse().getText());
		workstation.setDateOfBorrow(Date.valueOf(frame.getDateOfBorrow().getText()));
		workstation.setCheque(Boolean.parseBoolean(frame.getCheque().getText()));
		workstation.setReturnComment(frame.getReturnComment().getText());
		workstation.setIsDeleted(false);
		frame.getDao().getWorkstationDao().addWorkstation(workstation);
		
		frame.getBrand().setText("");
		frame.getModel().setText("");
		frame.getTag().setText("");
		frame.getStudentName().setText("");
		frame.getStudentSurname().setText("");
		frame.getCourse().setText("");
		frame.getDateOfBorrow().setText("1900-01-01");
		frame.getCheque().setText("");
		frame.getReturnComment().setText("");
		frame.refreshList();
		frame.getWorkstationJList().setSelectedIndex(0);
	}
	
}
