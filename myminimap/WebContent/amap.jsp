<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="mapDTO" class="amap.amapDTO"/>
<jsp:useBean id="mapDAO" class="amap.amapDAO"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String USER_EMAIL = request.getParameter("id");
Double User_SEQ = memDAO.getSEQ_User(USER_EMAIL);
System.out.println(User_SEQ);
ArrayList<String> Email = mapDAO.getEmail();
ArrayList<String> lngList = new ArrayList<>();
ArrayList<String> latList = new ArrayList<>();
ArrayList<String> NameList = new ArrayList<>();
ArrayList<String> AddressList = new ArrayList<>();
ArrayList<String> telList = new ArrayList<>();
ArrayList<String> PriceList = new ArrayList<>();
ArrayList<String> IdList = new ArrayList<>();
ArrayList<String> TasteList = new ArrayList<>();
ArrayList<String> CheckList = new ArrayList<>();
//out.print(bytes);
String id;
int sum = 0;
for(int i = 0 ; i<Email.size();i++){
	id = Email.get(i);	
	int  k = mapDAO.getNum(id);
	ArrayList<String> Id = mapDAO.getId(k);
	ArrayList<String> Taste = mapDAO.getaste(k);
	ArrayList<String> Price = mapDAO.getPrice(k);
	ArrayList<String> Check = new ArrayList<>();
	for(int j = 0 ; j < Id.size(); j++){
		Check.add(String.valueOf(placeDAO.getCheck(Id.get(j),User_SEQ)));
	}
	TasteList.addAll(Taste);
	IdList.addAll(Id);
	PriceList.addAll(Price);
	CheckList.addAll(Check);
	Check.clear();
}

for(int i = 0 ; i < IdList.size();i++){
	NameList.add(placeDAO.get_Name(IdList.get(i)));
	AddressList.add(placeDAO.get_Address(IdList.get(i)));
	telList.add(placeDAO.get_Tel(IdList.get(i)));
	latList.add(String.valueOf(placeDAO.get_lat(IdList.get(i))));
	lngList.add(String.valueOf(placeDAO.get_lng(IdList.get(i))));
}
sum = IdList.size();
System.out.println("sum : "+sum);
System.out.println("IdList.size () : "+ IdList.size());

out.print(sum+"@/@");
for(int i = 0 ; i <sum;i++)
	out.print(lngList.get(i)+"@/@");
for(int i = 0 ; i <sum;i++)
	out.print(latList.get(i)+"@/@");
for(int i = 0 ; i <sum;i++)
	out.print(NameList.get(i)+"@/@");
for(int i = 0 ; i <sum;i++)
	out.print(AddressList.get(i)+"@/@");
for(int i = 0 ; i <sum;i++){
	if(telList.get(i).equals(""))
		out.print(" @/@");
	else
		out.print(telList.get(i)+"@/@");
}
for(int i = 0 ; i <sum;i++)
	out.print(IdList.get(i)+"@/@");
for(int i = 0 ; i <sum;i++)
	out.print(PriceList.get(i)+"@/@");
for(int i = 0 ; i <sum;i++)
	out.print(TasteList.get(i)+"@/@");
for(int i = 0 ; i <sum;i++)
	out.print(CheckList.get(i)+"@/@");
//for(int i = 0 ; i<sum;i++){
//	if(telList.get(i).equals(""))
//		System.out.println("notnull");
//	else
//		System.out.println("null");
//	
//}
//System.out.println(lngList.size());
//System.out.println(latList.size());
//System.out.println(NameList.size());
//System.out.println(AddressList.size());
//System.out.println(telList.size());
//System.out.println(IdList.size());
//System.out.println(PriceList.size());
//System.out.println(TasteList.size());
//System.out.println(CheckList.size());
%>