package net.codejava.upload;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class PlacesDAO {

	public static void InsertPostAllData(double SEQ_User, String Id, int SaveType, int FoodType, int Taste, String Colleague, int Price) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Posts(SEQ_User, Update_PostDay, Id, SaveType, FoodType, Taste, Colleague, Price) values (?,now(),?,?,?,?,?,?)"; // 6媛� �냽�꽦
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			ps.setString(2, Id);
			ps.setInt(3, SaveType);
			ps.setInt(4, FoodType);
			ps.setInt(5, Taste);
			ps.setString(6, Colleague);
			ps.setInt(7, Price);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void InsertPostByETC(double SEQ_User, String Name, String Address, String Tel, String Id, double Lat, double Lng, int SaveType, int Taste, String Colleague) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Posts(SEQ_User, Update_PostDay, Name, Address, Tel, Id, Lat, Lng, SaveType, Taste, Colleague) values (?,now(),?,?,?,?,?,?,?,?,?)"; // 11媛� �냽�꽦
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			ps.setString(2, Name);
			ps.setString(3, Address);
			ps.setString(4, Tel);
			ps.setString(5, Id);
			ps.setDouble(6, Lat);
			ps.setDouble(7, Lng);
			ps.setInt(8, SaveType);
			ps.setInt(10, Taste);
			ps.setString(11, Colleague);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void InsertPostOnlySave(double SEQ_User, String Name, String Address, String Tel, String Id, double Lat, double Lng, int SaveType) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Posts(SEQ_User, Update_PostDay, Name, Address, Tel, Id, Lat, Lng, SaveType) values (?,now(),?,?,?,?,?,?,?)"; // 
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			ps.setString(2, Name);
			ps.setString(3, Address);
			ps.setString(4, Tel);
			ps.setString(5, Id);
			ps.setDouble(6, Lat);
			ps.setDouble(7, Lng);
			ps.setInt(8, SaveType);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
 
	public ArrayList<String> get1() throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
	   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
	   String sql = "select JSON_ARRAY(Lat, Lng, Name, Address, Tel, Taste, Price) from Posts";
	   ArrayList<String> list = new ArrayList<String>();
	   try {
	   PreparedStatement ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   return list;
 }
}
