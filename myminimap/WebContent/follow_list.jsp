<%@page import="bean.MemDTO"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<MemDTO> list = memDAO.Show_Follower_List(user_SEQ);

for(MemDTO member : list){
	String nickname = member.getEmail();
	%>
	<%= member.getEmail() %><br>
<% 
}
%>
</body>
</html>