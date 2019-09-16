<%@page import="bean.MemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Filter.FilterDAO"%>
<%@page import="bean.PlacesDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>

p{
border-bottom: 1px solid gray;
}
</style>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js" type="text/javascript"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="tagging/jquery.tag-editor.css">
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<body>

<jsp:useBean id="placesDAO" class="bean.PlacesDAO"/>


	<% 
	    String email = (String)session.getAttribute("email");
		String nickname = request.getParameter("nickname");
		int SEQ_User = memDAO.getSEQ_User(nickname);
		String path = "./imageupload/";
		String profile = "./profileupload/";
		String img = profile + memDAO.getProfilePhoto(nickname);
		int SEQ_My = (Integer)session.getAttribute("SEQ_User");

		int CountPosts = memDAO.CountPost(SEQ_User);
		int state = 0;
		if(memDAO.Following_State(SEQ_My, SEQ_User) == true){
			state = 1;
		}else{
			state = 0;
		}
		ArrayList<MemDTO> Follower_list = memDAO.Show_Follower_List(SEQ_User);
		ArrayList<MemDTO> Following_list = memDAO.Show_Following_List(SEQ_User);
	%>


<button onclick="test()">
get
</button>
<button onclick="timeline()">
t-l
</button>



<script>
var seq_user = <%=session.getAttribute("SEQ_User")%>;

function move(){
	console.log("1");
}
function timeline(){
	


	console.log(seq_user);
	console.log("location is");

	console.log(locations);
	console.log(su);
	
	

}

var tlAry = new Array();

myArray = null;
myArray1 = null;
$(document).ready(function test(){
	var sequser = {"SEQ_User": seq_user};
	var myArray = new Array();
	$.ajax({ 
        type:'POST',
        url:'getTimelineDatasurl',
        async:false,
        data: sequser,
        success:function(data)
        {
        myArray1 = data.postId;
        console.log("myArray1 is");
        console.log(myArray1);
        console.log()
        	}
     });
	
    for (var i=0;i<myArray1.length;i++){
    	document.write('<div class="posttimeline">');
    	document.write('<p class="postNick">'+myArray1[i][0][0]+'</p>');
    	document.write('<p class="postPlace">'+myArray1[i][0][1]+'</p>');
    	document.write('<div class="postImg">');
    	document.write('<img src='+myArray1[i][1]+'>')
    	document.write('</div>');
    	document.write('<p class="postTime">'+myArray1[i][0][2]+'</p>');
    	document.write('<p class="PostLikes"> 좋아요 '+myArray1[i][2]+'개</p>');
    	document.write('<div class="postCommentTop">comments<button onclick=move();>더보기</button>')
    	for (var j=0;j<myArray1[i][3].length;j++){
    		document.write('<p class="postComments">'+myArray1[i][3][j][0]+'&nbsp;'+myArray1[i][3][j][1]+'</p>');
    	}
    	document.write('<textarea row="5" cols="30" name="contents" placeholder="댓글달기..." id="memo" style="width:100%; height:50px; border:1px solid black;;overflow-y:hidden;background:clear;"></textarea>')
    	document.write('</div>')
    	document.write('</div>');
    }
    $('.posttimeline').css('border','1px solid black');
    $('.posttimeline').css('height','800px');
    $('.posttimeline').css('width','500px');
    $('.postNick').css('height','30px');
    $('.postNick').css('width','500px');
    $('.postImg').css('height','400px');
    $('.postImg').css('width','400px');
    $('.postImg').css('border','1px solid red');
    $('.postNick').css('border-bottom','1px solid black');
    $('.postPlace').css('border-bottom','1px solid black');
    $('.postCommentTop').css('height','200px');
    $('.postCommentTop').css('overflow','auto');
    $('.postComments').css('height','20px');
 //   $('p').css('text-align','center');
    $.ajax({ 
        type:'POST',
        url:'Timelineurl',
        async:false,
        data: sequser,
        success:function(data)
        {
        myArray = data.postId;
        	}
     }); 
    //console.log(myArray);
    console.log(myArray);
    console.log(myArray.length);
    
    

    
    function clickTimeline(){
    	
    }

});


</script>
</body>
</html>