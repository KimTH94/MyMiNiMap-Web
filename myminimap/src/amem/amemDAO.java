package amem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class amemDAO {
	  private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private Connection conn = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   String returns = "";
	   String returns2 = "";
	
	
	public Double getSEQ_User(String email) {
		String SQL = "select SEQ_User from Users where Email=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public Double getSEQ_UserbyNickname(String Nickname) {
		String SQL = "select SEQ_User from Users where Nickname=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, Nickname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public int SaveProfilePhoto(String email, String filename) throws Exception {
	      Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement ps = null;
			ResultSet rs = null;
			String nickname = null;
	        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	        int result;
	      String sql = "update Users set Filename = ? where Email =?";
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, filename);
	         ps.setString(2, email);
	         result = ps.executeUpdate(); 
	         return result; 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	          try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
	          try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
	      }
	      return -1;
	   }
	
	
	public String getNickname2(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nickname = null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Nickname from Users where Email = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				nickname = rs.getString(1);
			}
			return nickname;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return nickname;
	}

	public String getNickname3(Double SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nickname = null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Nickname from Users where SEQ_User = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				nickname = rs.getString(1);
			}
			return nickname;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return nickname;
	}
	public String getProfilePhoto(String nickname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String filename = null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select fileName from Users where Nickname = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			while(rs.next()) {
				filename = rs.getString(1);
			}
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return filename;
	}
	
	public String get(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Profile_imformation = null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Profile_imformation from Users where Email = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				Profile_imformation = rs.getString(1);
			}
			return Profile_imformation;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Profile_imformation;
	}
	public Double getSEQ_Owner(Double SEQ_Post) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Double SEQ_Owner = null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select SEQ_User from Posts where SEQ_Post = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			rs = ps.executeQuery();
			while(rs.next()) {
				SEQ_Owner = rs.getDouble(1);
			}
			return SEQ_Owner;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return SEQ_Owner;
	}
	public int Count_Follower(Double user_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select distinct count(*) from Followers where Follower_SEQ = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, user_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
			result = rs.getInt(1);
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	
	public boolean Following_State(Double user_SEQ, Double my_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		boolean result = false;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select distinct count(*) from Followers where Follower_SEQ = ? and User_SEQ = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, user_SEQ);
			ps.setDouble(2, my_SEQ);
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
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	
	public String getallEmail() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Email=null;
		int count=0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Email from Users";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Email += rs.getString(1)+"/";
				count++;
			}

			Email = count+"/"+Email;
			return Email;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Email;
	}

	public String getallNick() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Nick=null;
		int count =0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Nickname from Users";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Nick += rs.getString(1)+"/";
				count++;
			}

			Nick = count+"/"+Nick;
			return Nick;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Nick;
	}

	public String getallName() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Name=null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Name from Users";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Name += rs.getString(1)+"/";
			}
			return Name;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Name;
	}
	
	public String getallNickName() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Nick = "";
		int count =0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Nickname,Name from Users";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Nick += rs.getString(1)+"    ";
				Nick += rs.getString(2)+"/";
				count++;
			}

			Nick = count+"/"+Nick;
			return Nick;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Nick;
	}
	
	public String getEmail(String Nickname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Email=null;
		int count =0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Email from Users where NickName = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Nickname);
			rs = ps.executeQuery();
			while(rs.next()) {
				Email = rs.getString(1);
			}
			return Email;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Email;
	}
	
	public int Count_pin(Double user_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select count(*) from Posts where SEQ_User = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, user_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
			result = rs.getInt(1);
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public int Follow(Double user_SEQ, Double follow_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
 	    sql = "insert into Followers (User_SEQ,Follower_SEQ) values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, user_SEQ);
			ps.setDouble(2, follow_SEQ);
			ps.executeUpdate();
			
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	public int unFollow(Double user_SEQ, Double follow_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
 	    sql = "delete from Followers where User_SEQ = ? and Follower_SEQ=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, user_SEQ);
			ps.setDouble(2, follow_SEQ);
			ps.executeUpdate();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public String getFollower_SEQ(Double User_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Follower_SEQ="";
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Follower_SEQ from Followers where User_SEQ=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1,User_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
				Follower_SEQ += rs.getString(1)+"/";
			}
			return Follower_SEQ;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Follower_SEQ;
	} 
	
	public String getPost(Double Follower_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Update_Post="", SEQ_Post="";
		int count =0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Update_PostDay,SEQ_Post from Posts where SEQ_User = ? order by Update_PostDay asc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, Follower_SEQ);
			rs = ps.executeQuery();
			while(rs.next()) {
				Update_Post += rs.getString(1)+"/"+rs.getString(2)+"/";
				count++;
			}
			return count+"/"+Update_Post;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return count+"/"+Update_Post;	
		}
	
	public String getfileImage(Double SEQ_Post) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Update_Post="";
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select distinct SEQ_Post, FileName from Attachments where SEQ_Post = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			rs = ps.executeQuery();
			while(rs.next()) {
				Update_Post = rs.getString(1);
			}
			return Update_Post;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return Update_Post;	
		}

	public int CountLike(double SEQ_Post) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select count(*) from Likes where SEQ_Post = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return count;	
		}
	
	public String getNickname1(Double SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nickname = null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select Nickname from Users where SEQ_User = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				nickname = rs.getString(1);
			}
			return nickname;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return nickname;
	}
	
	public String get_Image(Double SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nickname = "";
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select FileName from Users where SEQ_User = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				nickname = rs.getString(1);
			}
			return nickname;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return nickname;
	}
	
	
	
	public String getProfile(Double SEQ_User) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String profile = null;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select fileName from Users where SEQ_User = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				profile = rs.getString(1);
			}
			return profile;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return profile;
	}
	
	public Double getSEQ_UserbyPost(Double SEQ_Post) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Double SEQ_User =0.0;
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		String sql = "select SEQ_User from Posts where SEQ_Post = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			rs = ps.executeQuery();
			while(rs.next()) {
				SEQ_User = rs.getDouble(1);
			}
			return SEQ_User;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return SEQ_User;
	}
	
}
