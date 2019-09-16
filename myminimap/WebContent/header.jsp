<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/search.css">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:setProperty name="memDTO" property="*" />
<% 
	request.setCharacterEncoding("utf-8"); 
 	response.setCharacterEncoding("utf-8");
 	String email = (String)session.getAttribute("email");
 	String nickname = memDAO.getNickname2(email);
 
%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a class="navbar-brand" href="index.jsp">MyMiNi</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"	data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
			<% if (email != null) {%>
			<li class="nav-item"><a class="nav-link" href="index.jsp" style="padding-right: 10px">홈</a></li>
			<li class="nav-item"><a class="nav-link" href="Followerindex.jsp" style="padding-right: 10px">마이 맵</a></li>
			<li class="nav-item"><a class="nav-link" href="userfeed.jsp?nickname=<%=nickname%>" style="padding-right: 10px">내 피드</a></li>
			<li class="nav-item"><a class="nav-link" href="ajax.jsp" style="padding-right: 10px">사용자 검색</a></li>
			<li class="nav-item"><a class="nav-link" href="Timeline.jsp" style="padding-right: 10px">사용자 검색</a></li>
			<% } else if(email == null){%>
			<li class="nav-item"><a class="nav-link" href="index.jsp" style="padding-right: 10px">홈</a></li>
			<li class="nav-item"><a class="nav-link" href="login.jsp" style="padding-right: 10px">마이 맵</a></li>
			<li class="nav-item"><a class="nav-link" href="login.jsp" style="padding-right: 10px">내 피드</a></li>
			<li class="nav-item"><a class="nav-link" href="login.jsp" style="padding-right: 10px">사용자 검색</a></li>			
			<% } %>
		</ul>
		<!-- <input type="text" id="txtCountry" class="form-control" placeholder="enter country name"> -->
            </div>
				<div align="right" style="padding-top: 7px">
				<%
					if (email != null) {
						out.print(nickname + "님");
				%>
				<a href="member_info_pw_check.jsp"><button type="button" class="btn btn-primary">개인
						정보 수정</button></a> <a href="logout.jsp"><button type="button"
						class="btn btn-primary">로그아웃</button></a>
				<%
					} else if(email == null){
				%>
				<a href="login.jsp"><button type="button"
						class="btn btn-primary">로그인</button></a> <a href="join.jsp"><button
						type="button" class="btn btn-primary">회원가입</button></a>
				<%
					}
				%>
			</div> 
	</nav>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
        $(document).ready(function(){
            $('#txtCountry').keyup(function(){
                var search=$('#txtCountry').val();
                if(search !=='' && search !==null)
                {    
                    $.ajax({ 
                       type:'POST',
                       url:'array.jsp',
                       data:'key='+search,
                       success:function(data)
                       {
                           $('#showList').html(data);
                       }
                    }); 
                }
                else
                {
                    $('#showList').html('');
                }
            });
            $(document).on('click','li',function(){
               $('#txtCountry').val($(this).text());
            });
        });
</script>

</html>