package com.sgic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgic.bean.Book;
import com.sgic.dao.BookDao;

public class EditBook extends HttpServlet {
	Book book = new Book();
	BookDao bookdao = new BookDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String bookId = request.getParameter("bookId");
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		String mainclassification = request.getParameter("mainclassification");
//		String subclassification = request.getParameter("subclassification");

		book.setBookId(request.getParameter("bookId"));
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setMainclassification(request.getParameter("mainclassification"));
		book.setSubclassification(request.getParameter("subclassification"));

		bookdao.update(book);
		response.sendRedirect("viewbooks.jsp");
	}

}
