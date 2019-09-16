<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="acheck.apwCheck"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String key = request.getParameter("key");

String menu = placeDAO.get_menu(key);
System.out.println("메뉴키키키키"+menu);
out.print(menu);
%>