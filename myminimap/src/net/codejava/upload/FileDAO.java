package net.codejava.upload;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.PlacesDTO;

import java.sql.Connection;

public class FileDAO {
	
	public static int upload(int SEQ_User, String fileName) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Attachments(SEQ_User, FileName) values (?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, SEQ_User);
		ps.setString(2, fileName);
		int result = ps.executeUpdate();
		return result;
	}
	
	public static void Update_upload(double SEQ_User, String fileName, double SEQ_Post) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Attachments(SEQ_User, FileName, SEQ_Post) values (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, SEQ_User);
		ps.setString(2, fileName);
		ps.setDouble(3, SEQ_Post);
		int rs = ps.executeUpdate();
	}
	
	public static int getSEQ_Post(int SEQ_User, String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select SEQ_Post from Posts where SEQ_User = ? and Id = ?";
		ResultSet rs = null;
		int SEQ_Post = 0;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, SEQ_User);
		ps.setString(2, Id);
		rs = ps.executeQuery();
		while(rs.next()) {
			SEQ_Post = rs.getInt(1);
		}
		return SEQ_Post;
	}
}
