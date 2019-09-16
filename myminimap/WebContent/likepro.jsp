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
<jsp:useBean id="feedDTO" class="bean.FeedDTO"/>
<jsp:useBean id="feedDAO" class="bean.FeedDAO"/>
<jsp:useBean id="likeDTO" class="Like.LikeDTO"/>
<jsp:useBean id="likeDAO" class="Like.LikeDAO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:setProperty name="feedDTO" property="*" />
<jsp:setProperty name="likeDTO" property="*" />
<%
String S_SEQ_User = request.getParameter("SEQ_User");
String S_SEQ_Post = request.getParameter("SEQ_Post");
String S_Post_owner = request.getParameter("Post_owner");

double SEQ_User = Integer.parseInt(S_SEQ_User);
double SEQ_Post = Integer.parseInt(S_SEQ_Post);
double Post_owner = Integer.parseInt(S_Post_owner);

likeDAO.LikeUp(SEQ_User, Post_owner, SEQ_Post);
%>
</body>
</html>