<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:useBean id="filterDTO" class="afilter.aFilterDTO"/>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String id = request.getParameter("key");
int count = placeDAO.get_Counting(id);

System.out.println("countingId:~~~");
System.out.println(id);
System.out.println("Count:~~~");
System.out.println(count);

System.out.println(count);
out.print(count);
%>