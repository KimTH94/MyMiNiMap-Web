<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import=" java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<jsp:useBean id="memDTO" class="ajoin.amemGetset"/>
<jsp:useBean id="memDAO" class="ajoin.amemJoin"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:setProperty name="memDTO" property="*"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
int Food1=0,Food2=0,Food3=0,Food4=0,Food5=0,Food6=0;
int Save1 = 0 , Save2=0, Save3=0, Save4=0, Save5=0;
int Colleague1 = 0,Colleague2 = 0,Colleague3 = 0,Colleague4 = 0,Colleague5 = 0, Colleague6 = 0,Colleague7 = 0;
int saveType=0;
ArrayList<Integer> colleague,food,save;
colleague = new ArrayList<>();
food = new ArrayList<>();
save = new ArrayList<>();
String a = request.getParameter("Lat");
System.out.println(a);
String Id = request.getParameter("loginId");
//String UserEmail = request.getParameter("restaurantName");

//System.out.println(SEQ_Post);
//System.out.println(UserEmail);
System.out.println(Id);
if(a.equals("ID")){
	String name = placeDAO.get_Name(Id);
	String Address = placeDAO.get_Address(Id);
	String Tel = placeDAO.get_Tel(Id);
	if(Tel.equals(""))
		Tel = "전화번호 정보 없음";
	System.out.println(name+Address+Tel);
	String FoodTypeAll = placeDAO.get_FoodType1(Id);
	String SaveTypeAll = placeDAO.get_SaveType1(Id);
	String ColleagueAll = placeDAO.get_Colleague1(Id);
	System.out.println(FoodTypeAll);
	System.out.println(SaveTypeAll);
	System.out.println(ColleagueAll);

	
	StringTokenizer st = new StringTokenizer(FoodTypeAll,"/");
	while(st.hasMoreTokens()){
		int index= Integer.parseInt(st.nextToken());
		switch(index){
		case 1:
			Food1++;
			break;
		case 2:
			Food2++;
			break;
		case 3:
			Food3++;
			break;
		case 4:
			Food4++;
			break;
		case 5:
			Food5++;
			break;
		case 6:
			Food6++;
			break;
		}
	}
	
	st = new StringTokenizer(ColleagueAll,"/");
	while(st.hasMoreTokens()){
		int index= Integer.parseInt(st.nextToken());
		switch(index){
		case 1:
			Colleague1++;
			break;
		case 2:
			Colleague2++;
			break;
		case 3:
			Colleague3++;
			break;
		case 4:
			Colleague4++;
			break;
		case 5:
			Colleague5++;
			break;
		case 6:
			Colleague6++;
			break;
		case 7:
			Colleague7++;
			break;
		}
	}
	st = new StringTokenizer(SaveTypeAll,"/");
	while(st.hasMoreTokens()){
		int index= Integer.parseInt(st.nextToken());
		switch(index){
		case 1:
			Save1++;
			break;
		case 2:
			Save2++;
			break;
		case 3:
			Save3++;
			break;
		case 4:
			Save4++;
			break;
		case 5:
			Save5++;
			break;
		}
	}
	
	System.out.println("Food");
	System.out.println(Food1);
	System.out.println(Food2);
	System.out.println(Food3);
	System.out.println(Food4);
	System.out.println(Food5);
	System.out.println(Food6);
	food.add(Food1);
	food.add(Food2);
	food.add(Food3);
	food.add(Food4);
	food.add(Food5);
	food.add(Food6);
	
	System.out.println("Colleague");
	System.out.println(Colleague1);
	System.out.println(Colleague2);
	System.out.println(Colleague3);
	System.out.println(Colleague4);
	System.out.println(Colleague5);
	System.out.println(Colleague6);
	System.out.println(Colleague7);
	colleague.add(Colleague1);
	colleague.add(Colleague2);
	colleague.add(Colleague3);
	colleague.add(Colleague4);
	colleague.add(Colleague5);
	colleague.add(Colleague6);
	colleague.add(Colleague7);
	
	System.out.println("Save");
	System.out.println(Save1);
	System.out.println(Save2);
	System.out.println(Save3);
	System.out.println(Save4);
	System.out.println(Save5);
	save.add(Save1);
	save.add(Save2);
	save.add(Save3);
	save.add(Save4);
	save.add(Save5);
	
	Collections.sort(colleague);
	Collections.sort(save);
	Collections.sort(food);
	
	if(Save1==save.get(0)){
		saveType = 1;
	}else if(Save2==save.get(0)){
		saveType = 2;
	}else if(Save3==save.get(0)){
		saveType = 3;
	}else if(Save4==save.get(0)){
		saveType = 4;
	}else if(Save5==save.get(0)){
		saveType = 5;
	}
	
	
	
	System.out.println("SaveType : " + saveType);
	
	for(int i = 0 ; i < 5;i++)
		System.out.println(colleague.get(i));
}






else if(a.equals("SEQ")){
System.out.println("dsfadsfadsfsadfsafd");
	
	
	
	
	
	
	
}


%>	