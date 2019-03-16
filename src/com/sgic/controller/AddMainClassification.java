package com.sgic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.bean.MainClassification;
import com.sgic.dao.MainDao;

@WebServlet("/AddMainClassification")
public class AddMainClassification extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainClassification mc = new MainClassification();
		MainDao mdo = new MainDao();
		
		String mainClass_Id = request.getParameter("mainClass_Id");
		String mainClass_name = request.getParameter("mainClass_name");
		
		mc.setMainClass_Id(request.getParameter("mainClass_Id"));
		mc.setMainClass_name(request.getParameter("mainClass_name"));
		
		try {
			mdo.save(mc);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
        }
		
//		response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        pw.write("<h2>  Classification added sucessfully.. <h2> <br>");
//        pw.write("<h3> Classification Id: " + mainClass_Id + " </h3>");
//        pw.write("<h3> Classification: " + mainClass_name + " </h3>");
//        pw.write("</h3>");
//        request.setAttribute("successMessage", "Classification Successfully Added..");
		
		response.sendRedirect("viewMainclass.jsp");
		
	}

}
