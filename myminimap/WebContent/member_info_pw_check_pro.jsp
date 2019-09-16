<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<% 
 request.setCharacterEncoding("utf-8"); 
 response.setCharacterEncoding("utf-8");
 String email= (String)session.getAttribute("email"); 
 %>

<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:useBean id="memDAO" class="bean.MemDAO"/>

<%
String pw = request.getParameter("pw");
out.print(pw);
int result = memDAO.deleteMember(email, pw);
if(result == 1){	
	response.sendRedirect("member_info.jsp");
}
else{
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("history.back();");
	script.println("</script>");
}
%>
</body>
<script>
function msg(){ 
	alert("비밀번호가 일치하지 않습니다."); 
	}

</script>
</html>
