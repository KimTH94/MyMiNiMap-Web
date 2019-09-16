   <%@page import="bean.MemDTO"%>
<%@page import="bean.FeedDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
#result_img{
width:390px;
height:390px;
}
#rt{
width: 400px;
position: relative;
background: white;
top: -90%;
}
.form-row{
padding: 0px; margin: 0px;
}
*{
margin: 0px;
padding: 0px;
}
#arct_name, #arct_tel, #arct_type1, #arct_eval, #arct_with, #arct_price{
height: 30px;
margin: 0;
padding: 5px5 px 5px 5px;
}
#arct_addr, #arct_type2, #arct_menu, #arct_tag{
height: 60px;
margin: 0;
padding: 0;
border-bottom: 1px solid black;
}
#acrt_pic{
height:  350px;
margin: 0;
padding: 0;
}
#AutoCompleteResultToggle{
float: left;
width: 500px;
margin-left: 20px;
}
#resultToggle{
 display:none; 
 float:left; 
 width: 400px;
 height: 80%;
 position: absolute;

 }
 .subdata{
 
 border: 1px solid black;
 width: 25%;
 }
 #sd_pic{
 width: 430px;
 height: 350px;
 }
 .nametag{
 padding-left: 10px;
 width: 100px;
 }
.btn-sm{
height: 20px;
text-align: center;
}
.sd-name{
width: 75px;
}
.tsd-name{
width: 30%;
}
#sd-addr{
height: 60px;
}
.subdata2{
 border: 1px solid black;
 
 width: 25%;
 height: 60px;
 }

}
.sd-data{
width:300px;
}
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }

/* * {
  box-sizing: border-box;
} */

.row > .column {
  padding: 0 8px;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

.column {
  float: left;
  width: 25%;
}

.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 70%; /* Full width */
  height: 100%; /* Full height */
  overflow: 100%; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

.modal-container{
	width:100%;
	display: flex;
	height:800px;
	background-color: white;
	margin: 0 auto;
}
.photo{
	display: flex;
	flex-grow: 3;
}
.content{
	flex-grow: 2;
	height:560px;
	flex-direction:column;
}
.header{
	padding: 10px;
	height:60px;
}
.content-content{
	height:400px;
}
.like{
	height:60px;
}
.comment{
	height:40px;
	overflow:scroll;
}

.close {
  color: white;
  position: absolute;
  top: 10px;
  right: 25px;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #999;
  text-decoration: none;
  cursor: pointer;
}

.mySlides {
width:100%;
height:100%;
  display: none;
}

.cursor {
  cursor: pointer;
}

.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -50px;
  color: white;
  font-weight: bold;
  font-size: 20px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
  -webkit-user-select: none;  
}

.next {
  float:rigth;
  right: 0;
  border-radius: 3px 0 0 3px;
}

.prev:hover,
.next:hover {
  background-color: rgba(0, 0, 0, 0.8);
}

.numbertext {
  color: #000000;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

.img1 {
	width: 100%;
	height: 100%;
}

.caption-container {
  text-align: center;
  background-color: black;
  padding: 2px 16px;
  color: white;
}

.demo {
  opacity: 0.6;
}

.active,
.demo:hover {
  opacity: 1;
}

img.hover-shadow {
  transition: 0.3s;
}
.hover-shadow:hover {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.small-img{
border-radius: 50%;
width: 10%;
height: 10%;
}

#map {
 width: 1200px;
  height: 741.1px;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
  position: relative;
}

#resultToggle{
display: none;
float: left;
width:260px;
z-index:1;
}

.profile_img{
 	width: 50px;
 	height: 50px;
	border-radius: 50%;
}
.mySlides {display: none}
</style>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:useBean id="feedDTO" class="bean.FeedDTO"/>
<jsp:useBean id="feedDAO" class="bean.FeedDAO"/>
<jsp:useBean id="likeDTO" class="Like.LikeDTO"/>
<jsp:useBean id="likeDAO" class="Like.LikeDAO"/>
<jsp:useBean id="placesDTO" class="bean.PlacesDTO"/>
<jsp:useBean id="placesDAO" class="bean.PlacesDAO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:setProperty name="feedDTO" property="*" />
<jsp:setProperty name="likeDTO" property="*" />


