<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="mapDTO" class="amap.amapDTO"/>
<jsp:useBean id="mapDAO" class="amap.amapDAO"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
ArrayList<String> lngList = new ArrayList<>();
ArrayList<String> latList = new ArrayList<>();
ArrayList<String> NameList = new ArrayList<>();
ArrayList<String> AddressList = new ArrayList<>();
ArrayList<String> telList = new ArrayList<>();


String id = request.getParameter("id");
int  sum=0;
int num;
int  k = mapDAO.getNum(id); //User의 SEQ_USER획득
ArrayList<Integer> Email = mapDAO.Show_Following_List(k);
//지금 Email에는 내가 Follow한 User의 SEQ_User이 들어잇음. 

for(int i = 0 ; i <Email.size(); i++){
	num = Email.get(i);
	ArrayList<String> lng = mapDAO.getLng(num);
	ArrayList<String> lat = mapDAO.getLat(num);
	ArrayList<String> Name = mapDAO.getName(num);
	ArrayList<String> Address = mapDAO.getAddress(num);
	ArrayList<String> tel = mapDAO.getTel(num);
	sum+=lng.size();	
	lngList.addAll(lng);
	latList.addAll(lat);
	NameList.addAll(Name);
	AddressList.addAll(Address);
	telList.addAll(tel);
}

out.print(sum+"/");
for(int i = 0 ; i <sum;i++)
	out.print(lngList.get(i)+"/");
for(int i = 0 ; i <sum;i++)
	out.print(latList.get(i)+"/");
for(int i = 0 ; i <sum;i++)
	out.print(NameList.get(i)+"/");
for(int i = 0 ; i <sum;i++)
	out.print(AddressList.get(i)+"/");
for(int i = 0 ; i <sum;i++)
	out.print(telList.get(i)+"/");

%>