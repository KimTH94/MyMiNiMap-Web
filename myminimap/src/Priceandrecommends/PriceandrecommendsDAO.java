package Priceandrecommends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Collections;

public class PriceandrecommendsDAO {
	
	@SuppressWarnings("resource")
	public static String getPrice(String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int[] Price = new int[5];
		int count = 0;
		int f_count = 0;
		int Price1 = 0;
		int Price2 = 0;
		int Price3 = 0;
		int Price4 = 0;
		int Price5 = 0;
		String S_Price1 = null;
		String S_Price2 = null;
		String S_Price3 = null;
		String S_Price4 = null;
		String S_Price5 = null;
		int FirstPrice = 0;
		int SecondPrice = 0;
		int sum = 0 ; 
		double avg = 0;
		String result = null;
		/*ArrayList<Integer> PriceList = new ArrayList<Integer>();*/
		HashMap<Integer, Integer> PriceMap = new HashMap<Integer, Integer>();
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Price1, Price2, Price3, Price4, Price5 from PriceAndRecommends where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				for(int i = 0 ; i < 5 ; i++) {
					/*PriceList.add(rs.getInt(i));*/
					Price[i] = rs.getInt((i+1));
					//PriceMap.put(i, rs.getInt((i+1)));
				}
				for(int i = 0 ; i < 5; i ++) { // 以묐났 寃��궗
					for(int j = 0 ; j < 5 ; j++) {
						if(Price[i] == Price[j]) {
							if(Price[i] != 0 && Price[j] != 0 && i != j) {
								count++;
							}else if(Price[i] == 0 && Price[j] == 0 && i != j) {
								f_count++;
							}
						}
						
					}
				}
				
				count = count / 2;
				f_count = f_count / 2;
				
				Price1 = rs.getInt(1);
				Price2 = rs.getInt(2);
				Price3 = rs.getInt(3);
				Price4 = rs.getInt(4);
				Price5 = rs.getInt(5);
				
				S_Price1 = "Price1 / " + Price1;
				S_Price2 = "Price2 / " + Price2;
				S_Price3 = "Price3 / " + Price3;
				S_Price4 = "Price4 / " + Price4;
				S_Price5 = "Price5 / " + Price5;
				
				/*System.out.println("0�씠 �븘�땶 以묐났 媛쒖닔 : " + count);
				System.out.println("0�씠 以묐났�씤 媛� 媛쒖닔 : " + f_count);*/
				if(count > 1) {
					String sql1 = "select greatest(Price1, Price2, Price3, Price4, Price5) as Price from PriceAndRecommends where Id = ?";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ps1.setString(1, Id);
					ResultSet rs1 = ps1.executeQuery();
					while(rs1.next()) {
						/*System.out.println("理쒕�媛� : " + rs1.getInt(1));*/
						FirstPrice = rs1.getInt(1);
						for(int i = 0 ; i < 5 ; i++) {
							if(Price[i] ==  rs1.getInt(1)) {
								if(result == null) {
									result = "Price" + (i+1) + "/";
								}else {
									result += "Price" + (i+1) + "/";
								}
							}
						}
						/*System.out.println("result : " + result);*/
					}
				}else if(count == 0){
					Arrays.sort(Price);
					FirstPrice = Price[4];
					SecondPrice = Price[3];
					
					sum = Price1 + Price2 + Price3 + Price4 + Price5;
			        avg = sum / 5;
			        
			        if((FirstPrice - SecondPrice) > (sum * 0.2)) {
			        	if(FirstPrice == Price1) {
			        		result = "Price1/";
						}else if(FirstPrice == Price2) {
							result = "Price2/";
						}else if(FirstPrice == Price3) {
							result = "Price3/";
						}else if(FirstPrice == Price4) {
							result = "Price4/";
						}else if(FirstPrice == Price5) {
							result = "Price5/";
						}
			        	/*System.out.println("FirstPrice : " + FirstPrice + " result : " + result);*/
			        }else {
			        	if(FirstPrice == Price1) {
			        		result = "Price1/";
						}else if(FirstPrice == Price2) {
							result = "Price2/";
						}else if(FirstPrice == Price3) {
							result = "Price3/";
						}else if(FirstPrice == Price4) {
							result = "Price4/";
						}else if(FirstPrice == Price5) {
							result = "Price5/";
						}
			        	
			        	if(SecondPrice == Price1) {
			        		result += "Price1/"; 
			        	}else if(SecondPrice == Price2) {
			        		result += "Price2/";
			        	}else if(SecondPrice == Price3) {
			        		result += "Price3/";
			        	}else if(SecondPrice == Price4) {
			        		result += "Price4/";
			        	}else if(SecondPrice == Price5) {
			        		result += "Price5/";
			        	}
			        	/*System.out.println("FirstPrice : " + FirstPrice + " SecondPrice : " + SecondPrice + " result : " + result);*/
			        }
				}
		}
			/*System.out.println("Price 諛곗뿴 �젙�젹");
			for(int i = 0 ; i < 5 ; i ++) {
				System.out.println("Price["+ i + "] : " + Price[i]);
			}
			System.out.println("Price1 : " + S_Price1);
			System.out.println("Price2 : " + S_Price2);
			System.out.println("Price3 : " + S_Price3);
			System.out.println("Price4 : " + S_Price4);
			System.out.println("Price5 : " + S_Price5);
	        */ 
			if(result == null) {
				result = "Price0/";
			}
			/*System.out.println("result : " + result);*/
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	public static double getRecommend(String Id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://minimapdb.ciwr6p8mnjyh.ap-northeast-2.rds.amazonaws.com:3306/minimap?serverTimezone=UTC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double Recommend = 0;
		double NonRecommend = 0;
		double sum = 0;
		double RecommendResult = 0;
		con = DriverManager.getConnection(url, "minimapdb", "alslaoq94");
		String sql = "select Recommend, NonRecommend from PriceAndRecommends where Id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Recommend = rs.getDouble(1);
				NonRecommend = rs.getDouble(2);
				sum = rs.getDouble(1) + rs.getDouble(2);
				RecommendResult = (Recommend / sum) * 100;
				}
//			System.out.println(Id + "�쓽 Recommend : " + Recommend);
//			System.out.println(Id + "�쓽 NonRecommend : " + NonRecommend);
//			System.out.println(Id + "�쓽 sum : " + sum);
//			System.out.println(Id + "�쓽 (Recommend / sum) : " + (Recommend / sum));
//			System.out.println(Id + "�쓽 RecommendResult : " + RecommendResult);
			return RecommendResult;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(con != null) con.close();} catch(Exception e) {e.printStackTrace();}
			try {if(ps != null) ps.close();} catch(Exception e) {e.printStackTrace();}
		}
		return RecommendResult;
	}
}

