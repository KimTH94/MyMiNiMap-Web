package bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PlacesDAO {
	public static JSONArray getData4 (String User_SEQ) throws Exception{
		  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		  String a_id = "minimapdb";
		  String a_pw = "alslaoq94";
		  System.out.println(User_SEQ);
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select Users.Nickname, Comment from Comments inner join Users on Users.SEQ_User = Comments.SEQ_User where SEQ_Post = ?";
	      ArrayList<String> timeline = new ArrayList<String>();
	      ArrayList<String> timelineset = new ArrayList<String>();
//	      ArrayList<String> timelinedata = new ArrayList<String>();
	      JSONObject jobjt1 = new JSONObject();
	      
	      JSONArray jarryt1 = new JSONArray();
	      JSONArray jarryt2 = new JSONArray();
	      JSONObject finaljsonobj = new JSONObject();
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  ps.setString(1, User_SEQ);
	    	  rs = ps.executeQuery();
	      while(rs.next()) {
		      ArrayList<String> timelinedata = new ArrayList<String>();
	    	  timelinedata.add(rs.getString(1));
	    	  timelinedata.add(rs.getString(2));
	    	  jarryt1.put(timelinedata);
	    	 }

	      
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return jarryt1;
	      
	}
	
	public static ArrayList<String> getData3 (String User_SEQ) throws Exception{
		  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		  String a_id = "minimapdb";
		  String a_pw = "alslaoq94";
		  System.out.println(User_SEQ);
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select count(*) from Likes where SEQ_Post = ?";
	      ArrayList<String> timeline = new ArrayList<String>();
	      ArrayList<String> timelineset = new ArrayList<String>();
	      ArrayList<String> timelinedata = new ArrayList<String>();
	      JSONObject jobjt1 = new JSONObject();
	      
	      JSONArray jarryt1 = new JSONArray();
	      JSONArray jarryt2 = new JSONArray();
	      JSONObject finaljsonobj = new JSONObject();
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  ps.setString(1, User_SEQ);
	    	  rs = ps.executeQuery();
	      while(rs.next()) {
	    	  timelinedata.add(rs.getString(1));

	    	 }

	      
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return timelinedata;
	      
	}
	public static ArrayList<String> getData2 (String User_SEQ) throws Exception{
		  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		  String a_id = "minimapdb";
		  String a_pw = "alslaoq94";
		  System.out.println(User_SEQ);
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select Users.Nickname, Restaurants.Name, Update_PostDay from Posts inner join Users on Posts.SEQ_User = Users.SEQ_User inner join Restaurants on Restaurants.Id = Posts.Id where SEQ_Post = ?";
	      ArrayList<String> timeline = new ArrayList<String>();
	      ArrayList<String> timelineset = new ArrayList<String>();
	      ArrayList<String> timelinedata = new ArrayList<String>();
	      JSONObject jobjt1 = new JSONObject();
	      
	      JSONArray jarryt1 = new JSONArray();
	      JSONArray jarryt2 = new JSONArray();
	      JSONObject finaljsonobj = new JSONObject();
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  ps.setString(1, User_SEQ);
	    	  rs = ps.executeQuery();
	      while(rs.next()) {
	    	  timelinedata.add(rs.getString(1));
	    	  timelinedata.add(rs.getString(2));
	    	  timelinedata.add(rs.getString(3));
	    	 }

	      
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return timelinedata;
	      
	}
	
	public static ArrayList<String> getData1 (int User_SEQ) throws Exception{
		  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		  String a_id = "minimapdb";
		  String a_pw = "alslaoq94";
		  System.out.println(User_SEQ);
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select SEQ_Post, Name, Address, SaveType, FoodType, Colleague, Price, Update_PostDay FROM Restaurants inner join Posts on Restaurants.Id = Posts.Id inner join Followers on Followers.Follower_SEQ = Posts.SEQ_User where User_SEQ = ? order by SEQ_Post desc";
	      ArrayList<String> timeline = new ArrayList<String>();
	      ArrayList<String> timelineset = new ArrayList<String>();
	      ArrayList<String> timelinedata = new ArrayList<String>();
	      JSONObject jobjt1 = new JSONObject();
	      
	      JSONArray jarryt1 = new JSONArray();
	      JSONArray jarryt2 = new JSONArray();
	      JSONObject finaljsonobj = new JSONObject();
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  ps.setInt(1, User_SEQ);
	    	  rs = ps.executeQuery();
	      while(rs.next()) {
	    	  timelinedata.add(rs.getString(1));
	    	 }

	      
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return timelinedata;
	      
	}
	
	public static ArrayList<String> timeline_seqpost (int User_SEQ) throws Exception{
	  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
	  String a_id = "minimapdb";
	  String a_pw = "alslaoq94";
	  System.out.println(User_SEQ);
	  Class.forName("com.mysql.jdbc.Driver");
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    con = DriverManager.getConnection(a_url, a_id, a_pw);
    String sql = "select Lat, Lng, Name, Address, Restaurants.Id, SaveType, FoodType, Colleague, Price FROM Restaurants inner join Posts on Restaurants.Id = Posts.Id inner join Followers on Followers.Follower_SEQ = Posts.SEQ_User where User_SEQ = ? order by SEQ_Post desc";
    ArrayList<String> timeline = new ArrayList<String>();
    String[][] strArr = new String[][] {{}};
    ArrayList<String> timelinedata = new ArrayList<String>();
    JSONObject test1 = new JSONObject();
    try {
  	  ps = con.prepareStatement(sql);
  	  ps.setInt(1, User_SEQ);
  	  rs = ps.executeQuery();
    while(rs.next()) {
  	  rs.getString((1));
  	  timeline.add(rs.getString(1));
  	  timeline.add(rs.getString(2));
  	  timeline.add(rs.getString(3));
  	  timeline.add(rs.getString(4));
  	  timeline.add(rs.getString(5));
  	  timeline.add(rs.getString(6));
  	  timeline.add(rs.getString(7));
  	  timeline.add(rs.getString(8));
  	  
    }
    
    } catch (Exception e) {
  	  e.printStackTrace();
    }
    return timeline;
    
}

	
	public static ArrayList<String> notjsontest(int User_SEQ) throws Exception{
		  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		  String a_id = "minimapdb";
		  String a_pw = "alslaoq94";
		  System.out.println(User_SEQ);
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select SEQ_Post,Lat, Lng, Name, Address, Restaurants.Id, SaveType, FoodType, Colleague, Prices FROM Restaurants inner join Posts on Restaurants.Id = Posts.Id inner join Followers on Followers.Follower_SEQ = Posts.SEQ_User where User_SEQ = ? order by SEQ_Post desc";
	      ArrayList<String> list = new ArrayList<String>();
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  ps.setInt(1, User_SEQ);
	    	  rs = ps.executeQuery();
	      while(rs.next()) {
	    	  rs.getString((1));
	    	  System.out.println(rs.getString((1)));

	    	  list.add(rs.getString(1));
	      }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return list;
	      
	}
	
	public static JSONArray followingtimeline(int User_SEQ) throws Exception{
		  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		  String a_id = "minimapdb";
		  String a_pw = "alslaoq94";
		  System.out.println(User_SEQ);
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select SEQ_Post, Name, Address, SaveType, FoodType, Colleague, Price, Update_PostDay FROM Restaurants inner join Posts on Restaurants.Id = Posts.Id inner join Followers on Followers.Follower_SEQ = Posts.SEQ_User where User_SEQ = ? order by SEQ_Post desc";
	      ArrayList<String> timeline = new ArrayList<String>();
	      ArrayList<String> timelineset = new ArrayList<String>();
	      ArrayList<String> timelinedata = new ArrayList<String>();
	      JSONObject jobjt1 = new JSONObject();
	      
	      JSONArray jarryt1 = new JSONArray();
	      JSONArray jarryt2 = new JSONArray();
	      JSONObject finaljsonobj = new JSONObject();
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  ps.setInt(1, User_SEQ);
	    	  rs = ps.executeQuery();
	      while(rs.next()) {
	    	  JSONArray jarryt3 = new JSONArray();
	    	  jarryt3.put(rs.getString(1));
	    	  jarryt3.put(rs.getString(2));
	    	  jarryt3.put(rs.getString(3));
	    	  jarryt3.put(rs.getString(4));
	    	  jarryt3.put(rs.getString(5));
	    	  jarryt3.put(rs.getString(6));
	    	  jarryt3.put(rs.getString(7));
	    	  jarryt3.put(rs.getString(8));
	    	  jarryt1.put(jarryt3);
	    	 }

	      
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return jarryt1;
	      
	}
	
	public ArrayList<String> getFollowers(int SEQ_User) throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select JSON_ARRAY(group_concat(Follower_SEQ)) FROM Followers where User_SEQ = ?";
		   ArrayList<String> list = new ArrayList<String>();
		   try {
		   PreparedStatement ps = con.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   ps.setInt(1, SEQ_User);
		   while(rs.next()) {
			   list.add(rs.getString(1));
		   }
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   return list;
	}
	
	public static ArrayList<String> Timeline(String SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;

		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Id from Posts where SEQ_User = ? order by Update_PostDay desc";
		ArrayList<String> list = new ArrayList<String>();
	    try {
			   PreparedStatement ps = con.prepareStatement(sql);
			   ps.setString(1, SEQ_User);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   list.add(rs.getString(1));
				   
		          }
		         return list;
			   }catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public static ArrayList<PlacesDTO> getTagIndiv(String PlaceId, String SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select tag from Tags where PlaceId = ? and SEQ_User = ?";
	    ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	    PlacesDTO placesDTO = null;
		try {
			ps = con.prepareStatement(sql);
	         ps.setString(1, PlaceId);
	         ps.setString(2, SEQ_User);
	         rs = ps.executeQuery();
			while(rs.next()) {
				placesDTO = new PlacesDTO();
				placesDTO.setTags(rs.getString(1));
	             P_info.add(placesDTO);
			}
			return P_info;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return P_info;
	}
	
	public static ArrayList<PlacesDTO> getMenuIndiv(String PlaceId, String SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Menu from RecommendMenus where PlaceId = ? and SEQ_User = ?";
	    ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	    PlacesDTO placesDTO = null;
		try {
			ps = con.prepareStatement(sql);
	         ps.setString(1, PlaceId);
	         ps.setString(2, SEQ_User);
	         rs = ps.executeQuery();
			while(rs.next()) {
				placesDTO = new PlacesDTO();
				placesDTO.setMenu(rs.getString(1));
	             P_info.add(placesDTO);
			}
			return P_info;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return P_info;
	}
	
	public static ArrayList<String> getMenu(String id) throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select Menu from RecommendMenus where PlaceId = ?";
		   ArrayList<String> list = new ArrayList<String>();

		   try {
		   PreparedStatement ps = con.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   list.add(rs.getString(1)+"\r\n");
			   
	          }
	         return list;
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   return list;
	}
	
	public static ArrayList<String> getTag1(String id) throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select Tag from Tags where PlaceId = ?";
		   ArrayList<String> list = new ArrayList<String>();

		   try {
		   PreparedStatement ps = con.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   list.add(rs.getString(1)+"\r\n");
			   
	          }
	         return list;
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   return list;
	}
	
	public static ArrayList<PlacesDTO> getTags(String id) throws Exception{ //가격
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select Tag from Tags where PlaceId = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);	    
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setTags(rs.getString(1));	
	             System.out.println("1123"+rs.getString(1));
	             P_info.add(placesDTO);	             
	          }
	         return P_info;
	         
	        
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	      
	}
	
	public static ArrayList<PlacesDTO> getRecommendMenus(String id) throws Exception{ //가격
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select Menu from RecommendMenus where PlaceId = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);	    
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setRecommendMenu(rs.getString(1));	
	             System.out.println("1123"+rs.getString(1));
	             P_info.add(placesDTO);	             
	          }
	         return P_info;
	         
	        
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	      
	}

	
	public static ArrayList<PlacesDTO> PostIndiv(String id, String SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Name, Address, Tel, SaveType, FoodType, Taste, Price, Colleague, Restaurants.Id from Restaurants inner join Posts on Posts.Id = Restaurants.Id where Posts.Id = ? and Posts.SEQ_User = ?";
	    ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	    PlacesDTO placesDTO = null;
		try {
			ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	         ps.setString(2, SEQ_User);
	         rs = ps.executeQuery();
			while(rs.next()) {
				placesDTO = new PlacesDTO();
	             placesDTO.setName(rs.getString(1));
	             placesDTO.setAddress(rs.getString(2));
	             placesDTO.settel(rs.getString(3));
	             placesDTO.setSaveType(rs.getString(4));
	             placesDTO.setFoodType(rs.getString(5));
	             placesDTO.setTaste(rs.getString(6));
	             placesDTO.setPrice(rs.getString(7));
	             placesDTO.setColleague(rs.getString(8));
	             P_info.add(placesDTO);
			}
			return P_info;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return P_info;
	}
	
	public ArrayList<String> getPoster() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select JSON_ARRAY(Id, group_concat(distinct(Nickname))) from Posts inner join Users on Posts.SEQ_User = Users.SEQ_User group by Id";
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
//	public static String testPoster(String id) throws Exception {
//		Class.forName("com.mysql.jdbc.Driver");
//		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
//		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
//		   String sql = "select distinct(Nickname) from Posts inner join Users on Posts.SEQ_User = Users.SEQ_User where Posts.id = ?";
//		   String list = null;
//
//		   try {
//		   PreparedStatement ps = con.prepareStatement(sql);
//		   ps.setString(1, id);
//		   ResultSet rs = ps.executeQuery();
//		   while(rs.next()) {
//			   list.add(rs.getString(1));			   
//	          }
//	         return list;
//		   }catch (Exception e) {
//			e.printStackTrace();
//		}
//		   return list;
//	}
	
	public static ArrayList<String> getPoster1(String id) throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select distinct(Nickname) from Posts inner join Users on Posts.SEQ_User = Users.SEQ_User where Posts.id = ?";
		   ArrayList<String> list = new ArrayList<String>();

		   try {
		   PreparedStatement ps = con.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   list.add(rs.getString(1)+"\r\n");
			   
	          }
	         return list;
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   return list;
	}
	public ArrayList<String> followerpin(String User_SEQ) throws Exception{
		  String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		  String a_id = "minimapdb";
		  String a_pw = "alslaoq94";
		  System.out.println(User_SEQ);
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select JSON_ARRAY(Lat, Lng, Name, Address, Restaurants.Id) FROM Restaurants inner join Posts on Restaurants.Id = Posts.Id inner join Followers on Followers.Follower_SEQ = Posts.SEQ_User where User_SEQ = ?";
	      ArrayList<String> list = new ArrayList<String>();
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  ps.setString(1, User_SEQ);
	    	  rs = ps.executeQuery();
	      while(rs.next()) {
	    	  rs.getString((1));
	    	  System.out.println(rs.getString((1)));

	    	  list.add(rs.getString(1));
	      }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return list;
	      
	}
	
	public static ArrayList<PlacesDTO> UseID6(String id) throws Exception{ //가격
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select group_concat(Price) from Posts where id = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	      
	         
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setPrice(rs.getString(1));

	  
	             P_info.add(placesDTO);
	             
	          }
	         return P_info;
	         
	         
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	      
	}
	
	public static ArrayList<PlacesDTO> UseID5(String id) throws Exception{ //평가
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select group_concat(Taste) from Posts where id = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setTaste(rs.getString(1));
	             P_info.add(placesDTO);
	          }
	         return P_info;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	}

	public static ArrayList<PlacesDTO> UseID4(String id) throws Exception{ //종류2
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select group_concat(FoodType) from Posts where id = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setFoodType(rs.getString(1));
	             P_info.add(placesDTO);
	          }
	         return P_info;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	}
	public static ArrayList<PlacesDTO> UseID3(String id) throws Exception{
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select group_concat(SaveType) from Posts where id = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setSaveType(rs.getString(1));
	             P_info.add(placesDTO);
	          }
	         return P_info;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	}


	
	public static ArrayList<PlacesDTO> UseID2(String id) throws Exception{
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select group_concat(Colleague) from Posts where id = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setColleague(rs.getString(1));
	             P_info.add(placesDTO);
	          }
	         return P_info;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	}
	public static ArrayList<PlacesDTO> UseID(String id) throws Exception{
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");

	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select Name, Address, Tel, SaveType, FoodType, Taste, Price, Colleague, Restaurants.Id from Restaurants inner join Posts on Posts.Id = Restaurants.Id where Posts.Id = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;
	      String pType1 = null;
	      String pType2 = null;
	      String pPrice = null;
	      String pColleague = null;
	      String pTaste = null;
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             //변수
	             
	             if(rs.getString(4).equals("1")) {
	            	 System.out.println("맛집");
	            	 pType1 = "맛집";
	             } else if(rs.getString(4).equals("2")) {
	            	 System.out.println("맛집");
	            	 pType1 = "술집";
	             } else if(rs.getString(4).equals("3")) {
	            	 System.out.println("맛집");
	            	 pType1 = "기타";
	             } else if(rs.getString(4).equals("4")) {
	            	 System.out.println("맛집");
	            	 pType1 = "저장";
	             }
	             
	             if(rs.getString(5).equals("1")) {
	            	 System.out.println("맛집");
	            	 pType2 = "한식";
	             } else if(rs.getString(5).equals("2")) {
	            	 System.out.println("맛집");
	            	 pType2 = "중식";
	             } else if(rs.getString(5).equals("3")) {
	            	 System.out.println("맛집");
	            	 pType2 = "일식";
	             } else if(rs.getString(5).equals("4")) {
	            	 System.out.println("맛집");
	            	 pType2 = "양식";
	             } else if(rs.getString(5).equals("5")) {
	            	 System.out.println("맛집");
	            	 pType2 = "동남아";
	             } else if(rs.getString(5).equals("6")) {
	            	 System.out.println("맛집");
	            	 pType2 = "야식";
	             } else if(rs.getString(5).equals("7")) {
	            	 System.out.println("맛집");
	            	 pType2 = "분식";
	             }
	             
	             /*
	             if(rs.getString(8).equals("1")) {
	            	 System.out.println("맛집");
	            	 pColleague = "혼자";
	             } else if(rs.getString(8).equals("2")) {
	            	 System.out.println("맛집");
	            	 pColleague = "친구";
	             } else if(rs.getString(8).equals("3")) {
	            	 System.out.println("맛집");
	            	 pColleague = "연인";
	             } else if(rs.getString(8).equals("4")) {
	            	 System.out.println("맛집");
	            	 pColleague = "회식";
	             } else if(rs.getString(8).equals("5")) {
	            	 System.out.println("맛집");
	            	 pColleague = "비지니스";
	             } else if(rs.getString(8).equals("6")) {
	            	 System.out.println("맛집");
	            	 pColleague = "가족";
	             } 
	             
	             */
	             if(rs.getString(6).equals("1")) {//평가
	            	 System.out.println("맛집");
	            	 pTaste = "가고 싶지 않아요.";
	             } else if(rs.getString(6).equals("2")) {
	            	 System.out.println("맛집");
	            	 pTaste = "가볼만 했어요.";
	             } else if(rs.getString(6).equals("3")) {
	            	 System.out.println("맛집");
	            	 pTaste = "추천 할 만해요.";
	             } else if(rs.getString(6).equals("4")) {
	            	 System.out.println("맛집");
	            	 pTaste = "또 가고싶어요.";
	             } 
	             if(rs.getString(7).equals("1")) {//평가
	            	 System.out.println("맛집");
	            	 pPrice = "1만원대";
	             } else if(rs.getString(7).equals("2")) {
	            	 System.out.println("맛집");
	            	 pPrice = "3만원대";
	             } else if(rs.getString(7).equals("3")) {
	            	 System.out.println("맛집");
	            	 pPrice = "5만원대";
	             } else if(rs.getString(7).equals("4")) {
	            	 System.out.println("맛집");
	            	 pPrice = "7만원대";
	             } else if(rs.getString(7).equals("5")) {
	            	 System.out.println("맛집");
	            	 pPrice = "10만원대";
	             } 

	             pColleague = rs.getString(8);
	             pColleague = pColleague.replaceAll(",", " ");
	             pColleague = pColleague.replaceAll("1", "혼자");
	             pColleague = pColleague.replaceAll("2", "친구");
	             pColleague = pColleague.replaceAll("3", "연인");
	             pColleague = pColleague.replaceAll("4", "회식");
	             pColleague = pColleague.replaceAll("5", "비지니스");
	             pColleague = pColleague.replaceAll("6", "가족");
	             
	             placesDTO.setName(rs.getString(1));
	             placesDTO.setAddress(rs.getString(2));
	             placesDTO.settel(rs.getString(3));
	             placesDTO.setSaveType(pType1);
	             placesDTO.setFoodType(pType2);
	             placesDTO.setTaste(pTaste);
	             placesDTO.setColleague(pColleague);
	             placesDTO.setPrice(pPrice);
	             P_info.add(placesDTO);
	          }
	         return P_info;
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return P_info;
	}

	public int insert(PlacesDTO placesDTO, int SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Posts(Lat, Lng, Name, Address, Tel, Taste, Price, SEQ_User, Id, Update_PostDay) values (?,?,?,?,?,?,?,?,?,now())";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, placesDTO.getLat());
	    ps.setString(2, placesDTO.getLng());
		ps.setString(3, placesDTO.getName());
		ps.setString(4, placesDTO.getAddress());
		ps.setString(5, placesDTO.getTel());
	    ps.setString(6, placesDTO.getTaste());
		ps.setString(7, placesDTO.getPrice());
		ps.setInt(8, SEQ_User);
		ps.setString(9, placesDTO.getId());
		int result = ps.executeUpdate();
		return result;
	}
 
	public ArrayList<String> get1(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
	   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
	   String sql = "select JSON_ARRAY(Lat, Lng, Name, Address, Tel, SEQ_User, SaveType, FoodType, Taste, Price, Colleague, Restaurants.Id) from Restaurants inner join Posts on Posts.Id = Restaurants.Id where Posts.SEQ_User = ?";
	   ArrayList<String> list = new ArrayList<String>();
	   try {
	   PreparedStatement ps = con.prepareStatement(sql);
	   ps.setInt(1, SEQ_User);
	   ResultSet rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   return list;
 }
	
	public ArrayList<String> getId() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
		   String sql = "select JSON_ARRAY(Id) FROM Posts";
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
	
	public ArrayList<PlacesDTO> getId1() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
		   String sql = "select Id from Posts";
		   ArrayList<PlacesDTO> list = new ArrayList<PlacesDTO>();
		   PlacesDTO placesDTO = null;
		   try {
		   PreparedStatement ps = con.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
	             placesDTO = new PlacesDTO();
	             placesDTO.setId(rs.getString(1));
	             list.add(placesDTO);
	          }
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   return list;
	 }
	
	public ArrayList<String> get2() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select JSON_ARRAY(Lat, Lng, Name, Address, Posts.Id) FROM Posts inner join Restaurants on Restaurants.Id = Posts.Id";
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
	
	public static String getF() throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		   Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		   String sql = "select distinct Menu FROM RecommendMenus";
		   ArrayList<String> list = new ArrayList<String>();
		   String menu = "0,";
		   String Rmenu = null;
		   try {
		   PreparedStatement ps = con.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   list.add(rs.getString(1));
		   }
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   for(int i = 0 ; i < list.size(); i++) {
			   menu += "\"" + list.get(i) + "\"" + ",";
		   }
		   Rmenu = "[" + menu + "]";
		   return Rmenu;
	 } 
}
