<%@page import="Comments.CommentsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:useBean id="commentsDTO" class="Comments.CommentsDTO"/>
<jsp:useBean id="commentsDAO" class="Comments.CommentsDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<jsp:setProperty name="CommentsDTO" property="*"/>
<%
	ArrayList<CommentsDTO> CommentsList = commentsDAO.PrintComments(1, 9);
	for(CommentsDTO comments : CommentsList){
		out.print(comments.getComment() + "<br>");
	}
%>
</body>
</html>