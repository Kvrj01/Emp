package com.Employee.Pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SkillSearchController")
public class SkillSearch extends HttpServlet {
	
 
    public SkillSearch() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String skill = request.getParameter("skill");

		try {

			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Where is h2 Driver?");
			e.printStackTrace();
			return;

		}
		
		Connection connection = null;
		try {
				connection = DriverManager.getConnection(
						"jdbc:h2:tcp://localhost/~/test","sa","");
		} catch (SQLException sqlException) {
			System.out.println("Connection Failed! Check output console");
			sqlException.printStackTrace();
			return;
		}			
		if (connection != null) {
                        
			Statement stmt;
			try {
				stmt = connection.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery("select e.EMP_ID, e.EMP_NAME ,e.designation, s.STATUS , b.SKILLS from EMPLOYEE e, SKILL_SET s, SKILLSDTLS b where e.EMP_ID = s.EMP_ID and s.SKILL_REG_ID = b.SKILL_REG_ID and skills = '"+skill+"' and s.status = 'Approved'");
			System.out.println(rs);
				PrintWriter out = response.getWriter();
				out.println("<table>\r\n" + 
						"  <tr>\r\n" + 
						"    <th>Employee Id</th>\r\n" + 
						"    <th>Emplyee Name</th>\r\n" + 
						"    <th>Designation</th>\r\n" + 
						"    <th>Skill</th>\r\n" + 
						"    <th>Status</th>\r\n" + 						
						"  </tr>");
				
				while(rs.next())
				{
										
					out.println("<tr>\r\n" + 
							"    <td>"+rs.getString("emp_id")+"</td>\r\n" + 
							"    <td>"+rs.getString("EMP_NAME")+"</td>\r\n" + 
							"    <td>"+rs.getString("DESIGNATION")+"</td>\r\n" + 
							"    <td>"+rs.getString("skills")+"</td>\r\n" + 
							"    <td>"+rs.getString("Status")+"</td>\r\n" + 					
							"  </tr>\r\n" + 
							"");					
				}							    
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
  	  	}
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
