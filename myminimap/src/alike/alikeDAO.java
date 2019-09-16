package alike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class alikeDAO {
	private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private Connection con = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   String returns = "";
	   String returns2 = "";
	   
		public ArrayList<String> getSEQ_User1(double SEQ_User) throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	        String sql = "select SEQ_User from Likes where Post_owner = ? order by Like_DAY";
	        pstmt = con.prepareStatement(sql);
	        ArrayList<String> list = new ArrayList<>();
	        try {
	        	pstmt = con.prepareStatement(sql);
	        	pstmt.setDouble(1, SEQ_User);
				   rs = pstmt.executeQuery();
			   while(rs.next()) {
				   list.add(rs.getString(1));
			   	}
			   return list;
			   }catch (Exception e) {
				e.printStackTrace();
			}
	        
	        finally {
	            try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	            try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	            try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
	        }
			return null;
	    }
		public ArrayList<String> getSEQ_Post(double SEQ_User) throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	        String sql = "select SEQ_Post from Likes where Post_owner = ? order by Like_DAY";
	        pstmt = con.prepareStatement(sql);
	        ArrayList<String> list = new ArrayList<>();
	        try {
	        	pstmt = con.prepareStatement(sql);
	        	pstmt.setDouble(1, SEQ_User);
				   rs = pstmt.executeQuery();
			   while(rs.next()) {
				   list.add(rs.getString(1));
			   	}
			   return list;
			   }catch (Exception e) {
				e.printStackTrace();
			}
	        
	        finally {
	            try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	            try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	            try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
	        }
			return null;
	    }
		public ArrayList<String> getLike_DAY(double SEQ_User) throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	        String sql = "select Like_DAY from Likes where Post_owner = ? order by Like_DAY";
	        pstmt = con.prepareStatement(sql);
	        ArrayList<String> list = new ArrayList<>();
	        try {
	        	pstmt = con.prepareStatement(sql);
	        	pstmt.setDouble(1, SEQ_User);
				   rs = pstmt.executeQuery();
			   while(rs.next()) {
				   list.add(rs.getString(1));
			   	}
			   return list;
			   }catch (Exception e) {
				e.printStackTrace();
			}
	        
	        finally {
	            try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
	            try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
	            try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
	        }
			return null;
	    }
}
