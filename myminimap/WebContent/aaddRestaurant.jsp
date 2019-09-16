<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<jsp:useBean id="restaurantDAO" class="arestaurant.aRestaurantDAO"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
String Name = request.getParameter("loginId");
String Address = request.getParameter("restaurantName");
String Id = request.getParameter("Lat");
String Lat = request.getParameter("Lng");
String Lng = request.getParameter("Id");

placeDAO.insertRestaurants(Name,Address,"",Id,Double.parseDouble(Lat),Double.parseDouble(Lng));
%>