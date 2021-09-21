package com.amalmikolaj;

import javax.swing.*;
import java.awt.*;

import com.amalmikolaj.listeners.DeletePcListener;
import com.amalmikolaj.model.ModelFrame;

public class AdminFrame extends ModelFrame{
	private static final long serialVersionUID = 1L;
	
	// Button and panel for "administrator-options".
	JButton adminOptionsButton = new JButton();
	JPanel adminOptionsButtonPanel = new JPanel();
	// Button and panel for "PC" deletion.
	JButton deletePcButton = new JButton();
	JPanel deletePcButtonPanel = new JPanel();
	
	// Managing the panel with the buttons. Addition of two new buttons: "deletePcButton", and "adminOptionsButton".
	public void manageC2() {
		getPanelC().setLayout(new GridLayout(7, 1));
		getPanelC().add(deletePcButtonPanel);
		getPanelC().add(adminOptionsButtonPanel);
	}
	// Managing the label with the title.
	public void label2Manage() {
		getLabel().setText("Welcome to PC Admin-Manager!");
	}
	//Managing "adminOptions" button.
	public void ManageAdminOptionsButton() {
		adminOptionsButton.setText("Users Manager >>>");
		adminOptionsButton.setBackground(Color.WHITE);
		adminOptionsButton.setPreferredSize(new Dimension(200, 50));
		adminOptionsButton.setFocusable(false);
		adminOptionsButton.addActionListener(e -> {
			@SuppressWarnings("unused")
			AdminFrame2 adFrame2 = new AdminFrame2(this.getMail());
			this.setVisible(false);
		});
	}
	//Managing the panel which hold "adminOptionsButton" button.
	public void ManageAdminOptionsButtonPanel() {
		adminOptionsButtonPanel.setPreferredSize(new Dimension(200, 50));
		adminOptionsButtonPanel.add(adminOptionsButton);
	}
	// Managing "deletePcButton" button.
	public void manageDeletePcButton() {
		deletePcButton.setText("Delete PC");
		deletePcButton.setBackground(Color.red);
		deletePcButton.setPreferredSize(new Dimension(200, 50));
		deletePcButton.setFocusable(false);
		deletePcButton.addActionListener(new DeletePcListener(this));
	}
	// Managing the panel for "deletePcButton" button.
	public void manageDeletePcButtonPanel() {
		deletePcButtonPanel.setPreferredSize(new Dimension(200, 50));
		deletePcButtonPanel.add(deletePcButton);
		deletePcButtonPanel.setVisible(true);
	}
	// Constructor of the frame
	public AdminFrame(String mail) {
		super(mail);
		// Invoking managing-methods for the "AdminFrame".
		label2Manage();
		manageC2();
		ManageAdminOptionsButton();
		ManageAdminOptionsButtonPanel();
		manageDeletePcButton();
		manageDeletePcButtonPanel();	
	}	
}