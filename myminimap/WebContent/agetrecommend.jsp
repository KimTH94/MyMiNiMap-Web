<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:useBean id="filterDTO" class="afilter.aFilterDTO"/>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String id = request.getParameter("key");
String recommend = placeDAO.get_Recommmend(id);

System.out.println("recommend:~~~");
System.out.println(id);
System.out.println("recommend:~~~");
System.out.println(recommend);

out.print(recommend);

%>