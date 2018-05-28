<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Employee.Pro.EmployeeConnectionManager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reg page</title>
</head>
<body>
<FORM action="EmployeeRegistration" method="post">
   <h1>Employee Registration</h1>
<table >
<tr>
    <td >Employee ID:</td>
    <td>
  <%
  EmployeeConnectionManager EmpModelObj = new EmployeeConnectionManager();
    int Empid;
    Empid = EmpModelObj.GetEmpID(0);
    String EmpidStr = String.valueOf(Empid);
    
  %>
    <input type='text' name='txtEmpid' value="<%=EmpidStr %>" ></td>
</tr>
<tr>
    <td >Full Name:</td>
    <td><input type='text' name='txtEmpFname'></td>
    <td><font color="Red"><%= request.getAttribute("NameValidation")%></font></td>    
</tr>
<tr>
    <td >Gender:</td>
    <td><input type="radio" name="gender" value="male"> Male
<input type="radio" name="gender" value="female"> Female</td>
</tr>

<tr>
    <td >AGE:</td>
    <td><input type='text' name='age'></td>
</tr>

<tr>
    <td >Mobile Number:</td>
    <td><input name="txtPhoneNo" type="text" /></td>
</tr>

<tr>
    <td >Email ID:</td>
    <td><input  name='txtEmail' type='text'></td>
</tr>

<tr>
    <td >Address:</td>
    <td><textarea name='txtaddress'  type='text'></textarea></td>
</tr>

<tr>
    <td >Designation:</td>
    <td> <select id = "id" name="designation">
               <option value = "Trainer">Trainer</option>
               <option value = "HR">HR</option>
             </select></td>
</tr>


<tr>
    <td >Password:</td>
    <td><input type='password' name='txtpwd'></td>
</tr>

<tr>
    <td >Confirm Password:</td>
    <td><input type='password' name='txtCnfmPwd'></td>
    <td><td><%= request.getAttribute("Validation")%></td>
</tr>
<tr>
    <td ><input type='submit' name='REGISTER' value="Register"></td>
</tr>
</table>
</form>
 

</body>
</html>