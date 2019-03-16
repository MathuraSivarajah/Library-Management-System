package com.sgic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.dao.SubDao;

@WebServlet("/deletesubclass")
public class DeleteSubclass extends HttpServlet{
	SubDao subdao = new SubDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deleteId = request.getParameter("deleteId");
		subdao.delete(deleteId);
		response.sendRedirect("viewSubclass.jsp");
	}

}
