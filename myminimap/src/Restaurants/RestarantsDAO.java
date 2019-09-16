package Restaurants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RestarantsDAO {
	
	public static void InsertRestarants(String Name, String Address, String Tel, String Id, double Lat, double Lng) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
		String sql = "select * from Restaurants where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = 1; // �씠誘� �벑濡앸맂 �쓬�떇�젏
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
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		int saveType = type;
		String sql = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		int FoodType = type;
		String sql = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		String Colleague = type;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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
	
	@SuppressWarnings("resource")
	public static void InsertPriceAndRecommends(String Id, int Price, int Taste) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		String sql1 = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
		if (Price == 1) {
			sql = "insert into PriceAndRecommends(Id, Price1) values (?,1)";
		}else if(Price == 2) {
			sql = "insert into PriceAndRecommends(Id, Price2) values (?,1)";
		}else if(Price == 3) {
			sql = "insert into PriceAndRecommends(Id, Price3) values (?,1)";
		}else if(Price == 4) {
			sql = "insert into PriceAndRecommends(Id, Price4) values (?,1)";
		}else if(Price == 5) {
			sql = "insert into PriceAndRecommends(Id, Price5) values (?,1)";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(Taste == 1){
			sql1 = "update PriceAndRecommends set Recommend = Recommend + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(Taste == 2) {
			sql1 = "update PriceAndRecommends set NonRecommend = NonRecommend + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	}
	
	public static void UpdateSaveType(String Id, int type) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		int saveType = type;
		String sql = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		int FoodType = type;
		String sql = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
		if (FoodType == 1) {
			sql = "update FoodTypes set KoreanFood = KoreanFood + 1 where id = ?";
		}else if(FoodType == 2) {
			sql = "update FoodTypes set ChineseFood = ChineseFood + 1 where id = ?";
		}else if(FoodType == 3) {
			sql = "update FoodTypes set JapaneseFood = JapaneseFood + 1 where id = ?";
		}else if(FoodType == 4) {
			sql = "update FoodTypes set WesternFood = WesternFood + 1 where id = ?";
		}else if(FoodType == 5) {
			sql = "update FoodTypes set SoutheastAsianFood = SoutheastAsianFood + 1 where id = ?";
		}else if(FoodType == 6) {
			sql = "update FoodTypes set lateNightMeal = lateNightMeal + 1 where id = ?";
		}else if(FoodType == 7) {
			sql = "update FoodTypes set FlourBasedFood = FlourBasedFood + 1 where id = ?";
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
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		String Colleague = type;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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
	
	@SuppressWarnings("resource")
	public static void UpdatePriceAndRecommends(String Id, int Price, int Taste) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		String sql1 = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
		if (Price == 1) {
			sql = "update PriceAndRecommends set Price1 = Price1 + 1 where Id = ?";
		}else if(Price == 2) {
			sql = "update PriceAndRecommends set Price1 = Price1 + 2 where Id = ?";
		}else if(Price == 3) {
			sql = "update PriceAndRecommends set Price1 = Price1 + 3 where Id = ?";
		}else if(Price == 4) {
			sql = "update PriceAndRecommends set Price1 = Price1 + 4 where Id = ?";
		}else if(Price == 5) {
			sql = "update PriceAndRecommends set Price1 = Price1 + 5 where Id = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(Taste == 1){
			sql1 = "update PriceAndRecommends set Recommend = Recommend + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(Taste == 2) {
			sql1 = "update PriceAndRecommends set NonRecommend = NonRecommend + 1 where Id = ?";
			try {
				ps = con.prepareStatement(sql1);
				ps.setString(1, Id);
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	}
}
