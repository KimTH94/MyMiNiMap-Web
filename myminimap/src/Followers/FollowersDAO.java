package Followers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FollowersDAO {
	
	public static ArrayList<String> getFollow(int User_SEQ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select id from Posts where SEQ_User = (select Follower_SEQ from Followers where User_SEQ = ?)";
		ArrayList<String> List = new ArrayList<String>();
		try {
		ps = con.prepareStatement(sql);
		ps.setInt(1, User_SEQ);
		rs = ps.executeQuery();
			while(rs.next()) {
				List.add(rs.getString(1));
			}
			/*for(int i = 0 ; i < List.size() ; i++) {
				System.out.println(List.get(i));
			}*/
			return List;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return List;
	}
}
