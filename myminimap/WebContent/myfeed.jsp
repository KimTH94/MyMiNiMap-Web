<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.profile_img{
 	width: 200px;
 	height: 200px;
	border-radius: 50%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:include page="header.jsp"/>
<%
String email = (String)session.getAttribute("email");
String path = "./a/";
//String path = "C:/Users/kcc94/Desktop/김태환/공부/JSP-Test/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/h_pro/upload/";
//String path = "C:/a/";
String filename = memDAO.getProfilePhotoName(email);
String img = path + filename;

out.print(session.getAttribute("nickname"));
out.print("<br>");
out.print(session.getAttribute("SEQ_User"));
out.print("<br>");
out.print(memDAO.get(email));
%>

<img class="profile_img" src="<%=img%>"/>
<input type="button" class="btn btn-primary"/>
</body>
</html>