package Like;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDAO {
	
	/*public static void RestuarantLikeDelete(String Id) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "update Restaurants set TotalLike = TotalLike - 1 where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
		    ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	public static void RestuarantLikeUp(String Id) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "update Restaurants set TotalLike = TotalLike + 1 where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps. executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	
	public static String getRestuarantId(double SEQ_Post, double SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Id = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Restaurants.Id from Restaurants inner join Posts on Posts.Id = Restaurants.Id where Posts.SEQ_Post = ? and Posts.SEQ_User = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			ps.setDouble(2, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				Id = rs.getString(1);
			}
			return Id;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return Id;
	}*/
	
	public static void LikeUp(double SEQ_User, double Post_owner,double SEQ_Post) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "insert into Likes(SEQ_Post, SEQ_User, Post_owner, Like_DAY) values(?,?,?,now())";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			ps.setDouble(2, SEQ_User);
			ps.setDouble(3, Post_owner);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	public static void LikeDelete(double SEQ_User, double Post_owner,double SEQ_Post) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "delete from Likes where SEQ_User = ? and SEQ_Post = ? and Post_owner = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_User);
			ps.setDouble(2, SEQ_Post);
			ps.setDouble(3, Post_owner);
		    ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	public static int CountLike(double SEQ_Post, double Post_owner) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select count(*) from Likes where SEQ_Post = ? and Post_owner = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			ps.setDouble(2, Post_owner);
			rs = ps.executeQuery();
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return count;
	}
	
	public int ModalCountLike(double SEQ_Post, double Post_owner) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select count(*) from Likes where SEQ_Post = ? and Post_owner = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			ps.setDouble(2, Post_owner);
			rs = ps.executeQuery();
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return count;
	}
	
	public boolean LikeState(double SEQ_Post, double Post_owner, double SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		boolean state = false;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select count(*) from Likes where SEQ_Post = ? and Post_owner = ? and SEQ_User = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			ps.setDouble(2, Post_owner);
			ps.setDouble(3, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			if(count > 0) {
				state = true;
			}else {
				state = false;
			}
			return state;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return state;
	}
}
