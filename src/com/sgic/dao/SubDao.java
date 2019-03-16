package com.sgic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sgic.bean.MainClassification;
import com.sgic.bean.SubClassification;

public class SubDao {

	public void save(SubClassification sc) throws ClassNotFoundException, SQLException {
		databaseConnection dbConnection = new databaseConnection();
		Connection con = dbConnection.getConnection();

		PreparedStatement stmt = con.prepareStatement("insert into subclassification values(?,?,?)");
		stmt.setString(1, sc.getSubClass_Id());
		stmt.setString(2, sc.getMainClass_name());
		stmt.setString(3, sc.getSubClass_name());
		stmt.executeUpdate();

	}

	public static List<SubClassification> getAllRecords() throws ClassNotFoundException, SQLException {
		List<SubClassification> list = new ArrayList<SubClassification>();
		databaseConnection dbConnection = new databaseConnection();

		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from subclassification");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubClassification sc = new SubClassification();
				sc.setSubClass_Id(rs.getString("subClass_Id"));
				sc.setMainClass_name(rs.getString("mainClass_name"));
				sc.setSubClass_name(rs.getString("subClass_name"));

				list.add(sc);
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
			PreparedStatement ps = con
					.prepareStatement("delete from subclassification where subClass_Id=" + s + id + s);
			// ps.setString(1, book.getBookId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		// return status;
	}

	public static SubClassification getRecordById(String id) {
		databaseConnection dbConnection = new databaseConnection();
		SubClassification sc = null;
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from subclassification where subClass_Id=?");
			// ps.setInt(1,id);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sc = new SubClassification();
				sc.setSubClass_Id(rs.getString("subClass_Id"));
				sc.setMainClass_name(rs.getString("mainClass_name"));
				sc.setSubClass_name(rs.getString("subClass_name"));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return sc;
	}

	public void update(SubClassification sc) {
		databaseConnection dbConnection = new databaseConnection();
		// int status = 0;
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update subclassification set subClass_Id=?,mainClass_name=?, subClass_name=? where subClass_Id=?");
			ps.setString(1, sc.getSubClass_Id());
			ps.setString(2, sc.getMainClass_name());
			ps.setString(3, sc.getSubClass_name());
			ps.setString(4, sc.getSubClass_Id());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		// return status;
	}

}
