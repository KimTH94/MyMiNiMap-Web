<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
String Type = request.getParameter("filterType");
String name = request.getParameter("name");
String id = request.getParameter("id");
String address = request.getParameter("address");
String tel = request.getParameter("tel");
String lat = request.getParameter("lat");
String lng = request.getParameter("lng");
String foodType[] = request.getParameterValues("AutoCompleteFoodType");
String taste = request.getParameter("filterTaste");
String price = request.getParameter("filterPrice");
String Colleague[] = request.getParameterValues("AutoCompleteColleague");
/* int price = Integer.parseInt(request.getParameter("filterPrice"));
int taste = Integer.parseInt(request.getParameter("filterTaste")); */
/* String address = URLDecoder.decode(request.getParameter("address")); */
/* String name = URLDecoder.decode(request.getParameter("name")); */
out.print("filterType : " + Type + "<br>");
out.print("name : " + name + "<br>");
out.print("id : " + id + "<br>");
out.print("address : " + address + "<br>");
out.print("tel : " + tel + "<br>");
out.print("lat : " + lat + "<br>");
out.print("lng : " + lng + "<br>");
out.print("taste : " + taste + "<br>");
out.print("price : " + price + "<br>");
if(request.getParameterValues("AutoCompleteFoodType") != null){
	for(String val1 : foodType){
		out.print("foodType : " + val1 + "<br>");
	}
}
if(request.getParameterValues("AutoCompleteFoodType") != null){
	for(String val2 : Colleague){
		out.print("Colleague : " + val2 + "<br>");
	}
}
%>
</body>
</html>