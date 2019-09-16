<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
String S_SEQ_User = request.getParameter("SEQ_User");
String S_Post_owner = request.getParameter("Post_owner");

double SEQ_User = Integer.parseInt(S_SEQ_User);
double Post_owner = Integer.parseInt(S_Post_owner);

out.print(SEQ_User);
out.print(Post_owner);
%>
</body>
</html>