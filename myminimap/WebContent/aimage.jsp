<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        //이미지를 저장할 경로 입력.
        String folderTypePath = application.getRealPath("/imageupload/");
        String name = new String(); //이미지이름
        String ID = new String();
        String fileName = new String();
        String POST_SEQ = new String();
        int sizeLimit = 5 * 1024 * 1024; // 5메가까지 제한 넘어서면 예외발생
        try {
            MultipartRequest multi = new MultipartRequest(request, folderTypePath, sizeLimit,
                    new DefaultFileRenamePolicy());
            Enumeration files = multi.getFileNames();
            ID = (String) multi.getParameter("ID");
            POST_SEQ = (String)multi.getParameter("POST_SEQ");
            //파일 정보가 있다면
            //String params =  URLDecoder.decode( "(String)multi.getParameter("Address")", "UTF-8");
			//System.out.println("params :"+params);
           if (files.hasMoreElements()) {              
            	name = (String) files.nextElement();
             	fileName = multi.getFilesystemName(name);
             }
            System.out.println(folderTypePath);
            System.out.println(fileName);
            System.out.println(memDAO.getSEQ_User(ID));
            System.out.println(POST_SEQ);
            
            placeDAO.Update_upload(memDAO.getSEQ_User(ID), fileName, Double.parseDouble(POST_SEQ));
            System.out.println("이미지를 저장하였습니다. : " + fileName);
        } catch (IOException e) {
            out.println("안드로이드 부터 이미지를 받아옵니다.");
   }
    %>
</body>
</html>