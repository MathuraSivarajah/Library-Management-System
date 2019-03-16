package com.sgic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.bean.SubClassification;
import com.sgic.dao.SubDao;

@WebServlet("/AddSubClassification")
public class AddSubClassification extends HttpServlet{
	SubClassification sc = new SubClassification();
	SubDao subdao = new SubDao();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subClass_Id = request.getParameter("subClass_Id");
		String mainClass_name = request.getParameter("mainClass_name");
		String subClass_name = request.getParameter("subClass_name");
		
		sc.setSubClass_Id(subClass_Id);
		sc.setMainClass_name(mainClass_name);
		sc.setSubClass_name(subClass_name);
		
		try {
			subdao.save(sc);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
        }
		response.sendRedirect("viewSubclass.jsp");
	}

}
