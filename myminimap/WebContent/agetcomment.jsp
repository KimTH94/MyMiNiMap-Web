<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="commentDAO" class="acomment.acommentDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");


String SEQ_Post = request.getParameter("loginId");//해당포스트의 번호를 받아서 double형으로 형변환을 시키고 그걸 seq_Post 에 넣어놓음. 
Double seq_Post = Double.parseDouble(SEQ_Post);
ArrayList<String> User_SEQ = commentDAO.getSEQ_User(seq_Post);
ArrayList<String> commentList = commentDAO.getComment(seq_Post);
ArrayList<String> Nick  = new ArrayList<>();

for(int i = 0 ; i  < User_SEQ.size(); i++){
	Nick.add( memDAO.getNickname1(Double.parseDouble(User_SEQ.get(i))));
}

System.out.println("SEQ_POst "+ SEQ_Post);
System.out.println("User_SEQ "+ User_SEQ.size());
for(int i = 0 ; i <User_SEQ.size();i++)
	System.out.print(User_SEQ.get(i));
System.out.println();
System.out.println("CommentList0 "+ commentList.size());
for(int i = 0 ; i <commentList.size();i++)
	System.out.print(commentList.get(i));
System.out.println();
System.out.println("Nick "+ Nick.size());
for(int i = 0 ; i <Nick.size();i++)
	System.out.print(Nick.get(i));
System.out.println();


try{
	for(int i =0 ; i < commentList.size();i++){
	out.println(Nick.get(i)+ "@/@" + commentList.get(i)+"@/@");
	System.out.println("==========================================="+Nick.get(i)+ "@/@" + commentList.get(i)+"@/@");
}}catch(Exception e){
	
}


%>