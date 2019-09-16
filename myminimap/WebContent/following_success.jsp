<%@page import="bean.MemDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<% 
String key = request.getParameter("key");
int user_SEQ = Integer.parseInt(key);
int my_SEQ = (Integer)session.getAttribute("SEQ_User");
int result = memDAO.following(my_SEQ, user_SEQ);
out.print("팔로잉 성공");
%>
</body>
</html>