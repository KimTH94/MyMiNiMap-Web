package bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedDAO {
	public static ArrayList<FeedDTO> AllShowPhoto2(String Id) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select FileName from Attachments inner join Posts on Posts.SEQ_Post = Attachments.SEQ_Post where Id = ?";
		ArrayList<FeedDTO> AllPhotoList = new ArrayList<FeedDTO>();
		FeedDTO feedDTO = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				feedDTO = new FeedDTO();
				feedDTO.setFileName(rs.getString(1));
				AllPhotoList.add(feedDTO);
			}
			return AllPhotoList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return AllPhotoList;
	}

	public static ArrayList<FeedDTO> ShowPhotoTimeline(String SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select * from  Attachments where SEQ_Post = ?";
		ArrayList<FeedDTO> PhotoList = new ArrayList<FeedDTO>();
		FeedDTO feedDTO = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				feedDTO = new FeedDTO();
				feedDTO.setSEQ_Attachment(rs.getInt(1));
				feedDTO.setSEQ_Post(rs.getInt(2));
				feedDTO.setSEQ_User(rs.getInt(3));
				feedDTO.setFileName(rs.getString(4));
				PhotoList.add(feedDTO);
			}
			return PhotoList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return PhotoList;
	}
	

	
	public ArrayList<FeedDTO> ShowPhoto(int SEQ_User) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select * from  Attachments where SEQ_User = ? group by SEQ_Post";
		ArrayList<FeedDTO> PhotoList = new ArrayList<FeedDTO>();
		FeedDTO feedDTO = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, SEQ_User);
			rs = ps.executeQuery();
			while(rs.next()) {
				feedDTO = new FeedDTO();
				feedDTO.setSEQ_Attachment(rs.getInt(1));
				feedDTO.setSEQ_Post(rs.getInt(2));
				feedDTO.setSEQ_User(rs.getInt(3));
				feedDTO.setFileName(rs.getString(4));
				PhotoList.add(feedDTO);
			}
			return PhotoList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return PhotoList;
	}
	
	public ArrayList<FeedDTO> AllShowPhoto(int SEQ_User, int SEQ_Post) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select FileName from Attachments where SEQ_User = ? and SEQ_Post = ?";
		ArrayList<FeedDTO> AllPhotoList = new ArrayList<FeedDTO>();
		FeedDTO feedDTO = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, SEQ_User);
			ps.setInt(2, SEQ_Post);
			rs = ps.executeQuery();
			while(rs.next()) {
				feedDTO = new FeedDTO();
				feedDTO.setFileName(rs.getString(1));
				AllPhotoList.add(feedDTO);
			}
			return AllPhotoList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch(Exception e) {e.printStackTrace();}
		}
		return AllPhotoList;
	}
}
