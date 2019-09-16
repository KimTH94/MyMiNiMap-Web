<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");

//String Email = memDAO.getallEmail();
//String Nickname = memDAO.getallNick();
//String Name = memDAO.getallName();
String result = memDAO.getallNickName();
out.print(result);
%>