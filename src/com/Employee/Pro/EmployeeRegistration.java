package com.Employee.Pro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/EmployeeRegistration")
public class EmployeeRegistration extends HttpServlet {
  
    public EmployeeRegistration() {
        super();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int emp_Id = Integer.parseInt(request.getParameter("txtEmp_id"));
		String emp_Name = request.getParameter("txtEmp_Fname");
		String emp_Gender = request.getParameter("rdgender");
		String age = request.getParameter("txtage");
		String mobile_no = request.getParameter("txtPhoneNo");
		String email = request.getParameter("txtEmail");
		String address = request.getParameter("txtaddress");
		String designation = request.getParameter("designation");
		String Password	= request.getParameter("txtpwd");	
		String ConfirmPassword = request.getParameter("txtCnfmPwd");
		

		if(Password.isEmpty() || ConfirmPassword.isEmpty()) {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");
			request.setAttribute("Validation","Password should not be empty");
			requestdispatcher.include(request,response);
		}
		else if(!Password.equals(ConfirmPassword)) {			
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");
			request.setAttribute("Validation","Password and Confirm password should be same");
			requestdispatcher.include(request,response);
		}

		if(emp_Name.isEmpty()) {
			System.out.print("Name valid");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");			
			request.setAttribute("NameValidation","Name should not be empty");
			requestdispatcher.include(request,response);
		}		

		if(mobile_no.isEmpty()) {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("EmployeReg.jsp");
			request.setAttribute("MobileValidation","Mobile number should not be empty");
			requestdispatcher.include(request,response);		
		}
		

		try
	    {
	      // create a mysql database connection
	      String h2Driver = "org.h2.Driver";
	      String dbUrl = "jdbc:h2:tcp://localhost/~/test";
	      Class.forName(h2Driver);
	      Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
	    
	      // create a sql date object so we can use it in our INSERT statement
	      
	      // the mysql insert statement
	      String insertquery = " insert into employee (emp_id, emp_name, gender, dob, mobile_no, Email_id, join_date, "
	      		+ "designation, address, qualification, uname, password)"
	        + " values (?, ?, ?, ?, ?,?, ?, ?, ?,?)";


	      PreparedStatement preparedStmt = conn.prepareStatement(insertquery);
	      preparedStmt.setInt(1, emp_Id);
	      preparedStmt.setString(2, emp_Name);
	      preparedStmt.setString(3, emp_Gender);
	      preparedStmt.setString(4, age);
	      preparedStmt.setString (5, mobile_no);
	      preparedStmt.setString(6, email);
	      preparedStmt.setString (7, designation);
	      preparedStmt.setString(8, address);
	      preparedStmt.setString (9, email);
	      preparedStmt.setString (10, Password);
	      preparedStmt.execute();
	      
	      conn.close();
	      PrintWriter out = response.getWriter();
	    }
	    catch (Exception e)
	    {

	      System.err.println(e.getMessage());
	    }

	}
}