<jsp:include page="header.jsp"/>
	<% 
	    String email = (String)session.getAttribute("email");
		String nickname = request.getParameter("nickname");
		int SEQ_User = memDAO.getSEQ_User(nickname);
		String path = "./imageupload/";
		String profile = "./profileupload/";
		String img = profile + memDAO.getProfilePhoto(nickname);
		int SEQ_My = (Integer)session.getAttribute("SEQ_User");
		int CountFollowing = memDAO.Count_Following(SEQ_User);
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
	<script>console.log(<%=SEQ_User%>);</script>
	<div class="container">
		<div class="form-row">
		<%if( SEQ_My == SEQ_User) {%>
			<div class ="form-group col-sm-4"><img src = <%= img %> data-toggle="modal" data-target="#ProfilePhoto"></div>
			<% }else if(SEQ_My != SEQ_User) {%>
			<div class ="form-group col-sm-4"><img src = <%= img %>></div>
			<% } %>
			  <form id="ProFilePhotoUpload">
      <input type="file" name="uploadFile" id="uploadFile"  value="사진 업로드" style="position:absolute;visibility:hidden;" accept=".jpg,.jpeg"/>
  			  </form>
			  <div class="modal fade" id="ProfilePhoto" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title"><strong>프로필 사진 바꾸기</strong></h4>
        </div>
        <div class="modal-header" id="PhotoUpload">
        <p style="color:#00C6ED" onclick=document.all.uploadFile.click();><strong>사진 업로드</strong></p>
        </div>
		<div class="modal-header" id="PhotoDelete">
          <p style="color:red;"><strong>현재 사진 삭제</strong></p>
        </div>
        <div class="modal-header" data-dismiss="modal">
        	취소
        </div>
      </div>
    </div>
  </div>
			<div class ="form-group col-sm-7">
			<h3> <%= nickname %>	 			
			<%if(state == 1){ %>
				<input type="button" id="btn" class="btn btn-danger" value = "팔로우 취소">
			<%	
				}else if(state == 0){
	 		%>
				<input type="button" id="btn" class="btn btn-primary" value = "팔로우">
			<%} %> 
			</h3>
			<h5>게시물 <strong><%= CountPosts %></strong></h5>
			<div data-toggle="modal" data-target="#FollwerModal"><h5>팔로우 <strong><%= CountFollowing %></strong></h5></div>
				<div class="modal fade" id="FollwerModal" role="dialog">
    				<div class="modal-dialog">
      					<div class="modal-content">
        					<div class="modal-header">
          						<button type="button" class="close" data-dismiss="modal">&times;</button>
          						<h4 class="modal-title"><strong>팔로잉</strong></h4>
        					</div>
        					<%for(MemDTO member : Follower_list){%>
        					<div class="modal-body">
        						<div class="form-row">
        							<div class ="form-group col-sm-2"><img src="<%= path + member.getFilename() %>" class="profile_img"></div>
									<div class ="form-group col-sm-7"><%= member.getName() %><p><%= member.getNickname() %></p></div>
									<%= memDAO.getSEQ_User(member.getNickname()) %>
									<%
									boolean follwingState = memDAO.Following_State(SEQ_My, memDAO.getSEQ_User(member.getNickname()));
									if(follwingState == false) { %>
									<div class ="form-group col-sm-2"><input type="button" value="팔로우" class="btn btn-primary" id=<%= member.getNickname() %>></div>
									<% } else if(follwingState == true){%>
									<div class ="form-group col-sm-2"><input type="button" value="팔로잉" class="btn btn-success" id=<%= member.getNickname() %>></div>
									<% } %>
								</div>
        					</div>
        					<% } %>
        					<div class="modal-footer">
          					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        					</div>
      					</div>
    				</div>
				</div>
				<div data-toggle="modal" data-target="#FollwingModal"><h5>팔로워 <strong><%= memDAO.Count_Follower(SEQ_User) %></strong></h5></div>
				<div class="modal fade" id="FollwingModal" role="dialog">
    				<div class="modal-dialog">
      					<div class="modal-content">
        					<div class="modal-header">
          						<button type="button" class="close" data-dismiss="modal">&times;</button>
          						<h4 class="modal-title"><strong>팔로워</strong></h4>
        					</div>
        					<%for(MemDTO Following_member : Following_list){%>
        					<div class="modal-body">
        						<div class="form-row">
        							<div class ="form-group col-sm-2"><img src="<%= path + Following_member.getFilename() %>" class="profile_img"></div>
									<div class ="form-group col-sm-7"><%= Following_member.getName() %><p><%= Following_member.getNickname() %></p></div>
									<%= memDAO.getSEQ_User(Following_member.getNickname()) %>
									<%
									boolean follwingState = memDAO.Following_State(SEQ_My, memDAO.getSEQ_User(Following_member.getNickname()));
									if(follwingState == false) { %>
									<div class ="form-group col-sm-2"><input type="button" value="팔로우" class="btn btn-primary" id=<%= Following_member.getNickname() %>></div>
									<% } else if(follwingState == true){%>
									<div class ="form-group col-sm-2"><input type="button" value="팔로잉" class="btn btn-success" id=<%= Following_member.getNickname() %>></div>
									<% } %>
								</div>
        					</div>
        					<% } %>
        					<div class="modal-footer">
          					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        					</div>
      					</div>
    				</div>
				</div>
				</div>
			
		</div>
		<div class="form-row">
		</div>
		<div class="form-row">
		<input type = "button" value =" 지도" class="btn btn-primary" id ="showmap">
		<input type = "button" value =" 피드" class="btn btn-success" id ="showfeed">
		
		</div>
		</div>
		<div id="map" style="margin: 0 auto"></div>
		
		<div id="myModal" class="modal">
  			<span class="close cursor" onclick="closeModal()">&times;</span>
  			<div class="modal-container">
				<div class="photo">
    				<div id="result" class="result">
    				<div class="mySlides">
    				</div>
    				</div>
  				  		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	    	  			<a class="next" onclick="plusSlides(1)">&#10095;</a>
    				</div>
			<div class="content">
				<img src = <%= img %> class ="small-img"><%= nickname %>
				<input type = "button" value =" 콘솔" class="btn btn-primary" id ="edittextarea" onclick="page()">
				<img src = "./img/loading.png" id ="PostSetUp" data-toggle="modal" data-target="#PostSet">
				<div id="comment">
				</div>
				<span id ="likeimg"></span> 좋아요 수 <span id = "likeCount"></span>
				<textarea rows="5" cols="30" name="contents" placeholder="댓글 달기..." id="memo" style="width:100%; height:50px; border:0;overflow-y:hidden;background:clear;"></textarea>
			</div>
			</div>
		</div>
		
		<div class="modal fade" id="PostSet" role="dialog">
    		<div class="modal-dialog">
      			<div class="modal-content">
        			<div class="modal-header" id="PhotoUpload">
	        			<p style="color:red;" id ="PostDelete"><strong>게시물 삭제</strong></p>
        			</div>
					<div class="modal-header" id="PhotoDelete">
	          			<p style="color:#00C6ED"><strong>무슨 기능 넣을까 헤헷</strong></p>
        			</div>
        			<div class="modal-header" data-dismiss="modal">
	        			취소
        			</div>
      			</div>
    		</div>
  		</div>
