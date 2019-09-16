<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDAO" class="alogin.amemLogin"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<%@page import=" java.util.StringTokenizer"%>
<%


request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String id = request.getParameter("id");

String result = placeDAO.get_SEQ_Post(id);
StringTokenizer st = new StringTokenizer(result,"@/@");
Double SEQ_Post = Double.parseDouble(st.nextToken());

System.out.println("=====================");
System.out.println(SEQ_Post);
System.out.println(placeDAO.get_Address(id));
if(placeDAO.get_Tel(id).equals(""))
	System.out.println("None");
else
	System.out.println(placeDAO.get_Tel(id));
System.out.println(placeDAO.get_Name(id));
if(placeDAO.get_Image(SEQ_Post).equals(""))
	System.out.println("None");
else
System.out.println(placeDAO.get_Image(SEQ_Post));
System.out.println(placeDAO.getCheck(id));
System.out.println(placeDAO.get_saveType(id));
System.out.println(placeDAO.get_foodType(id));
System.out.println(placeDAO.get_Taste(id));
System.out.println(placeDAO.get_Colleague(id));
System.out.println(placeDAO.get_recommend(SEQ_Post));
System.out.println(placeDAO.get_Tag(SEQ_Post));
System.out.println(placeDAO.getTasteLike(id));
System.out.println(placeDAO.getTasteUnLike(id));

int like = placeDAO.getTasteLike(id);
int unlike = placeDAO.getTasteUnLike(id);
int percent = 0;
String status="like";
if(like==0)
{
	status="unlike";
	percent = 100;
}
else if(unlike==0){
	status = "like";
	percent =100;
}
	
else if (like>=unlike)
{
	status = "like";
	percent = like/(unlike+like)*100;
}
else{
	status = "unlike";
	percent = unlike/(unlike+like)*100;
}
System.out.println("status : " + status);
System.out.println("percent : " + percent);
	



out.print(placeDAO.get_Address(id)+"@/@");
if(placeDAO.get_Tel(id).equals(""))
	out.print("None@/@");
else
	out.print(placeDAO.get_Tel(id)+"@/@");
out.print(placeDAO.get_Name(id)+"@/@");
if(placeDAO.get_Image(SEQ_Post).equals(""))
	out.print("None@/@");
else
out.print(placeDAO.get_Image(SEQ_Post)+"@/@");
out.print(placeDAO.getCheck(id)+"@/@");
out.print(placeDAO.get_saveType(id)+"@/@");
out.print(placeDAO.get_foodType(id)+"@/@");
out.print(status+"@/@");
out.print(percent+"@/@");
out.print(placeDAO.get_Colleague(id)+"@/@");
out.print(placeDAO.get_recommend(SEQ_Post)+"@/@");
out.print(placeDAO.get_Tag(SEQ_Post)+"@/@");




%>