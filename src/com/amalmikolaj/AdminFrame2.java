package com.amalmikolaj;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import com.amalmikolaj.dao.DaoFactory;
import com.amalmikolaj.listeners.AddNewUserListen;
import com.amalmikolaj.listeners.ChangePassListen;
import com.amalmikolaj.listeners.DeleteUserListen;
import com.amalmikolaj.listeners.GetUserToModifListen;
import com.amalmikolaj.listeners.SaveUserModifListen;
import com.amalmikolaj.model.User;

public class AdminFrame2 extends JFrame{
	private static final long serialVersionUID = 1L;
	
	String mail ;
	
	DefaultListModel<User> modelUser = new DefaultListModel<User>();
	JList<User> userJList = new JList<User>(modelUser);
	ArrayList<User> userList = new ArrayList<User>();
	JScrollPane userListScroll = new JScrollPane();
	DaoFactory dao = new DaoFactory();
	JLabel label = new JLabel();
	
	JRadioButton userPost = new JRadioButton("User");
	JRadioButton adminPost = new JRadioButton("Admin");
	ButtonGroup postButtonsGroup = new ButtonGroup();
	JPanel postButtonsPanel = new JPanel();
	

	JPanel panelA = new JPanel();
	JPanel panelB = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelD = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelF = new JPanel();
	
	//TextFields and Labels for user edition panel
	JLabel editUserIdL = new JLabel("Here you can modify users. For update, just click 'Save Modification' button.");
	JLabel editUserNameL = new JLabel("Name: ");
	JLabel editUserSurnameL = new JLabel("Surname: ");
	JLabel editUserDobL = new JLabel("Date of birth: ");
	JLabel editUserPostL = new JLabel("Post: ");
	JLabel editUserPassL = new JLabel("Password: ");
	JLabel editUserMailL = new JLabel("E-mail: ");
	
	JTextField editUserId = new JTextField("0");
	JTextField editUserName = new JTextField();
	JTextField editUserSurname = new JTextField();
	JTextField editUserDob = new JTextField();
	JTextField editUserPost = new JTextField();
	JTextField editUserPass = new JTextField();
	JTextField editUserMail = new JTextField();
	
	// TextFields and Labels for new user addition
	JLabel addUserIdL = new JLabel("ID: ");
	JLabel addUserNameL = new JLabel("Name: ");
	JLabel addUserSurnameL = new JLabel("Surname: ");
	JLabel addUserDobL = new JLabel("Date of birth: ");
	JLabel addUserPostL = new JLabel("Post: ");
	JLabel addUserPassL = new JLabel("Password: ");
	JLabel addUserMailL = new JLabel("E-mail: ");
	
	JTextField addUserId = new JTextField("0");
	JTextField addUserName = new JTextField();
	JTextField addUserSurname = new JTextField();
	JTextField addUserDob = new JTextField();
	JTextField addUserPost = new JTextField();
	JTextField addUserPass = new JTextField();
	JTextField addUserMail = new JTextField();
	
	JButton addUser = new JButton();
	JButton unblock = new JButton();

	
	JButton modifyU = new JButton("Save Modification");
	
	JButton deleteUserButton = new JButton();
	JPanel deleteUserButtonPanel = new JPanel();
	
	JButton activatePassChangeButton = new JButton();
	JPanel activatePassChengeButtonPanel = new JPanel();
	
	JButton saveNewPassButton = new JButton();
	JPanel saveNewPassButtonPanel = new JPanel();
	
	JButton pcAdminOptionsButton = new JButton();
	JPanel pcAdminOptionsButtonPanel = new JPanel();
	
	JButton logoutButton = new JButton();
	JPanel logoutButtonPanel = new JPanel();

	public void manageE() {
		panelE.setSize(800, 250);
		panelE.setLayout(new BorderLayout());
		panelE.add(label, BorderLayout.NORTH);
		userJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userJList.addListSelectionListener(new GetUserToModifListen(this));
		refreshList();
        userListScroll = new JScrollPane(userJList);
        userListScroll.setSize(800, 150);
        panelE.add(userListScroll, BorderLayout.CENTER);
	}
	
