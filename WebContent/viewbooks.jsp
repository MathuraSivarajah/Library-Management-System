<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewbooks</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
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

	<div>
		<form action="searchItem" method="GET" style="float: right">
			<input type="text" placeholder="Search.." name="search">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form>
	</div>
	</br>

	<form action="del">
		<%@page import="com.sgic.dao.BookDao, com.sgic.bean.Book, java.util.*"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<h2 align="center">Book List</h2>

		<%
			List<Book> list = BookDao.getAllRecords();
			request.setAttribute("list", list);
		%>
<div>
		<table border="1" width="90%" id="t01">
			<tr>

				<th>Book Id</th>
				<th>Book Title</th>
				<th>Author Name</th>
				<th>Main Classification</th>
				<th>Sub Classification</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="u">
				<tr>

					<td>${u.getBookId()}</td>
					<td>${u.getTitle()}</td>
					<td>${u.getAuthor()}</td>
					<td>${u.getMainclassification()}</td>
					<td>${u.getSubclassification()}</td>
					<td><a href="editbookform.jsp?id=${u.getBookId()}"><i
							style="color: green;" class="far fa-edit"></i></a></td>
					<td><a href="deletebook?deletebookId=${u.getBookId()}"><i
							style="color: red" class="far fa-trash-alt"></i></a></td>

				</tr>
			</c:forEach>
		</table>
		</div>
		<br /> <a href="addbookform.jsp" class="button"
			style="float: left; color: #0000FF"><span>Add New Book</span></a>
	</form>
	<script type="text/javascript">
window.addEventListener("load", function () {
    create_sample_table(document.getElementById("table_box_bootstrap"), false, false, false);
    var box = paginator({
        table: document.getElementById("table_box_bootstrap").getElementsByTagName("table")[0],
        box_mode: "list",
    });
    box.className = "box";
    document.getElementById("table_box_bootstrap").appendChild(box);
}, false);
            </script>
</body>
</html>