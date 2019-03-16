<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Sub Classification</title>
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
	<%@page
		import="com.sgic.dao.SubDao, com.sgic.bean.SubClassification,java.util.*,
	com.sgic.dao.MainDao, com.sgic.bean.MainClassification"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		String id = request.getParameter("id");
		SubClassification sc = SubDao.getRecordById(id);
	%>
	<%
		List<MainClassification> list = MainDao.getAllRecords();
		request.setAttribute("list", list);
	%>
	<h2>Edit Sub Classification</h2>

	<form action="EditSubclass" method="post">
		<input type="hidden" name="subClass_Id"
			value="<%=sc.getSubClass_Id()%>" />
		<table>
			<tr>
				<td>Classification Id:</td>
				<td><input type="text" name="subClass_Id"
					value="<%=sc.getSubClass_Id()%>" /></td>
			</tr>
			<tr>
				<td>Main Classification:</td>
				<td><select name="mainClass_name">
				
						<c:forEach items="${list}" var="u">
							<option value="${u.getMainClass_name()}">${u.getMainClass_name()}</option>
						</c:forEach>
				</select></td>

			</tr>

			<tr>
				<td>Sub Classification:</td>
				<td><input type="text" name=subClass_name
					value="<%=sc.getSubClass_name()%>" /></td>
			</tr>


			</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"
					style="float: right" /></td>
			</tr>
		</table>



	</form>

</body>
</html>