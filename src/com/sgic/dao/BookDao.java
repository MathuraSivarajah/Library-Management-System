package com.sgic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.sgic.bean.Book;

public class BookDao {
	static String searchValue;

	public void save(Book book) throws ClassNotFoundException, SQLException {
		databaseConnection dbConnection = new databaseConnection();
		Connection con = dbConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement("insert into bookinfo values(?,?,?,?,?)");
		stmt.setString(1, book.getBookId());
		stmt.setString(2, book.getTitle());
		stmt.setString(3, book.getAuthor());
		stmt.setString(4, book.getMainclassification());
		stmt.setString(5, book.getSubclassification());

		stmt.executeUpdate();

	}

	public static List<Book> getAllRecords() throws ClassNotFoundException, SQLException {
		List<Book> list = new ArrayList<Book>();
		databaseConnection dbConnection = new databaseConnection();

		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from bookinfo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getString("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setMainclassification(rs.getString("mainclassification"));
				book.setSubclassification(rs.getString("subclassification"));
				list.add(book);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public String getSearchValue(String value) {
		searchValue = value;
		return searchValue;
	}
	
	public static  List<Book> searchBook() throws ClassNotFoundException, SQLException{
		List<Book> list = new ArrayList<Book>();
		String s = "'";
		databaseConnection dbConnection = new databaseConnection();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from bookinfo where bookId like '%"+searchValue+"%'" + " or title like '%"+searchValue+"%'"
													+ " or author like '%"+searchValue+"%'" + " or mainclassification like '%"+searchValue+"%'" + " or subclassification like '%"+searchValue+"%'");
			//System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getString("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setMainclassification(rs.getString("mainclassification"));
				book.setSubclassification(rs.getString("subclassification"));
				list.add(book);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public void delete(String id) {
		// int status = 0;
		databaseConnection dbConnection = new databaseConnection();
		String s = "'";

		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from bookinfo where bookId=" + s + id + s);
			//ps.setString(1, book.getBookId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		// return status;
	}

	public void update(Book book) {
		databaseConnection dbConnection = new databaseConnection();
		// int status = 0;
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update bookinfo set bookId=?,title=?,author=?,mainclassification=?,subclassification=? where bookId=?");
			ps.setString(1, book.getBookId());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getMainclassification());
			ps.setString(5, book.getSubclassification());
			ps.setString(6, book.getBookId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		// return status;
	}

	public static Book getRecordById(String id) {
		databaseConnection dbConnection = new databaseConnection();
		Book book = null;
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from bookinfo where bookId=?");
			// ps.setInt(1,id);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getString("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setMainclassification(rs.getString("mainclassification"));
				book.setSubclassification(rs.getString("subclassification"));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return book;
	}
}