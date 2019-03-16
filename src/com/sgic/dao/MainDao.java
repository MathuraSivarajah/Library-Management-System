package com.sgic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sgic.bean.Book;
import com.sgic.bean.MainClassification;

public class MainDao {
	public void save(MainClassification mc) throws ClassNotFoundException, SQLException {
		databaseConnection dbConnection = new databaseConnection();
		Connection con = dbConnection.getConnection();
		
		PreparedStatement stmt = con.prepareStatement("insert into mainclassification values(?,?)");
		stmt.setString(1, mc.getMainClass_Id());
		stmt.setString(2, mc.getMainClass_name());
		stmt.executeUpdate();
		
	}
	
	public static List<MainClassification> getAllRecords() throws ClassNotFoundException, SQLException {
		List<MainClassification> list = new ArrayList<MainClassification>();
		databaseConnection dbConnection = new databaseConnection();

		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from mainclassification");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MainClassification mc = new MainClassification();
				mc.setMainClass_Id(rs.getString("mainClass_Id"));
				mc.setMainClass_name(rs.getString("mainClass_name"));
				list.add(mc);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public void delete(String id) {
		// int status = 0;
		String s = "'";
		databaseConnection dbConnection = new databaseConnection();

		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from mainclassification where mainClass_Id=" + s + id + s);
			//ps.setString(1, book.getBookId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		// return status;
	}
	
	public static MainClassification getRecordById(String id) {
		databaseConnection dbConnection = new databaseConnection();
		MainClassification mc = null;
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from mainclassification where mainClass_Id=?");
			// ps.setInt(1,id);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mc = new MainClassification();
				mc.setMainClass_Id(rs.getString("mainClass_Id"));
				mc.setMainClass_name(rs.getString("mainClass_name"));
							
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mc;
	}
	
	public void update(MainClassification mc) {
		databaseConnection dbConnection = new databaseConnection();
		// int status = 0;
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update mainclassification set mainClass_Id=?,mainClass_name=? where mainClass_Id=?");
			ps.setString(1, mc.getMainClass_Id());
			ps.setString(2, mc.getMainClass_name());
			ps.setString(3, mc.getMainClass_Id());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		// return status;
	}

}
