package com.sgic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.bean.Book;
import com.sgic.dao.BookDao;
import com.sgic.dao.SubDao;

public class AddBook extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		BookDao bookdao = new BookDao();

		String bookId = request.getParameter("bookId");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String mainclassification = request.getParameter("mainclassification");
		String subclassification = request.getParameter("subclassification");

		book.setBookId(request.getParameter("bookId"));
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setMainclassification(request.getParameter("mainclassification"));
		book.setSubclassification(request.getParameter("subclassification"));

		try {
			bookdao.save(book);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
		}

		response.sendRedirect("viewbooks.jsp");

//		response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        pw.write("<h2>  Book added sucessfully.. <h2> <br>");
//        pw.write("<h3> Book Id: " + bookId + " </h3>");
//        pw.write("<h3> Book Title: " + title + " </h3>");
//        pw.write("<h3> Author Name: " + author + " </h3>");
//        pw.write("<h3> Main Classification: " + mainclassification + " </h3>");
//        pw.write("<h3> Sub Classification: " + subclassification + " </h3>");
//        pw.write("</h3>");
//        request.setAttribute("successMessage", "Book Successfully Added..");

	}

}
