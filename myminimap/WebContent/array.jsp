<%@page import="bean.MemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/search.css">
<title>Insert title here</title>
</head>
<style>
.profile_img{
 	width: 50px;
 	height: 50px;
	border-radius: 50%;
}
</style>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:useBean id="encode" class="bean.encodeURIComponent"/>
<%
String key = request.getParameter("key");
String wild="%" +key+ "%";
String path = "./profileupload/";
ArrayList<MemDTO> list = memDAO.searchUser(wild);

for(MemDTO member : list){
	String nickname = member.getNickname();
	String encodeURI = encode.encodeURIComponent(nickname);
%>
<a href="userfeed.jsp?nickname=<%=encodeURI%>">
<li class="l-g-item">
<div style="float: left; width: 6%;"><img class="profile_img" src="<%= path + member.getFilename()%>"></div>
<div>
<%=member.getNickname() %><br><%=member.getName()%>
</div>
</li>
</a>
<%
}
%>
</body>
</html>