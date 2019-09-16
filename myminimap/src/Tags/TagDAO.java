package Tags;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TagDAO {
	
	public static void TagInsert(double SEQ_Post, double SEQ_User, String Id, String Tag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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

}
