<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Skill page</title>
</head>
<body>
<FORM action="SkillsetReeg" method="post">

  <h1>Skill Set Registration</h1>
<table>
<tr>
<%
   String Emp_id = (String) request.getSession(false).getAttribute("Emp_id");
%>
    <td >Employee ID:</td>
    <td>   
    <input type='text' name='txtEmp_id' value="<%=Emp_id%>" ></td>
</tr>

<tr>
    <td >Number of Batches Handled:</td>
    <td><input type='text' name='txthndlbtch'></td>
</tr>

<tr>
    <td >Number of student Handled:</td>
    <td><input type='text' name='txthndlstd'></td>
</tr>

<tr>
    <td >Number of student placed:</td>
    <td><input type='text' name='txtplcdstd'></td>
</tr>

<tr>
    <td >Experience:</td>
    <td><input type='text' name='experiance'></td>
</tr>

<tr>
    <td >Certification:</td>
    <td><input type='text' name='txtcerification'></td>
</tr>

<tr>
    <td >Skills:</td>
    <td> <input type='text' name='skills'>
  </td>
</tr>

<tr>
<td ><input type='submit' name='REGISTER' value="Register"></td>
</tr>
</table>

</FORM>
</body>
</html>