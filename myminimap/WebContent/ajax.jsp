<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>1</title>
    </head>
    <style>
#box-left {
border-left: 0;
border-right: 0;
border-top: 0;
  border-bottom :1;
  border-bottom-color: red;
  flex: 1;
}
#box-center {
  border : 0;
  border-bottom :1;
  flex: 1;
}
#box-right {
  border : 0;
  border-bottom :1;
  flex: 1;
}
</style>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
	<link rel="stylesheet" href="css/bootstrap.css">
    <body>
    <jsp:include page="header.jsp"/>    
	<% 
 		request.setCharacterEncoding("utf-8"); 
 		response.setCharacterEncoding("utf-8");
	 %>
        <div class="container">
            <input type="text" id="txtCountry" class="form-control" placeholder="enter country name">
            
            <div id="showList">
                <ul class="list-group">
                </ul>
            </div>
        </div>
        
    </body>
	<script type="text/javascript">
        $(document).ready(function(){
            $('#txtCountry').keyup(function(){
                var search=$('#txtCountry').val();
                if(search !=='' && search !==null)
                {    
                    $.ajax({ 
                       type:'POST',
                       url:'array.jsp',
                       data:'key='+search,
                       success:function(data)
                       {
                           $('#showList').html(data);
                       }
                    }); 
                }
                else
                {
                    $('#showList').html('');
                }
            });
            $(document).on('click','li',function(){
               $('#txtCountry').val($(this).text());
            });
        });
</script>
</html>

