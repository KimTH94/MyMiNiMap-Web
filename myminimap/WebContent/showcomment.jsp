<%@page import="Comments.CommentsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.profile_img{
 	width: 50px;
 	height: 50px;
	border-radius: 50%;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:useBean id="commentsDTO" class="Comments.CommentsDTO"/>
<jsp:useBean id="commentsDAO" class="Comments.CommentsDAO"/>
<jsp:useBean id="encode" class="bean.encodeURIComponent"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
	String S_SEQ_Post = request.getParameter("SEQ_Post");
	String S_Post_owner = request.getParameter("Post_owner");

	double SEQ_Post = Integer.parseInt(S_SEQ_Post);
	double Post_owner = Integer.parseInt(S_Post_owner);
	
	String path = "./upload/";
	
	String CommentFileName = null;
	String CommentNickname = null;
	String CommentencodeURI = null;
	String Comment = null;
	
	double count = 1;
	
	ArrayList<CommentsDTO> CommentsList = commentsDAO.PrintComments(SEQ_Post, Post_owner);
	
	for(CommentsDTO comments : CommentsList){
		CommentFileName = comments.getFileName();
		CommentNickname = comments.getNickname();
		CommentencodeURI = encode.encodeURIComponent(CommentNickname);
		double CommentSEQ_Comment = comments.getSEQ_Comment();
		Comment = comments.getComment();
%>
		<a href="userfeed.jsp?nickname=<%= CommentencodeURI %>">
		<li class="l-g-item">
		<img src="<%= path + CommentFileName %>" class = "profile_img">
<%
		out.print("<strong>" + CommentNickname + "</strong>");
%>
		</a>
<%
		out.print(Comment);
%>		
		<br>
    	<span class = "reComment" onclick = "give(<%= CommentSEQ_Comment %>);">대댓글</span>

		</li>
		
<%
      count++;
	}
%>
</body>
<script type="text/javascript">

var parameter;

function give(n){
	parameter = n;
}

$(document).ready(function(){
	$(".reComment").on('click',function(){
      	$.ajax({
	        type:'POST',
		   	url:'ReCommentGetNickname',
		   	data: 'SEQ_Comment=' + parameter, 
         	success:function(data)
             {
         		console.log("showcomment " + parameter);
         		$('#memo').text(data.ReCommetGetNickname);
        	 }	
      	});	 
  	});
});
</script>
</html>