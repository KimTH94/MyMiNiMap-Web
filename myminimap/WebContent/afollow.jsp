<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");


String email = request.getParameter("first");
String myEmail = request.getParameter("second");
String type = request.getParameter("type");
String followEmail = memDAO.getEmail(email);
Double mySEQ = memDAO.getSEQ_User(myEmail);
Double followSEQ = memDAO.getSEQ_User(followEmail);

if(type.equals("unFollow")){
	System.out.println("팔로우호출");
	memDAO.Follow(mySEQ,followSEQ);
}else if(type.equals("Follow")){
	System.out.println("언팔호출");
	memDAO.unFollow(mySEQ,followSEQ);
}

System.out.println(followEmail);
System.out.println(myEmail);
System.out.println(type);
%>
 