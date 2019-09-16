<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/login.css">
<style type="text/css">
input.error, textarea.error{
  border:1px dashed red;
}
label.error{
  margin-left:10px;
  color:red;
}
</style>
</head>
<body>
	<jsp:include page="boot.jsp" />
	<jsp:include page="header.jsp" />
	<form action="member_info_pw_check_pro.jsp" method="post" id="pw_check">
	<div class="container">
	<div class="form-row">
	<div class ="form-group col-sm-4"></div>
	<div class ="form-group col-sm-4"><center><h3>비밀번호 입력</h3></center><br><input type="password" class="form-control" placeholder="Enter Password ..."	name="pw"></div>
	<div class ="form-group col-sm-4"></div>
	</div>
	</div>
	<br>
	<center><input type="submit" class="btn btn-primary" value="확인"></center>
	</form>
	<% String id = (String) session.getAttribute("email");
	%>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="css/jquery.validate.min.js"></script>
<script type="text/javascript" src="css/additional-methods.min.js"></script>
<script type="text/javascript" src="css/messages_ko.min.js"></script>
</body>
<script>
$(function(){
	
	var color_red ="red";
	
	$("#pw_check").validate({
	    rules: {
	    	pw : {
	    		required : true
	    	}
	    },
	    messages: {
            pw: {
                required: "비밀번호를 입력하세요"
            }
	    }
	})
})
</script>
</html>
