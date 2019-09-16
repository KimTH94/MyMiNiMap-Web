package acomment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class acommentDAO {
	private String jdbcUrl = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC"; // MySQL ���� "jdbc:mysql://localhost:3306/DB�̸�"
	   private String dbId = "minimapdb"; // MySQL ���� "������ ��� root"
	   private String dbPw = "alslaoq94"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	   private Connection con = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;
	   private String sql = "";
	   String returns = "";
	   String returns2 = "";
	public void insert(double SEQ_Post, double SEQ_User, double SEQ_Owner, String Comment) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "INSERT INTO Comments(SEQ_Post, SEQ_User, SEQ_Owner, Comment, Comment_DAY) VALUES(?,?,?,?,now())";
        pstmt = con.prepareStatement(sql);
        try {
        	pstmt = con.prepareStatement(sql);
        	pstmt.setDouble(1, SEQ_Post);
        	pstmt.setDouble(2, SEQ_User);
        	pstmt.setDouble(3, SEQ_Owner);
        	pstmt.setString(4, Comment);
        	pstmt. executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
            try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
        }
    }
	public void recommentinsert(double SEQ_Post, double SEQ_User, double SEQ_Owner, String Comment,int Parent) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "INSERT INTO Comments(SEQ_Post, SEQ_User, SEQ_Owner, Comment, Comment_DAY,Parent) VALUES(?,?,?,?,now(),?)";
        pstmt = con.prepareStatement(sql);
        try {
        	pstmt = con.prepareStatement(sql);
        	pstmt.setDouble(1, SEQ_Post);
        	pstmt.setDouble(2, SEQ_User);
        	pstmt.setDouble(3, SEQ_Owner);
        	pstmt.setString(4, Comment);
        	pstmt.setInt(5, Parent);
        	pstmt. executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
            try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
        }
    }
	
	public ArrayList<String> getComment(double SEQ_Post) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "select Comment,Comment_DAY from Comments where SEQ_Post = ? and Parent is null order by Comment_DAY";
        pstmt = con.prepareStatement(sql);
        ArrayList<String> list = new ArrayList<>();
        try {
        	pstmt = con.prepareStatement(sql);
        	pstmt.setDouble(1, SEQ_Post);
			   rs = pstmt.executeQuery();
		   while(rs.next()) {
			   String a = rs.getString(1);
			   String b= rs.getString(2);
			   if(a.equals(""))
				   list.add(" "+"@/@"+b);
			   else 
				   list.add(rs.getString(1)+"@/@"+rs.getString(2));
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
	public ArrayList<String> getreComment(int SEQ_Parent) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "select Comment,Comment_DAY from Comments where Parent=? order by Comment_DAY";
        pstmt = con.prepareStatement(sql);
        ArrayList<String> list = new ArrayList<>();
        try {
        	pstmt = con.prepareStatement(sql);
        	pstmt.setInt(1, SEQ_Parent);
			   rs = pstmt.executeQuery();
		   while(rs.next()) {
			   String a = rs.getString(1);
			   String b= rs.getString(2);
			   if(a.equals(""))
				   list.add(" "+"@/@"+b);
			   else 
				   list.add(rs.getString(1)+"@/@"+rs.getString(2));
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
	

	public ArrayList<String> getSEQ_UserbyParent(int SEQ_Parent) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "select SEQ_User from Comments where Parent = ? order by Comment_DAY";
        pstmt = con.prepareStatement(sql);
        ArrayList<String> list = new ArrayList<>();
        try {
        	pstmt = con.prepareStatement(sql);
        	pstmt.setInt(1, SEQ_Parent);
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
	
	public ArrayList<String> getSEQ_User(double SEQ_Post) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "select SEQ_User from Comments where SEQ_Post = ? order by Comment_DAY";
        pstmt = con.prepareStatement(sql);
        ArrayList<String> list = new ArrayList<>();
        try {
        	pstmt = con.prepareStatement(sql);
        	pstmt.setDouble(1, SEQ_Post);
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
        String sql = "select SEQ_Post from Comments where SEQ_Owner = ? order by Comment_DAY";
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
	
	public ArrayList<String> getSEQ_User1(double SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "select SEQ_User from Comments where SEQ_Owner = ? order by Comment_DAY";
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
	public ArrayList<String> getComment_DAY(double SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "select Comment_DAY from Comments where SEQ_Owner = ? order by Comment_DAY";
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
	public ArrayList<String> getParent(double SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        String sql = "select Parent from Comments where SEQ_Owner = ? order by Comment_DAY";
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
	
	public int getSEQ_Comment(Double SEQ_Post,Double SEQ_User, String Comment) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
	    String sql = "select SEQ_Comment from Comments where SEQ_Post = ? and SEQ_User = ? and Comment = ?";
	    pstmt = con.prepareStatement(sql);     
		int SEQ_Comment=0;
	    try {
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, SEQ_Post);
			pstmt.setDouble(2, SEQ_User);
			pstmt.setString(3, Comment);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SEQ_Comment = rs.getInt(1);
			}
			return SEQ_Comment;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(pstmt != null) pstmt.close();} catch(Exception e) {e.printStackTrace();}
			 try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return SEQ_Comment;
	}
}