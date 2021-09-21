package com.amalmikolaj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.amalmikolaj.model.*;

public class WorkstationDao {
	
	private Connection connection;
	
	public WorkstationDao(Connection con) {
		this.connection = con;
	}
	
	public Workstation getWorkstationById(int id) throws Exception {
		
		// Method which gets the particular workstation from the database by it's ID.
		
		Workstation w = new Workstation();
		String pcQuery = ("SELECT * FROM pc WHERE pc_id = ?;");
		PreparedStatement ps = connection.prepareStatement(pcQuery);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getString(10), rs.getBoolean(11));
		}
		ps.close();
		//connection.close();
		//System.out.println(w.toString());
		return w;
	}
	
	public List<Workstation> showAllMachines() throws Exception {

		// Method which is creating the list of the all workstations (PC's) in the database. 
		
        List<Workstation> PCList = new ArrayList<Workstation>();
        String query = "SELECT * FROM pc;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            Workstation w = new Workstation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getString(10), rs.getBoolean(11));
            PCList.add(w);
        }
        //st.close();
        //connection.close();
        return PCList;

    }
	
	public void addWorkstation(Workstation workStation) {
		
		// Method for new-workstation (PC) addition.
		
		String newPC = ("INSERT INTO pc (brand, model, tag, student_Name, student_Surname, course, date_Of_Borrow, cheque, return_Comment, isDeleted) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		try
		{
		PreparedStatement ps = connection.prepareStatement(newPC);
		ps.setString(1, workStation.getBrand());
		ps.setString(2, workStation.getModel());
		ps.setString(3, workStation.getTag());
		ps.setString(4, workStation.getStudentName());
		ps.setString(5, workStation.getStudentSurname());
		ps.setString(6, workStation.getCourse());
		ps.setDate(7, (java.sql.Date) workStation.getDateOfBorrow());
		ps.setBoolean(8, workStation.isCheque());
		ps.setString(9, workStation.getReturnComment());
		ps.setBoolean(10, workStation.getIsDeleted());
		
		ps.executeUpdate();
		} catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}
		JOptionPane.showMessageDialog(null, "New workstation added!");
//		connection.close();
		System.out.println(workStation);
	
	}
	
	public void modifyPC(Workstation w) throws Exception{
		
		// Method for introducing changes/modifications in the PC's (workstations).
		
		String modify = "UPDATE pc SET brand = ?, model = ?, tag = ?, "
				+ "student_Name = ?, student_Surname =?, course = ?, date_Of_Borrow = ?, cheque = ?, return_Comment = ?"
				+ "WHERE pc_id = ?";
		PreparedStatement ps = connection.prepareStatement(modify);
		ps.setString(1, w.getBrand());
		ps.setString(2, w.getModel());
		ps.setString(3, w.getTag());
		ps.setString(4, w.getStudentName());
		ps.setString(5, w.getStudentSurname());
		ps.setString(6, w.getCourse());
		ps.setDate(7, (java.sql.Date) w.getDateOfBorrow());
		ps.setBoolean(8, w.isCheque());
		ps.setString(9, w.getReturnComment());
		ps.setInt(10, w.getId());
		ps.executeUpdate();
		ps.close();
		JOptionPane.showMessageDialog(null, "Update successful!");
	}
 

	public void deletePC(int id) {
		
		// Method for deleting workstation (PC) - soft-deletion.
		
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("UPDATE pc SET isDeleted = 1 WHERE pc_id = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Workstation deleted!");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
