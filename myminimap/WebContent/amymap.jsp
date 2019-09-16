<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="mapDTO" class="amap.amapDTO"/>
<jsp:useBean id="mapDAO" class="amap.amapDAO"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
int  k = mapDAO.getNum(id);

ArrayList<String> lng = mapDAO.getLng(k);
ArrayList<String> lat = mapDAO.getLat(k);
ArrayList<String> Name = mapDAO.getName(k);
ArrayList<String> Address = mapDAO.getAddress(k);
ArrayList<String> tel = mapDAO.getTel(k);

out.print(lng.size()+"/");
for(int i = 0 ; i <lng.size();i++)
out.print(lng.get(i)+"/");
for(int i = 0 ; i <lat.size();i++)
out.print(lat.get(i)+"/");
for(int i = 0 ; i <lat.size();i++)
out.print(Name.get(i)+"/");
for(int i = 0 ; i <lat.size();i++)
out.print(Address.get(i)+"/");
for(int i = 0 ; i <tel.size();i++){
	if(tel.get(i).equals(""))
		out.print(" /");
	else
		out.print(tel.get(i)+"/");
}

%>

