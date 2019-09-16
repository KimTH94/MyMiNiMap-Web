<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:useBean id="filterDTO" class="afilter.aFilterDTO"/>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String id = request.getParameter("key");
String tel = placeDAO.get_Tel(id);

System.out.println("telID:~~~");
System.out.println(id);
System.out.println("tel:~~~");
System.out.println(tel);

if(tel!=null){
out.print(tel);
System.out.println("널아니래");
}
else{
	out.print(" ");
	System.out.println("널이래");
	}
%>