	public void refreshList() {
        userList.clear();
        
        try {
            ArrayList<User> ListOfUsers = (ArrayList<User>) dao.getUserDao().showAllUsers() ;
            for(int i = 0; i + 1 <= ListOfUsers.size(); i++) {
                if(ListOfUsers.get(i).isDeleted()==false) {
                    userList.add(ListOfUsers.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        modelUser.clear();
        modelUser.addAll(userList);
        //workstationJList.setSelectedIndex(0);
    }
	
	// Managing the panel which holds the form for user edition.
	public void manageF() {
		panelF.setSize(800, 450);
		panelF.setLayout(new GridLayout(15, 2));
		panelF.add(editUserIdL);
		panelF.add(editUserId);
		panelF.add(editUserNameL);
		panelF.add(editUserName);
		panelF.add(editUserSurnameL);
		panelF.add(editUserSurname);
		panelF.add(editUserDobL);
		panelF.add(editUserDob);
		panelF.add(editUserPostL);
		panelF.add(editUserPost);
		panelF.add(editUserPassL);
		panelF.add(editUserPass);
		panelF.add(editUserMailL);
		panelF.add(editUserMail);
		panelF.add(modifyU);
		panelF.setVisible(true);
	}
	
	// Managing the button for save the modification of user.
	public void manageModifyU() {
		modifyU.setFocusable(false);
		modifyU.setBackground(Color.ORANGE);
		modifyU.addActionListener(new SaveUserModifListen(this));
	}
	// Managing of the panels which are hold everything else.
	
	public void manageA() {
		// Managing panel A which holds panel with list of users(panel E), and panel with users modification area (panel F)
		panelA.setSize(800, 700);
		panelA.setLayout(new BorderLayout());
		panelA.add(panelE, BorderLayout.NORTH);
		panelA.add(panelF, BorderLayout.CENTER);
	}
	
	public void manageB() {
		// Managing panel B which holds panel with buttons (panel C) and new-user-addition-area panel (panel D)
		panelB.setSize(800, 700);
		panelB.setLayout(new GridLayout(1, 2));
		panelB.add(panelC);
		panelB.add(panelD);
	}
	public void manageC() {
		
		panelC.setSize(400, 700);
		panelC.setLayout(new GridLayout(5, 1));
		panelC.add(activatePassChengeButtonPanel);
		panelC.add(saveNewPassButtonPanel);
		panelC.add(deleteUserButtonPanel);
		panelC.add(pcAdminOptionsButtonPanel);
		panelC.add(logoutButtonPanel);
		
	}
	
	public void managePostButtonsGroup() {
		postButtonsGroup.add(userPost);
		postButtonsGroup.add(adminPost);
	}
	
	public void managePostButtonsPanel() {
		postButtonsPanel.setLayout(new GridLayout(1,2));
		postButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));;
		postButtonsPanel.add(userPost);
		postButtonsPanel.add(adminPost);
	}
	
	public void manageD() {
		panelD.setSize(400, 700);
		panelD.setLayout(new GridLayout(15, 1));
		panelD.add(unblock);
		panelD.add(addUserId);
		panelD.add(addUserNameL);
		panelD.add(addUserName);
		panelD.add(addUserSurnameL);
		panelD.add(addUserSurname);
		panelD.add(addUserDobL);
		panelD.add(addUserDob);
		panelD.add(addUserPostL);
		panelD.add(postButtonsPanel);
		//panelD.add(addUserPost);
		panelD.add(addUserPassL);
		panelD.add(addUserPass);
		panelD.add(addUserMailL);
		panelD.add(addUserMail);
		panelD.add(addUser);
		
	}
	// Managing the button "unblock user addition"
	public void manageUnblock() {
		unblock.setText("Add new user");
		unblock.setBackground(Color.red);
		unblock.setFocusable(false);
		unblock.addActionListener(e -> {
			addUserName.setEditable(true);
			addUserSurname.setEditable(true);
			addUserDob.setEditable(true);
			userPost.setEnabled(true);
			adminPost.setEnabled(true);
			//addUserPost.setEditable(true);
			addUserPass.setEditable(true);
			addUserMail.setEditable(true);
			addUser.setEnabled(true);
		});
	}
	
	// Managing "Add new user" button
	public void manageAddUserButton() {
		addUser.setText("Save new user!");
		addUser.setBackground(Color.green);
		addUser.setFocusable(false);
		addUser.setEnabled(false);
		if(!(addUserMail.getText()==null)) {
			addUser.addActionListener(new AddNewUserListen(this));
		}
	}
	
	// Managing the label with the title.
	public void labelManage() {
		label.setSize(800, 100);
		label.setText("Welcome to Admin-User-Manager!");
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Mv Boli", Font.PLAIN, 30));
	}
	
	// Managing the button which activate the option of password change for the user.
	public void manageActivatePassChangeButton() {
		activatePassChangeButton.setText("Set new password");
		activatePassChangeButton.setBackground(Color.red);
		activatePassChangeButton.setFocusable(false);
		activatePassChangeButton.setPreferredSize(new Dimension(200, 50));
		activatePassChangeButton.addActionListener(e -> {
			if(!(Integer.valueOf(editUserId.getText())==0)) {
				saveNewPassButtonPanel.setVisible(true);
				editUserPass.setEditable(true);
			}
		});
	}
		
	// Managing the panel for the "activatePassChangeButton".
	public void manageActivatePassChangeButtonPanel() {
		activatePassChengeButtonPanel.setPreferredSize(new Dimension(200, 50));
		activatePassChengeButtonPanel.add(activatePassChangeButton);
	}
	
	// Managing "Save new password" button
	public void manageSaveNewPassButton() {
		saveNewPassButton.setText("Save new password");
		saveNewPassButton.setBackground(Color.red);
		saveNewPassButton.setPreferredSize(new Dimension(200, 50));
		saveNewPassButton.setFocusable(false);
		saveNewPassButton.addActionListener(new ChangePassListen(this));
		
	}
	
	// Managing panel for the "Save new password" button
	public void manageSaveNewPassButtonPanel() {
		saveNewPassButtonPanel.setPreferredSize(new Dimension(200, 50));
		saveNewPassButtonPanel.add(saveNewPassButton);
		saveNewPassButtonPanel.setVisible(false);
	}
	
	public void manageDeleteUserButton() {
		deleteUserButton.setText("Delete User");
		deleteUserButton.setBackground(Color.RED);
		deleteUserButton.setPreferredSize(new Dimension(200, 50));
		deleteUserButton.setFocusable(false);
		deleteUserButton.addActionListener(new DeleteUserListen(this));
	}
	
	public void manageDeleteUserButtonPanel() {
		deleteUserButtonPanel.setPreferredSize(new Dimension(200, 50));
		deleteUserButtonPanel.add(deleteUserButton);
	}
	
	public void managePcAdminOptionsButton() {
		pcAdminOptionsButton.setText("<<< Workstations Manager");
		pcAdminOptionsButton.setBackground(Color.white);
		pcAdminOptionsButton.setPreferredSize(new Dimension(200, 50));
		pcAdminOptionsButton.setFocusable(false);
		pcAdminOptionsButton.addActionListener(e -> {
			this.setVisible(false);
			@SuppressWarnings("unused")
			AdminFrame aFrame = new AdminFrame(this.mail);
		});
	}
	
	public void managePcAdminOptionsButtonPanel() {
		pcAdminOptionsButtonPanel.setPreferredSize(new Dimension(200, 50));
		pcAdminOptionsButtonPanel.add(pcAdminOptionsButton);
	}
	
	// Managing logout button
	public void manageLogoutButton() {
		logoutButton.setText("Log Out");
		logoutButton.setBackground(Color.lightGray);
		logoutButton.setPreferredSize(new Dimension(200, 50));
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(e -> {
			System.exit(0);
		});
	}
		
	// Managing "logut" button panel
	public void manageLogoutButtonPanel() {
		logoutButtonPanel.setPreferredSize(new Dimension(200, 50));
		logoutButtonPanel.add(logoutButton);
	}
	
	//Manage some labels, text fields and RadioButtons.
	public void labelsManage() {
		
		editUserIdL.setForeground(Color.RED);
		editUserId.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserId.setEditable(false);
		editUserName.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserSurname.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserDob.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserPost.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserPass.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editUserPass.setEditable(false);
		editUserMail.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		addUserIdL.setForeground(Color.RED);
		addUserId.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserId.setEditable(false);
		addUserName.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserName.setEditable(false);
		addUserSurname.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserSurname.setEditable(false);
		addUserDob.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserDob.setText("1900-01-01");
		addUserDob.setEditable(false);
		addUserPost.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserPost.setEditable(false);
		addUserPass.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserPass.setEditable(false);
		addUserMail.setFont(new Font("Helvetica", Font.PLAIN, 15));
		addUserMail.setEditable(false);
		addUserMail.setText(null);
		
		userPost.setEnabled(false);
		adminPost.setEnabled(false);
	}	
	
	// Constructor of the frame
	public AdminFrame2(String mail) {
		this.mail = mail;
		
		labelManage();
		labelsManage();
		managePostButtonsPanel();
		managePostButtonsGroup();
		manageA();
		manageB();
		manageC();
		manageD();
		manageE();
		manageF();
		manageModifyU();
		manageAddUserButton();
		manageActivatePassChangeButton();
		manageActivatePassChangeButtonPanel();
		manageSaveNewPassButton();
		manageSaveNewPassButtonPanel();
		manageUnblock();
		manageDeleteUserButtonPanel();
		manageDeleteUserButton();
		managePcAdminOptionsButton();
		managePcAdminOptionsButtonPanel();
		manageLogoutButton();
		manageLogoutButtonPanel();
		
		this.setSize(1600, 700);
	    this.setTitle("Our Users");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new GridLayout(1, 2, 1, 1));
	    this.add(panelA);
	    this.add(panelB);
	    Image icon = Toolkit.getDefaultToolkit().getImage("resources/csm.png");    
		this.setIconImage(icon);
		this.setVisible(true);
	}

	public JTextField getEditUserId() {
		return editUserId;
	}

	public JTextField getEditUserName() {
		return editUserName;
	}

	public JTextField getEditUserSurname() {
		return editUserSurname;
	}

	public JTextField getEditUserDob() {
		return editUserDob;
	}

	public JTextField getEditUserPost() {
		return editUserPost;
	}

	public JTextField getEditUserPass() {
		return editUserPass;
	}

	public JTextField getEditUserMail() {
		return editUserMail;
	}

	public JList<User> getUserJList() {
		return userJList;
	}

	public JPanel getSaveNewPassButtonPanel() {
		return saveNewPassButtonPanel;
	}

	public JTextField getAddUserName() {
		return addUserName;
	}

	public JTextField getAddUserSurname() {
		return addUserSurname;
	}

	public JTextField getAddUserDob() {
		return addUserDob;
	}

	public JTextField getAddUserPost() {
		return addUserPost;
	}

	public JTextField getAddUserPass() {
		return addUserPass;
	}

	public JTextField getAddUserMail() {
		return addUserMail;
	}

	public JButton getAddUser() {
		return addUser;
	}

	public DaoFactory getDao() {
		return dao;
	}

	public String getMail() {
		return mail;
	}

	public JRadioButton getUserPost() {
		return userPost;
	}

	public JRadioButton getAdminPost() {
		return adminPost;
	}

	public JPanel getPostButtonsPanel() {
		return postButtonsPanel;
	}
	
}

