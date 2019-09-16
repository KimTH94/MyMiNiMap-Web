package Filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.MemDTO;

public class FilterDAO {
	
	public static ArrayList<String> AddallRestaurants() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select distinct id from Restaurants;";
		ArrayList<String> IdList = new ArrayList<String>();
		try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
			while(rs.next()) {
				IdList.add(rs.getString(1));
			}
			return IdList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return IdList;
	}

	
	public static ArrayList<FilterDTO> SearchTag(String key) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		key = "%" + key + "%";
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select distinct Tag from Restaurants inner join Tags on Tags.PlaceId = Restaurants.Id where Tags.Tag like ?";
		FilterDTO filterDTO = null;
		ArrayList<FilterDTO> TagList = new ArrayList<FilterDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, key);
			rs= ps.executeQuery();
			while(rs.next()) {
				filterDTO = new FilterDTO();
				filterDTO.setTag(rs.getString(1));
				TagList.add(filterDTO);
			}
			return TagList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return TagList;
	}	
	
	public static ArrayList<FilterDTO> SearchRecommendMenu(String key) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		key = "%" + key + "%";
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select distinct Menu from Restaurants inner join RecommendMenus on RecommendMenus.PlaceId = Restaurants.Id where RecommendMenus.Menu like ?";
		FilterDTO filterDTO = null;
		ArrayList<FilterDTO> MenuList = new ArrayList<FilterDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, key);
			rs= ps.executeQuery();
			while(rs.next()) {
				filterDTO = new FilterDTO();
				filterDTO.setMenu(rs.getString(1));
				MenuList.add(filterDTO);
			}
			return MenuList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return MenuList;
	}	
	
	public static ArrayList<FilterDTO> SearchRestaurant(String key) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		key = "%" + key + "%";
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select distinct Name from Restaurants where Name like ?";
		FilterDTO filterDTO = null;
		ArrayList<FilterDTO> Restaurant = new ArrayList<FilterDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, key);
			rs= ps.executeQuery();
			while(rs.next()) {
				filterDTO = new FilterDTO();
				filterDTO.setName(rs.getString(1));
				Restaurant.add(filterDTO);
			}
			return Restaurant;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Restaurant;
	}	
	
	public static ArrayList<String> getLocation() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   //String sql = "select JSON_ARRAY(Lat, Lng, Restaurants.Id, Name, Address, Tel, SEQ_User, SaveType, FoodType, Taste, Price, Colleague) from Restaurants inner join Posts on Posts.Id = Restaurants.Id";
		   String sql = "select JSON_ARRAY(Lat, Lng, Restaurants.Id) from Restaurants inner join Posts on Posts.Id = Restaurants.Id";
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
	
	
	public static ArrayList<String> getLocation1() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select JSON_ARRAY(Lat, Lng, Name, Address, Tel, SEQ_User, SaveType, FoodType, Taste, Price, Colleague, Restaurants.Id) from Restaurants inner join Posts on Posts.Id = Restaurants.Id";
		   ArrayList<String> list = new ArrayList<String>();
		   try {
		   PreparedStatement ps = con.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   String key = rs.getString(1).replaceAll("[\\[\\]]", "");
			   list.add(key);
		   }
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   return list;
	 }
	
	
	public static ArrayList<String> getLocation2() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select Lat, Lng from Restaurants inner join Posts on Posts.Id = Restaurants.Id";
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
	
	public static double CountMenu(String Menu) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select count(*) from RecommendMenus where Menu = ?";
		int count = 0;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Menu);
		rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return count;
	}
	
	public static double CountTag(String Tag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select count(*) from Tags where Tag = ?";
		int count = 0;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Tag);
		rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return count;
	}
	
	public static ArrayList<String> getIdByTag(String Tag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select Tags.* from (select PlaceId, count(*) as count from Tags where Tag = ? group by PlaceId) Tags order by count desc";
		ArrayList<String> IdList = new ArrayList<String>();
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Tag);
		rs = ps.executeQuery();
			while(rs.next()) {
				IdList.add(rs.getString(1));
			}
			return IdList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return IdList;
	}
	
	public static ArrayList<String> getIdByTag(String Tag, String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select Tags.PlaceId from (select PlaceId, count(*) as count from Tags where Tag = ? and PlaceId = ? group by PlaceId) Tags order by count desc";
		ArrayList<String> IdList = new ArrayList<String>();
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Tag);
		ps.setString(2, Id);
		rs = ps.executeQuery();
			while(rs.next()) {
				IdList.add(rs.getString(1));
			}
			return IdList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return IdList;
	}
	
	public static ArrayList<String> getIdByMenu(String Menu) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select RecommendMenus.* from (select PlaceId, count(*) as count from RecommendMenus where Menu = ? group by PlaceId) RecommendMenus order by count desc";
		ArrayList<String> IdList = new ArrayList<String>();
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Menu);
		rs = ps.executeQuery();
			while(rs.next()) {
				IdList.add(rs.getString(1));
			}
			return IdList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return IdList;
	}
	
	public static ArrayList<String> getId() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select Restaurants.* from (select *, count(*) as 개수 from Posts group by Id) Restaurants order by 개수";
		ArrayList<String> IdList = new ArrayList<String>();
		try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
			while(rs.next()) {
				IdList.add(rs.getString(3));
			}
			return IdList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return IdList;
	}
	
	public static String getColleague(String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		double sum, Agv_Alone, Agv_Friend, Agv_Couple, Agv_DiningTogether, Agv_Business, Agv_Family;
		String sql = "select * from Colleagues where Id = ?";
		String ColleagueResult = "0";
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Id);
		rs = ps.executeQuery();
			while(rs.next()) {
				sum = rs.getDouble(2) + rs.getDouble(3) + rs.getDouble(4) + rs.getDouble(5) + rs.getDouble(6) + rs.getDouble(7);
				Agv_Alone = (rs.getDouble(2)/sum) * 100;
				Agv_Friend = (rs.getDouble(3)/sum) * 100;
				Agv_Couple = (rs.getDouble(4)/sum) * 100;
				Agv_DiningTogether = (rs.getDouble(5)/sum) * 100;
				Agv_Business = (rs.getDouble(6)/sum) * 100;
				Agv_Family = (rs.getDouble(7)/sum) * 100;
				/*System.out.println("Id : " + rs.getString(1) + " Alone : " + Agv_Alone + " Friend : " + Agv_Friend + " Couple : " + Agv_Couple + " DiningTogether : " + Agv_DiningTogether + " Business : " + Agv_Business + "Family : " + Agv_Family);*/
				if(Agv_Alone >= 20) {
					ColleagueResult += ",1";
				}
				if(Agv_Friend >= 20) {
					ColleagueResult += ",2";
				}
				if(Agv_Couple >= 20) {
					ColleagueResult += ",3";
				}
				if(Agv_DiningTogether >= 20) {
					ColleagueResult += ",4";
				}
				if(Agv_Business >= 20) {
					ColleagueResult += ",5";
				}
				if(Agv_Family >= 20) {
					ColleagueResult += ",6";
				}
				ColleagueResult += "/" + rs.getString(1);
			}
			return ColleagueResult;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return ColleagueResult;
	}
	
	public static String getFoodType(String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		double sum, Agv_KoreanFood, Agv_ChineseFood, Agv_JapaneseFood, Agv_WesternFood, Agv_SoutheastAsianFood, Agv_lateNightMeal, Agv_FlourBasedFood;
		String sql = "select * from FoodTypes where Id = ?";
		String FoodResult = "0";
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Id);
		rs = ps.executeQuery();
			while(rs.next()) {
				sum = rs.getDouble(2) + rs.getDouble(3) + rs.getDouble(4) + rs.getDouble(5) + rs.getDouble(6) + rs.getDouble(7) + rs.getDouble(8);
				Agv_KoreanFood = (rs.getDouble(2)/sum) * 100;
				Agv_ChineseFood = (rs.getDouble(3)/sum) * 100;
				Agv_JapaneseFood = (rs.getDouble(4)/sum) * 100;
				Agv_WesternFood = (rs.getDouble(5)/sum) * 100;
				Agv_SoutheastAsianFood = (rs.getDouble(6)/sum) * 100;
				Agv_lateNightMeal = (rs.getDouble(7)/sum) * 100;
				Agv_FlourBasedFood = (rs.getDouble(8)/sum) * 100;
				/*System.out.println("Id : " + rs.getString(1) + "Alone : " + Agv_Alone + "Friend : " + Agv_Friend + "Couple : " + Agv_Couple + "DiningTogether : " + Agv_DiningTogether + "Business : " + Agv_Business + "Family : " + Agv_Family);*/
				if(Agv_KoreanFood >= 20) {
					FoodResult += ",1";
				}
				if(Agv_ChineseFood >= 20) {
					FoodResult += ",2";
				}
				if(Agv_JapaneseFood >= 20) {
					FoodResult += ",3";
				}
				if(Agv_WesternFood >= 20) {
					FoodResult += ",4";
				}
				if(Agv_SoutheastAsianFood >= 20) {
					FoodResult += ",5";
				}
				if(Agv_lateNightMeal >= 20) {
					FoodResult += ",6";
				}
				if(Agv_FlourBasedFood >= 20) {
					FoodResult += ",7";
				}
				FoodResult += "/" + rs.getString(1);
			}
			return FoodResult;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return FoodResult;
	}
	
	public static String getSaveType(String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		double sum, Agv_Restaurant, Agv_Cafe, Agv_Alcohol, Agv_Place, Agv_Save;
		String sql = "select * from SaveTypes where Id = ?";
		String SaveResult = "0";
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, Id);
		rs = ps.executeQuery();
			while(rs.next()) {
				sum = rs.getDouble(2) + rs.getDouble(3) + rs.getDouble(4) + rs.getDouble(5) + rs.getDouble(6);
				Agv_Restaurant = (rs.getDouble(2)/sum) * 100;
				Agv_Cafe = (rs.getDouble(3)/sum) * 100;
				Agv_Alcohol = (rs.getDouble(4)/sum) * 100;
				Agv_Place = (rs.getDouble(5)/sum) * 100;
				Agv_Save= (rs.getDouble(6)/sum) * 100;
				/*System.out.println("Id : " + rs.getString(1) + "Alone : " + Agv_Alone + "Friend : " + Agv_Friend + "Couple : " + Agv_Couple + "DiningTogether : " + Agv_DiningTogether + "Business : " + Agv_Business + "Family : " + Agv_Family);*/
				if(Agv_Restaurant >= 20) {
					SaveResult += ",1";
				}
				if(Agv_Cafe >= 20) {
					SaveResult += ",2";
				}
				if(Agv_Alcohol >= 20) {
					SaveResult += ",3";
				}
				if(Agv_Place >= 20) {
					SaveResult += ",4";
				}
				if(Agv_Save >= 20) {
					SaveResult += ",5";
				}
				SaveResult += "/" + rs.getString(1);
			}
			return SaveResult;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return SaveResult;
	}
}
