package Comments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import bean.MemDTO;

public class CommentsDAO {
	
	public static int getSEQ_CommentByComments(String Comments) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int SEQ_Comment = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select SEQ_Comment from Comments where Comment like ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Comments);
			rs = ps.executeQuery();
			while(rs.next()) {
				SEQ_Comment = rs.getInt(1);
			}
			return SEQ_Comment;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return SEQ_Comment;
	}

	public static String getNicknameBySEQ_Comment(double SEQ_Comment) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Nickname = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "SELECT Nickname FROM Users INNER JOIN Comments ON Users.SEQ_User = Comments.SEQ_User WHERE Comments.SEQ_Comment = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Comment);
			rs = ps.executeQuery();
			while(rs.next()) {
				Nickname = rs.getString(1);
			}
			return Nickname;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return Nickname;
	}
	
	public void insert(double SEQ_Post, double SEQ_User, double SEQ_Owner, String Comment) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
        String sql = "INSERT INTO Comments(SEQ_Post, SEQ_User, SEQ_Owner, Comment, Comment_DAY) VALUES(?,?,?,?,now())";
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, SEQ_Post);
            ps.setDouble(2, SEQ_User);
            ps.setDouble(3, SEQ_Owner);
            ps.setString(4, Comment);
            ps. executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
            try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
        }
    }
	
	public void insert(double SEQ_Post, double SEQ_User, double SEQ_Owner, String Comment, double SEQ_Comment) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		StringTokenizer st = new StringTokenizer(Comment,"@");
		if(st.countTokens() <= 0) {
			String sql = "insert into Comments(SEQ_Post, SEQ_User, SEQ_Owner, Comment, Comment_DAY) values(?,?,?,?,now())";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Post);
			ps.setDouble(2, SEQ_User);
			ps.setDouble(3, SEQ_Owner);
			ps.setString(4, Comment);
			ps. executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			}finally {
				try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
				try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
				try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			}
		}else if(st.countTokens() > 0){
			String sql = "insert into Comments(SEQ_Post, SEQ_User, SEQ_Owner, Comment, Comment_DAY, Parent) values(?,?,?,?,now(),?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setDouble(1, SEQ_Post);
				ps.setDouble(2, SEQ_User);
				ps.setDouble(3, SEQ_Owner);
				ps.setString(4, Comment);
				ps.setDouble(5, SEQ_Comment);
				ps. executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
				try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
				try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			}
		}
	}
	
	public ArrayList<CommentsDTO> PrintComments(double SEQ_Post, double SEQ_Owner) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "SELECT fileName, Nickname, Comment, SEQ_Comment, Parent FROM Users INNER JOIN Comments ON Users.SEQ_User = Comments.SEQ_User WHERE Comments.SEQ_Owner = ? and Comments.SEQ_Post = ?";
		ArrayList<CommentsDTO> Comments = new ArrayList<CommentsDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Owner);
			ps.setDouble(2, SEQ_Post);
			rs = ps.executeQuery();
			while(rs.next()) {
				CommentsDTO commentsDTO = new CommentsDTO();
				commentsDTO.setFileName(rs.getString(1));
				commentsDTO.setNickname(rs.getString(2));
				commentsDTO.setComment(rs.getString(3));
				commentsDTO.setSEQ_Comment(rs.getInt(4));
				commentsDTO.setParent(rs.getInt(5));
				StringTokenizer st = new StringTokenizer(rs.getString(3),"@",true);
				if(st.countTokens() < 2) {
					Comments.add(commentsDTO);
					}
				}
			return Comments;
			}
			catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
				try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
				try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			}
		return Comments;
		}
	
	public int HaveRecomment(double SEQ_Comment) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "SELECT * FROM Comments WHERE Parent = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Comment);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = 1; 
				}
			return result;
			}
			catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
				try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
				try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			}
		return result;
		}
	
	public ArrayList<CommentsDTO> PrintReComments(double SEQ_Post, double SEQ_Owner, double Parent) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "SELECT fileName, Nickname, Comment, SEQ_Comment FROM Users INNER JOIN Comments ON Users.SEQ_User = Comments.SEQ_User WHERE Comments.SEQ_Owner = ? and Comments.SEQ_Post = ? and Comments.Parent = ?";
		ArrayList<CommentsDTO> ReComments = new ArrayList<CommentsDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, SEQ_Owner);
			ps.setDouble(2, SEQ_Post);
			ps.setDouble(3, Parent);
			rs = ps.executeQuery();
			while(rs.next()) {
				CommentsDTO commentsDTO = new CommentsDTO();
				commentsDTO.setFileName(rs.getString(1));
				commentsDTO.setNickname(rs.getString(2));
				commentsDTO.setComment(rs.getString(3));
				commentsDTO.setSEQ_Comment(rs.getInt(4));
				ReComments.add(commentsDTO);
				}
			return ReComments;
			}
			catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
				try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
				try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
			}
		return ReComments;
		}
}
