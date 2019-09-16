<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="memDTO" class="bean.MemDTO"/>
	<jsp:setProperty name="memDTO" property="*" />
	<jsp:useBean id="memDAO" class="bean.MemDAO"/>
	<%
	 request.setCharacterEncoding("UTF-8"); 
	 response.setCharacterEncoding("UTF-8");
	 String email= (String)session.getAttribute("email");
	 memDTO.setEmail(email);
	 memDAO.update(memDTO);
	 response.sendRedirect("main.jsp");
%>
</body>
</html>