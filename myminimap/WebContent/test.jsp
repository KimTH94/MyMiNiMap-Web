<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
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
String S_SEQ_Post = request.getParameter("SEQ_Post");
String S_Post_owner = request.getParameter("Post_owner");
String S_SEQ_User = request.getParameter("SEQ_User");

double SEQ_Post = Integer.parseInt(S_SEQ_Post);
double Post_owner = Integer.parseInt(S_Post_owner);
double SEQ_User = Integer.parseInt(S_SEQ_User);

boolean state = likeDAO.LikeState(SEQ_Post, Post_owner, SEQ_User);

if(state == true){
%>
<img src="./img/like.png" id = "likechange">
<% }
else{
%>
<img src="./img/unlike.png" id = "likechange">
<% } %>

</body>
</html>