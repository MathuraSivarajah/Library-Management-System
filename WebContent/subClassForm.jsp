<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sub Classification Form</title>
<style>
.button {
	display: inline-block;
	border-radius: 4px;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 20px;
	padding: 20px;
	width: 200px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
	position: right;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

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
		import="com.sgic.dao.MainDao, com.sgic.bean.MainClassification, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		List<MainClassification> list = MainDao.getAllRecords();
		request.setAttribute("list", list);
	%>
	<a href="viewSubclass.jsp" class="button"
		style="float: left; color: #0000FF"><span>View Records</span></a>
	<br />
	</br>
	<h2 align="left">Add Sub Classification</h2>
	<form action="AddSubClassification" method="post">
		<table>
			<tr>
				<td>Sub Classification Id:</td>
				<td><input type="text" name="subClass_Id" /></td>
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
				<td><input type="text" name=subClass_name /></td>
			</tr>


			</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add"
					style="float: right" /></td>
			</tr>
		</table>
	</form>

</body>
</html>