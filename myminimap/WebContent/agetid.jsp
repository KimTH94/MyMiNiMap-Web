<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="acheck.apwCheck"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String key = request.getParameter("key");

String Id = placeDAO.get_Id(Double.parseDouble(key));
System.out.println("키키키키"+Id);
out.print(Id);
%>