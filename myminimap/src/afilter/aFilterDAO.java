package afilter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class aFilterDAO {


	  private static String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private static String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private static String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private static Connection conn = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   String returns = "";
	   String returns2 = "";
	
		
	public String get_Tag() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
       conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Tag from Tags";
		ResultSet rs = null;
		String Tag = "";
		PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			Tag+=rs.getString(1)+"@/@";
		}

       try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
       try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
       try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		return Tag;
	}		
	public String get_placeId() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
       conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Id from Restaurants";
		ResultSet rs = null;
		String Tag = "";
		PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			Tag+=rs.getString(1)+"@/@";
		}

       try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
       try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
       try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		return Tag;
	}
		
		
	public String get_Recommend() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Menu from RecommendMenus";
		ResultSet rs = null;
		String Recommend="";
		PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			Recommend+= rs.getString(1)+"@/@";
		}
	
	    try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	    try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	    try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		return Recommend;
	}
	
	
	public String get_Name() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Name from Restaurants";
		ResultSet rs = null;
		String Name ="";
		PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			Name+= rs.getString(1)+"@/@";
		}
	
	    try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	    try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	    try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		return Name;
	}
	
	public static ArrayList<String> menu(String menu) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<String> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "SELECT RecommendMenus.PlaceId\r\n" + 
	      		"FROM (\r\n" + 
	      		"    SELECT  *, COUNT(*) AS 개수\r\n" + 
	      		"    FROM RecommendMenus\r\n" + 
	      		"    WHERE Menu = ?\r\n" + 
	      		"    GROUP BY PlaceId\r\n" + 
	      		"    ) RecommendMenus\r\n" + 
	      		"ORDER BY 개수 DESC;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}

	public static ArrayList<String> tag(String tag) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<String> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "SELECT Tags.PlaceId\r\n" + 
	      		"FROM (\r\n" + 
	      		"    SELECT  *, COUNT(*) AS 개수\r\n" + 
	      		"    FROM Tags\r\n" + 
	      		"    WHERE Tag = ?\r\n" + 
	      		"    GROUP BY PlaceId\r\n" + 
	      		"    ) Tags\r\n" + 
	      		"ORDER BY 개수 DESC;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tag);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	
	
	public static ArrayList<String> tag(String tag,String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<String> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = " SELECT Tags.PlaceId\r\n" + 
	      		"FROM (\r\n" + 
	      		"    SELECT  PlaceId, COUNT(*) AS 개수\r\n" + 
	      		"    FROM Tags\r\n" + 
	      		"    WHERE Tag = ? and PlaceId = ?\r\n" + 
	      		"    GROUP BY PlaceId\r\n" + 
	      		"    ) Tags\r\n" + 
	      		"ORDER BY 개수 DESC limit 20;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tag);
			ps.setString(2, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
		
	
	

	public static ArrayList<String> menuFilter(String menu, String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<String> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "select PlaceId from RecommendMenus where Menu = ? and PlaceId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu);
			ps.setString(2, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	public static ArrayList<String> tagFilter(String menu,String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<String> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "select PlaceId from Tags where Tag = ? and  PlaceId= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	public static ArrayList<String> all() throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<String> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "select Id from Posts";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	
	public static ArrayList<Double> getColleagues(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<Double> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "select Alone,Friend,Couple,DiningTogether,Business,Family from Colleagues where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getDouble(1));
				list.add(rs.getDouble(2));
				list.add(rs.getDouble(3));
				list.add(rs.getDouble(4));
				list.add(rs.getDouble(5));
				list.add(rs.getDouble(6));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	public static ArrayList<Double> getFoodTypes(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<Double> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "select KoreanFood,ChineseFood,JapaneseFood,WesternFood,SoutheastAsianFood,lateNightMeal,FlourBasedFood from FoodTypes where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getDouble(1));
				list.add(rs.getDouble(2));
				list.add(rs.getDouble(3));
				list.add(rs.getDouble(4));
				list.add(rs.getDouble(5));
				list.add(rs.getDouble(6));
				list.add(rs.getDouble(7));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	
	public static ArrayList<Double> getSaveTypes(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<Double> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "select Restaurant,Cafe,Alcohol,Price,Save from SaveTypes where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getDouble(1));
				list.add(rs.getDouble(2));
				list.add(rs.getDouble(3));
				list.add(rs.getDouble(4));
				list.add(rs.getDouble(5));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	
	public static ArrayList<Double> getPrice(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<Double> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      String sql = "select Price1,Price2,Price3,Price4,Price5 from PriceAndRecommends where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getDouble(1));
				list.add(rs.getDouble(2));
				list.add(rs.getDouble(3));
				list.add(rs.getDouble(4));
				list.add(rs.getDouble(5));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	public static ArrayList<Double> getRecommend(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ArrayList<Double> list = new ArrayList<>();
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      String sql = "select Recommend,NonRecommend from PriceAndRecommends where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getDouble(1));
				list.add(rs.getDouble(2));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
}