<div id="resultToggle">


		<table id= "rt">
		<tr class="subdata">
			<td class="sd-name"></td>
			<td><p id="result_Name"></td>
		</tr>
<div id="sd_pic">
			<img id="result_img" src="">
		</div>
		<tr class="subdata" id="sd-addr" >
			<td class="sd-name"><p>주소</p></td>
			<td id="sd_address"><p id="result_Address"></td>
		</tr>
		<tr  class="subdata">
			<td class="sd-name"><p>전화번호</p></td>
			<td><p id="result_Tel"></td>
		</tr>
		<tr  class="subdata">
			<td class="sd-name"><p>종류</p></td>
			<td><p id="result_SaveType"></td>
		</tr>
		<tr  class="subdata">
			<td class="sd-name" rowsapn='3'><p>세부종류</p></td>
			<td><p id="result_FoodType"></td>
		</tr>
		
		<tr class="subdata">
			<td class="sd-name"><p>평가</p></td>
			<td ><p id="result_Taste"></td>
		</tr>
		<tr class="subdata">
			<td class="sd-name"><p>동행</p></td>
			<td><p id="result_Colleague"></td>
		</tr>
		<tr class="subdata">
			<td class="sd-name"><p>가격</p></td>
			<td><p id="result_Price"></td>
		</tr>
		<tr class="subdata2" id="2row">
			<td class="sd-name"><p>추천메뉴</p></td>
			<td><p id="result_Menu"></td>
		</tr>
		<tr class="subdata2" id="2row">
			<td class="sd-name"><p>태그</p></td>
			<td><p id="result_Tags"></td>
		</tr>
		</table>
		</div>
			

