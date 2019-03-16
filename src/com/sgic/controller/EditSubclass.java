package com.sgic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.bean.SubClassification;
import com.sgic.dao.SubDao;

@WebServlet("/EditSubclass")
public class EditSubclass extends HttpServlet{
	SubClassification sc = new SubClassification();
	SubDao subdao = new SubDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc.setSubClass_Id(request.getParameter("subClass_Id"));
		sc.setMainClass_name(request.getParameter("mainClass_name"));
		sc.setSubClass_name(request.getParameter("subClass_name"));
		

		subdao.update(sc);
		response.sendRedirect("viewSubclass.jsp");
	}

}
