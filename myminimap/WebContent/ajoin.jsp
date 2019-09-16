<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="ajoin.amemGetset"/>
<jsp:useBean id="memDAO" class="ajoin.amemJoin"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String nick= request.getParameter("nick");
String email = request.getParameter("email");
String returns = memDAO.joindb(id,pwd,nick,email);
out.print(returns);
%>	