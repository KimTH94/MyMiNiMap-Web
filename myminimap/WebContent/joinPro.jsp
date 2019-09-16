<%@page import="bean.MemDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="javax.mail.*" %>
<%@ page import="java.util.Properties" %>
<%@ page import="bean.SHA256" %>
<%@ page import="util.Gmail" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
 request.setCharacterEncoding("utf-8"); 
 response.setCharacterEncoding("utf-8");
 String email = request.getParameter("email");
%>

<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:useBean id="memDAO" class="bean.MemDAO"/>

<%
int result = memDAO.insert(memDTO);
if(result == 1){
	session.setAttribute("email", email);
	int SEQ_User = memDAO.getSEQ_UserByEmail(email);
	session.setAttribute("SEQ_User", SEQ_User);
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("location.href = 'emailSendAction.jsp'");
	script.println("</script>");
	
	//response.sendRedirect("join_complete.jsp");
}
%>
</body>
</html>
