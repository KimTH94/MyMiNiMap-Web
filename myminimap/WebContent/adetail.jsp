<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import=" java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="memDTO" class="alogin.amemLoginGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="likeDAO" class="alike.alikeDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:useBean id="commentDAO" class="acomment.acommentDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
	request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
ArrayList<String> Name = new ArrayList<>();
ArrayList<String> Nick =  new ArrayList<>();

String email = request.getParameter("id");
Double SEQ_User = memDAO.getSEQ_User(email);
ArrayList<adata.aPostUserLike> list = new ArrayList<>();
ArrayList<String> flag = new ArrayList<>();
ArrayList<String> SEQ_Postlike = new ArrayList<>();
ArrayList<String> SEQ_Userlike = new ArrayList<>();
ArrayList<String> Like_DAYlike = new ArrayList<>();
ArrayList<String> SEQ_Postcom = new ArrayList<>();
ArrayList<String> SEQ_Usercom = new ArrayList<>();
ArrayList<String> Comment_DAY = new ArrayList<>();
ArrayList<String> Image = new ArrayList<>();
SEQ_Postlike = likeDAO.getSEQ_Post(SEQ_User);
SEQ_Userlike = likeDAO.getSEQ_User1(SEQ_User);
Like_DAYlike = likeDAO.getLike_DAY(SEQ_User);
SEQ_Postcom = commentDAO.getSEQ_Post(SEQ_User);
SEQ_Usercom = commentDAO.getSEQ_User1(SEQ_User);
Comment_DAY = commentDAO.getComment_DAY(SEQ_User);
for(int i = 0 ; i < SEQ_Postlike.size();i++)
	flag.add("like");
for(int i = 0 ; i < SEQ_Postcom.size();i++)
	flag.add("comment");

//placeDAO의 getName
//memDAO의 //getNickname3


SEQ_Postlike.addAll(SEQ_Postcom);
SEQ_Userlike.addAll(SEQ_Usercom);
Like_DAYlike.addAll(Comment_DAY);

for(int i = 0 ; i<SEQ_Postlike.size();i++){
	String Id = placeDAO.get_Id(Double.parseDouble(SEQ_Postlike.get(i)));
	Image.add(placeDAO.get_Image(Double.parseDouble(SEQ_Postlike.get(i))));
	Name.add( placeDAO.get_Name(Id));
	Nick.add(memDAO.getNickname3(Double.parseDouble(SEQ_Userlike.get(i))));
}
System.out.println(Name.size());

System.out.println(Image.size());
for(int i = 0 ; i <Image.size();i++){
	if(Image.get(i).equals(""))
		Image.set(i, "default.jpg");
}
for(int i = 0 ; i < Image.size();i++)
	System.out.println(Image.get(i));


for(int i = 0 ; i<SEQ_Postlike.size();i++){
	out.print(Name.get(i)+"@/@"+Nick.get(i)+"@/@"+Like_DAYlike.get(i)+"@/@"+flag.get(i)+"@/@"+Image.get(i)+"@/@");
	System.out.println(Name.get(i)+"@/@"+Nick.get(i)+"@/@"+Like_DAYlike.get(i)+"@/@"+flag.get(i)+"@/@"+Image.get(i)+"@/@");
}
%>