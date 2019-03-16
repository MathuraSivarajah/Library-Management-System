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
<title>Insert title here</title>
</head>
<body>

<%
				try{
					//System.out.println(request.getParameter("count"));
					//String Query = "select * from subclassification where mainClass_name=?";
					String count=request.getParameter("count");
					
					//System.out.println(Query);
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();	
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
					String Query = "select * from subclassification where mainClass_name=?";
					PreparedStatement pstmt = con.prepareStatement(Query);
					pstmt.setString(1, count);
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()){
						//System.out.println("aaa");
						%>
						<option value="<%=rs.getString("subClass_name")%>"><%=rs.getString("subClass_name") %></option>
						<% 
					}
				}
				
				catch(Exception ex){
					ex.printStackTrace();
				}
				%>

</body>
</html>