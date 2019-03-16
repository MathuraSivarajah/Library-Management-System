package com.sgic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.bean.MainClassification;
import com.sgic.dao.MainDao;

@WebServlet("/EditMainclass")
public class EditMainclass extends HttpServlet {
	MainClassification mc = new MainClassification();
	MainDao md = new MainDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mc.setMainClass_Id(request.getParameter("mainClass_Id"));
		mc.setMainClass_name(request.getParameter("mainClass_name"));
		

		md.update(mc);
		response.sendRedirect("viewMainclass.jsp");
	}

}
