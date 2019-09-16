<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	%>
	<jsp:include page="boot.jsp" />
	<jsp:include page="header.jsp" />
	<form action="joinPro.jsp" method="get" onsubmit="return a();">
	<BR>
	<BR>
	<BR>
	<div class="container">
	<div class="form-row">
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">사용자 닉네임<br><input type="text" class="form-control" placeholder="닉네임"	name="nickname" id="nick123"><span id="result_nick"></span></div>
	
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">E-Mail<br><input type="email" class="form-control" placeholder="Email" name="email" id="email123"><span id="result_email"></span></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	</div>
	<div class="container">
	<div class="form-row">
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">사용자 이름<br><input type="text" class="form-control" placeholder="이름"	name="name"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">Password<br><input type="password" class="form-control" placeholder="비밀번호" name="password"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	</div>
    <div class="container">
	<div class="form-row">
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">Password Confirm<br><input type="password" class="form-control" placeholder="비밀번호확인" name="pw_confirm"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	</div>
	<BR>
	<BR>
	<BR>
	<center><input type="submit" class="btn btn-primary" value="완료"></center>
    </form>
</body>
<script type="text/javascript">

var checkNickname = 0;
var checkEmail = 0;

$(document).ready(function(){
    $('#nick123').keyup(function(){
    	var id = $('#nick123').val();
      $.ajax({ 
         type:'POST',
         url:'Check',
         data: 'id=' + id,
         success:function(data)
         {
        	 if(data.a == 1){
        		 $('#result_nick').html(data.result);
        		 checkNickname = 0;
        	 }else{
        		 $('#result_nick').html(data.result123);
        		 checkNickname = 1;
        	 }
         }
       }); 
    });
});

$(document).ready(function(){
    $('#email123').keyup(function(){
    	var email = $('#email123').val();
      $.ajax({ 
         type:'POST',
         url:'CheckE',
         data: 'email=' + email,
         success:function(data)
         {
        	 if(data.a == 1){
        		 $('#result_email').html(data.result);
        		 checkEmail = 0;
        	 }else{
        		 $('#result_email').html(data.result123);
        		 checkEmail = 1;
        	 }
         }
       }); 
    });
});

function a(){
	
	var nickname = document.forms[0].nickname.value;
	var name = document.forms[0].name.value;
	var email = document.forms[0].email.value;
	var pw = document.forms[0].password.value;
	var pw_confirm = document.forms[0].pw_confirm.value;
	
	if (nickname == null || nickname == "") {
		alert("닉네임을 입력하세요.");
		document.forms[0].nickname.focus();
		return false;
	}

	if (name == null || name == "") {
		alert("이름을 입력하세요.");
		document.forms[0].name.focus();
		return false;
	}

	if (email == null || email == "") {
		alert("E-Mail을 입력하세요.");
		document.forms[0].email.focus();
		return false;
	}

	if (pw == null || pw == "") {
		alert("비밀번호을 입력하세요.");
		document.forms[0].password.focus();
		return false;
	}
	
	if (pw_confirm == null || pw_confirm == "") {
		alert("비밀번호 확인을 해주세요.");
		document.forms[0].pw_confirm.focus();
		return false;
	}

	if (pw != pw_confirm) {
		alert("비밀번호가 일치하지 않습니다!");
		document.forms[0].pw.focus();
		return false;
	}
	
	if(checkEmail == 0){
		alert("중복된 이메일 입니다.");
		return false;
	}
	if(checkNickname == 0){
		alert("중복된 닉네임 입니다.");
		return false;
	}
	if(checkEmail == 1 && checkNickname == 0){
		return true;
	}
	return true;
}
</script>
</html>
