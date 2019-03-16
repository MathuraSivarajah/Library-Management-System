<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Main Classification</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: center;
}

table#t01 tr:nth-child(even) {
	background-color: #eee;
}

table#t01 tr:nth-child(odd) {
	background-color: #fff;
}

table#t01 th {
	background-color: black;
	color: white;
}

.button {
	display: inline-block;
	border-radius: 4px;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 20px;
	font-family: bold;
	padding: 20px;
	width: 280px;
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
</style>
</head>
<body>
	<%@page
		import="com.sgic.dao.MainDao, com.sgic.bean.MainClassification, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<h2 align="center">Main Classification List</h2>
	<%
		List<MainClassification> list = MainDao.getAllRecords();
		request.setAttribute("list", list);
	%>

	<table border="1" width="90%" id="t01">
		<tr>

			<th>Classification Id</th>
			<th>Classification</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>

				<td>${u.getMainClass_Id()}</td>
				<td>${u.getMainClass_name()}</td>
				<td><a href="editmainclassform.jsp?id=${u.getMainClass_Id()}"><i
						style="color: green;" class="far fa-edit"></i></a></td>
				<td><a href="deletemainclass?deleteId=${u.getMainClass_Id()}"><i
						style="color: red" class="far fa-trash-alt"></i></a></td>


			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addmainclassform.jsp" class="button"
		style="float: left; color: #0000FF"><span>Add New Main
			Classification</span></a>


</body>
</html>