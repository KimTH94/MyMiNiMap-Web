<%@page import="bean.MemDTO"%>
<%@page import="bean.FeedDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
	hello
	<h3> <%= SEQ_User %></h3>
	<h5>게시물 <strong><%= CountPosts %></strong></h5>
	<h5>팔로우 <strong><%= CountFollowing %></strong></h5>
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
</body>
</html>