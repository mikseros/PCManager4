package com.amalmikolaj.model;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import com.amalmikolaj.dao.DaoFactory;
import com.amalmikolaj.listeners.*;

	// Model for the user and first-administrator panels.

public class ModelFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	String mail ;
	// List Model for JList.
	DefaultListModel<Workstation> modelL = new DefaultListModel<Workstation>();
	// JList which contains the list of workstations.
	JList<Workstation> workstationJList = new JList<Workstation>(modelL);
	// List of workstations.
	ArrayList<Workstation> workstationList = new ArrayList<Workstation>();
	// JScrollPane for the list of workstations.
	JScrollPane workstationListScrolling = new JScrollPane();
	DaoFactory dao = new DaoFactory();
	// Label with the "Title" of each frame.
	JLabel label = new JLabel();
	// Button for activation the area for logged-in user profile.
	JButton editProfile = new JButton();
	// Button for activation the area for addition of new workstation to the database.
	JButton addPc = new JButton();
	// Button for activation of part profile-edition-panel responsible for changing the password of the user.
	JButton activatePassChangeButton = new JButton();
	// Panel for button above.
	JPanel activatePassChengeButtonPanel = new JPanel();
	// Button for saving the new password for logged-in user.
	JButton saveNewPassButton = new JButton();
	// Panel for button above.
	JPanel saveNewPassButtonPanel = new JPanel();
	// Panel for "addPc" button.
	JPanel addPcPanel = new JPanel();
	// Text field for "Brand" attribute in the panel for adding new workstations.
	JTextField brand = new JTextField();
	// Text field for "Model" attribute in the panel for adding new workstations.
	JTextField model = new JTextField();
	// Text field for "Tag" attribute in the panel for adding new workstations.
	JTextField tag = new JTextField();
	// Text field for "Student Name" attribute in the panel for adding new workstations.
	JTextField studentName = new JTextField();
	// Text field for "Student Surname" attribute in the panel for adding new workstations.
	JTextField studentSurname = new JTextField();
	// Text field for "Course" attribute in the panel for adding new workstations.
	JTextField course = new JTextField();
	// Text field for "Date of borrow" attribute in the panel for adding new workstations.
	JTextField dateOfBorrow = new JTextField();
	// Text field for "Cheque" attribute in the panel for adding new workstations.
	JTextField cheque = new JTextField();
	// Text field for "Return comment" attribute in the panel for adding new workstations.
	JTextField returnComment = new JTextField();
	// Labels for buttons in the panel for adding new workstations.
	JLabel brandLabel = new JLabel();
	JLabel modelLabel = new JLabel();
	JLabel tagLabel = new JLabel();
	JLabel nameLabel = new JLabel();
	JLabel surnameLabel = new JLabel();
	JLabel courseLabel = new JLabel();
	JLabel dateLabel = new JLabel();
	JLabel chequeLabel = new JLabel();
	JLabel commentLabel = new JLabel();
	// Button for saving new workstation in the database.
	JButton savePc = new JButton();
	// Panel for "addPc" button.
	JPanel addButtonPanel = new JPanel();
	// Panel for "editProfile" button.
	JPanel editButtonPanel = new JPanel();
	
	// Declarations of the components serving for self-profile edition.
	JPanel editProfilePanel = new JPanel();
	JTextField userName = new JTextField();
	JTextField surname = new JTextField();
	JTextField dateOfBirth = new JTextField();
	JTextField post = new JTextField();
	JTextField password = new JTextField();
	JTextField email = new JTextField();
	JLabel userNameL = new JLabel();
	JLabel uSurnameL = new JLabel();
	JLabel dobL = new JLabel();
	JLabel postL = new JLabel();
	JLabel passL = new JLabel();
	JLabel emailL = new JLabel();
	JButton modifyUser = new JButton();
	
	// Declarations of 2 main panels (A, B), and four sub-panels (C,D,E,F)
	JPanel panelA = new JPanel();
	JPanel panelB = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelD = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelF = new JPanel();
	
	// Declarations of components for pc-modification area (panel F)
	JLabel editIdL = new JLabel("Here you can modify workstations. After edition just click 'Save Modification' button.");
	JLabel editBrandL = new JLabel("Brand: ");
	JLabel editModelL = new JLabel("Model: ");
	JLabel editTagL = new JLabel("Service tag: ");
	JLabel edStudNameL = new JLabel("Student Name: ");
	JLabel edStudSurnL = new JLabel("Student surname: ");
	JLabel editCourseL = new JLabel("Course: ");
	JLabel editDobL = new JLabel("Date of borrow: ");
	JLabel editChequeL = new JLabel("Cheque(true/false): ");
	JLabel editRetCommL = new JLabel("Return comment: ");
	
	JTextField editId = new JTextField("0");
	JTextField editBrand = new JTextField();
	JTextField editModel = new JTextField();
	JTextField editTag = new JTextField();
	JTextField edStudName = new JTextField();
	JTextField edStudSurn = new JTextField();
	JTextField editCourse = new JTextField();
	JTextField editDob = new JTextField();
	JTextField editCheque = new JTextField();
	JTextField editRetComm = new JTextField();
	
	JButton modifyWS = new JButton("Save Modification");
	// Declarations of "log out" button and the holding panel 
	JButton logoutButton = new JButton();
	JPanel logoutButtonPanel = new JPanel();
	
	// Method for creating and refreshing the list of workstations.
	public void refreshList() {
        workstationList.clear();
        
        try {
            ArrayList<Workstation> ListOfMachines = (ArrayList<Workstation>) dao.getWorkstationDao().showAllMachines() ;
            for(int i = 0; i + 1 <= ListOfMachines.size(); i++) {
                if(ListOfMachines.get(i).getIsDeleted()==false) {
                    workstationList.add(ListOfMachines.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        modelL.clear();
        modelL.addAll(workstationList);
        //workstationJList.setSelectedIndex(0);
    }
	
	// Managing of the panels which are hold everything else.
		public void manageA() {
			
			panelA.setSize(800, 700);
			panelA.setLayout(new BorderLayout());
			panelA.add(panelE, BorderLayout.NORTH);
			panelA.add(panelF, BorderLayout.CENTER);
		}
		
		public void manageB() {
			
			panelB.setSize(800, 700);
			panelB.setLayout(new GridLayout(1, 2));
			panelB.add(panelC);
			panelB.add(panelD);
		}
		public void manageC() {
			
			panelC.setSize(400, 700);
			//panelC.setLayout(null);
			panelC.setLayout(new GridLayout(5, 1));
			panelC.add(addButtonPanel);//addButtonPanel addPc
			panelC.add(editButtonPanel);//editProfile
			panelC.add(activatePassChengeButtonPanel);//activatePassChangeButton
			panelC.add(saveNewPassButtonPanel);//saveNewPassButton
			panelC.add(logoutButtonPanel);
			
		}
		public void manageD() {
			
			panelD.setSize(400, 700);
			panelD.setLayout(new BorderLayout());
			panelD.add(addPcPanel, BorderLayout.NORTH);
			panelD.add(editProfilePanel, BorderLayout.CENTER);
		}
	
	// Managing the panel which holds the list of workstations.
	public void manageE() {
		panelE.setSize(800, 250);
		panelE.setLayout(new BorderLayout());
		panelE.add(label, BorderLayout.NORTH);
		workstationJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		workstationJList.addListSelectionListener(new GetPcToModification(this));
		refreshList();
        workstationListScrolling = new JScrollPane(workstationJList);
        workstationListScrolling.setSize(800, 150);
        panelE.add(workstationListScrolling, BorderLayout.CENTER);
	}

	// Managing the panel which holds the form for workstation edition.
	public void manageF() {
		panelF.setSize(800, 450);
		panelF.setLayout(new GridLayout(21, 1));
		panelF.add(editIdL);
		panelF.add(editId);
		panelF.add(editBrandL);
		panelF.add(editBrand);
		panelF.add(editModelL);
		panelF.add(editModel);
		panelF.add(editTagL);
		panelF.add(editTag);
		panelF.add(edStudNameL);
		panelF.add(edStudName);
		panelF.add(edStudSurnL);
		panelF.add(edStudSurn);
		panelF.add(editCourseL);
		panelF.add(editCourse);
		panelF.add(editDobL);
		panelF.add(editDob);
		panelF.add(editChequeL);
		panelF.add(editCheque);
		panelF.add(editRetCommL);
		panelF.add(editRetComm);
		panelF.add(modifyWS);
		panelF.setVisible(true);
	}
	// Managing the button for save the modification of workstation.
	public void manageModifyWS() {
		modifyWS.setFocusable(false);
		modifyWS.setBackground(Color.ORANGE);
		modifyWS.addActionListener(new SavePcModification(this));
	}
	
	// Managing the label with the title.
	public void labelManage() {
		label.setSize(800, 100);
		label.setText("Welcome to PC Manager!");
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
		label.setFont(new Font("Mv Boli", Font.PLAIN, 30));
	}
	
	// Managing the button which shows the panel for new workstation addition.
	public void manageAddPcButton() {
		addPc.setText("Add new PC");
		addPc.setBackground(Color.green);
		addPc.setFocusable(false);
		addPc.setPreferredSize(new Dimension(200, 50));
		addPc.addActionListener(e -> {
			addPcPanel.setVisible(true);
			editProfilePanel.setVisible(false);
		});
	}
	// Managing the panel for the button.
	public void manageAddButtonPanel() {
		addButtonPanel.setPreferredSize(new Dimension(200, 50));
		addButtonPanel.add(addPc);
	}
	// Managing the button which shows the panel for user-profile modifications.
	public void manageProfileButton() {
		editProfile.setText("Edit my profile");
		editProfile.setBackground(Color.cyan);
		editProfile.setFocusable(false);
		editProfile.setPreferredSize(new Dimension(200, 50));
		//editProfile.setBounds(0, 175, 400, 175);
		editProfile.addActionListener(e -> {
			editProfilePanel.setVisible(true);
			addPcPanel.setVisible(false);
		});
	}
	// Managing the panel for the button.
	public void manageEditButtonPanel() {
		editButtonPanel.setPreferredSize(new Dimension(200, 50));
		editButtonPanel.add(editProfile);
	}
	
	// Managing the button which activate the option of password change for the user.
	public void manageActivatePassChangeButton() {
		activatePassChangeButton.setText("Set new password");
		activatePassChangeButton.setBackground(Color.red);
		activatePassChangeButton.setFocusable(false);
		activatePassChangeButton.setPreferredSize(new Dimension(200, 50));
		//activatePassChangeButton.setBounds(0, 350, 400, 175);
		activatePassChangeButton.setVisible(true);
		activatePassChangeButton.addActionListener(e -> {
			if(editProfilePanel.isVisible()) {
				password.setEditable(true);
				saveNewPassButtonPanel.setVisible(true);
			}
		});
	}
			
	// Managing the panel for the "activatePassChangeButton".
	public void manageActivatePassChangeButtonPanel() {
		activatePassChengeButtonPanel.setPreferredSize(new Dimension(200, 50));
		activatePassChengeButtonPanel.add(activatePassChangeButton);
	}
		
	// Managing the button which saves password change
	public void manageSaveNewPassButton() {
		saveNewPassButton.setText("Save new password");
		saveNewPassButton.setBackground(Color.RED);
		saveNewPassButton.setFocusable(false);
		saveNewPassButton.setPreferredSize(new Dimension(200, 50));
		saveNewPassButton.addActionListener(new EditPassword(this));
	}
			
	// Managing the panel for the "activatePassChangeButton".
	public void manageSaveNewPassButtonPanel() {
		saveNewPassButtonPanel.setPreferredSize(new Dimension(200, 50));
		saveNewPassButtonPanel.add(saveNewPassButton);
		saveNewPassButtonPanel.setVisible(false);
	}
	
	// Managing the button for saving new workstation in the database.
	public void manageSavePcButton() {
		savePc.setText("Save new Pc");
		savePc.setBackground(Color.green);
		savePc.setFocusable(false);
		savePc.addActionListener(new SavePcListen(this));
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
	
	// Managing the panel for new workstation addition.
	public void manageAddPcPanel() {
		addPcPanel.setLayout(new GridLayout(19, 1));
		addPcPanel.add(brandLabel);
		addPcPanel.add(brand);
		addPcPanel.add(modelLabel);
		addPcPanel.add(model);
		addPcPanel.add(tagLabel);
		addPcPanel.add(tag);
		addPcPanel.add(nameLabel);
		addPcPanel.add(studentName);
		addPcPanel.add(surnameLabel);
		addPcPanel.add(studentSurname);
		addPcPanel.add(courseLabel);
		addPcPanel.add(course);
		addPcPanel.add(dateLabel);
		addPcPanel.add(dateOfBorrow);
		addPcPanel.add(chequeLabel);
		addPcPanel.add(cheque);	
		addPcPanel.add(commentLabel);
		addPcPanel.add(returnComment);
		addPcPanel.add(savePc);
		addPcPanel.setVisible(false);
	}
	// Managing the button for saving modifications in the user account.
	public void modifyUser() {
		modifyUser.setText("Modify My profile");
		modifyUser.setBackground(Color.red);
		modifyUser.setFocusable(false);
		modifyUser.addActionListener(new ModifyProfileListen(this));
	}
	// Managing the form for modify user account.
	public void manageEditProfilePanel() {
		editProfilePanel.setLayout(new GridLayout(13, 1));
		editProfilePanel.add(userNameL);
		editProfilePanel.add(userName);
		editProfilePanel.add(uSurnameL);
		editProfilePanel.add(surname);
		editProfilePanel.add(dobL);
		editProfilePanel.add(dateOfBirth);
		editProfilePanel.add(postL);
		editProfilePanel.add(post);
		editProfilePanel.add(passL);
		editProfilePanel.add(password);
		editProfilePanel.add(emailL);
		editProfilePanel.add(email);
		editProfilePanel.add(modifyUser);
		editProfilePanel.setVisible(false);
		
	}
	//Managing labels and text fields for pc-modification area.
	public void labelsManage() {
		
		editIdL.setForeground(Color.RED);
		editId.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editId.setEditable(false);
		
		editBrand.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editModel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editTag.setFont(new Font("Helvetica", Font.PLAIN, 15));
		edStudName.setFont(new Font("Helvetica", Font.PLAIN, 15));
		edStudSurn.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editCourse.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editDob.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editCheque.setFont(new Font("Helvetica", Font.PLAIN, 15));
		editRetComm.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		// Managing text-fields and labels for user-modification area.
		userName.setEditable(true);
		userName.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		userName.setSize(600, 50);
		userNameL.setSize(600, 50);
		userNameL.setText("Name");
		userNameL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		surname.setEditable(true);
		surname.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		surname.setSize(600, 50);
		uSurnameL.setSize(600, 50);
		uSurnameL.setText("Surname");
		uSurnameL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		dateOfBirth.setEditable(true);
		dateOfBirth.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		dateOfBirth.setSize(600, 50);
		dobL.setSize(600, 50);
		dobL.setText("Date of birth");
		dobL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		post.setEditable(false);
		post.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		post.setSize(600, 50);
		postL.setSize(600, 50);
		postL.setText("Post");
		postL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		password.setEditable(false);
		password.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		password.setSize(600, 50);
		passL.setSize(600, 50);
		passL.setText("Password");
		passL.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		email.setEditable(true);
		email.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		email.setSize(600, 50);
		emailL.setSize(600, 50);
		emailL.setText("E-Mail");
		emailL.setFont(new Font("Mv Boli", Font.PLAIN, 13));
		
		// Managing labels and text-fields for pc-addition area.
		brand.setEditable(true);
		brand.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		brand.setSize(600, 50);
		brandLabel.setSize(600, 50);
		brandLabel.setText("Brand");
		brandLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		model.setEditable(true);
		model.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		model.setSize(600, 50);
		modelLabel.setSize(600, 50);
		modelLabel.setText("Model");
		modelLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		tag.setEditable(true);
		tag.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		tag.setSize(600, 50);
		tagLabel.setSize(600, 50);
		tagLabel.setText("Service Tag");
		tagLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		studentName.setEditable(true);
		studentName.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		studentName.setSize(600, 50);
		nameLabel.setSize(600, 50);
		nameLabel.setText("Student Name");
		nameLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		studentSurname.setEditable(true);
		studentSurname.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		studentSurname.setSize(600, 50);
		surnameLabel.setSize(600, 50);
		surnameLabel.setText("Student Surname");
		surnameLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		course.setEditable(true);
		course.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		course.setSize(600, 50);
		courseLabel.setSize(600, 50);
		courseLabel.setText("Course");
		courseLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		dateOfBorrow.setEditable(true);
		dateOfBorrow.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		dateOfBorrow.setSize(600, 50);
		dateOfBorrow.setText("1900-01-01");
		dateLabel.setSize(600, 50);
		dateLabel.setText("Date");
		dateLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		cheque.setEditable(true);
		cheque.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		cheque.setSize(600, 50);
		chequeLabel.setSize(600, 50);
		chequeLabel.setText("Cheque(true/false)");
		chequeLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		
		
		returnComment.setEditable(true);
		returnComment.setFont(new Font("Mv Boli", Font.PLAIN, 15));
		returnComment.setSize(600, 50);
		commentLabel.setSize(600, 50);
		commentLabel.setText("Return comment");
		commentLabel.setFont(new Font("Mv Boli", Font.PLAIN, 15));
	}
	
	// Filling panel for modification user-account of the logged in user.
	public void getUserInfo() {
		
		User u = dao.getUserDao().getUserByMail(mail);
		userName.setText(u.getName());
		surname.setText(u.getSurname());
		dateOfBirth.setText(String.valueOf(u.getDateOfBirth()));
		post.setText(u.getPost());
		//password.setText(null);
		email.setText(u.getEmail());
		
	}
	
	// Getters
	public String getMail() {
		return mail;
	}

	public ArrayList<Workstation> getWorkstationList() {
		return workstationList;
	}

	public JButton getEditProfile() {
		return editProfile;
	}

	public JTextField getBrand() {
		return brand;
	}

	public JTextField getModel() {
		return model;
	}

	public JTextField getTag() {
		return tag;
	}

	public JTextField getStudentName() {
		return studentName;
	}

	public JTextField getStudentSurname() {
		return studentSurname;
	}

	public JTextField getCourse() {
		return course;
	}

	public JTextField getDateOfBorrow() {
		return dateOfBorrow;
	}

	public JTextField getCheque() {
		return cheque;
	}

	public JTextField getReturnComment() {
		return returnComment;
	}

	public JTextField getUserName() {
		return userName;
	}

	public JTextField getSurname() {
		return surname;
	}

	public JTextField getDateOfBirth() {
		return dateOfBirth;
	}

	public JTextField getPost() {
		return post;
	}

	public JTextField getPassword() {
		return password;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getEditId() {
		return editId;
	}

	public JTextField getEditBrand() {
		return editBrand;
	}

	public JTextField getEditModel() {
		return editModel;
	}

	public JTextField getEditTag() {
		return editTag;
	}

	public JTextField getEdStudName() {
		return edStudName;
	}

	public JTextField getEdStudSurn() {
		return edStudSurn;
	}

	public JTextField getEditCourse() {
		return editCourse;
	}

	public JTextField getEditDob() {
		return editDob;
	}

	public JTextField getEditCheque() {
		return editCheque;
	}

	public JTextField getEditRetComm() {
		return editRetComm;
	}

	public JList<Workstation> getWorkstationJList() {
		return workstationJList;
	}

	public JPanel getSaveNewPassButtonPanel() {
		return saveNewPassButtonPanel;
	}

	public JLabel getLabel() {
		return label;
	}
	
	public JPanel getPanelC() {
		return panelC;
	}
	
	public DaoFactory getDao() {
		return dao;
	}


	// Constructor of the frame
	public ModelFrame(String mail) {
		this.mail = mail;
		
		getUserInfo();
		labelManage();
		manageAddPcButton();
		manageProfileButton();
		manageSaveNewPassButton();
		manageActivatePassChangeButton();
		labelsManage();
		manageSavePcButton();
		manageAddPcPanel();
		manageAddButtonPanel();
		manageEditButtonPanel();
		modifyUser();
		manageEditProfilePanel();
		manageA();
		manageB();
		manageC();
		manageD();
		manageE();
		manageF();
		manageModifyWS();
		manageActivatePassChangeButtonPanel();
		manageSaveNewPassButtonPanel();
		manageLogoutButtonPanel();
		manageLogoutButton();
			
		this.setSize(1600, 700);
		this.setTitle("Our Workstations");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2, 1, 1));
		this.add(panelA);
		this.add(panelB);
		Image icon = Toolkit.getDefaultToolkit().getImage("resources/csm.png");    
		this.setIconImage(icon);  
		this.setVisible(true);
	}
}