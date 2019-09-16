<%@page import="java.util.ArrayList"%>
<%@page import=" java.util.StringTokenizer"%>
<%@page import=" java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
ArrayList<String> timeList = new ArrayList<>();
ArrayList<Double> SEQ_List = new ArrayList<>();
ArrayList<String> imageList = new ArrayList<>();
ArrayList<Double> PostList = new ArrayList<>();
ArrayList<Integer> likeList = new ArrayList<>();
ArrayList<String> nickList = new ArrayList<>();
ArrayList<String> profileList = new ArrayList<>();
ArrayList<String> likeState = new ArrayList<>();

String email = request.getParameter("key");
Double  SEQ_User = memDAO.getSEQ_User(email);
HashMap<String,String> map = new HashMap<>();


String Follower_SEQ = memDAO.getFollower_SEQ(SEQ_User);

System.out.print(Follower_SEQ);
StringTokenizer st = new StringTokenizer(Follower_SEQ,"/");
while(st.hasMoreTokens()){
	String returns = memDAO.getPost(Double.parseDouble(st.nextToken()));
	System.out.println("returns : " + returns);
	StringTokenizer st2 = new StringTokenizer(returns,"/");

	String stSize = st2.nextToken();
	System.out.println("Integer.valueOf(stSize)"+Integer.valueOf(stSize));
	for(int i = 0 ; i <Integer.valueOf(stSize);i++){
		String first = st2.nextToken();
		String second = st2.nextToken();
		timeList.add(first);
		System.out.println("first"+ first);
		System.out.println("second"+ second);
		PostList.add(Double.parseDouble(second));
		map.put(first,second);
	}	
}
for(int i = 0 ; i <PostList.size();i++)
	System.out.println(PostList.get(i));
timeList.sort(null);
for(int i = 0 ; i <timeList.size();i++)
	System.out.println("timeList :" + timeList.get(i));

System.out.println("사이즈"+map.size());
for(int i = 0 ; i<timeList.size();i++){
	System.out.println(map.get(timeList.get(i)));
	SEQ_List.add(Double.parseDouble(map.get(timeList.get(i))));
}

for(int i = 0 ; i<SEQ_List.size();i++){
	//if(memDAO.getfileImage(SEQ_List.get(i)).equals(""))
		imageList.add("default.jpg");
//	else
	//imageList.add(memDAO.getfileImage(SEQ_List.get(i)));
	System.out.println(imageList.get(i));
}

for(int i = 0 ; i <SEQ_List.size();i++){
	memDAO.CountLike(SEQ_List.get(i));
	likeList.add(memDAO.CountLike(SEQ_List.get(i)));
	System.out.println("count :"+likeList.get(i));
}

for(int i = 0 ; i <SEQ_List.size();i++){
	//여기서 오류임 SEQ_Post로 nick을 구할수가없음. SEQ_Post로 SEQ-User을 구해서 그걸 넣어야함 .
	
	
	memDAO.getNickname1(SEQ_List.get(i));
	nickList.add(memDAO.getNickname1(memDAO.getSEQ_UserbyPost(SEQ_List.get(i))));
	System.out.println("nick :"+nickList.get(i));
}

for(int i = 0 ; i <SEQ_List.size();i++){
	profileList.add(memDAO.get_Image(placeDAO.get_SEQUser(PostList.get(i)))); //지금 포스트 번호를 아는거라서 포스트 번호에서 그 글 쓴사람의 SEQ를 알아내서 그걸 넣어야하네 .
	System.out.println("profile :"+profileList.get(i));
}

for(int i = 0 ; i <SEQ_List.size();i++){
	memDAO.getProfile(SEQ_List.get(i));
	likeState.add(placeDAO.LikeState(SEQ_List.get(i),SEQ_User));
	System.out.println("likeState :"+likeState.get(i));
	System.out.println("SEQ_USER : " +SEQ_User + "SEQ_POst : " + SEQ_List.get(i) + "likeState : " + likeState.get(i));
}




out.print(SEQ_List.size()+"@/@");
for(int i = 0 ; i<SEQ_List.size();i++){
		out.print(nickList.get(i)+"@/@");
		out.print(likeList.get(i)+"@/@");
		out.print(profileList.get(i)+"@/@");
		out.print(imageList.get(i)+"@/@");
		out.print(PostList.get(i)+"@/@");
		out.print(likeState.get(i)+"@/@");
		
		System.out.println(nickList.get(i)+"@/@");
		System.out.println(likeList.get(i)+"@/@");
		System.out.println(profileList.get(i)+"@/@");
		System.out.println(imageList.get(i)+"@/@");
		System.out.println(PostList.get(i)+"@/@");
		System.out.println(likeState.get(i)+"@/@");
		System.out.println("====================");
	}
%>