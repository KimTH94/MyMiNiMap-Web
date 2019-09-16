<%@page import="bean.MemDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import = "java.io.File" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.oreilly.servlet.*" %>
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
<jsp:setProperty name="memDTO" property="*" />
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<%
	request.setCharacterEncoding("utf-8"); 	
	response.setCharacterEncoding("utf-8");
	String directory = application.getRealPath("/profileupload/");
	int maxSize = 1024 * 1024 * 100;
	String encoding = "UTF-8";
	String email = (String)session.getAttribute("email");
	
	MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
	
	String fileName = multipartRequest.getOriginalFileName("uploadFile");
	String fileRealName = multipartRequest.getFilesystemName("uploadFile");
	
	memDAO.SaveProfilePhoto(email, fileRealName);
%>
</body>
</html>