<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="commentDAO" class="acomment.acommentDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");


String PostNick = request.getParameter("loginId");
String SEQ_User = request.getParameter("restaurantName");
String SEQ_Owner = request.getParameter("Lat");
String Comment = request.getParameter("Lng");
Double seqPost,seqUser,seqOwner;
String email = memDAO.getEmail(PostNick);
seqUser = memDAO.getSEQ_User(SEQ_User);
seqOwner = memDAO.getSEQ_User(email);
seqPost = Double.parseDouble(SEQ_Owner);

commentDAO.insert(seqPost, seqUser, seqOwner, Comment);
System.out.println(PostNick);
System.out.println(SEQ_User);
System.out.println(SEQ_Owner);
System.out.println(Comment);

out.println("sdfd");


%>