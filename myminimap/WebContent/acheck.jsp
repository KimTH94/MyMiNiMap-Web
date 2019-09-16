<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="acheck.apwCheck"/>
<jsp:useBean id="memDAO" class="acheck.apwCheckGetset"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String pwd = request.getParameter("pwd");
String returns = memDTO.checkpw(pwd);
out.print(returns);
out.print(pwd.length());
%>