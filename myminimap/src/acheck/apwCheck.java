package acheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class apwCheck {

	  private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private Connection conn = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   String returns = "";

	   public String checkpw(String pwd) {
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	         sql = "select Password from Users where Password=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, pwd);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            if (rs.getString("Password").equals(pwd)) {
	               returns = "Good";// �α��� ����
	            } else {
	               returns = "Not Good"; // �α��� ����
	            }
	         }

	      } catch (Exception e) {
	    	  
	      } finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	         if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	         if (conn != null)try {conn.close();} catch (SQLException ex) {}
	      }
	      return returns;
	   }
}