</body>
<script type="text/javascript">
var Tid = null;
var suser = null;

function showTag(){
	  
	  console.log("노는게 제일 좋아: " + Tid);
	  var allData = {"Id": Tid, "SEQ_User": suser};
	  
    $.ajax({ 
        type:'POST',
        url:'Tagsddd',
        data:allData,
        success:function(data)
        {
      	  console.log("태그 : " + data.Tags);
            $('#whotag').html(data.Tags);
            $('#popmenu2').show();
        }
     }); 

$('#popup2').show();

}
$(".exit").click(function(){
	  $("#popup2").hide();
});
function Menu(){
		  
		  console.log("노는게 제일 좋아: " + Tid);
	  	var allData = {"Id": Tid};
	  
   	 $.ajax({ 
   	     type:'POST',
   	     url:'Menuddd',
   	     data:allData,
   	     success:function(data)
   	     {
   	   	  console.log("Menu : " + data.Menu);
   	         $('#whomenu').html(data.Menu);
   	         $('#popmenu3').show();
   	     }
   	  }); 

	$('#popup3').show();
	
    }
    $(".exit").click(function(){
  	  $("#popup3").hide();
    });

    
    $("#result_Tags").click(function(){
  	  showTag();
  	  //alert(test1);
    });
    $("#result_RecommandMenus").click(function(){
  	  Menu();
  	  //alert(test1);
    });
$(document).ready(function(){
	$("#PhotoDelete").on('click',function(){
		var email = "<%= email %>"
      	$.ajax({
	           	type:'POST',
		   	url:'PhotoDelete',
		   	data: 'email=' + email, 
         	success:function(data)
             {
         		location.reload();
        	 }	
      	});	 
  	});
});

$(document).ready(function(){
	 $('#ProFilePhotoUpload').on('change', "input#uploadFile", function (e) {
      var formData = new FormData();
      formData.append("uploadFile", $('input[name=uploadFile]')[0].files[0]);
          $.ajax({
              type : 'post',
              url : 'saveProfilePhoto.jsp',
              data : formData,
          	  processData : false,
          	  contentType : false,
              error: function(xhr, status, error){
                  alert(error);
              },
              success : function(data){
            	  $("#ProFilePhotoUpload").submit();
            	  location.reload();
              },
          });
	 });
  });
  
$(document).ready(function(){
	 var SEQ_User = <%=SEQ_User%>;
   $("#btn").on('click',function(){
	   var state = $("input#btn").attr("class");
       if(state == "btn btn-primary")
       {    
           $.ajax({ 
           	type:'POST',
           	url:'following_success.jsp',
           	data:'key=' + SEQ_User,
              success:function(data)
              {
           	   $("#btn").attr("value","팔로우 취소");
           	   $("#btn").attr("class","btn btn-danger");
           	   console.log(SEQ_User);
              }
           }); 
       }
       else if(state == "btn btn-danger")
       {
           $.ajax({ 
           	type:'POST',
           	url:'following_cancel.jsp',
           	data:'key=' + SEQ_User,
              success:function(data)
              {
           	   $("#btn").attr("value","팔로우");
              	$("#btn").attr("class","btn btn-primary");
              	console.log(SEQ_User);
              }
           }); 
       }
   });
});

// 모달 시작

var count;
var postnum;

