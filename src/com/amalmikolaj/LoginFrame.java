package com.amalmikolaj;

import javax.swing.*;

import com.amalmikolaj.dao.DaoFactory;
import com.amalmikolaj.listeners.LoginFormKeysListener;
import com.amalmikolaj.model.User;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class LoginFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	// Element declarations for the content of LoginFrame.
	Container container = getContentPane();
	JLabel userLabel = new JLabel("Your e-mail");
	JLabel passwordLabel = new JLabel("PASSWORD");
	public JTextField userTextField = new JTextField();
	public JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("SHOW PASSWORD");
	Connection con;
	DaoFactory dao = new DaoFactory();
	
	User u;
	
	public LoginFrame() {
		// Constructor of login frame.
		this.setTitle("PCManager Login");
		Image icon = Toolkit.getDefaultToolkit().getImage("resources/csm.png");    
		this.setIconImage(icon);
		this.setVisible(true);
		this.getRootPane().setDefaultButton(loginButton);
		this.setBounds(10, 10, 370, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		userTextField.requestFocus();
	}
	// Method setting the layout for the LoginFrame
	public void setLayoutManager() {
		container.setLayout(null);
	}
	// Method setting locations for the elements contain in the LoginFrame
	public void setLocationAndSize() {
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		passwordField.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
	}
	// A method for adding elements to the LoginFrame.
	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
	}
	// ActionListener for LoginFrame.
	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
		userTextField.addKeyListener(new LoginFormKeysListener(this));
		passwordField.addKeyListener(new LoginFormKeysListener(this));
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==loginButton) {
			dao.getUserDao().login(this);
			dao.getUserDao().checkPost(this);
			//u = dao.getUserDao().getUserByMail(userTextField.getText());
		}
		
		if(e.getSource()==resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource()==showPassword) {
			if(showPassword.isSelected()) {
				passwordField.setEchoChar((char)0);
			} else {
				passwordField.setEchoChar('*');
			}
		}
	}
	public JTextField getUserTextField() {
		return userTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}