<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/><%@page import="java.net.URLDecoder"%>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="commentDAO" class="acomment.acommentDAO"/>
<jsp:setProperty name="memDTO" property="*"/><%@page import="java.util.ArrayList"%>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");

String SEQ_Post = request.getParameter("loginId");
String Comment = request.getParameter("restaurantName");
String Nickname = request.getParameter("Lat");
Double seqPost,seqUser,seqOwner;
String decodeStr =URLDecoder.decode(Comment, "UTF-8") ;

//String email = memDAO.getEmail(PostNick);
//seqUser = memDAO.getSEQ_User(SEQ_User);
//seqOwner = memDAO.getSEQ_User(email);
//seqPost = Double.parseDouble(SEQ_Owner);

//commentDAO.insert(seqPost, seqUser, seqOwner, Comment);
System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
System.out.println(decodeStr);
System.out.println("========"+SEQ_Post);
System.out.println("========"+Comment);
System.out.println("========"+Nickname);

Double SEQ_User = memDAO.getSEQ_UserbyNickname(Nickname);
int SEQ_Comment = commentDAO.getSEQ_Comment(Double.parseDouble(SEQ_Post), SEQ_User, Comment);

ArrayList<String> seqList = new ArrayList<>();
ArrayList<String> commentList = new ArrayList<>();

seqList = commentDAO.getSEQ_UserbyParent(SEQ_Comment);
commentList = commentDAO.getreComment(SEQ_Comment);
ArrayList<String> Nick  = new ArrayList<>();

for(int i = 0 ; i  < seqList.size(); i++){
	Nick.add( memDAO.getNickname1(Double.parseDouble(seqList.get(i))));
}

System.out.println(SEQ_Comment);
System.out.println(seqList.size());
System.out.println(commentList.size());
try{
	for(int i =0 ; i < commentList.size();i++){
	out.println(Nick.get(i)+ "@/@" + commentList.get(i)+"@/@");
}}catch(Exception e){
	
}

//그 구한 SEQ_Comment와 Parent가 같은 애들만 죄다 긁어오는거지 

//SEQ_User이랑 Comment 를 싹 끍어와서 

//SEQ_User로 Nickname 얻어내고

//Nick +Comment 형식으로 전송해주고 여기선 받아서 리스트에 넣어주고 어댑터 적용시켜주면됨


%>