function openModal(n, s) {
		document.getElementById('myModal').style.display = "block";
		count = n;
		postnum = s;
		var allData = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>, "SEQ_Post": postnum };
		
		console.log(postnum);
		$.ajax({ 
           	type:'POST',
           	url:'countlike.jsp',
           	data: allData,
            success:function(data)
            {
                $('#likeCount').html(data);
            }
           });
		$.ajax({ 
           	type:'POST',
           	url:'test.jsp',
           	data: allData,
            success:function(data)
            {
                $('#likeimg').html(data);
            }
           });
		$.ajax({ 
           	type:'POST',
           	url:'textarearesult.jsp',
           	data: allData,
            success:function(data)
            {
                $('#comment').html(data);
            }
           });
		$.ajax({ 
           	type:'POST',
           	url:'Feed_Photo.jsp',
           	data: allData,
            success:function(data)
            {
                $('#result').html(data);
                $("n").html();
            }
           });		
}

function closeModal() {
	    $('#memo').val('');
	    parameter = null;
		document.getElementById('myModal').style.display = "none";
		
}

var slideIndex = 1;

showSlides(slideIndex);

function plusSlides(n) {
  	showSlides(slideIndex += n);
}

function currentSlide(n, s) {
		showSlides(slideIndex = n);
}		

function showSlides(n) {
		var i;
		var slides = document.querySelectorAll('.mySlides');
		var captionText = document.getElementById("caption");
		if (n > slides.length) {slideIndex = 1}
		if (n < 1) {slideIndex = slides.length}
		for (i = 0; i < slides.length; i++) {
  		slides[i].style.display = "none";
		}
		slides[slideIndex-1].style.display = "block";
}

window.onclick = function() {
 	var modal = document.getElementById('myModal');
	if (event.target == modal) {
		closeModal();
		slideIndex = 1;
	}
}

$(document).ready(function(){
	$("#showmap").on('click',function(){
		var allData = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>};
          $.ajax({
             success:function(data)
             {
            	 location.reload();
             }
          }); 
  });
});

$(document).ready(function(){
	$("#showfeed").on('click',function(){
		var allData = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>};
          $.ajax({
 	           type:'POST',
			   url:'showfeed.jsp',
			   data: allData,
             success:function(data)
             {
        		 $("#resultToggle").hide();
            	 $("#map").attr("id", "chmap");
            	 $('#chmap').html(data);
             }
          }); 
  });
});     

$(document).ready(function(){
	$("textarea").on('keydown',function(event){
		var str = document.getElementById("memo").value;
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
		if(parameter == null){
			var allData = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>, "SEQ_Post": postnum, "content": str };
		}else if(parameter != null){
			var allData = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>, "SEQ_Post": postnum, "content": str , "SEQ_Comment": parameter};
		}
		if(event.keyCode == 13){
			if(!event.shiftKey){
          		$.ajax({
     	       		type:'POST',
			   		url:'textarearesult.jsp',
			   		data: allData,
             		success:function(data)
             		{
            	 		$('#memo').val('');
            	 		$('#comment').html(data);
             		}
          		}); 
			}
		}
  });
});  

$(document).ready(function(){
	$("#likeimg").on('click',function(){
		var state = $("#likechange").attr("src");
		if(state == "./img/unlike.png"){
			var allDataLike = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>, "SEQ_Post": postnum };
          	$.ajax({
               type:'POST',
		       url:'LikeUpPro',
		       data: allDataLike,
             success:function(data)
             {
               $("#likechange").attr("src", "./img/like.png");
               $('#likeCount').html(data.LikeCountResult);
             }
          	});
		}else if(state == "./img/like.png"){
			var allDataLike = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>, "SEQ_Post": postnum };
			$.ajax({
		           type:'POST',
				   url:'UnLikePro',
				   data: allDataLike,
	             success:function(data)
	             {
	               $("#likechange").attr("src", "./img/unlike.png");
	               $('#likeCount').html(data.LikeCountResult);
	             }
	          });
		}
  });
});

$(document).ready(function(){
	$("#PostDelete").on('click',function(){
		var allDataLike = { "SEQ_User": <%=SEQ_My%>, "Post_owner": <%=SEQ_User%>, "SEQ_Post": postnum };
          	$.ajax({
          		type:'POST',
				url:'DeletePost',
				data: allDataLike,
             success:function(data)
             {
            	 location.reload();
             }
          	});
  });
}); 

