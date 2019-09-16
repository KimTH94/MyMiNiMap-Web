<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:setProperty name="memDTO" property="*" />
<%

String email = request.getParameter("email");
String UUID = request.getParameter("UUID");
int result = 0;
 
if(UUID.equals(memDAO.GetUUID(email)) == true){
	memDAO.GrantAuty(email);
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("location.href = 'join_complete.jsp'");
	script.println("</script>");
	memDAO.DeleteConfirmkey(email);
}
%>
</body>
</html>