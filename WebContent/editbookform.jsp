<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
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
<script language="javascript" type="text/javascript">
	var xmlHttp
	var xmlHttp
	function showState(str) {
		//alert(str);

		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp == null) {
			alert("Browser does not support XMLHTTP Request")
			return;
		}
		var url = "combosubclassification.jsp";
		url += "?count=" + str;

		xmlHttp.onreadystatechange = stateChange;
		xmlHttp.open("GET", url, true);
		stateChange();
		xmlHttp.send(null);
	}

	function stateChange() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			document.getElementById("subclassification").innerHTML = xmlHttp.responseText
		}
	}
</script>

</head>
<body>
	<%@page import="com.sgic.dao.BookDao, com.sgic.bean.Book"%>
	<%
		String id = request.getParameter("id");
		Book book = BookDao.getRecordById(id);
	%>
	<h2 align="left">Edit Book</h2>

	<form action="EditBook" method="post">
		<input type="hidden" name="bookId" value="<%=book.getBookId()%>" />

		<table>
			<tr>
				<td>Book Id:</td>
				<td><input type="text" name="bookId" placeholder="B/MC/000"
					value="<%=book.getBookId()%>" /></td>
			</tr>
			<tr>
				<td>Book Title:</td>
				<td><input type="text" name="title"
					value="<%=book.getTitle()%>" /></td>
			</tr>
			<tr>
				<td>Author Name:</td>
				<td><input type="text" name="author"
					value="<%=book.getAuthor()%>" /></td>
			</tr>
			<tr>
				<td>Main Classification:</td>
				<td>
					<%
						
					%> <select name="mainclassification" id="mainclassification"
					onchange="showState(this.value)">
						<!-- <option value="0">Select Main Classification</option> -->
						<%
							try {

								String Query = "select * from mainclassification";
								Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
								PreparedStatement pstmt = con.prepareStatement(Query);
								ResultSet rs = pstmt.executeQuery();
								while (rs.next()) {
						%>
						<option value="<%=rs.getString("mainClass_name")%>"><%=rs.getString("mainClass_name")%></option>
						<%
							}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						%>
				</select>
				</td>
			</tr>
			<tr>
				<td>Sub Classification:</td>
				<td>
				<select name="subclassification" id="subclassification">
				
				
				
				</select>
				</td>
				
				<!-- <td><input type="text" name="subclassification" /></td> -->
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Edit Book"
					style="float: right" /></td>
			</tr>
		</table>
	</form>

</body>
</html>