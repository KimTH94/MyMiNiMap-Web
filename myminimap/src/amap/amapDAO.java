package amap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class amapDAO {

private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
private Connection conn = null;
private PreparedStatement ps = null;
private ResultSet rs = null;
private String sql = "";
String returns = "";
ArrayList<String> list;
  
	public ArrayList<String> getLat(int SEQ_User) throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		   sql = "select Lat FROM Posts where SEQ_User = ?";
		   list = new ArrayList<String>();
		   try {
			   ps = conn.prepareStatement(sql);
			   ps.setInt(1, SEQ_User);
			   rs = ps.executeQuery();
		   while(rs.next()) {
			   list.add(rs.getString(1));
		   	}
		   return list;
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	         if (ps != null)try {ps.close();} catch (SQLException ex) {}
	         if (conn != null)try {conn.close();} catch (SQLException ex) {}
	 }
		   return list;
}
	public ArrayList<String> getLng(int SEQ_User) throws Exception{
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		   sql = "select Lng FROM Posts where SEQ_User = ?";
		   list = new ArrayList<String>();
		   try {
			   ps = conn.prepareStatement(sql);
			   ps.setInt(1, SEQ_User);
			   rs = ps.executeQuery();
		   while(rs.next()) {
			   list.add(rs.getString(1));
		   	}
		   return list;
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	         if (ps != null)try {ps.close();} catch (SQLException ex) {}
	         if (conn != null)try {conn.close();} catch (SQLException ex) {}
	 }
		   return list;
}	public ArrayList<String> getName(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Name FROM Posts where SEQ_User = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, SEQ_User);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
      if (ps != null)try {ps.close();} catch (SQLException ex) {}
      if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
}	public ArrayList<String> getAddress(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Address FROM Posts where SEQ_User = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, SEQ_User);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
      if (ps != null)try {ps.close();} catch (SQLException ex) {}
      if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
}	public ArrayList<String> getTel(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select tel FROM Posts where SEQ_User = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, SEQ_User);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
      if (ps != null)try {ps.close();} catch (SQLException ex) {}
      if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
}	public ArrayList<String> getaste(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Taste FROM Posts where SEQ_User = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, SEQ_User);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
      if (ps != null)try {ps.close();} catch (SQLException ex) {}
      if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
}	

public ArrayList<String> getMood(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Mood FROM Posts where SEQ_User = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, SEQ_User);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
   if (ps != null)try {ps.close();} catch (SQLException ex) {}
   if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
}


public ArrayList<String> getPrice(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Price FROM Posts where SEQ_User = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, SEQ_User);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
      if (ps != null)try {ps.close();} catch (SQLException ex) {}
      if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
}	public ArrayList<String> getId(int SEQ_User) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Id FROM Posts where SEQ_User = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, SEQ_User);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
      if (ps != null)try {ps.close();} catch (SQLException ex) {}
      if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
	}


public int getNum(String email) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	int SEQ_User = 0;
	conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	String sql = "select SEQ_User from Users where email = ?";
	try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		while(rs.next())
		SEQ_User = rs.getInt(1);
		return SEQ_User;
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	}
	return SEQ_User;
}
public ArrayList<String> getEmail() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Email from Users";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
   if (ps != null)try {ps.close();} catch (SQLException ex) {}
   if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
}


public ArrayList<Integer> Show_Following_List(int my_SEQ) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	sql = "select Follower_SEQ from Users inner join Followers on Users.SEQ_User = Followers.User_SEQ where Followers.User_SEQ= ?";
	ArrayList<Integer> Following_List = new ArrayList<>();
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, my_SEQ);
		rs = ps.executeQuery();
		while(rs.next()) {
			Following_List.add(rs.getInt(1));
		}
		return Following_List;
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		 try {if(conn != null) conn.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
	}
	return Following_List;
}


public ArrayList<String> getLat(String Id) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Lat FROM Restaurants where Id = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, Id);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
   if (ps != null)try {ps.close();} catch (SQLException ex) {}
   if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
	}

public ArrayList<String> getLng(String Id) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Lng FROM Restaurants where Id = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, Id);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
if (ps != null)try {ps.close();} catch (SQLException ex) {}
if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
	}

public String getName(String Id) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Name FROM Restaurants where Id = ?";
	   String name ="";
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, Id);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   name = rs.getString(1);
	   	}
	   return name;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
if (ps != null)try {ps.close();} catch (SQLException ex) {}
if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return name;
	}

public String getAddress(String Id) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Address FROM Restaurants where Id = ?";
	   String address="";
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, Id);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		address = rs.getString(0);
	   }
	   return address;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
if (ps != null)try {ps.close();} catch (SQLException ex) {}
if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return address;
	}

public String getTel(String Id) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Tel FROM Restaurants where Id = ?";
	   String tel ="";
	   String a ;
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, Id);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   a = rs.getString(1);
		   if(a.length()==0)
			   tel  ="NULL";
		   else
			   tel = a;
	   	}
	   return tel;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
if (ps != null)try {ps.close();} catch (SQLException ex) {}
if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return tel;
	}


public ArrayList<String> getRecommend(String Id) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Recommend,NonRecommend FROM PriceAndRecommends where Id = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, Id);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
		   list.add(rs.getString(1));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
if (ps != null)try {ps.close();} catch (SQLException ex) {}
if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
	}

public ArrayList<String> getPrice(String Id) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	   sql = "select Price1,Price2,Price3,Price4,Price5 FROM PriceAndRecommends where Id = ?";
	   list = new ArrayList<String>();
	   try {
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, Id);
		   rs = ps.executeQuery();
	   while(rs.next()) {
		   list.add(rs.getString(1));
		   list.add(rs.getString(2));
		   list.add(rs.getString(3));
		   list.add(rs.getString(4));
		   list.add(rs.getString(5));
	   	}
	   return list;
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
if (ps != null)try {ps.close();} catch (SQLException ex) {}
if (conn != null)try {conn.close();} catch (SQLException ex) {}
}
	   return list;
	}
}
   