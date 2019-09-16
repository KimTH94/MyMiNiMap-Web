<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");


String email = request.getParameter("Email");
String SEQ_Post = request.getParameter("Post_SEQ");
String types = request.getParameter("types");

System.out.println(memDAO.getSEQ_User(email));
System.out.println(SEQ_Post);
System.out.println(types);
placeDAO.getSEQ_User(Double.parseDouble(SEQ_Post));
if(types.equals("like")){
	placeDAO.LikeUp(memDAO.getSEQ_User(email),placeDAO.getSEQ_User(Double.parseDouble(SEQ_Post)),Double.parseDouble(SEQ_Post));
}
else{
	placeDAO.LikeDelete(memDAO.getSEQ_User(email),placeDAO.getSEQ_User(Double.parseDouble(SEQ_Post)),Double.parseDouble(SEQ_Post));
}

%>