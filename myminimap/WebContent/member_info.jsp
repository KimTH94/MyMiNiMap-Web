<%@page import="bean.MemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style>
.profile_img{
 	width: 50px;
 	height: 50px;
	border-radius: 50%;
}
.modal {
        text-align: center;
}
 
@media screen and (min-width: 768px) { 
        .modal:before {
                display: inline-block;
                vertical-align: middle;
                content: " ";
                height: 100%;
        }
}
 
.modal-dialog {
        display: inline-block;
        text-align: left;
        vertical-align: middle;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<jsp:include page="boot.jsp" />
	<jsp:include page="header.jsp" />
	<jsp:useBean id="memDTO" class="bean.MemDTO"/>
	<jsp:setProperty name="memDTO" property="*" />
	<jsp:useBean id="memDAO" class="bean.MemDAO"/>
	<%
	 request.setCharacterEncoding("utf-8");
	 response.setCharacterEncoding("utf-8");
	 String email = (String)session.getAttribute("email");
	 ArrayList<MemDTO> list = memDAO.memberInfo(email);
	 String name = null;
	 String birthday = null;
	 String tel = null;
	 String address = null;
	 String nickname = null;
	 String profile_imformation = null;
	 String nation = null;
	 String password = null;
	 for(MemDTO member : list){
			name = member.getName();
			birthday = member.getBirthday();
			tel = member.getTel();
			address = member.getAddress();
			nickname = member.getNickname();
			if(member.getProfile_imformation() == null){
				profile_imformation = member.getProfile_imformation();
			}else{
				profile_imformation = member.getProfile_imformation().replace("<br>","\r\n");
			}
			nation = member.getNation();
			password = member.getPassword();
	 }
	String path = "./upload/";
	String img = path + memDAO.getProfilePhoto(nickname);
	%>

 <form action="member_infopro.jsp" method="get">
	<div class="container">
	<div class="form-row">
		<div class ="form-group col-sm-4">
		<img src=<%= img %> class="profile_img"><input type="button" class="btn btn-link" data-toggle="modal" data-target="#myModal" value="������ ���� �ٲٱ�">
 		</div>
		<div class ="form-group col-sm-3"></div>
		<div class ="form-group col-sm-1"></div>
		<div class ="form-group col-sm-3"></div>
		<div class ="form-group col-sm-1"></div>
	</div>
	<div class="form-row">
	<div class ="form-group col-sm-3">�̸�<br><input type="text" class="form-control" placeholder="<%= name %>" value="<%= name %>" name="name">
	</div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">����� �г���<br><input type="text" class="form-control" placeholder="<%= nickname %>" value="<%= nickname %>" name="nickname"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">���� ��й�ȣ<br><input type="password" class="form-control" placeholder="<%= password %>" value="<%= password %>" name="password"></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	<div class="form-row">
	<%if(birthday == null) {%>
	<div class ="form-group col-sm-3">�������<br><input type="text" class="form-control" placeholder="Enter Birthday ..." name="birthday">
	<%} else if(birthday != null){%>
	<div class ="form-group col-sm-3">�������<br><input type="text" class="form-control" placeholder="<%= birthday %>" value="<%= birthday %>" name="birthday">
	<%} %>
	</div>
	<div class ="form-group col-sm-1"></div>
	<%if(profile_imformation == null){%>
	<!-- <div class ="form-group col-sm-3">����� ����<br><input type="textarea" class="form-control" placeholder="Enter Introduction ..."	name="profile_imformation"></div> -->
	<div class ="form-group col-sm-3">����� ����<br><textarea class="form-control" placeholder="Enter Introduction ..."	name="profile_imformation"></textarea></div>
	<%} else if(profile_imformation != null) {%>
	<%-- <div class ="form-group col-sm-3">����� ����<br><input type="textarea" class="form-control" placeholder=<%= profile_imformation %> value=<%= profile_imformation %> name="profile_imformation"></div> --%>
	<div class ="form-group col-sm-3">����� ����<br><textarea class="form-control" placeholder="<%= profile_imformation %>" value="<%= profile_imformation %>" name="profile_imformation"></textarea></div>
	<%} %>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3">���� ��й�ȣ Ȯ��<br><input type="password" class="form-control" placeholder="<%= password %>" value="<%= password %>" name="password_confirm"></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	<div class="form-row">
	<%if(tel == null) {%>
	<div class ="form-group col-sm-3">��ȭ��ȣ<br><input type="text" class="form-control" placeholder="Enter Tel ..."	name="tel">
	<%} else if(tel != null) {%>
	<div class ="form-group col-sm-3">��ȭ��ȣ<br><input type="text" class="form-control" placeholder="<%= tel %>" value="<%= tel %>" name="tel">
	<%} %>
	</div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3"></div>
	<div class ="form-group col-sm-1"></div>
	<%if( nation == null) { %>
	<div class ="form-group col-sm-3">����<br><select class="form-control" name="nation">
	<% }else if(nation != null) { %>
	<div class ="form-group col-sm-3">����<br><select class="form-control" name="nation" value="<%= nation%>">
	<% } %>
							<option value="���ѹα�">���ѹα�</option>
							<option value="�Ϻ�">�Ϻ�</option>
							<option value="�߱�">�߱�</option>
							<option value="�̱�">�̱�</option>
					</select></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	<div class="form-row">
	<%if(address == null) {%>
	<div class ="form-group col-sm-3">�ּ�<br><input type="text" class="form-control" id="sample4_roadAddress" placeholder="���θ��ּ�" readonly name="address">
	<br>
	<%} else if( address != null) {%>
	<div class ="form-group col-sm-3">�ּ�<br><input type="text" class="form-control" id="sample4_roadAddress" placeholder="<%= address %>" value= "<%= address %>" readonly name="address">
	<%} %>
	<br>
	<input type="button" class="btn btn-primary" onclick="sample4_execDaumPostcode()" value="�ּ� ã��"><br>
 <input type="hidden" id="sample4_postcode" placeholder="�����ȣ">
 <input type="hidden" id="sample4_jibunAddress" placeholder="�����ּ�">
 <span id="guide" style="color:#999;display:none"></span>
 <input type="hidden"" id="sample4_extraAddress" placeholder="�����׸�">
	</div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3"></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	<div class="form-row">
	<div class ="form-group col-sm-3">
	</div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3"></div>
	<div class ="form-group col-sm-1"></div>
	<div class ="form-group col-sm-3"></div>
	<div class ="form-group col-sm-1"></div>
	</div>
	</div>
	<center><input type="submit" class="btn btn-primary" value="�����ϱ�"></center>
	</form>
	
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title"><strong>������ ���� �ٲٱ�</strong></h4>
        </div>
        <div class="modal-header" id="PhotoUpload">
        <p style="color:#00C6ED" onclick=document.all.uploadFile.click();><strong>���� ���ε�</strong></p>
        </div>
		<div class="modal-header" id="PhotoDelete">
          <p style="color:red;"><strong>���� ���� ����</strong></p>
        </div>
        <div class="modal-header" data-dismiss="modal">
        	���
        </div>
      </div>
    </div>
  </div>
  <form id="t1">
      <input type="file" name="uploadFile" id="uploadFile"  value="���� ���ε�" style="position:absolute;visibility:hidden;" accept="image/*"/>
  </form>	
</body>
<script>
	$(document).ready(function(){
		$("#PhotoDelete").on('click',function(){
			var email = "<%= email %>"
          	$.ajax({
  	           	type:'POST',
			   	url:'PhotoDelete',
			   	data: 'email=' + email, 
             	success:function(data)
	             {
             		location.reload();
            	 }	
          	});	 
	  	});
	});

    $(document).ready(function(){
    	 $('#t1').on('change', "input#uploadFile", function (e) {
          var formData = new FormData();
          formData.append("uploadFile", $('input[name=uploadFile]')[0].files[0]);
              $.ajax({
                  type : 'post',
                  url : 'saveProfilePhoto.jsp',
                  data : formData,
              	  processData : false,
              	  contentType : false,
                  error: function(xhr, status, error){
                      alert(error);
                  },
                  success : function(data){
                	  $("#t1").submit();
                  },
              });
    	 });
      });
	
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress;
                var extraRoadAddr = '';
                if(data.bname !== '' && /[��|��|��]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(���� ���θ� �ּ� : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(���� ���� �ּ� : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</html>
