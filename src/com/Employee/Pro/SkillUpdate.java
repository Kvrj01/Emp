package com.Employee.Pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SkillUpdate")
public class SkillUpdate extends HttpServlet {

   
    public SkillUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cerificate=request.getParameter("txtCertification");
		String skill =request.getParameter("txtSkill");
		HttpSession session=request.getSession(false);  
		int skill_id = Integer.parseInt((String)session.getAttribute("skill_id"));
		try
	    {

	      String h2Driver = "org.h2.Driver";
	      String dbUrl = "jdbc:h2:tcp://localhost/~/test";
	      Class.forName(h2Driver);
	      Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
	      String insertquery = " insert into SKILLSDTLS(skill_reg_id, skills, certification)"
	        + " values (?, ?, ?)";

	      PreparedStatement preparedStmt = conn.prepareStatement(insertquery);
	      preparedStmt.setInt(1, skill_id);
	      preparedStmt.setString(3, cerificate);
	      preparedStmt.setString(2, skill);
          preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }

}
}
