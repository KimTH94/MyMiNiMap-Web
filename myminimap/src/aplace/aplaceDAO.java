package aplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class aplaceDAO {
	  private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private Connection conn = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   String returns = "";
	   String returns2 = "";
		public void insertRestaurants(String Name, String Address, String Tel, String Id, Double Lat, Double Lng) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "insert into Restaurants(Name,Address,Tel, Id,Lat,Lng) values(?,?,?,?,?,?)";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Name);
		         ps.setString(2, Address);
		         ps.setString(3, Tel);
		         ps.setString(4, Id);
		         ps.setDouble(5, Lat);
		         ps.setDouble(6, Lng);
		         ps. executeUpdate();
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		   }
		
		public void insertPosts(Double SEQ_User, String Id, int SaveType, int FoodType, int Taste, int Price, String Colleague) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "insert into Posts(SEQ_User,Id,SaveType,FoodType, Taste, Price, Colleague ,Check_In,Update_PostDAY) values(?,?,?,?,?,?,?,now(),now())";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setDouble(1, SEQ_User);
		         ps.setString(2, Id);
		         ps.setInt(3, SaveType);
		         ps.setInt(4, FoodType);
		         ps.setInt(5, Taste);
		         ps.setInt(6, Price);
		         ps.setString(7, Colleague);
		         ps. executeUpdate();
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		   }
		
		
		public void TagInsert(double SEQ_Post, double SEQ_User, String Id, String Tag) throws Exception {
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection con = null;
		      PreparedStatement ps = null;
		      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "insert into Tags(SEQ_Post, SEQ_User, PlaceId, Tag) values (?,?,?,?)";
		      try {
		         ps = con.prepareStatement(sql);
		         ps.setDouble(1, SEQ_Post);
		         ps.setDouble(2, SEQ_User);
		         ps.setString(3, Id);
		         ps.setString(4, Tag);
		         ps.executeUpdate();
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		      }
		   }
		
		public  void MenuInsert(double SEQ_Post, double SEQ_User, String Id, String Menu) throws Exception {
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection con = null;
		      PreparedStatement ps = null;
		      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "insert into RecommendMenus(SEQ_Post, SEQ_User, PlaceId, Menu) values (?,?,?,?)";
		      try {
		         ps = con.prepareStatement(sql);
		         ps.setDouble(1, SEQ_Post);
		         ps.setDouble(2, SEQ_User);
		         ps.setString(3, Id);
		         ps.setString(4, Menu);
		         ps.executeUpdate();
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		      }
		   }
		
		
	public Double getSEQ_Post(Double SEQ_User, String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select SEQ_Post from Posts where SEQ_User = ? and Id = ?";
		ResultSet rs = null;
		Double SEQ_Post = (double) 0;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, SEQ_User);
		ps.setString(2, Id);
		rs = ps.executeQuery();
		while(rs.next()) {
			SEQ_Post = rs.getDouble(1);
		}

        try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
        try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
        try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		return SEQ_Post;
	}
	
	public void Update_upload(Double SEQ_User, String fileName, Double SEQ_Post) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "insert into Attachments(SEQ_User, FileName, SEQ_Post) values (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, SEQ_User);
		ps.setString(2, fileName);
		ps.setDouble(3, SEQ_Post);
		int rs = ps.executeUpdate();
        try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
        try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
      
	}
	
	public int getCheck(String rID, Double SEQ_User) throws Exception {//식당 ID랑 내 SEQ_User 넘겨서 그 두개로 등록된 Count 있는지 체크해서 0,1로 반환해주자 .
		int check = 0;
		ResultSet rs;
		int checkNum=0;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select count(*) from Posts where SEQ_User = ? and Id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, SEQ_User);
		ps.setString(2, rID);
		rs = ps.executeQuery();
		while(rs.next())
			checkNum = rs.getInt(1);
		
		
		if(checkNum==0)
			check=0;
		else
			check=1;

        try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
        try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
        try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		return check;
	}
	
	
	public void LikeUp(double SEQ_User, double Post_owner,double SEQ_Post) throws Exception{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      String sql = "insert into Likes(SEQ_Post, SEQ_User, Post_owner, Like_DAY) values(?,?,?,now())";
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setDouble(1, SEQ_Post);
	         ps.setDouble(2, SEQ_User);
	         ps.setDouble(3, Post_owner);
	         ps. executeUpdate();
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
	      }
	   }
	
	
	@SuppressWarnings("null")
	public String LikeState(double SEQ_Post,double SEQ_User) throws Exception{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int count = 0;
	      String state = "false";
	      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      String sql = "select count(SEQ_Like) from Likes where SEQ_Post = ? and SEQ_User = ?";
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setDouble(1, SEQ_Post);
	         ps.setDouble(2, SEQ_User);
	         rs = ps.executeQuery();
	         while(rs.next()) {
	            count = rs.getInt(1);
	         }
	         if(count > 0) {
	            state = "true";
	         }else {
	            state = "false";
	         }
	         return state;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
	      }
	      return state;
	   }
	
	
	public Double getSEQ_User(double SEQ_Post) throws Exception{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int count = 0;
	      Double SEQ=0.0;
	      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      String sql = "select SEQ_User from Posts where SEQ_Post = ?";
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setDouble(1, SEQ_Post);
	         rs = ps.executeQuery();
	         while(rs.next()) {
	        	 SEQ= rs.getDouble(1);
	         }
	         return SEQ;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
	      }
	      return SEQ;
	   }
	
	public String getName(double SEQ_Post) throws Exception{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int count = 0;
	      String name="";
	      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      String sql = "select Name from Posts where SEQ_Post = ?";
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setDouble(1, SEQ_Post);
	         rs = ps.executeQuery();
	         while(rs.next()) {
	        	 name= rs.getString(1);
	         }
	         return name;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
	      }
	      return name;
	   }
	
	
	   public  void LikeDelete(double SEQ_User, double Post_owner,double SEQ_Post) throws Exception{
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "delete from Likes where SEQ_User = ? and SEQ_Post = ? and Post_owner = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setDouble(1, SEQ_User);
		         ps.setDouble(2, SEQ_Post);
		         ps.setDouble(3, Post_owner);
		          ps.executeUpdate();
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		   }
	
	   
		public String get_Name(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String name="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Name from Restaurants where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 name= rs.getString(1);
		         }
		         return name;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return name;
		   }

		public String get_Address(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String name="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Address from Restaurants where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 name= rs.getString(1);
		         }
		         return name;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return name;
		   }

		public String get_Tel(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String name="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Tel from Restaurants where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 name= rs.getString(1);
		         }
		         return name;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return name;
		   }
		public int get_Counting(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select count(*) from Restaurants where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 count= rs.getInt(1);
		         }
		         return count;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return count;
		   }
		
		public String get_Recommmend(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      String result = null;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Recommend,NonRecommend from PriceAndRecommends where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 result = rs.getString(1)+"/";
		        	 result+=rs.getString(2);
		         }
		         return result;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return result;
		   }
		
		public Double get_lat(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      Double lat=0.0;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Lat from Restaurants where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 lat= rs.getDouble(1);
		         }
		         return lat;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return lat;
		   }
		public Double get_lng(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      Double lng=0.0;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Lng from Restaurants where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 lng= rs.getDouble(1);
		         }
		         return lng;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return lng;
		   }
		
		public String get_Id(Double SEQ_Post) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String Id = "";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Id from Posts where SEQ_Post = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setDouble(1, SEQ_Post);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 Id= rs.getString(1);
		         }
		         return Id;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return Id;
		   }
		
		public String get_Image(Double SEQ_Post) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String Id = "";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select FileName from Attachments where SEQ_Post = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setDouble(1, SEQ_Post);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 Id= rs.getString(1);
		         }
		         return Id;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return Id;
		   }
		public Double get_SEQUser(Double SEQ_Post) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      Double SEQ_User = 0.0;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select SEQ_User from Posts where SEQ_Post = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setDouble(1, SEQ_Post);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 SEQ_User= rs.getDouble(1);
		         }
		         return SEQ_User;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return SEQ_User;
		   }
		

		public String get_SEQ_Post(String Id) throws Exception{
				ResultSet rs=null;
				String name="";
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
				String sql = "select SEQ_Post from Posts where Id = ?";
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, Id);
		         rs = pstmt.executeQuery();
		         while(rs.next()) {
		        	 name= rs.getString(1);
		         }
		         return name;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return name;
		   }
		
		

		public int getCheck(String id) throws Exception {//식당 ID랑 내 SEQ_User 넘겨서 그 두개로 등록된 Count 있는지 체크해서 0,1로 반환해주자 .
			int check = 0;
			ResultSet rs;
			int checkNum=0;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			String sql = "select count(*) from Posts where Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next())
				checkNum = rs.getInt(1);
			if(checkNum==0)
				checkNum=0;

	         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			return checkNum;
		}
		
		public int getTasteLike(String id) throws Exception {//식당 ID랑 내 SEQ_User 넘겨서 그 두개로 등록된 Count 있는지 체크해서 0,1로 반환해주자 .
			int check = 0;
			ResultSet rs;
			int checkNum=0;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			String sql = "select count(*) from Posts where Id = ? and Taste= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, 1);
			rs = ps.executeQuery();
			while(rs.next())
				checkNum = rs.getInt(1);
			if(checkNum==0)
				checkNum=0;

	         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			return checkNum;
		}
		
		public int getTasteUnLike(String id) throws Exception {//식당 ID랑 내 SEQ_User 넘겨서 그 두개로 등록된 Count 있는지 체크해서 0,1로 반환해주자 .
			int check = 0;
			ResultSet rs;
			int checkNum=0;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			String sql = "select count(*) from Posts where Id = ? and Taste= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, 2);
			rs = ps.executeQuery();
			while(rs.next())
				checkNum = rs.getInt(1);
			if(checkNum==0)
				checkNum=0;

	         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			return checkNum;
		}


		
		public int get_saveType(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      int SaveType=0;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select SaveType from Posts where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 SaveType= rs.getInt(1);
		         }
		         return SaveType;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return SaveType;
		   }
		
		

		public int get_foodType(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      int FoodType=0;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select FoodType from Posts where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 FoodType= rs.getInt(1);
		         }
		         return FoodType;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return FoodType;
		   }
		
		
		public int get_Taste(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      int Taste=0;
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Taste from Posts where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 Taste= rs.getInt(1);
		         }
		         return Taste;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return Taste;
		   }
		
		
		public String get_Colleague(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String colleague="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Colleague from Posts where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 colleague= rs.getString(1);
		         }
		         return colleague;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return colleague;
		   }
		public String get_Colleagues(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      String colleague="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Alone,Friend,Couple,DiningTogether,Business,Family from Colleagues where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 colleague+= rs.getString(1)+"@/@";
		        	 colleague+= rs.getString(2)+"@/@";
		        	 colleague+= rs.getString(3)+"@/@";
		        	 colleague+= rs.getString(4)+"@/@";
		        	 colleague+= rs.getString(5)+"@/@";
		        	 colleague+= rs.getString(6)+"@/@";
		         }
		         return colleague;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return colleague;
		   }
		
		public String get_SaveTypes(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      String savetype="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Restaurant,Cafe,Alcohol,Price,Save from SaveTypes where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 savetype+= rs.getString(1)+"@/@";
		        	 savetype+= rs.getString(2)+"@/@";
		        	 savetype+= rs.getString(3)+"@/@";
		        	 savetype+= rs.getString(4)+"@/@";
		        	 savetype+= rs.getString(5)+"@/@";
		         }
		         return savetype;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return savetype;
		   }
		
		public String get_foodTypes(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      String foodtype="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select KoreanFood,ChineseFood,JapaneseFood,WesternFood,SoutheastAsianFood,lateNightMeal,FlourBasedFood from FoodTypes where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 foodtype+= rs.getString(1)+"@/@";
		        	 foodtype+= rs.getString(2)+"@/@";
		        	 foodtype+= rs.getString(3)+"@/@";
		        	 foodtype+= rs.getString(4)+"@/@";
		        	 foodtype+= rs.getString(5)+"@/@";
		        	 foodtype+= rs.getString(6)+"@/@";
		        	 foodtype+= rs.getString(7)+"@/@";
		         }
		         return foodtype;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return foodtype;
		   }
		
		public String get_Tag(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      String Tag="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Tag from Tags where PlaceId = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 Tag+= rs.getString(1)+"@/@";
		         }
		         return Tag;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return Tag;
		   }
		public String get_menu(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      String Menu="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Menu from RecommendMenus where PlaceId = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 Menu+= rs.getString(1)+"@/@";
		         }
		         return Menu;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return Menu;
		   }
		
		public String get_recommend(Double SEQ_Post) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String Menu="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Menu from RecommendMenus where SEQ_Post = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setDouble(1, SEQ_Post);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 Menu+= rs.getString(1)+"@/@";
		         }
		         return Menu;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return Menu;
		   }
		
		

		public String get_Tag(Double SEQ_Post) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String Tag="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Tag from Tags where SEQ_Post = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setDouble(1, SEQ_Post);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 Tag+= rs.getString(1)+"@/@";
		         }
		         return Tag;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return Tag;
		   }
		
		
		
		public String get_FoodType1(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String colleague="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select FoodType from Posts where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 colleague= rs.getString(1)+"/";
		         }
		         return colleague;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return colleague;
		   }
		public String get_SaveType1(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String colleague="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select SaveType from Posts where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 colleague= rs.getString(1)+"/";
		         }
		         return colleague;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return colleague;
		   }
		public String get_Colleague1(String Id) throws Exception{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      int count = 0;
		      String colleague="";
		      conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		      String sql = "select Colleague from Posts where Id = ?";
		      try {
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, Id);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		        	 colleague= rs.getString(1)+"/";
		         }
		         return colleague;
		      }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		         try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		      }
		      return colleague;
		   }
		
		
		
		
}
