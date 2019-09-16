<%@page import="java.util.StringTokenizer"%>
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
<style>
#comment{
height: 80%;
overflow: auto;
}
.commentstart{
border: 1px solid gray;
padding: 10px;
}
.commentanswer{
margin-left : 50px;
}

</style>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:useBean id="commentsDTO" class="Comments.CommentsDTO"/>
<jsp:useBean id="commentsDAO" class="Comments.CommentsDAO"/>
<jsp:useBean id="encode" class="bean.encodeURIComponent"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
String S_SEQ_User = request.getParameter("SEQ_User");
String S_SEQ_Post = request.getParameter("SEQ_Post");
String S_Post_Owner = request.getParameter("Post_owner");
String S_SEQ_Comment = request.getParameter("SEQ_Comment");
String content = request.getParameter("content");

double SEQ_User = Integer.parseInt(S_SEQ_User);
double SEQ_Post = Integer.parseInt(S_SEQ_Post);
double SEQ_Owner = Integer.parseInt(S_Post_Owner);
double SEQ_Comment = 0;

if(S_SEQ_Comment != null && content != null){
	 SEQ_Comment = Integer.parseInt(S_SEQ_Comment);
	 commentsDAO.insert(SEQ_Post, SEQ_User, SEQ_Owner, content,SEQ_Comment);
}else if(S_SEQ_Comment == null && content != null){
	commentsDAO.insert(SEQ_Post, SEQ_User, SEQ_Owner, content);
}

String path = "./upload/";

ArrayList<CommentsDTO> CommentsList = commentsDAO.PrintComments(SEQ_Post, SEQ_Owner);

int count = 0;
for(CommentsDTO comments : CommentsList){
	String fileName = comments.getFileName();
	String Nickname = comments.getNickname();
	String encodeURI = encode.encodeURIComponent(Nickname);
	String Comment = comments.getComment();
	double CommentSEQ_Comment = comments.getSEQ_Comment();
	SEQ_Comment = comments.getSEQ_Comment();
	double Parent = comments.getParent();
	%>
	<div class="commentstart">
	<a href="userfeed.jsp?nickname=<%= encodeURI %>">
	<li class="l-g-item">
	<img src="<%= path + fileName %>" class = "profile_img">
<%
	out.print("<strong>" + Nickname + "</strong>");


%>
	
	</a><!-- <p id="please"style="display:none"></p> --><%out.print(Comment);%>

    

    </li>
   
    <%
    	int RecommentState = commentsDAO.HaveRecomment(SEQ_Comment);
    	if(RecommentState == 0){
    %>
    <span class = "reComment" onclick = "give(<%= CommentSEQ_Comment %>);"><strong>답글 달기</strong></span>
    <%
    	}else if(RecommentState == 1){
     %>
    		<div id="showrecomments"><span class = "reComment" onclick = "give(<%= CommentSEQ_Comment %>);"><strong>답글 달기</strong></span></div>
    		
    <%
    ArrayList<CommentsDTO> ReCommentsList = commentsDAO.PrintReComments(SEQ_Post, SEQ_Owner, SEQ_Comment);
    for(CommentsDTO recomments : ReCommentsList){
    	String ReFileName = recomments.getFileName();
    	String ReNickname = recomments.getNickname();
    	String ReComment = recomments.getComment();
    	String RencodeURI = encode.encodeURIComponent(ReNickname);
    	%>
    	<li class="commentanswer">
    	<a href="userfeed.jsp?nickname=<%= RencodeURI %>">
    	<img src="<%= path + ReFileName %>" class = "profile_img">
    	<p id="hiddenNick" style="display:none"><%= ReNickname %></p>
    	<% out.print("<strong>" + ReNickname + "</strong>");%>
    	</a>
    	<% 
    	int idx = ReComment.indexOf("@");
    	int space = ReComment.indexOf('\t');
    	int spacep1 =  space+1;
    	int idx1 = idx+1;
    	String recommentnick = ReComment.substring(idx, space);
		String commentcontent = ReComment.substring(space+1);
//		String getnickforCom = recommentnick.substring(idx1);
		%><p id="please"style="display:none"><%out.print(ReComment);%></p>
		<a href="userfeed.jsp?nickname=<%= encodeURI %>" id="recommentuser"><% 
//		out.print(getnickforCom);

	  	out.print(recommentnick);%></a><%
	  	String getnickforCom = recommentnick.substring(idx1);

		out.print('\t'+commentcontent);
    	%>
    	
    	<br>
    	<span class = "reRecomment" id="nic_name" onclick = "getNickforComment();"><strong>답글 달기</strong></span>
    	</li>
    	
    	<%
    }
    	}
    	
    %>
	</li></div>
	
<%
count++;
}
%>
</body>
<script type="text/javascript">

var a;
var parameter;
var nnick;
function getNickforComment(){
	var jb = $('#hiddenNick').text();
	console.log(jb);
	var commentsearch = $('#please').text();
	console.log(commentsearch);

  	$.ajax({
        type:'POST',
	   	url:'dddreRecommentGetNickname',//바꾸어야함
	   	data: 'Comments=' + commentsearch, 
	   	async:false,
     	success:function(data)
         {
     		nnick = data.SEQ_No;
     		//console.log(nnick)
     	
    	 }	
  	});	
  	console.log(nnick)
	$.ajax({
        type:'POST',
	   	url:'ReCommentGetNickname',
	   	data: 'SEQ_Comment=' + nnick, 
     	success:function(data)
         {
     		$('#memo').val(data.ReCommetGetNickname);
     		$('#memo').focus();
    	 }	
  	});	
}
function give(n){
	parameter = n;
	console.log(parameter);
//	console.log(get_SEQ_Comment);
}

$(document).ready(function(){
	$(".reComment").on('click',function(){
      	$.ajax({
	        type:'POST',
		   	url:'ReCommentGetNickname',
		   	data: 'SEQ_Comment=' + parameter, 
         	success:function(data)
             {
         		$('#memo').val(data.ReCommetGetNickname);
         		$('#memo').focus();
        	 }	
      	});	 
  	});
});

</script>
</html>