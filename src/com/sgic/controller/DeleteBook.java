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

public class DeleteBook extends HttpServlet {
	Book book = new Book();
	BookDao bookdao = new BookDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String bookId = request.getParameter("bookId");
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		String mainclassification = request.getParameter("mainclassification");
//		String subclassification = request.getParameter("subclassification");
		//System.out.print("aaa");
		
//		PrintWriter out = response.getWriter();
//		out.println(request.getParameter("deletebookId"));
		String deleteId = request.getParameter("deletebookId");
		

//		book.setBookId(request.getParameter("bookId"));
//		book.setTitle(request.getParameter("title"));
//		book.setAuthor(request.getParameter("author"));
//		book.setMainclassification(request.getParameter("mainclassification"));
//		book.setSubclassification(request.getParameter("subclassification"));
//
	
		bookdao.delete(deleteId);
		response.sendRedirect("viewbooks.jsp");
	}
}
