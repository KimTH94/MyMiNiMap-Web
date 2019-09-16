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
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:useBean id="commentsDTO" class="Comments.CommentsDTO"/>
<jsp:useBean id="commentsDAO" class="Comments.CommentsDAO"/>
<jsp:useBean id="encode" class="bean.encodeURIComponent"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
	int result = commentsDAO.HaveRecomment(2);
	out.print(result);
%>
</body>
</html>