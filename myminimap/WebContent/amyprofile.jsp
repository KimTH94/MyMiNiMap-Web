<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDTO" class="ajoin.amemGetset"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String nick = request.getParameter("first");
String se = request.getParameter("second");
String type = request.getParameter("type");
String nickName;
//System.out.println("nick : " +nick);
//System.out.println("second : " +se);
//System.out.println("type : " +type);

if(type.equals("My")) //내 피드에 온거임 ..!!!! 
{
	nickName = memDAO.getNickname2(nick);
	nick = nickName;
	System.out.println("11nick : " +nick);
	System.out.println("11second : " +se);
	System.out.println("11type : " +type);
	String imformation = memDAO.get(se);
	String photo = memDAO.getProfilePhoto(nick);
	//int Follower = memDAO.Count_Follower(memDAO.getSEQ_User(id));
	//System.out.println(Follower);
	
	Double follow = memDAO.getSEQ_User(se);
	
	out.print(type+"/");
	out.print(nick+"/");
	out.print(memDAO.Count_Follower(follow)+"/");
	out.print(memDAO.Count_pin(follow)+"/");
	out.print("my/");
	if(imformation!=null)
		out.print(imformation+"/");
	else
		out.print(" /");
	if(photo!=null)
		out.print(photo);
	else
		out.print("default.jpg");
	
	
	System.out.print(type+"/");
	System.out.print(nick+"/");
	System.out.print(memDAO.Count_Follower(follow)+"/");
	System.out.print(memDAO.Count_pin(follow)+"/");
	System.out.print("my/");
	if(imformation!=null)
		System.out.print("imformation/");
	else
		System.out.print(" /");
	if(photo!=null)
		System.out.print(photo);
	else
		System.out.print("default.jpg");
	
	
	
	
	
	
	System.out.println("===========");
}
else if(type.equals("Other")){//남의 피드에 온거임     22 Nick을 넘겨주면되겟네
	System.out.println("22nick : " +nick);
	System.out.println("22second : " +se);
	System.out.println("22type : " +type);
	String id = memDAO.getEmail(nick);
	System.out.println("id :" +id);
	String imformation = memDAO.get(id);
	String photo = memDAO.getProfilePhoto(nick);
	//int Follower = memDAO.Count_Follower(memDAO.getSEQ_User(id));
	//System.out.println(Follower);
	
	
	Double my = memDAO.getSEQ_User(se);
	Double follow = memDAO.getSEQ_User(id);
	boolean followState = memDAO.Following_State(follow, my);


	out.print(type+"/");
	out.print(nick+"/");
	out.print(memDAO.Count_Follower(follow)+"/");
	out.print(memDAO.Count_pin(follow)+"/");
	if(followState)
		out.print("Follow/");
	else
		out.print("unFollow/");
	if(imformation!=null)
		out.print(imformation+"/");
	else
		out.print(" /");
	if(photo!=null)
		out.print(photo);
	else
		out.print("default.jpg");
	
	
	System.out.println("******************");
	
	System.out.print(type+"/");
	System.out.print(nick+"/");
	System.out.print(memDAO.Count_Follower(follow)+"/");
	System.out.print(memDAO.Count_pin(follow)+"/");
	if(followState)
		System.out.print("Follow/");
	else
		System.out.print("unFollow/");
	if(imformation!=null)
		System.out.print("imformation/");
	else
		System.out.print(" /");
	if(photo!=null)
		System.out.print(photo);
	else
		System.out.print("default.jpg");
	System.out.println("===========");	
}
%>
