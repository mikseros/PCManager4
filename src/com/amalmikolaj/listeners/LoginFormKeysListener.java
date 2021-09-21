package com.amalmikolaj.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.amalmikolaj.LoginFrame;

public class LoginFormKeysListener implements KeyListener {
	
	LoginFrame frame;
	
	public LoginFormKeysListener(LoginFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			frame.getUserTextField().requestFocus();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			frame.getPasswordField().requestFocus();
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
