<%@page import="bean.FeedDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
body {
  font-family: Verdana, sans-serif;
  margin: 0;
}

* {
  box-sizing: border-box;
}

.row > .column {
  padding: 0 8px;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

.column {
  float: left;
  width: 25%;
}

.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: 100%; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

.modal-container{
	width:70%;
	display: flex;
	height:800px;
	background-color: white;
}
.photo{
	display: flex;
	flex-grow: 3;
}
.content{
	flex-grow: 2;
	height:560px;
	flex-direction:column;
}
.header{
	padding: 10px;
	height:60px;
}
.content-content{
	height:400px;
}
.like{
	height:60px;
}
.comment{
	height:40px;
}

.close {
  color: white;
  position: absolute;
  top: 10px;
  right: 25px;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #999;
  text-decoration: none;
  cursor: pointer;
}

.mySlides {
width:100%;
height:100%;
  display: none;
}

.cursor {
  cursor: pointer;
}

.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -50px;
  color: white;
  font-weight: bold;
  font-size: 20px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
  -webkit-user-select: none;  
}

.next {
  float:rigth;
  right: 0;
  border-radius: 3px 0 0 3px;
}

.prev:hover,
.next:hover {
  background-color: rgba(0, 0, 0, 0.8);
}

.numbertext {
  color: #000000;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

.img1 {
	width: 100%;
	height: 100%;
}

.caption-container {
  text-align: center;
  background-color: black;
  padding: 2px 16px;
  color: white;
}

.demo {
  opacity: 0.6;
}

.active,
.demo:hover {
  opacity: 1;
}

img.hover-shadow {
  transition: 0.3s;
}
.hover-shadow:hover {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.small-img{
border-radius: 50%;
width: 10%;
height: 10%;
}
.mySlides {display: none}
</style>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<jsp:useBean id="feedDTO" class="bean.FeedDTO"/>
<jsp:useBean id="feedDAO" class="bean.FeedDAO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:setProperty name="feedDTO" property="*" />
<%
String path = "./imageupload/";
String i = request.getParameter("SEQ_Post");
String S_Post_owner = request.getParameter("Post_owner");
int Post_owner = Integer.parseInt(S_Post_owner);
int sum = Integer.parseInt(i);
ArrayList<FeedDTO> list123 = feedDAO.AllShowPhoto(Post_owner, sum);

int size = list123.size();
for(FeedDTO feed1 : list123){
 	%>
 	    <div class="mySlides">
		<img src=<%= path + feed1.getFileName()%>>
		</div>
<%}
	%>
</body>
<script type="text/javascript">	
var slideIndex = 1;

showSlides(slideIndex);

function plusSlides(n) {
showSlides(slideIndex += n);
}

function showSlides(n) {
		var i;
		var slides = document.querySelectorAll('.mySlides');
		if (n > slides.length) {slideIndex = 1}
		if (n < 1) {slideIndex = slides.length}
 		for (i = 0; i < slides.length; i++) {
  		slides[i].style.display = "none";
		}
		slides[slideIndex-1].style.display = "block"; 
}
</script>
</html>