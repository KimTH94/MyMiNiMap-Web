<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="boot.jsp" />
<jsp:include page="header.jsp" />
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:setProperty name="memDTO" property="*" />
	<div align ="center">
		<% 	String email = (String)session.getAttribute("email");
		    String nickname =  memDAO.getNickname2(email);
		%> 
	<h1><%= nickname %> 님 <br>Congratulation!</h1>
	<p>
	<p>
	<iframe width="600" height="400" src="https://www.youtube.com/embed/jhpx2dFaMZo" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	<p>
	<a href="main.jsp"><button type="button" class="btn btn-primary">사용 하기</button></a>
	</div>
</body>
</html>