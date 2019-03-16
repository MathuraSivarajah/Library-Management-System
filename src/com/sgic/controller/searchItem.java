
package com.sgic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.dao.BookDao;

@WebServlet("/searchItem")
public class searchItem extends HttpServlet{
	BookDao bookdao = new BookDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("search");
		//PrintWriter out = response.getWriter();
		//out.println(request.getParameter("search"));	
		
		bookdao.getSearchValue(value);
		
		response.sendRedirect("searchView.jsp");
		
		
	}

}
