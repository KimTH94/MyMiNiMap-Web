<%@page import="bean.FeedDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style>
#resultFeed{
width: 80%;
}
.dot{
	width: 293px;
	height: 293px;
	line-height: 100px;
	background-color: orangered;
	color: white;
	font-size: 3rem;
	text-align: center;
	/* float: left;
	margin: 0 10px; */
	display: inline-block;
}
</style>
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
String S_Post_owner = request.getParameter("Post_owner");
String path = "./imageupload/";
int SEQ_User = Integer.parseInt(S_SEQ_User);
int Post_owner = Integer.parseInt(S_Post_owner);
%>
<div id ="resultFeed" style="margin: 0 auto;">
	<%
	int count  = 1;
	ArrayList<FeedDTO> list = feedDAO.ShowPhoto(Post_owner); 
		for(FeedDTO feed : list){
			int PostNum = memDAO.PostNumber(Post_owner, count);
	%>
			<div class="dot" style="background-image: url(<%= path + feed.getFileName()%>); background-size: cover; background-position: center;"
			 onclick="openModal(<%= count %>, <%= PostNum %>);currentSlide(<%=count%>, <%= PostNum %>)" class="hover-shadow cursor" name="<%= PostNum %>"></div>
	<%if(count % 3 == 0 ){%>
		<br>
	<%
		}
		count ++;
	} 
	%>
</div>
</body>
</html>