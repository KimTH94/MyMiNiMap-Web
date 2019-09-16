<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<style tpye = "text/css">
.color{ color : red; }
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	%>

    <jsp:include page="boot.jsp" />
	<jsp:include page="header.jsp" />
	<form action="loginPro.jsp" method="post">
		<div class="login-container animated fadeInDown bootstrap snippets" style="border: none;">
				<div class="loginbox-textbox" style="border: none;">
					E-Mail
					<p>
					<p>
						<input type="email" class="form-control" placeholder="Enter Email..." name="email">
				</div>
				<div class="loginbox-textbox" style="border: none;">
					Password
					<p>
					<p>
						<input type="password" class="form-control" placeholder="Enter password..."	name="password">
						<h6 class = "color">아이디와 비밀번호를 확인해 주세요.</h6>
				</div>
			<div class="loginbox-forgot" style="border: none;">
                <%-- <a href="">자동 로그인</a> 자동 로그인 구현 x --%>
            </div>
				<div class="loginbox-forgot" align = "right" style="border: none;">
                <!-- <a href="">비밀번호 찾기 </a> -->
                <a href="join.jsp"> 회원 가입</a>
            </div>
            <BR>
            <BR>
            <div>
			<center><input type="submit" class="btn btn-primary" value="로그인"></center>
			</div>
		</div>
	</form>
</body>
</html>