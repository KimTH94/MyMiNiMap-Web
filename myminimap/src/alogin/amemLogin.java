package alogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class amemLogin {
	  private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private Connection conn = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   String returns = "";
	   String returns2 = "";

	   public String logindb(String email, String pwd) {
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	         sql = "select Email,Password from Users where Email=? and Password=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, email);
	         pstmt.setString(2, pwd);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            if (rs.getString("Email").equals(email) && rs.getString("Password").equals(pwd)) {
	               returns2 = email;// �α��� ����
	            } else {
	               returns2 = "false"; // �α��� ����
	            }
	         } else {
	            returns2 = "noId"; // ���̵� �Ǵ� ��й�ȣ ���� X
	         }

	      } catch (Exception e) {

	      } finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	         if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	         if (conn != null)try {conn.close();} catch (SQLException ex) {}
	      }
	      return returns2;
	   }
}
