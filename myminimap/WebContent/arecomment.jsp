<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="commentDAO" class="acomment.acommentDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");

String Email = request.getParameter("loginId");
String SEQ_Post = request.getParameter("restaurantName");
String Comment = request.getParameter("Lat");
String CommentOwner = request.getParameter("Lng");
String reComment = request.getParameter("Id");
Double seqPost,seqUser,seqOwner;
//String email = memDAO.getEmail(PostNick);
//seqUser = memDAO.getSEQ_User(SEQ_User);
//seqOwner = memDAO.getSEQ_User(email);
//seqPost = Double.parseDouble(SEQ_Owner);

//commentDAO.insert(seqPost, seqUser, seqOwner, Comment);
System.out.println(Email);
System.out.println(SEQ_Post);
System.out.println(Comment);
System.out.println(CommentOwner);
System.out.println(reComment);
//1. Nickname으로 SEQ_User 검색
//2. Email로 SEQ_User검색
//2. SEQ_Post,Comment ,SEQ_User로  SEQ_Comment 얻기
//3. SEQ_Post로 SEQ_Owner를 알아내자. Post Table에서 검색 
//4. SEQ_User , SEQ_Post,  내용 , SEQ_Owner 와 Parent에 SEQ_Comment로 추가하기 . 

Double commentOwner = memDAO.getSEQ_UserbyNickname(CommentOwner);
Double recommentOwner = memDAO.getSEQ_User(Email);
int SEQ_Comment = commentDAO.getSEQ_Comment(Double.parseDouble(SEQ_Post),commentOwner,Comment);
Double SEQ_Owner = memDAO.getSEQ_Owner(Double.parseDouble(SEQ_Post));

System.out.println(commentOwner);
System.out.println(recommentOwner);
System.out.println(SEQ_Comment);
commentDAO.recommentinsert(Double.parseDouble(SEQ_Post), recommentOwner, SEQ_Owner, reComment, SEQ_Comment);
//out.println("sdfd");
//등록하는 Email, SEQ_Post , 내용 , 댓글쓴새끼 닉넹미
//닉네임으로 SEQ_User 검색하고 SEQ_Post, 내용 , SEQ_User로 SEQ_Comment를 얻어내자
//얻어낸 SEQ_Comment를 Parent로하는 SEQ_Comment를 Email로 SEQ_User 얻어낸거 + 내용+SEQ_Post, SEQ_Post로 SEQ_Owner얻어내서  추가하자 . 


%>
