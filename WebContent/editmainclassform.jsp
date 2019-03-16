<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Main Classification</title>
<style>
input[type=text], select {
  width: 175%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 35%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

</style>
</head>
<body>
	<%@page import="com.sgic.dao.MainDao, com.sgic.bean.MainClassification"%>
	<%
		String id = request.getParameter("id");
		MainClassification mc = MainDao.getRecordById(id);
	%>
	<h2 align="left">Edit Main Classification</h2>

	<form action="EditMainclass" method="post">
		<input type="hidden" name="mainClass_Id"
			value="<%=mc.getMainClass_Id()%>" />

		<table>
			<tr>
				<td>Classification Id:</td>
				<td><input type="text" name="mainClass_Id" value="<%=mc.getMainClass_Id() %>" /></td>
			</tr>
			<tr>
				<td>Classification:</td>
				<td><input type="text" name="mainClass_name" value="<%=mc.getMainClass_name() %>" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Save" style="float: right" /></td>
			</tr>
		</table>
	</form>

</body>
</html>