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
						<h6 class = "color">���̵�� ��й�ȣ�� Ȯ���� �ּ���.</h6>
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
</body>
</html>