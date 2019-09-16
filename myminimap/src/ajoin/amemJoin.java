package ajoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class amemJoin {
	   private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private Connection conn = null;
	   private PreparedStatement pstmt = null;
	   private PreparedStatement pstmt2 = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   private String sql2 = "";
	   String returns = "";
	   String returns2 = "";
	   public String joindb(String id, String pwd,String name , String nick) {
		      try {
		         Class.forName("com.mysql.jdbc.Driver");
		         conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		         sql = "select Email from Users where Email=?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, id);
		         rs = pstmt.executeQuery();
		         if (rs.next()) {
		            if (rs.getString("Email").equals(id)) { // �̹� ���̵� �ִ� ���
		               returns = "id";
		            }
		         }
		         sql = "select Nickname from Users where Nickname=?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, nick);
		         rs = pstmt.executeQuery();
		         if (rs.next()) {
		            if (rs.getString("Nickname").equals(nick)) { // �̹� ���̵� �ִ� ���
		               returns = "nick";
		            }
		         }
		   else { // �Է��� ���̵� ���� ���
		            sql2 = "insert into Users"
		            		+ "(Email,Password,Name,Nickname) values(?,?,?,?)";
		            pstmt2 = conn.prepareStatement(sql2);
		            pstmt2.setString(1, id);
		            pstmt2.setString(2, pwd);
		            pstmt2.setString(3, name);
		            pstmt2.setString(4, nick);
		            pstmt2.executeUpdate();
		            returns = "ok";
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
		         if (conn != null)try {conn.close();} catch (SQLException ex) {}
		         if (pstmt2 != null)try {pstmt2.close();} catch (SQLException ex) {}
		         if (rs != null)try {rs.close();} catch (SQLException ex) {}
		      }
		      return returns;
		   }
}
