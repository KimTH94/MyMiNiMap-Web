package bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemDAO {
	
	public static ArrayList<String> followings(int SEQ_User) throws Exception{ //가격
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select Follower_SEQ from Followers where User_SEQ = ?";
	      ArrayList<String> followinglist = new ArrayList<String>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, SEQ_User);
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             followinglist.add(rs.getString(1));
     
	          }
	         return followinglist;
	         
	         
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	         try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      System.out.println(followinglist);
	      System.out.println("123");
	      return followinglist;
	      
	}
	public boolean test_Following_State(int user_SEQ, int my_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		boolean result = false;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select distinct Nickname, Name from Users inner join Posts on Posts.SEQ_User = Users.SEQ_User where Id = ChIJFRmIDRGjfDUR2nv7h8qMx2Y";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, my_SEQ);
			ps.setInt(2, user_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
			count = rs.getInt(1);
			}
			if(count > 0 ) {
				result = true;
			}else {
				result = false;
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public static ArrayList<PlacesDTO> Poster(String id) throws Exception{ //가격
		String a_url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String a_id = "minimapdb";
		String a_pw = "alslaoq94";

		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      con = DriverManager.getConnection(a_url, a_id, a_pw);
	      String sql = "select distinct Nickname, Name from Users inner join Posts on Posts.SEQ_User = Users.SEQ_User where Id = ?";
	      ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	      PlacesDTO placesDTO = null;

	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, id);
	         
	         rs = ps.executeQuery();
	         while(rs.next()) { 
	             placesDTO = new PlacesDTO();
	             placesDTO.setNickname(rs.getString(1));
	             placesDTO.setName(rs.getString(2));

	  
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
	      System.out.println(P_info);
	      System.out.println("123");
	      return P_info;
	      
	}
	
	public static ArrayList<PlacesDTO> CountPost(String Id) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Count(*) from Posts where Id = ?";
		ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	    PlacesDTO placesDTO = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
	             placesDTO = new PlacesDTO();
	             placesDTO.setCount(rs.getString(1));
	             P_info.add(placesDTO);
			}
			return P_info;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return P_info;
	}
	
	public static ArrayList<PlacesDTO> CountPoster(String Id) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Count(DISTINCT SEQ_User) from Posts where Id = ?";
		ArrayList<PlacesDTO> P_info = new ArrayList<PlacesDTO>();
	    PlacesDTO placesDTO = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
	             placesDTO = new PlacesDTO();
	             placesDTO.setCount(rs.getString(1));
	             P_info.add(placesDTO);
			}
			return P_info;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return P_info;
	}
	
	public static void DeleteConfirmkey(String Email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Confirmkey = "인증 완료";
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "update Users set Confirmkey = ? where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Confirmkey);
			ps.setString(2, Email);
			ps.executeUpdate(); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static void GrantAuty(String Email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "update Users set Auty = 1 where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Email);
			ps.executeUpdate(); 
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public static String GetUUID(String Email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String UUID = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Confirmkey from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Email);
			rs = ps.executeQuery();
			while(rs.next()) {
				UUID = rs.getString(1);
			}
			return UUID;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return UUID;
	}

	public int PostNumber(int SEQ_User, int PostNumber) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "WITH ViewPosts as (SELECT ROW_NUMBER() OVER(ORDER BY SEQ_Post ASC) AS 'No', SEQ_Post FROM Posts where SEQ_User = ? ) select SEQ_Post from ViewPosts where No = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, SEQ_User);
			ps.setInt(2, PostNumber);
			rs = ps.executeQuery();
			while(rs.next()) {
			count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return count;
	}
	
	public int CountPost(int SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Count(DISTINCT Id) from Posts where SEQ_User = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
			count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return count;
	}
	
	public String getNickname2(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nickname = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Nickname from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				nickname = rs.getString(1);
			}
			return nickname;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return nickname;
	}
	
	public static int ChEmail(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int state = 0;
		email = email.replaceAll(" ", "");
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Email from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				state = 1;
			}else {
				state = 0;
			}
			return state;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return state;
	}
	
	public static int ChNickname(String nickname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int state = 0;
		nickname = nickname.replaceAll(" ", "");
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Nickname from Users where Nickname = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			if(rs.next()) {
				state = 1;
			}else {
				state = 0;
			}
			return state;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return state;
	}
	
	public ArrayList<MemDTO> memberInfo(String email) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Name, Birthday, Tel, Address, Nickname, Profile_Imformation, Nation, Password from Users where Email = ?";
		ArrayList<MemDTO> userList = new ArrayList<MemDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
					MemDTO memDTO = new MemDTO();
					memDTO.setName(rs.getString(1));
					memDTO.setBirthday(rs.getString(2));
					memDTO.setTel(rs.getString(3));
					memDTO.setAddress(rs.getString(4));
					memDTO.setNickname(rs.getString(5));
					memDTO.setProfile_imformation(rs.getString(6));
					memDTO.setNation(rs.getString(7));
					memDTO.setPassword(rs.getString(8));
					userList.add(memDTO);
				}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		return userList;
		}
	
	public String getProfile_imformation(String nickname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Profile_imformation = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Profile_Imformation from Users where Nickname = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			while(rs.next()) {
				Profile_imformation = rs.getString(1);
			}
			return Profile_imformation;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Profile_imformation;
	}
	
	public String getProfilePhoto(String nickname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String filename = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select FileName from Users where Nickname = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			while(rs.next()) {
				filename = rs.getString(1);
			}
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return filename;
	}
	
	public boolean Following_State(int user_SEQ, int my_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		boolean result = false;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select distinct count(*) from Followers where Follower_SEQ = ? and User_SEQ = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, my_SEQ);
			ps.setInt(2, user_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
			count = rs.getInt(1);
			}
			if(count > 0 ) {
				result = true;
			}else {
				result = false;
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public int Count_Follower(int user_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select distinct count(*) from Followers where Follower_SEQ = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
			result = rs.getInt(1);
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public int Count_Following(int user_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select distinct count(*) from Followers where User_SEQ = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
			result = rs.getInt(1);
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public ArrayList<MemDTO> Show_Following_List(int my_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Email, Nickname, FileName from Users inner join Followers on Users.SEQ_User = Followers.User_SEQ where Followers.Follower_SEQ= ?";
		MemDTO memDTO = null;
		ArrayList<MemDTO> Following_List = new ArrayList<MemDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, my_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
				memDTO = new MemDTO();
				memDTO.setName(rs.getString(1));
				memDTO.setNickname(rs.getString(2));
				memDTO.setFilename(rs.getString(3));
				Following_List.add(memDTO);
			}
			return Following_List;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Following_List;
	}
	
	public ArrayList<MemDTO> Show_Follower_List(int my_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Name, Nickname, FileName from Users inner join Followers on Users.SEQ_User = Followers.Follower_SEQ where Followers.User_SEQ= ?";
		MemDTO memDTO = null;
		ArrayList<MemDTO> Follower_List = new ArrayList<MemDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, my_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
				memDTO = new MemDTO();
				memDTO.setName(rs.getString(1));
				memDTO.setNickname(rs.getString(2));
				memDTO.setFilename(rs.getString(3));
				Follower_List.add(memDTO);
			}
			return Follower_List;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Follower_List;
	}
	
	public int following(int my_SEQ, int user_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Followers(User_SEQ, Follower_SEQ) values (?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, my_SEQ);
			ps.setInt(2, user_SEQ);
			result = ps.executeUpdate();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public void cancel_following(int my_SEQ, int user_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "delete from Followers where User_SEQ = ? and Follower_SEQ = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, my_SEQ);
			ps.setInt(2, user_SEQ);
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public int getSEQ_User(String nickname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int SEQ_User = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select SEQ_User from Users where Nickname = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			while(rs.next()) {
				SEQ_User = rs.getInt(1);
			}
			return SEQ_User;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return SEQ_User;
	}
	
	public ArrayList<MemDTO> searchUser(String name) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Nickname, Name, Filename from Users where Name like ? or Nickname LIKE ? ";
		MemDTO memDTO = null;
		ArrayList<MemDTO> userList = new ArrayList<MemDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, name);
			rs= ps.executeQuery();
			while(rs.next()) {
				memDTO = new MemDTO();
				memDTO.setNickname(rs.getString(1));
				memDTO.setName(rs.getString(2));
				memDTO.setFilename(rs.getString(3));
				userList.add(memDTO);
			}
			return userList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return userList;
	}
	
	public ArrayList<MemDTO> search(String userName) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Name, Email, Nickname from Users where Name = ?";
		ArrayList<MemDTO> userList = new ArrayList<MemDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()) {
					MemDTO memDTO = new MemDTO();
					memDTO.setName(rs.getString(1));
					memDTO.setEmail(rs.getString(2));
					memDTO.setNickname(rs.getString(3));
					userList.add(memDTO);
				}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		return userList;
		}
	
	public ArrayList<MemDTO> json() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3307/test1?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select JSON_ARRAY(Name, Address, Tel, Lat, Lng) from Posts";
		ArrayList<MemDTO> userList = new ArrayList<MemDTO>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemDTO memDTO = new MemDTO();
				memDTO.setJson(rs.getString(1) + ",");
				userList.add(memDTO);
				}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		return userList;
		}

	
	public int login(String email, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Password from Users where Email = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			if (rs.getString(1).equals(password))
					return 1;
				 else
					return 0;
		}
		return -2;
	}

	public String getNickname(MemDTO memDTO) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nickname = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Nickname from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memDTO.getEmail());
			rs = ps.executeQuery();
			while(rs.next()) {
				nickname = rs.getString(1);
			}
			return nickname;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return nickname;
	}
	
	public int getSEQ_User(MemDTO memDTO) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int SEQ_User = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select SEQ_User from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memDTO.getEmail());
			rs = ps.executeQuery();
			while(rs.next()) {
				SEQ_User = rs.getInt(1);
			}
			return SEQ_User;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return SEQ_User;
	}
	
	public int getSEQ_UserByEmail(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int SEQ_User = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select SEQ_User from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				SEQ_User = rs.getInt(1);
			}
			return SEQ_User;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return SEQ_User;
	}
	
	public String get(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Profile_imformation = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Profile_Imformation from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				Profile_imformation = rs.getString(1);
			}
			return Profile_imformation;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Profile_imformation;
	}
	
	public String getProfilePhotoName(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String filename = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Filename from Users where Email = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				filename = rs.getString(1);
			}
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return filename;
	}
	
	public int SaveProfilePhoto(String email, String filename) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		int result;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "update Users set Filename = ? where Email =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, filename);
			ps.setString(2, email);
			result = ps.executeUpdate(); 
			return result; 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return -1;
	}
	

	public void update(MemDTO memDTO) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		String profile_imformation = memDTO.getProfile_imformation();
		profile_imformation = profile_imformation.replace("\r\n","<br>");
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "update Users set Name = ?, Nickname = ?, Password = ?, Birthday = ?, Address = ?, Nation = ?, Tel = ?, Profile_Imformation = ? where Email = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memDTO.getName());
		ps.setString(2, memDTO.getNickname());
		ps.setString(3, memDTO.getPassword());
		ps.setString(4, memDTO.getBirthday());
		ps.setString(5, memDTO.getAddress());
		ps.setString(6, memDTO.getNation());
		ps.setString(7, memDTO.getTel());
		/*ps.setString(8, memDTO.getProfile_imformation());*/
		ps.setString(8, profile_imformation);
		ps.setString(9, memDTO.getEmail());
		ps.executeUpdate();
	}
	
	public int insert(MemDTO memDTO) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		UUID key = UUID.randomUUID();
		String UUID = key.toString();
		String sql = "insert into Users(Email, Name, Nickname ,Password, Confirmkey) values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memDTO.getEmail());
		ps.setString(2, memDTO.getName());
		ps.setString(3, memDTO.getNickname());
		ps.setString(4, memDTO.getPassword());
		ps.setString(5, UUID);
		int result = ps.executeUpdate();
		return result;
	}

	public String getUserEmail(String email) {
		String SQL = "select Email from Users where Email=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
			con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int checkPw(MemDTO memDTO, String email, String pw) {
		String SQL = "select Password from Users where Email = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpw;
		int x = -1;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
			con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, memDTO.getEmail());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpw = rs.getString(memDTO.getPassword());
				if (dbpw.equals(pw)) {
					x = 1;
				} else {
					x = 0;
				}
			}
			return x;
		} catch (Exception sqle) {
			try {
				con.rollback(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} 

	public int deleteMember(String email, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpw = ""; 
		int x = -1;

		try {
			StringBuffer query1 = new StringBuffer();
			query1.append("select Password from Users where email = ?");

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query1.toString());
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpw = rs.getString("password");
				if (dbpw.equals(pw)) 
				{
					x = 1; 
				} else {
					x = 0; 
				}
			}
			return x;

		} catch (Exception sqle) {
			try {
				conn.rollback(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
