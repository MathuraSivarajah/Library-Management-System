package com.sgic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.bean.MainClassification;
import com.sgic.dao.MainDao;

@WebServlet("/deletemainclass")
public class DeleteMainclass extends HttpServlet {
	MainDao md = new MainDao();
	MainClassification mc = new MainClassification();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deleteId = request.getParameter("deleteId");
		md.delete(deleteId);
		response.sendRedirect("viewMainclass.jsp");
	}

}
