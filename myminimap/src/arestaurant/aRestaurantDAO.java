package arestaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class aRestaurantDAO {

	  private static String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private static String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private static String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private static Connection conn = null;
	   private static PreparedStatement pstmt = null;
	   private static ResultSet rs = null;
	   private String sql = "";
	   String returns = "";
	   String returns2 = "";
	   
	public static void InsertRestarants(String Name, String Address, String Tel, String Id, double Lat, double Lng) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	    String sql = "insert into Restaurants(Name, Address, Tel, Id, Lat, Lng) values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Name);
			ps.setString(2, Address);
			ps.setString(3, Tel);
			ps.setString(4, Id);
			ps.setDouble(5, Lat);
			ps.setDouble(6, Lng);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}

	public static int OverlapRestarants(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	      int count = 0;
	      String sql = "select * from Restaurants where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = 1; // 이미 등록된 음식점
			}
			return count;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return count;
	}
	
	public static void InsertSaveType(String Id, int type) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   
		int saveType = type;
		String sql = null;
		if (saveType == 1) {
			sql = "insert into SaveTypes(Id, Restaurant) values (?,1)";
		}else if(saveType == 2) {
			sql = "insert into SaveTypes(Id, Cafe) values (?,1)";
		}else if(saveType == 3) {
			sql = "insert into SaveTypes(Id, Alcohol) values (?,1)";
		}else if(saveType == 4) {
			sql = "insert into SaveTypes(Id, Place) values (?,1)";
		}else if(saveType == 5) {
			sql = "insert into SaveTypes(Id, Save) values (?,1)";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void InsertFoodType(String Id, int type) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   
		int FoodType = type;
		String sql = null;
		if (FoodType == 1) {
			sql = "insert into FoodTypes(Id, KoreanFood) values (?,1)";
		}else if(FoodType == 2) {
			sql = "insert into FoodTypes(Id, ChineseFood) values (?,1)";
		}else if(FoodType == 3) {
			sql = "insert into FoodTypes(Id, JapaneseFood) values (?,1)";
		}else if(FoodType == 4) {
			sql = "insert into FoodTypes(Id, WesternFood) values (?,1)";
		}else if(FoodType == 5) {
			sql = "insert into FoodTypes(Id, SoutheastAsianFood) values (?,1)";
		}else if(FoodType == 6) {
			sql = "insert into FoodTypes(Id, lateNightMeal) values (?,1)";
		}else if(FoodType == 7) {
			sql = "insert into FoodTypes(Id, FlourBasedFood) values (?,1)";
		}
		else {
			sql ="insert into FoodTypes(Id, FlourBasedFood) values (?,1)";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void InsertColleagues(String Id, String type) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   String Colleague = type;
		String sql = "insert into Colleagues(Id) values (?)";
		String sql1 = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(Colleague.contains("1")) {
			sql1 = "update Colleagues set Alone = 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("2")) {
			sql1 = "update Colleagues set Friend = 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("3")) {
			sql1 = "update Colleagues set Couple = 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("4")) {
			sql1 = "update Colleagues set DiningTogether = 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("5")) {
			sql1 = "update Colleagues set Business = 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("6")) {
			sql1 = "update Colleagues set Family = 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
		try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	}
	
	public static void InsertPriceAndRecommends(String Id, int price) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = null;
		if (price == 1) {
			sql = "insert into PriceAndRecommends(Id, Price1) values (?,1)";
		}else if(price == 2) {
			sql = "insert into PriceAndRecommends(Id, Price2) values (?,1)";
		}else if(price == 3) {
			sql = "insert into PriceAndRecommends(Id, Price3) values (?,1)";
		}else if(price == 4) {
			sql = "insert into PriceAndRecommends(Id, Price4) values (?,1)";
		}else if(price == 5) {
			sql = "insert into PriceAndRecommends(Id, Price5) values (?,1)";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	
	public static void UpdateSaveType(String Id, int type) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		int saveType = type;
		String sql = null;
		if (saveType == 1) {
			sql = "update SaveTypes set Restaurant = Restaurant + 1 where Id = ?";
		}else if(saveType == 2) {
			sql = "update SaveTypes set Cafe = Cafe + 1 where Id = ?";
		}else if(saveType == 3) {
			sql = "update SaveTypes set Alcohol = Alcohol + 1 where Id = ?";
		}else if(saveType == 4) {
			sql = "update SaveTypes set Place = Place + 1 where Id = ?";
		}else if(saveType == 5) {
			sql = "update SaveTypes set Save = Save + 1 where Id = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void UpdateFoodType(String Id, int type) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   int FoodType = type;
		String sql = null;
		if (FoodType == 1) {
			sql = "update  FoodTypes set KoreanFood = KoreanFood + 1 where id = ?";
		}else if(FoodType == 2) {
			sql = "update  FoodTypes set ChineseFood = ChineseFood + 1 where id = ?";
		}else if(FoodType == 3) {
			sql = "update  FoodTypes set JapaneseFood = JapaneseFood + 1 where id = ?";
		}else if(FoodType == 4) {
			sql = "update  FoodTypes set WesternFood = WesternFood + 1 where id = ?";
		}else if(FoodType == 5) {
			sql = "update FoodTypes set SoutheastAsianFood = SoutheastAsianFood + 1 where id = ?";
		}else if(FoodType == 6) {
			sql = "update FoodTypes set lateNightMeal = lateNightMeal + 1 where id = ?";
		}else if(FoodType == 7) {
			sql = "update FoodTypes set FlourBasedFood = FlourBasedFood + 1 where id = ?";
		}else if(FoodType == 0) {
			sql = "update FoodTypes set FlourBasedFood = FlourBasedFood where id = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void UpdateColleagues(String Id, String type) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   	String Colleague = type;
			String sql = "insert into Colleagues(Id) values (?)";
		if(Colleague.contains("1")) {
			sql = "update Colleagues set Alone = Alone + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("2")) {
			sql = "update Colleagues set Friend = Friend + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("3")) {
			sql = "update Colleagues set Couple = Couple + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("4")) {
			sql = "update Colleagues set DiningTogether = DiningTogether + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("5")) {
			sql = "update Colleagues set Business = Business + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(Colleague.contains("6")) {
			sql = "update Colleagues set Family = Family + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
		try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	}
	

	
	public static void InsertSaveType(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "insert into SaveTypes(Id) values(?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void InsertFoodType(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "insert into FoodTypes(Id) values(?)";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void InsertColleagues(String Id) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "insert into Colleagues(Id) values(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
		try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	}
	
	public static void UpdatePrice(String Id, int price) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		int Price = price;
		String sql = null;
		if (Price == 1) {
			sql = "update PriceAndRecommends set Price1 = Price1 + 1 where Id = ?";
		}else if(Price == 2) {
			sql = "update PriceAndRecommends set Price2 = Price2 + 1 where Id = ?";
		}else if(Price == 3) {
			sql = "update PriceAndRecommends set Price3 = Price3 + 1 where Id = ?";
		}else if(Price == 4) {
			sql = "update PriceAndRecommends set Price4 = Price4 + 1 where Id = ?";
		}else if(Price == 5) {
			sql = "update PriceAndRecommends set Price5 = Price5 + 1 where Id = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void UpdateRecommends(String Id, int recommend) throws Exception {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		int Recommend = recommend;
		String sql = null;
		if (Recommend==1) {
			sql = "update PriceAndRecommends set Recommend = Recommend + 1 where Id = ?";
		}else if(Recommend==0) {
			sql = "update PriceAndRecommends set NonRecommend = NonRecommend + 1 where Id = ?";
		}try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	
}
