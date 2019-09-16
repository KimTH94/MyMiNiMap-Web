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
                <%-- <a href="">�ڵ� �α���</a> �ڵ� �α��� ���� x --%>
            </div>
				<div class="loginbox-forgot" align = "right" style="border: none;">
                <!-- <a href="">��й�ȣ ã�� </a> -->
                <a href="join.jsp"> ȸ�� ����</a>
            </div>
            <BR>
            <BR>
            <div>
			<center><input type="submit" class="btn btn-primary" value="�α���"></center>
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
                required: "�̸����� �Է��ϼ���"
            },
            password: {
                required: "��й�ȣ�� �Է��ϼ���"
            }
	    }
	})
})
</script>
</html>