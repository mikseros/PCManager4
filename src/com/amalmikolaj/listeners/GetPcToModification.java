package com.amalmikolaj.listeners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.amalmikolaj.model.ModelFrame;
import com.amalmikolaj.model.Workstation;

public class GetPcToModification implements ListSelectionListener {
	
	// Listener for list of PC's in the user & administrator panel.
	
	ModelFrame frame;
	
	public GetPcToModification(ModelFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(frame.getWorkstationJList().isSelectionEmpty()) {
			
		} else {
			try {
				Workstation w = frame.getWorkstationJList().getSelectedValue();
				frame.getEditId().setText(String.valueOf(w.getId()));
				//Workstation w = dao.getWorkstationDao().getWorkstationById(Integer.valueOf(editId.getText()));
				frame.getEditBrand().setText(w.getBrand());
				frame.getEditModel().setText(w.getModel());
				frame.getEditTag().setText(w.getTag());
				frame.getEdStudName().setText(w.getStudentName());
				frame.getEdStudSurn().setText(w.getStudentSurname());
				frame.getEditCourse().setText(w.getCourse());
				frame.getEditDob().setText(w.getDateOfBorrow().toString());
				frame.getEditCheque().setText(String.valueOf(w.isCheque()));
				frame.getEditRetComm().setText(w.getReturnComment());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
