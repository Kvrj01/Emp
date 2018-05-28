package com.Employee.Pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/SkillsetReeg")
public class SkillSetReg extends HttpServlet {
	
    public SkillSetReg() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    String emp_Id = request.getParameter("txtEmp_id");
	    int batchCount = Integer.parseInt(request.getParameter("txthndlbtch"));
	    int studentCount = Integer.parseInt(request.getParameter("txthndlstd"));
	    int noofstudentPlaced = Integer.parseInt(request.getParameter("txtplcdstd"));
	    int experiance = Integer.parseInt(request.getParameter("experiance"));
	    String certification = request.getParameter("txtcerification");
		try {

			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;

		}

		Connection connection = null;
	    try {
			connection = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test","sa","");
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return;
		}			
		if (connection != null) {
                        
			Statement stmt;
			try {
				String insertquery = " insert into skill_set (emp_id, skill_reg_id, reg_date, no_of_yr_exp, no_of_batches_handled, "
						+ "no_of_std_placed, no_std_handled, status)"
			        + " values (?, ?, ?, ?,?, ?, ?)";
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			      // create the mysql insert preparedstatement
				EmployeeConnectionManager GetSkillId = new EmployeeConnectionManager();		
				int skilRegID = GetSkillId.GetEmpID(1)+1;
			      PreparedStatement preparedStmt = connection.prepareStatement(insertquery);
			      preparedStmt.setInt(1, Integer.parseInt(emp_Id));			      	      
			      preparedStmt.setInt(2, skilRegID);
			      preparedStmt.setInt(3, experiance);
			      preparedStmt.setInt(4, batchCount);
			      preparedStmt.setInt (5, noofstudentPlaced);

			      preparedStmt.setInt(6, studentCount);
			      preparedStmt.setString (7, "Not approved");
			      preparedStmt.execute();
			      
			      String skills;
			      skills = request.getParameter("skills");
			      EmployeeConnectionManager skillReg = new EmployeeConnectionManager();
			      
			    	  skillReg.RegisterSkil(skilRegID, skills, certification);
			      
			      connection.close();

				}
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	  	}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
