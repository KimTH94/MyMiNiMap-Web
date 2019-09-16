<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">

</head>
<style type="text/css">
input.error, textarea.error{
  border:1px dashed red;
}
label.error{
  margin-left:10px;
  color:red;
}
</style>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	%>
    <jsp:include page="boot.jsp" />
	<jsp:include page="header.jsp" />
	<form action="loginPro.jsp" id="memberForm">
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
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="css/jquery.validate.min.js"></script>
<script type="text/javascript" src="css/additional-methods.min.js"></script>
<script type="text/javascript" src="css/messages_ko.min.js"></script>
</body>
<script>
$(function(){
	$("#memberForm").validate({
	    rules: {
	    	email : {
	    		required : true
	    	},
	    	password : {
	    		required : true
	    	}
	    },
	    messages: {
	    	email: {
                required: "이메일을 입력하세요"
            },
            password: {
                required: "비밀번호를 입력하세요"
            }
	    }
	})
})
</script>
</html>