function page(){
	if(parameter == null){
		console.log("안넘어온다.");
	}else{
		console.log("넘어온다." + parameter);
	}
		
}

</script>

    <script>
    var image = './img/pin.png';

    var locations = <%=placesDAO.get1(SEQ_User)%>


    function funct1on() {
    	  console.log(locations);
    };

    function a(){
    	  console.log(neighborhoods);
    }
    
    var markers = [];
    var map;

    var temp = 0;
    
    function initMap() {
      map = new google.maps.Map(document.getElementById('map'), {
        zoom: 11,
        center: {lat: 37.526693, lng: 126.991183}
      
      });
      
      var infowindow = new google.maps.InfoWindow({
      	
      });
      
      for (var i = 0; i < locations.length; i++) {  
	      a = new google.maps.Marker({
	    	position: new google.maps.LatLng(locations[i][0], locations[i][1]),
	        map: map,
	        icon: image
	      });
	      var temp = null;
	      google.maps.event.addListener(a, 'click', (function(a, i) {
  	        return function() {
  	          var state = $("#resultToggle").css('display');
  	          var n = locations[i][11];
  	          var m = <%=SEQ_User%>;
  	          var nm = {"Id": n, "SEQ_User":m};
  	          $.ajax({ 
	                 type:'POST',
	                 url:'ShowToggleIndiv',
	                 data: nm,
	                 success:function(data)
	                 {
 	                	 if(n != temp && state == 'none'){ // 처음
 	                		 $('#result_Name').html(data.Name);
 	                		$('#result_img').attr("src",data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		 $('#result_SaveType').html(data.SaveType);
 	                		 $('#result_FoodType').html(data.FoodType);
 	                		 $('#result_Colleague').html(data.Colleague);
 	                		$('#result_Menu').html(data.Menu);
 	                		$('#result_Tags').html(data.Tags);
 	                		 console.log("메뉴"+data.Menu);
 	                		 $("#resultToggle").show();
 	                		
 	                		 temp = n;
 	                	 }else if(n != temp && state == 'block'){ // 다른 버튼 누를때
 	                		 $('#result_Name').html(data.Name);
 	                		$('#result_img').attr("src",data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		 $('#result_SaveType').html(data.SaveType);
 	                		 $('#result_FoodType').html(data.FoodType);
 	                		 $('#result_Colleague').html(data.Colleague);
 	                		$('#result_Tags').html(data.Tags);
 	                		$('#result_Menu').html(data.Menu);
 	                		 console.log(data.Name + data.Addres);
 	                		 $("#resultToggle").show();
 	                		 temp = n;
 	                		 
 	                	 }else if(n == temp && state == 'block'){
 	                		 $('#result_Name').html(data.Name);
 	                		$('#result_img').attr("src",data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		$('#result_SaveType').html(data.SaveType);
	                		 $('#result_FoodType').html(data.FoodType);
	                		 $('#result_Colleague').html(data.Colleague);
	                		 $('#result_Menu').html(data.Menu);
	                		 $('#result_Tags').html(data.Tags);
 	                		 console.log(data.Name + data.Address);
 	                		 $("#resultToggle").hide();
 	                		 temp = n;
 	                	 }else if(n == temp && state == 'none'){
 	                		 $('#result_Name').html(data.Name);
 	                		$('#result_img').attr("src",data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		$('#result_SaveType').html(data.SaveType);
	                		 $('#result_FoodType').html(data.FoodType);
	                		 $('#result_Colleague').html(data.Colleague);
	                		 $('#result_Menu').html(data.Menu);
	                		 $('#result_Tags').html(data.Tags);
 	                		 console.log(data.Name + data.Address);
 	                		 $("#resultToggle").show();
 	                		 temp = n;
	                	 }
	                 }
	              });
  	        } 
  	      })(a, i));
  	    }
    }
    
    function qwerqwer(){
    	console.log("빨리좀");
    	console.log("빨리좀되라");
    	console.log("빨리좀1");
    	console.log("빨리좀2");
    	console.log("빨리좀3");
    	console.log("빨리좀4");
    }
    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDSMQLcRfJQUkkFrYRsCxtcM7cVoac6TIc&callback=initMap">
    </script>
</html>
