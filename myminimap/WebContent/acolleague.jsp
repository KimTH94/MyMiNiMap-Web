<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:useBean id="filterDTO" class="afilter.aFilterDTO"/>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String id = request.getParameter("key");
String Colleague = placeDAO.get_Colleagues(id);

System.out.println("colleagueId:~~~");
System.out.println(id);
System.out.println("colleague:~~~");
System.out.println(Colleague);
out.print(Colleague);
%>