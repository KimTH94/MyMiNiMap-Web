<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
<%@page import=" java.util.StringTokenizer"%>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:useBean id="restaurantDAO" class="arestaurant.aRestaurantDAO"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
String loginId = request.getParameter("loginId");
String rName = request.getParameter("restaurantName");
String Lat = request.getParameter("Lat");
String Lng = request.getParameter("Lng");
String Id = request.getParameter("Id");
String rTel = request.getParameter("restaurantTel");
String rAddress = request.getParameter("restaurantAddress");
String saveType= request.getParameter("saveType");
String foodType = request.getParameter("foodType");
if(foodType.length()==0)
	foodType="0";
String tasteNum = request.getParameter("tasteNum");
String priceNum = request.getParameter("priceNum");
if(priceNum.length()==0)
	priceNum="0";
String colleague = request.getParameter("colleague");
if(colleague.length()==0)
	colleague="0/";
String recommend = request.getParameter("recommend");
if(recommend.length()==0)
	recommend="";
String tag = request.getParameter("tag");
if(tag.length()==0)
	recommend="";
System.out.print(tag);
System.out.print(recommend);
System.out.println(rAddress);
Double User_SEQ = memDAO.getSEQ_User(loginId);

System.out.println( User_SEQ);
System.out.println(rName );
System.out.println( rAddress);
System.out.println( rTel);
System.out.println(Id );
System.out.println(Double.parseDouble(Lat) );
System.out.println(Double.parseDouble(Lng) );
System.out.println( Integer.parseInt(saveType));
System.out.println( Integer.parseInt(foodType));
System.out.println( Integer.parseInt(tasteNum)); //맛평가
System.out.println( colleague);
System.out.println( Integer.parseInt(priceNum));


if(restaurantDAO.OverlapRestarants(Id) == 0) { // 음식점 저장
	restaurantDAO.InsertRestarants(rName, rAddress, rTel, Id, Double.parseDouble(Lat), Double.parseDouble(Lng));
	restaurantDAO.InsertSaveType(Id, Integer.parseInt(saveType));
	restaurantDAO.InsertFoodType(Id, Integer.parseInt(foodType));
	restaurantDAO.InsertColleagues(Id, colleague);
	System.out.println("ID: " + Id + "Price " + priceNum);
	restaurantDAO.InsertPriceAndRecommends(Id, Integer.parseInt(priceNum));
	restaurantDAO.UpdatePrice(Id, Integer.parseInt(priceNum));
	restaurantDAO.UpdateRecommends(Id,Integer.parseInt(tasteNum));
}else if(restaurantDAO.OverlapRestarants(Id) >= 1) {
	restaurantDAO.InsertSaveType(Id);
	restaurantDAO.InsertFoodType(Id);
	restaurantDAO.InsertColleagues(Id);
	restaurantDAO.UpdateSaveType(Id, Integer.parseInt(saveType));
	restaurantDAO.UpdateFoodType(Id, Integer.parseInt(foodType));
	restaurantDAO.UpdateColleagues(Id, colleague);
	restaurantDAO.UpdatePrice(Id, Integer.parseInt(priceNum));
	restaurantDAO.UpdateRecommends(Id,Integer.parseInt(tasteNum));
}

placeDAO.insertPosts(User_SEQ,Id,Integer.parseInt(saveType),Integer.parseInt(foodType),Integer.parseInt(tasteNum),Integer.parseInt(priceNum),colleague);

Double result = placeDAO.getSEQ_Post(User_SEQ, Id);
out.println(result);


StringTokenizer st= new StringTokenizer(recommend,"#");
while(st.hasMoreTokens()){
	placeDAO.MenuInsert(result,User_SEQ,Id,st.nextToken());
}

st= new StringTokenizer(tag,"#");
while(st.hasMoreTokens()){
	placeDAO.TagInsert(result, User_SEQ, Id, st.nextToken());
}


System.out.println(result);
%>