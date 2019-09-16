package RecommendMenus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RecommendMenusDAO {
	
	public static void MenuInsert(double SEQ_Post, double SEQ_User, String Id, String Menu) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		con = DriverManager.getConnection(url,"minimapdb", "alslaoq94");
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
}
