<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
 request.setCharacterEncoding("UTF-8");
 String name = request.getParameter("name");
 String id = request.getParameter("id");
 
 System.out.println("�̸�:"+name+", ���̵�:"+id);
%>
<%= name %>
<%=id %>