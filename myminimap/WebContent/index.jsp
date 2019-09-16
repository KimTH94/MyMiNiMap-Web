
   <%@page import="bean.MemDTO"%>
 <%@page import="java.util.ArrayList"%>
<%@page import="Filter.FilterDAO"%>
<%@page import="bean.PlacesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="img/KakaoTalk_20190716_195737567.png" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no" />
<style>
#foo{
width: 350px;
height: 350px;
}
#acrt_type3, #acrt_type4{
display:none;
height: 40px;
margin: 0;
padding: 5px 5px 5px 5px;
}
#sd_pic{
width:400px;
height:400px;
margin-bottom: 40px;
}
#result_img{
width: 390px;
height: 390px;
}
#rt{
width: 400px;
}
.form-row{
padding: 0px; margin: 0px;
}
*{
margin: 0px;
padding: 0px;
}
#acrt_name, #acrt_tel, #acrt_type1, #acrt_eval, #acrt_with, #acrt_price,#acrt_type2{
height: 40px;
margin: 0;
padding: 5px 5px 5px 5px;
}
#acrt_addr{
margin-top : 20px;
padding: 0;
}
#acrt_menu, #acrt_tag{
height: 60px;
margin: 0;
padding: 0;

}
#acrt_pic{
height:  360px;
margin: 0;
padding: 0;
}

#AutoCompleteResultToggle{
float: left;
width: 500px;
margin-left: 20px;
}
#resultToggle{
 display:none; 
 float:left; 
 left:-40%;
 width: 400px;
 height: 80%;
 }
 .subdata{
 
 border: 1px solid black;
 width: 25%;
 }
 #sd_pic{
 width: 430px;
 height: 350px;
 }
 .nametag{
 padding-left: 10px;
 width: 100px;
 }
.btn-sm{
height: 20px;
text-align: center;
}
.sd-name{
width: 75px;
}
.tsd-name{
width: 30%;
}
#sd-addr{
height: 60px;
}
.subdata2{
 border: 1px solid black;
 
 width: 25%;
 height: 60px;
 }

}
.sd-data{
width:300px;
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
  background-color: rgba(0,0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0); /* Black w/ opacity */
}

.modal-container{
	width:100%;
	display: flex;
	height:800px;
	background-color: white;
	margin: 0 auto;
}

.close {
  color: white;
  position: absolute;
  top: 10px;
  right: 25px;
  font-size: 35px;
  font-weight: bold;
}

.gmnoprint{
	display : none;
}
.gm-control-active.gm-fullscreen-control{
	display : block; 
}

#map {
		height: 808px;
	}

#pac-input {
	height:  40px;
	width:	95%;
	margin : 10px;
	margin-right : 100px;
	font-size: 16px;
	padding: 10px;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0; 
	}

.controls {
	background-color: #fff;
	border-radius: 2px;
	border: 1px solid transparent;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
	box-sizing: border-box;	
	font-family: Roboto;
	font-size: 15px;
	font-weight: 300;
	height: 29px;
	margin-left: 17px;
	margin-top: 10px;
	outline: none;
	padding: 0 11px 0 13px;
	text-overflow: ellipsis;
	width: 400px;
}

.controls:focus {
	border-color: #4d90fe;
}

.title {
	font-weight: bold;
}

#infowindow-content {
	display: none;

}

#map #infowindow-content {
	display: none;
}
#place-id{
	/* display:none; */
}
#place-name{
	color:#FF0000;
}
#cancel-btn{
    background-color:#BDBDBD;
	color:#FFFFFF;
}
 .wrapper {
                /* padding: 20px;
                margin: 100px auto;
                width: 400px;
                min-height: 200px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0,0,0,.1); */
                background-color: #fff;
            }
            .rating{
                overflow: hidden;
                vertical-align: bottom;
                display: inline-block;
                width: auto;
                height: 30px;
            }
            .rating > input{
                opacity: 0;
                margin-right: -100%;
            }
            .rating > label{
                position: relative;
                display: block;
                float: right;
                background: url('img/star-off-big.png');
                background-size: 30px 30px;
            }
            .rating > label:before{
                display: block;
                opacity: 0;
                content: '';
                width: 30px;
                height: 30px;
                background: url('img/star-on-big.png');
                background-size: 30px 30px;
                transition: opacity 0.2s linear;
            }
            .rating > label:hover:before,
            .rating > label:hover ~ label:before,
            .rating:not(:hover) > :checked ~ label:before{
                opacity: 1;
            }
            
#box-left {
  	flex: 1;
}
#box-center {
  	border : 0;;
  	border-bottom :1;
  	flex: 1;
}	
#box-right {
  	border : 0;
  	border-bottom :1;
  	flex: 1;
}
.modal-footer : not(.form-row){

}
#popup, #popup2
{
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: 100%; /* Enable scroll if needed */
  background-color: rgba(0,0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0); /* Black w/ opacity */
}
#popup3
{
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: 100%; /* Enable scroll if needed */
  background-color: rgba(0,0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0); /* Black w/ opacity */
}

#popmenu, #popmenu2{
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,0);
	width: 300px;
	height: 200px;
	text-align: center;
	background: #fff;
}


#popmenu3{
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,0);
	width: 300px;
	height: 200px;
	text-align: center;
	background: #fff;
}


#popmenu p{
	margin-top: 80px;
}

#popmenu2 p{
	margin-top: 80px;
}


#popmenu3 p{
	margin-top: 80px;
}
.exit{
position: absolute;
left: 50%;
transform: translate(-50%,0);
width: 60px;
height: 30px;
text-align: center;
line-height: 30px;
background: #007AAE;
cursor:pointer;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js" type="text/javascript"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"	crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="tagging/jquery.tag-editor.css">
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:useBean id="memDAO" class="bean.MemDAO"/>



<body>

<div id ="popup">
	<div id="popmenu">
	<span id ="whopost"></span>
		<div class="exit">닫기</div>
	</div>
</div>

<div id ="popup2">
	<div id="popmenu2">
	<span id ="whotag"></span>
		<div class="exit">닫기</div>
	</div>
</div>


<div id ="popup3">
	<div id="popmenu3">
	<span id ="whomenu"></span>
	
		<div class="exit">닫기</div>
	</div>
</div>




<button onclick="t1()" style="display: none;">test</button> <strong>
	<jsp:useBean id="placesDAO" class="bean.PlacesDAO"/>
	<jsp:include page="header.jsp"/>
	<input type="button" data-toggle="modal" data-target="#FilteringModal" value ="모달" id="m" style= "display:none;">
	<!-- 필터 시작 -->
<div class="modal fade" id="FilteringModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
      					<div class="modal-content">
        					<div class="modal-header">
        						<div style="text-align:center">
        							<h4><strong>필터링</strong></h4>
        						</div>
        					<button type="button" class="close" data-dismiss="modal">&times;</button>
        					</div>
        					<div class="modal-body" id="body1">
	        					<input type="text" id="searchFilter" class="form-control" placeholder="메뉴 or 태그...">
	        					<div id="filterTop" style="display: flex;">
						            <div id="box-left" class="form-control" style="border-bottom: 0; border-left: 0; border-right: 0; border-top: 0; border-radius:0;">
						            	<h5 style="color: black;"><strong>장소명</strong></h5>
						            </div>
    								<div id="box-center" class="form-control" style="border-bottom: 0; border-left: 0; border-right: 0; border-top: 0; border-radius:0;">
    									<h5 style="color: black;"><strong>추천 메뉴</strong></h5>
    								</div>
    								<div id="box-right" class="form-control" style="border-bottom: 0; border-left: 0; border-right: 0; border-top: 0; border-radius:0;">
    									<h5 style="color: black;"><strong>태 그</strong></h5>
    								</div>
            					</div>
            					<div id="showList">
                					<ul class="list-group"></ul>
            					</div>
        					</div>
        					<div class="modal-body" id="body2">
        						<div class="form-row">
        							<div class = "form-group col-sm-12">
        								<textarea id="demo2"></textarea>
        							</div>
        						</div>
        					</div>
        					<div class="modal-body" id="body3">
        						<div class="form-row">
        						<div class = "form-group col-sm-2">
        								종류 : 
        							</div>
        							<div class = "form-group col-sm-9">
        							<div class="btn-group-toggle" data-toggle="buttons">
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterSaveType" value = "1"> 음식
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterSaveType" value = "2"> 카페
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterSaveType" value = "3"> 술
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterSaveType" value = "4"> 플레이스
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterSaveType" value = "5"> 저장
										</label>
										</div>	
        							</div>
        						</div>
        					</div>
        					<div class="modal-body" id="body4">
        						<div class="form-row">
        							<div class ="form-group col-sm-2">
        							종류 : 
        							</div>
									<div class ="form-group col-sm-9">
									<div class="btn-group-toggle" data-toggle="buttons">
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterFoodType" value = "1"> 한식
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterFoodType" value = "2"> 중식
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterFoodType" value = "3"> 일식
										</label>
										<br>
										<br>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterFoodType" value = "4"> 양식
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterFoodType" value = "5"> 동남아
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterFoodType" value = "6"> 야식
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterFoodType" value ="7"> 분식
										</label>
										</div>
									</div>
								</div>
							</div>
        					<div class="modal-body" id="body5">
        						<div class="form-row">
        							<div class ="form-group col-sm-2">
        							평가 : 
        							</div>
        							<div class ="form-group col-sm-4">
        							<strong><span id="TasteRangeResult">상관 없음</span></strong>
        							</div>
									<div class ="form-group col-sm-5">
										<div class="slidecontainer">
  											<input type="range" min="0" max="10" value="1" class="slider" id="TasteRange" name = "filterTaste">
  										</div>
									</div>
								</div>
        					</div>
        					<div class="modal-body" id="body6">
        						<div class="form-row">
        							<div class ="form-group col-sm-2">
        							동행 :
        							</div>
									<div class ="form-group col-sm-9">
									<div class="btn-group-toggle" data-toggle="buttons">
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterColleague" value = "1"> 혼자
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterColleague" value = "2"> 친구
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterColleague" value = "3"> 애인
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterColleague" value = "4"> 동료
										</label>
										<label class="btn btn-warning btn-sm">
											<input type="checkbox" name = "filterColleague" value = "5"> 기타
										</label>
										</div>
									</div>
									</div>
								</div>
        					<div class="modal-body" id="body7">
        						<div class="form-row">
        							<div class ="form-group col-sm-2">
        							가격 :
        							</div>
        							<div class ="form-group col-sm-4">
        							<strong><span id="PriceRangeResult">상관 없음</span></strong>
        							</div>
        							<div class ="form-group col-sm-5">
  										<div id="DoubleRangePrice"></div>
  									</div>
        						</div>
        					</div>
        					<div class="modal-header">
        					<div class="form-row" style="float: left;">
      		  						<div class="custom-control custom-checkbox">
    									<input type="checkbox" class="custom-control-input" id="followcheckbox">
    									<label class="custom-control-label" for="followcheckbox">팔로워 내에서 검색</label>
									</div>
        						</div> 
        					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        					<button type="submit" class="btn btn-primary" id ="CompleteFilter">검색</button>
          					<button type="button" class="btn btn-default" data-dismiss="modal" id ="FilteringModalClose">Close</button>
      					</div>
      					</div>
    				</div>
    				</div>
	<!-- 필터 끝 -->
	<!-- 저장 모달 시작 -->
	<div id="AutoCompleteResultToggle" style="display:none;">
	<form name="q" method="post" enctype="multipart/form-data" onsubmit = "return UploadCheck();">
	     <input type="hidden" name="name" value="">
         <input type="hidden" name="id" value="">
         <input type="hidden" name="address" value="">
         <input type="hidden" name="tel" value="">
         <input type="hidden" name="lat" value="">
         <input type="hidden" name="lng" value="">
 		<div class="form-row" id="acrt_name">
 			<div class ="form-group col-sm-1">
 			이름
 			</div>
 			<div class ="form-group col-sm-10">
 				<strong><p id ="AutoCompleteResultToggleName"></p></strong>
 			</div>
 		</div>
 		<div class="form-row" id="acrt_pic">
 			<div class ="form-group col-sm-11" id = "FileUpload">
 				<input type="file" name="uploadFileAJAX[]" id ="Savephoto" multiple /> 
 				<img id="foo" src="#"/>
 			</div>
 		</div>
 		<div class="form-row" id="acrt_addr">
 			<div class ="form-group col-sm-1">
 			주소
 			</div>
 			<div class ="form-group col-sm-10">
 				<strong><p id="AutoCompleteResultToggleAddress"></p></strong> 
 			</div>
 		</div>
 		<div class="form-row"id="acrt_tel">
 			<div class ="form-group col-sm-1">
 			번호
 			</div>
 			<div class ="form-group col-sm-10">
 				<strong><p id="AutoCompleteResultToggleTel"></p></strong> 
 			</div>
 		</div>
 		<div class="form-row" id="acrt_type1">
 			<div class ="form-group col-sm-1">
 			<p>종류</p>
 			</div>
 			<div class ="form-group col-sm-10">
 				<div class="btn-group-toggle" data-toggle="buttons">
 					<label class="btn btn-warning btn-xs" id="123">
	 					<input type = "radio" name ="filterType" id = "Restaurant" value = "1">맛집
 					</label>
 					<label class="btn btn-warning btn-xs" id="d123">
	 					<input type = "radio" name ="filterType" id = "cafe" value = "1">카페
 					</label>
 					<label class="btn btn-warning btn-xs" id="a123">
	 					<input type = "radio" name ="filterType" id = "Drinking" value = "2">술집
 					</label>
 					<label class="btn btn-warning btn-xs" id="b123">
	 					<input type = "radio" name ="filterType" id = "Anywhere" value = "3">기타
 					</label>
 					<label class="btn btn-warning btn-xs" id="c123">
	 					<input type = "radio" name ="filterType" id = "saveit" value = "4">저장
 					</label>
 				</div>
 			</div>
 		</div>
 		<div class="form-row" id="acrt_type2">
 			<div class ="form-group col-sm-1">
 			종류
 			</div>
 			<div class ="form-group col-sm-10">
 				<div class="btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "1"> 한식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "2"> 중식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "3"> 일식
					</label>
					
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "4"> 양식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "5"> 동남아
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "6"> 야식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value ="7"> 분식
					</label>
				</div>
 			</div>
 		</div>
 		<div class="form-row" id="acrt_type3" >
 			<div class ="form-group col-sm-1">
 			종류
 			</div>
 			<div class ="form-group col-sm-10">
 				<div class="btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "8"> 테마
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "9"> 감성
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "10"> 브런치
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "11"> 애견
					</label>

				</div>
 			</div>
 		</div>
 		<div class="form-row" id="acrt_type4" >
 			<div class ="form-group col-sm-1">
 			종류
 			</div>
 			<div class ="form-group col-sm-10">
 				<div class="btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "12"> 한식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "13"> 중식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "14"> 일식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "15"> 모던바
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "16"> 와인
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="radio" name = "AutoCompleteFoodType" value = "17"> 포차
					</label>

				</div>
 			</div>
 		</div>
 		<div class="form-row" id="acrt_eval">
 			<div class ="form-group col-sm-1">
 			평가
 			</div>
 			<div class ="form-group col-sm-10">
 				<div class="btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-warning btn-sm">
						<input type="radio" name = "Recommend" value = "1"> 긍정
					</label>
					<label class="btn btn-warning btn-sm">
						<input type="radio" name = "Recommend" value = "2"> 부정
					</label>
  				</div> 
 			</div>
 		
 			<div class ="form-group col-sm-4">
 				<strong><span id="SaveTasteResult"></span></strong> 
 			</div>
 		</div>
 		<div class="form-row" id="acrt_with">
 			<div class ="form-group col-sm-1">
 			동행
 			</div>
 			<div class ="form-group col-sm-10">
 				<div class="btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-warning btn-xs">
						<input type="checkbox" name = "AutoCompleteColleague" value = "1"> 혼자
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="checkbox" name = "AutoCompleteColleague" value = "2"> 친구
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="checkbox" name = "AutoCompleteColleague" value = "3"> 연인
					</label>			
					<label class="btn btn-warning btn-xs">
						<input type="checkbox" name = "AutoCompleteColleague" value = "4"> 회식
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="checkbox" name = "AutoCompleteColleague" value = "5"> 비지니스
					</label>
					<label class="btn btn-warning btn-xs">
						<input type="checkbox" name = "AutoCompleteColleague" value = "6"> 가족
					</label>
				</div>
 			</div>
 		</div>
 		<div class="form-row" id="acrt_price">
 			<div class ="form-group col-sm-1">
 			가격
 			</div>
 			
 			<div class ="form-group col-sm-6">
 				<div class="slidecontainer">
  					<input type="range" min="1" max="5" value="2" class="slider" id="AutoCompletePriceRange" name = "filterPrice">
 				</div> 
 			</div>
 			<div class ="form-group col-sm-4">
 				<strong><span id="SavePriceResult"></span></strong> 
 			</div>
 		</div>
		<div class="form-row" id="acrt_menu">
        	<div class ="form-group col-sm-2">
        	추천 메뉴
        	</div>
			<div class ="form-group col-sm-9">
  				<textarea rows="5" cols="30" name="MenuText" placeholder="#메뉴..." id="MenuText" style="width:100%; height:50px; border:0;overflow-y:hidden;background:clear;"></textarea>
			</div>
		</div>
		<div class="form-row" id="acrt_tag">
			<div class ="form-group col-sm-2">
    		태그
        	</div>
			<div class ="form-group col-sm-5">
				<textarea rows="5" cols="30" name="TagText" placeholder="#태그..." id="TagText" style="width:100%; height:50px; border:0;overflow-y:hidden;background:clear;"></textarea>
			</div>
		</div>
		<div class="form-row" id="acrt_ok">
		<input type ="submit" class = "btn btn-primary" id = "filterSubmit" value = "저장">
		</div>
		
	 </form>
	 </div>
	</div>
	<%
	 request.setCharacterEncoding("UTF-8"); 
	 response.setCharacterEncoding("UTF-8");
	 String id = (String) session.getAttribute("email");
	%>
	<script type="text/javascript">
   function auto(){
        var infowindow = new google.maps.InfoWindow();
        var infowindowContent = document.getElementById('infowindow-content');
        infowindow.setContent(infowindowContent);
        var name =  encodeURIComponent(infowindowContent.children['place-name'].textContent);
        var id =  infowindowContent.children['place-id'].textContent;
        var address = encodeURIComponent(infowindowContent.children['place-address'].textContent);
        var tel =  infowindowContent.children['phone-number'].textContent;
        var lat = infowindowContent.children['latitude'].textContent;
        var lng = infowindowContent.children['longitude'].textContent;
        document.q.name.value=name;
        document.q.id.value=id;
        document.q.address.value=address;
        document.q.tel.value=tel;
      document.q.lat.value=lat;
      document.q.lng.value=lng;
        console.log(name);
        console.log(id);
        console.log(address);
        console.log(lat);
        console.log(lng);
        console.log(tel);
   }
 </script>
 <div id="resultToggle">


		<table id= "rt">
		<tr class="subdata">
			<td class="sd-name"></td>
			<td><p id="result_Name"></td>
		</tr>
		<div id="sd_pic">
			<img id="result_img" src="">
		</div>
		
		<tr class="subdata" id="sd-addr" >
			<td class="sd-name"><p>주소</p></td>
			<td id="sd_address"><p id="result_Address"></td>
		</tr>
		<tr  class="subdata">
			<td class="sd-name"><p>전화번호</p></td>
			<td><p id="result_Tel"></td>
		</tr>
		<tr  class="subdata">
			<td class="sd-name"><p>종류</p></td>
			<td><p id="result_SaveType"></td>
		</tr>
		<tr  class="subdata">
			<td class="sd-name" rowsapn='3'><p>종류</p></td>
			<td><p id="result_FoodType"></td>
		</tr>
		
		<tr class="subdata">
			<td class="sd-name"><p>평가</p></td>
			<td ><p id="result_Taste"></td>
		</tr>
		<tr class="subdata">
			<td class="sd-name"><p>동행</p></td>
			<td><p id="result_Colleague"></td>
		</tr>
		<tr class="subdata">
			<td class="sd-name"><p>가격</p></td>
			<td><p id="result_Price"></td>
		</tr>
		<tr class="subdata2" id="2row">
			<td class="sd-name"><p>추천메뉴</p></td>
			<td><p id="result_RecommandMenus"></p></td>
			
			
		</tr>
		<tr class="subdata2" id="2row">
			<td class="sd-name"><p>태그</p></td>
			<td><p id="result_Tags"></td>
		</tr>
		
		<tr class="subdata2" id="2row">
			<td class="sd-name"><p>저장한 사람</p></td>
			<td><p id="result_Nickname"></td>
		</tr>
		</table>
		</div>
<input id="pac-input" class="controls" type="text"
        placeholder="Enter a location">
    <div id="map"></div>
    <div id="infowindow-content" style="display:none;">
    <span id="place-id" class="spanplaceid"></span>
	Name : <span id="place-name"  class="title"></span><br><br>
    Address : <span id="place-address"></span><br><br>
    <span id="latitude" class="spanlatlng"></span>
    <span id="longitude" class="spanlatlng"></span>
    phonenumber : <span id="phone-number"></span><br><br>
      
      <!-- 전화번호 : <span id="phone-number"></span> -->
      <form action="uploadFile" name="q1" method="post" enctype="multipart/form-data">
         <input type="hidden" name="name" value="">
         <input type="hidden" name="id" value="">
         <input type="hidden" name="address" value="">
         <input type="hidden" name="tel" value="">
         <input type="hidden" name="lat" value="">
         <input type="hidden" name="lng" value="">
         <div class="form-row">
         <div class ="form-group col-sm-3">맛 :</div>
         <div class ="form-group col-sm-8"><input type="range" name="taste" class="slider" value="50" min="0" max="100" step="10"></div>
         </div>
         <div class="form-row">
         <div class ="form-group col-sm-4"></div>
         <div class ="form-group col-sm-4"><div class = "result"></div></div>
         <div class ="form-group col-sm-4"></div>
         </div>
         <div class="form-row">
         <div class ="form-group col-sm-3">분위기 :</div>
         <div class ="form-group col-sm-8"><input type="range" class="slider" name ="mood" value="50" min="0" max="100" step="10"></div>
         </div>
         <div class="form-row">
         <div class ="form-group col-sm-3">가격 :</div>
         <div class ="form-group col-sm-8"><input type="range" class="slider" name ="price"value="50" min="0" max="100" step="10"></div>
         </div>
         <div class="form-row">
         <input type="file" name="uploadFile[]" multiple />
         <center><input type="button" id="cancel-btn"class="btn btn-default" value="취소" onclick="auto()"/>
         <%if (id != null){ %>
         <input type="submit" class="btn btn-primary" value="저장하기" onclick="auto()"/>
         <% } else if(id == null){%>
         <input type="button" class="btn btn-primary" value="저장하기" onclick="auto1()"/>
         <% }%>
         </center>
		</form>
</div>
  </body>
  <script type="text/javascript" src="js/jquery-ui.js"></script>
  <script type="text/javascript" src="js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="tagging/jquery.caret.min.js"></script>
  <script type="text/javascript" src="tagging/jquery.tag-editor.js"></script>
  <script src="css/bootstrap-suggest.min.js"></script>
  <script src="css/bootstrap-suggest.js"></script>
  
  <script type="text/javascript">
  function readURL(input){
	  if(input.files && input.files[0]) {
		  var reader = new FileReader();
		  reader.onload = function(e){
			  $('#foo').attr('src',e.target.result);
		  }
		  reader.readAsDataURL(input.files[0]);
	  }
  }
  $('#Savephoto').change(function(){
	  readURL(this);
  });
  function auto1(){
	  alert("로그인이 필요합니다.");
	  location.href="login.jsp";
	  }
  
  $("#result_Nickname").click(function(){
	  test();
	  //alert(test1);
  });
  $("#result_Tags").click(function(){
	  showTag();
	  //alert(test1);
  });
  $("#result_RecommandMenus").click(function(){
	  Menu();
	  //alert(test1);
  });
  </script>
  <script>
  
	 $('#c123').click(function(){
    	 $('#acrt_type2').hide();
    	 $('#acrt_eval').hide();
    	 $('#acrt_with').hide();
    	 $('#acrt_price').hide();
    	 $('#acrt_menu').hide();
    	 $('#acrt_tag').hide();
    	 
    	 console.log("왜안돼");
     });
function t1(){
	

	
	console.log(test1);
/*	  var bounds =new google.maps.LatLngBounds();
	  //var literal =  new google.maps.LatLngLiteral();
	 
	  console.log("boounds = "+bounds);
	  var swLatLng = bounds.getSouthWest();
	  var neLatLng = bounds.getNorthEast(); 
	  var getcenter = bounds.getCenter();
	  console.log("center"+getcenter);
	  console.log("swLatLng"+swLatLng);
	  console.log("neLatLng"+neLatLng);*/
}
   var Tid = null;
   var seq_user = <%=session.getAttribute("SEQ_User")%>;
   console.log("seq_user :"+seq_user);

	  var image = './img/pin.png';
      function CenterControl(controlDiv, map) {

          var controlUI = document.createElement('div');
          controlUI.style.backgroundColor = '#fff';
          controlUI.style.border = '2px solid #fff';
          controlUI.style.borderRadius = '3px';
          controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
          controlUI.style.cursor = 'pointer';
          controlUI.style.marginTop = '13px';
          controlUI.style.marginRight = '9px';
          controlUI.style.marginBottom = '22px';
          controlUI.style.textAlign = 'center';
          controlUI.title = 'Use Filter';
          controlUI.id='filtering-butt';
          controlDiv.appendChild(controlUI);

          var controlText = document.createElement('div');
          controlText.style.color = 'rgb(25,25,25)';
          controlText.style.fontFamily = 'Roboto,Arial,sans-serif';
          controlText.style.fontSize = '16px';
          controlText.style.lineHeight = '38px';
          controlText.style.paddingLeft = '5px';
          controlText.style.paddingRight = '5px';
          controlText.innerHTML = "<img class = 'filtimag' src='img/filter.png'>"
          controlUI.appendChild(controlText);

          controlUI.addEventListener('click', function() {
            	$.ajax({
             	success:function(data)
                 {
             		$("#m").trigger("click");
            	 }	
          	});	 
          });
      }
      
      var image = './img/pin.png';
      var blank = './img/blank.png';
      
      var locations = <%=placesDAO.get2()%>;
      console.log(locations);
      var test1 = <%=placesDAO.getPoster()%>;
      


      
	  var b = <%=session.getAttribute("SEQ_User")%>;

      
      if (b == null) {
    	  console.log(b);
    	  $('#result_Nickname').hide();

      } else {
    	  
    	  console.log(b);
      }

      //세션 유무
      var markers = [];
      var map;
      
      

      var temp = 0;
      

      function test(){
    	  
    	  console.log("노는게 제일 좋아: " + Tid);
    	  var allData = {"Id": Tid};
    	  
          $.ajax({ 
              type:'POST',
              url:'ddd',
              data:allData,
              success:function(data)
              {
            	  console.log("이거 : " + data.a123);
                  $('#whopost').html(data.a123);
                  $('#popmenu').show();
              }
           }); 

	$('#popup').show();
	
      }
      $(".exit").click(function(){
    	  $("#popup").hide();
      });
      
	function showTag(){
    	  
    	  console.log("노는게 제일 좋아: " + Tid);
    	  var allData = {"Id": Tid};
    	  
          $.ajax({ 
              type:'POST',
              url:'Tagsddd',
              data:allData,
              success:function(data)
              {
            	  console.log("태그 : " + data.Tags);
                  $('#whotag').html(data.Tags);
                  $('#popmenu2').show();
              }
           }); 

	$('#popup2').show();
	
      }
      $(".exit").click(function(){
    	  $("#popup2").hide();
      });
	function Menu(){
    		  
    		  console.log("노는게 제일 좋아: " + Tid);
    	  	var allData = {"Id": Tid};
    	  
         	 $.ajax({ 
         	     type:'POST',
         	     url:'Menuddd',
         	     data:allData,
         	     success:function(data)
         	     {
         	   	  console.log("Menu : " + data.Menu);
         	         $('#whomenu').html(data.Menu);
         	         $('#popmenu3').show();
         	     }
         	  }); 

		$('#popup3').show();
		
	      }
	      $(".exit").click(function(){
	    	  $("#popup3").hide();
	      });
      
      function initMap() {
    	  var seoul = {lat: 37.553870, lng: 126.969566};
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 37.553870, lng: 126.969566},
          zoom: 12
        });
        
        var labels = 'ABC';
		var infowindow = new google.maps.InfoWindow({
          	
        });
        
        //addMarker(swLatLng, neLatLng);
       var a;
       
       map.addListener('click', function(event) {
           addMarker(event.latLng);
         });

         // Adds a marker at the center of the map.
         addMarker(seoul);
         
        
       
       function addMarker(location) {
       for (var i = 0; i < locations.length; i++) {  
 	      var marker = new google.maps.Marker({
 	    	position: new google.maps.LatLng(locations[i][0], locations[i][1]),
 	        map: map,
 	        icon: image,
// 	        label: labels[i % labels.length]
 	      });
 	      
 	
 	      var temp = null;
 	      
 	      
 	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
   	        return function () {
   	        	
   	        	
   	        	
   	        	$("#AutoCompleteResultToggle").css("display","none");
   	          var state = $("#resultToggle").css('display');
   	          var n = locations[i][4];
   	         console.log(n);
   	      
   	          $.ajax({ 
 	                 type:'POST',
 	                 url:'Toggle',
 	                 data:'key=' + n,
 	                 success:function(data)
 	                 {
 	                	 if(n != temp && state == 'none'){ // 처음
 	                		 $('#result_Name').html(data.Name);
 	                	 	 $('#result_img').attr("src",data.file);
 	                	 	 console.log(data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		 $('#result_SaveType').html(data.SaveType);
 	                		 $('#result_FoodType').html(data.FoodType);
 	                		 $('#result_Colleague').html(data.Colleague);
 	                		$('#result_RecommandMenus').html(data.recommendMenu);
 	                		$('#result_Tags').html(data.Tags);
  	                		 $('#result_Nickname').html(data.Count);
  	                		 Tid = n;

  	                		console.log(data.Name + data.Address + data.Nickname);
  	                		console.log("id : " + Tid)
  	                		
 	                		 $("#resultToggle").show();
 	                		
 	                		 temp = n;
 	                	 }else if(n != temp && state == 'block'){ // 다른 버튼 누를때
 	                		 $('#result_Name').html(data.Name);
 	                		$('#result_img').attr("src",data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		 $('#result_SaveType').html(data.SaveType);
 	                		 $('#result_FoodType').html(data.FoodType);
 	                		 $('#result_Colleague').html(data.Colleague);
 	                		$('#result_RecommandMenus').html(data.recommendMenu);
 	                		$('#result_Tags').html(data.Tags);
 	                		$('#result_Nickname').html(data.Count);
 	                		 console.log(data.Name + data.Addres);
 	                		 $("#resultToggle").show();
 	                		Tid = n;
 	                		 temp = n;
 	                	 }else if(n == temp && state == 'block'){
 	                		 $('#result_Name').html(data.Name);
 	                		$('#result_img').attr("src",data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		$('#result_SaveType').html(data.SaveType);
	                		 $('#result_FoodType').html(data.FoodType);
	                		 $('#result_Colleague').html(data.Colleague);
	                		 $('#result_RecommandMenus').html(data.recommendMenu);
	                		 $('#result_Tags').html(data.Tags);
	                		 $('#result_Nickname').html(data.Nickname);
 	                		 console.log(data.Name + data.Address);
 	                		 $("#resultToggle").hide();
 	                		Tid = n;
 	                		 temp = n;
 	                	 }else if(n == temp && state == 'none'){
 	                		 $('#result_Name').html(data.Name);
 	                		$('#result_img').attr("src",data.file);
 	                		 $('#result_Address').html(data.Address);
 	                		 $('#result_Tel').html(data.Tel);
 	                		 $('#result_Price').html(data.Price);
 	                		 $('#result_Taste').html(data.Taste);
 	                		 $('#result_Mood').html(data.Mood);
 	                		$('#result_SaveType').html(data.SaveType);
	                		 $('#result_FoodType').html(data.FoodType);
	                		 $('#result_Colleague').html(data.Colleague);
	                		 $('#result_RecommandMenus').html(data.recommendMenu);
	                		 $('#result_Tags').html(data.Tags);
	                		 $('#result_Nickname').html(data.Nickname);
 	                		 console.log(data.Name + data.Address);
 	                		 $("#resultToggle").show();
 	                		Tid = n;
 	                		 temp = n;
 	                	 }
 	                	
 	                 }
 	              });
   	          
   	        } 
   	      })(marker, i));
 	      
 	      //console.log(Tid)
 	      	     
 	     $( "#pac-input" ).click(function() {
 	    	  $("#resultToggle").css("display","none");
 	    	});
 	    markers.push(marker);
   	    } //
      }

        var centerControlDiv = document.createElement('div');
        var centerControl = new CenterControl(centerControlDiv, map);

        centerControlDiv.index = 1;
        map.controls[google.maps.ControlPosition.TOP_RIGHT].push(centerControlDiv);
        
        
        infoWindow = new google.maps.InfoWindow;
       
        var input = document.getElementById('pac-input');	
        
        $("#CompleteFilter").click(function(){
        	clearMarkers();
        });
        
        var options = {
        		types: ['establishment']
		};

        var autocomplete = new google.maps.places.Autocomplete(input, options);
        
        autocomplete.bindTo('bounds', map);

        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
        

        var infowindow = new google.maps.InfoWindow();
        var infowindowContent = document.getElementById('infowindow-content');
        infowindow.setContent(infowindowContent);
        
        var marker = new google.maps.Marker({
          map: map
        });
        
        console.log("버튼 클릭 시작");
        marker.addListener('click', function() {
            var state = $("#AutoCompleteResultToggle").css('display');
            if(state == 'block'){
          	  $("#AutoCompleteResultToggle").hide();
            }else if(state == 'none'){
          	  $("#resultToggle").css("display","none");
          	  $("#AutoCompleteResultToggle").show();
            }
          });
        console.log("버튼 클릭 종료");
        autocomplete.addListener('place_changed', function() {
          infowindow.close();
          clearMarkers();
          var place = autocomplete.getPlace();
          if (!place.geometry) {
            return;
          }

          if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
          } else {
            map.setCenter(place.geometry.location);
            map.setZoom(17);
          }

          // Set the position of the marker using the place ID and location.
          marker.setPlace({
            placeId: place.place_id,
            location: place.geometry.location,
          });
          
          marker.setVisible(true);

		  infowindowContent.children['place-id'].textContent = place.place_id;
          infowindowContent.children['place-name'].textContent = place.name;
          infowindowContent.children['place-address'].textContent =place.formatted_address;
       	  infowindowContent.children['latitude'].textContent = place.geometry.location.lat();
       	  infowindowContent.children['longitude'].textContent = place.geometry.location.lng();
       	  infowindowContent.children['phone-number'].textContent = place.formatted_phone_number;
       
          /* infowindow.open(map, marker); */
          
          $("#AutoCompleteResultToggle").show();
          $('#AutoCompleteResultToggleName').html(place.name);
          $('#AutoCompleteResultToggleAddress').html(place.formatted_address);
          $('#AutoCompleteResultToggleTel').html(place.formatted_phone_number);
        });
        function setMapOnAll(map) {
            for (var i = 0; i < markers.length; i++) {
              markers[i].setMap(map);     
              
              }
          }
        function clearMarkers() {
            setMapOnAll(null);
          }

          // Shows any markers currently in the array.
        function showMarkers() {
            setMapOnAll(map);
          }
        
        $("#filterTop").hide();
        
        $(document).ready(function(){
            $('#searchFilter').focus(function() {
            	$("#filterTop").show();
            	$("#body2").hide();
            	$("#body3").hide();
            	$("#body4").hide();
            	$("#body5").hide();
            	$("#body6").hide();
            });
        });
        
        var l1 =1;
        var l2 =0;
        var l3 =0;
        
        
        $("#box-left").click(function(){
        	l1 = 1;
        	l2 = 0;
        	l3 = 0;
        	$('#searchFilter').val("");
        	$("#showList").empty();
        });
        
        $("#box-center").click(function(){
        	l1 = 0;
        	l2 = 1;
        	l3 = 0;
        	$('#searchFilter').val("");
        	$("#showList").empty();
        });
        
        $("#box-right").click(function(){
        	l1 = 0;
        	l2 = 0;
        	l3 = 1;
        	$('#searchFilter').val("");
        	$("#showList").empty();
        });
        
        $(document).ready(function(){
            $('#searchFilter').keyup(function(){
            	$("#showList").show();
                var search=$('#searchFilter').val();
                var allData = { "word": search, "param1": l1, "param2" : l2, "param3" : l3};
                if(search !=='' && search !==null)
                {    
                    $.ajax({ 
                       type:'POST',
                       url:'SearchPro',
                       data:allData,
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
               $('#searchFilter').val("");
               $("#filterTop").hide();
               $("#showList").empty();
               $("#body2").show();
           	   $("#body3").show();
           	   $("#body4").show();
           	   $("#body5").show();
           	   $("#body6").show();
               $('#demo2').tagEditor('addTag', $(this).text());
            });
        });
        
        $('#demo2').tagEditor({
            maxTags: 5
        });
 		
 		//검색실행
 		
 		 $(document).ready(function(){
 			$("#CompleteFilter").on('click',function(){
 				
 				var FColleagueList = [];
 			    var FFoodList = [];
 			    var FSaveList = [];
 			    
 				var FMenu = $("#demo2").val();
 				var FTaste = $("#TasteRange").val();
 				var FPrice1 = filterPrice1;
 				var FPrice2 = filterPrice2;
 				
 				$("input[name=filterFoodType]:checked").each(function(){
 					FFoodList.push($(this).val());
 				});
 				$("input[name=filterColleague]:checked").each(function(){
 					FColleagueList.push($(this).val());
				});
 				$("input[name=filterSaveType]:checked").each(function(){
 					FSaveList.push($(this).val());
 				});
 				
 				var filterFollower = $('input:checkbox[id="followcheckbox"]').is(":checked"); 
 				var allData = { "Menu": FMenu, "Taste": FTaste, "Price1" : FPrice1, "Price2" : FPrice2, "FoodList" : FFoodList, "Colleague" : FColleagueList, "Follow" : filterFollower, "SaveList" : FSaveList};
 		          $.ajax({
 		 	           type:'POST',
 					   url:'FilterPro',
 					   data: allData,
 		             success:function(data)
 		             {
 		            	var arr1 = data.a;
 		            	size = data.size;
 		            	console.log("length : " + arr1.length);
 		            	console.log("size : " + size);
 		            	var array = [];
 		            	for(var x = 0 ; x < size; x++){
 		            		array[x] = [];
 		            	}
 		            	for(var i = 0 ; i < size; i++){
 		            		arr1[i] = arr1[i].replace(/\"/gi, "");
 		            		arr1[i] = arr1[i].substring(1);
 		            		arr1[i] = arr1[i].slice(0,-1);
 		            		console.log("arr1[" + i + "] = " +arr1[i]);
 		            		var arr2 = arr1[i].split(',');
 		            		console.log("arr2[0] : " + arr2[0]);
 		            		console.log("arr2[1] : " + arr2[1]);
 		            		console.log("arr2[2] : " + arr2[2]);
 		            		for(var j = 0 ; j < size; j++){
 		            			array[i][j] = arr2[j];
 		            		}	
 		            	}

 		            	console.log(array);
 		            	AddMarker(array);
 		             }
 		          }); 
 		  });
 		});     
      }

       function AddMarker(array) {          
    	  for (var i = 0; i < 100; i++) {
    	      var v = new google.maps.Marker({
    	    	position: new google.maps.LatLng(array[i][0], array[i][1]),
    	        map: map,
    	        icon: image
    	      });
    	   	
     	      var temp = null;
     	      google.maps.event.addListener(v, 'click', (function(v, i) {
       	        return function () {
       	        	
       	        	
       	        	$("#AutoCompleteResultToggle").css("display","none");
       	          var state = $("#resultToggle").css('display');
       	          var n = locations[i][4];
       	      
       	          $.ajax({ 
     	                 type:'POST',
     	                 url:'Toggle',
     	                 data:'key=' + n,
     	                 success:function(data)
     	                 {
     	                	 if(n != temp && state == 'none'){ // 처음
     	                		 $('#result_Name').html(data.Name);
     	                	 
     	                		$('#result_img').attr("src",data.file);
     	                		 $('#result_Address').html(data.Address);
     	                		 $('#result_Tel').html(data.Tel);
     	                		 $('#result_Price').html(data.Price);
     	                		 $('#result_Taste').html(data.Taste);
     	                		 $('#result_Mood').html(data.Mood);
     	                		 $('#result_SaveType').html(data.SaveType);
     	                		 $('#result_FoodType').html(data.FoodType);
     	                		 $('#result_Colleague').html(data.Colleague);
     	                		$('#result_RecommandMenus').html(data.recommendMenu);
     	                		$('#result_Tags').html(data.Tags);
      	                		$('#result_Nickname').html(data.Nickname + data.Count);

      	                		console.log(123);
     	                		 $("#resultToggle").show();
     	                		
     	                		 temp = n;
     	                	 }else if(n != temp && state == 'block'){ // 다른 버튼 누를때
     	                		 $('#result_Name').html(data.Name);
     	                		$('#result_img').attr("src",data.file);
     	                		 $('#result_Address').html(data.Address);
     	                		 $('#result_Tel').html(data.Tel);
     	                		 $('#result_Price').html(data.Price);
     	                		 $('#result_Taste').html(data.Taste);
     	                		 $('#result_Mood').html(data.Mood);
     	                		 $('#result_SaveType').html(data.SaveType);
     	                		 $('#result_FoodType').html(data.FoodType);
     	                		 $('#result_Colleague').html(data.Colleague);
     	                		$('#result_RecommandMenus').html(data.recommendMenu);
     	                		$('#result_Tags').html(data.Tags);
     	                		$('#result_Nickname').html(data.Nickname + data.Count);
     	                		 console.log(data.Name + data.Addres);
     	                		 $("#resultToggle").show();
     	                		 temp = n;
     	                	 }else if(n == temp && state == 'block'){
     	                		 $('#result_Name').html(data.Name);
     	                		 
     	                		$('#result_img').attr("src",data.file);
     	                		 $('#result_Address').html(data.Address);
     	                		 $('#result_Tel').html(data.Tel);
     	                		 $('#result_Price').html(data.Price);
     	                		 $('#result_Taste').html(data.Taste);
     	                		 $('#result_Mood').html(data.Mood);
     	                		$('#result_SaveType').html(data.SaveType);
    	                		 $('#result_FoodType').html(data.FoodType);
    	                		 $('#result_Colleague').html(data.Colleague);
    	                		 $('#result_RecommandMenus').html(data.recommendMenu);
    	                		 $('#result_Tags').html(data.Tags);
    	                		 $('#result_Nickname').html(data.Nickname);
     	                		 console.log(data.Name + data.Address);
     	                		 $("#resultToggle").hide();
     	                		 temp = n;
     	                	 }else if(n == temp && state == 'none'){
     	                		 $('#result_Name').html(data.Name);
     	                		$('#result_img').attr("src",data.file);
     	                		 $('#result_Address').html(data.Address);
     	                		 $('#result_Tel').html(data.Tel);
     	                		 $('#result_Price').html(data.Price);
     	                		 $('#result_Taste').html(data.Taste);
     	                		 $('#result_Mood').html(data.Mood);
     	                		$('#result_SaveType').html(data.SaveType);
    	                		 $('#result_FoodType').html(data.FoodType);
    	                		 $('#result_Colleague').html(data.Colleague);
    	                		 $('#result_RecommandMenus').html(data.recommendMenu);
    	                		 $('#result_Tags').html(data.Tags);
    	                		 $('#result_Nickname').html(data.Nickname);
     	                		 console.log(data.Name + data.Address);
     	                		 $("#resultToggle").show();
     	                		 temp = n;
     	                	 }
     	                 }
     	              });
       	          
       	        } 
       	      })(v, i));
    	      
    	      
    	  }
      }
       
       
       $(".slider").change(function(){
         if(0 <= $(".slider").val() && $(".slider").val() <= 25){
       	  $(".result").text( "다시는 가고 싶지 않아요." );
         }else if(25 < $(".slider").val() && $(".slider").val() <= 50){
       	  $(".result").text( "가볼만 했어요." );
         }else if(50 < $(".slider").val() && $(".slider").val() <= 75){
       	  $(".result").text( "추천 할 만해요." );
         }else{
       	  $(".result").text( "또 가고싶어요" );
         }
       });
       

       $("#TasteRange").change(function(){
         if(0 <= $("#TasteRange").val() && $("#TasteRange").val() <= 1){
       	  $("#TasteRangeResult").text( "상관 없음" );
         }else if(1 < $("#TasteRange").val() && $("#TasteRange").val() <= 2){
       	  $("#TasteRangeResult").text( "10% 이상" );
         }else if(2 < $("#TasteRange").val() && $("#TasteRange").val() <= 3){
       	  $("#TasteRangeResult").text( "20% 이상" );
         }else if(3 < $("#TasteRange").val() && $("#TasteRange").val() <= 4){
       	  $("#TasteRangeResult").text( "30% 이상" );
         }else if(4 < $("#TasteRange").val() && $("#TasteRange").val() <= 5){
       	  $("#TasteRangeResult").text( "40% 이상" );
         }else if(5 < $("#TasteRange").val() && $("#TasteRange").val() <= 6){
       	  $("#TasteRangeResult").text( "50% 이상" );
         }else if(6 < $("#TasteRange").val() && $("#TasteRange").val() <= 7){
       	  $("#TasteRangeResult").text( "60% 이상" );
         }else if(7 < $("#TasteRange").val() && $("#TasteRange").val() <= 8){
       	  $("#TasteRangeResult").text( "70% 이상" );
         }else if(8 < $("#TasteRange").val() && $("#TasteRange").val() <= 9){
       	  $("#TasteRangeResult").text( "80% 이상" );
         }else if(9 < $("#TasteRange").val() && $("#TasteRange").val() <= 10){
       	  $("#TasteRangeResult").text( "90% 이상" );
         }
       });
       
       $("#PriceRange").change(function(){
         if(0 <= $("#PriceRange").val() && $("#PriceRange").val() <= 1){
       	  $("#PriceRangeResult").text( "1만원 이하" );
         }else if(1 < $("#PriceRange").val() && $("#PriceRange").val() <= 2){
       	  $("#PriceRangeResult").text( "3만원 이하" );
         }else if(2 < $("#PriceRange").val() && $("#PriceRange").val() <= 3){
       	  $("#PriceRangeResult").text( "5만원 이하" );
         }else if((3 < $("#PriceRange").val() && $("#PriceRange").val() <= 4)){
       	  $("#PriceRangeResult").text( "7만원 이하" );
         }else if((4 < $("#PriceRange").val() && $("#PriceRange").val() <= 5)){
         	$("#PriceRangeResult").text( "10만원 이상" );
         }
       });
       
       $("#AutoCompleteTasteRange").change(function(){
         if(0 <=  $("#AutoCompleteTasteRange").val() &&  $("#AutoCompleteTasteRange").val() <= 1){
       	  $("#SaveTasteResult").text( "가고 싶지 않아요." );
         }else if(1 < $("#AutoCompleteTasteRange").val() &&  $("#AutoCompleteTasteRange").val() <= 2){
       	  $("#SaveTasteResult").text( "가볼만 했어요." );
         }else if(2 < $("#AutoCompleteTasteRange").val() &&  $("#AutoCompleteTasteRange").val() <= 3){
       	  $("#SaveTasteResult").text( "추천 할 만해요." );
         }else if(3 < $("#AutoCompleteTasteRange").val() &&  $("#AutoCompleteTasteRange").val() <= 4){
       	  $("#SaveTasteResult").text( "또 가고싶어요" );
         }
       });
       
       $("#AutoCompletePriceRange").change(function(){
         if(0 <= $("#AutoCompletePriceRange").val() && $("#AutoCompletePriceRange").val() <= 1){
       	  $("#SavePriceResult").text( "1만원 이하" );
         }else if(1 < $("#AutoCompletePriceRange").val() && $("#AutoCompletePriceRange").val() <= 2){
       	  $("#SavePriceResult").text( "3만원 이하" );
         }else if(2 < $("#AutoCompletePriceRange").val() && $("#AutoCompletePriceRange").val() <= 3){
       	  $("#SavePriceResult").text( "5만원 이하" );
         }else if(3 < $("#AutoCompletePriceRange").val() && $("#AutoCompletePriceRange").val() <= 4){
       	  $("#SavePriceResult").text( "7만원 이하" );
         }else if(4 < $("#AutoCompletePriceRange").val() && $("#AutoCompletePriceRange").val() <= 5){
         	$("#SavePriceResult").text( "10만원 이상" );
         }
       });
       
       $("#likeRange").change(function(){
         if(0 <= $("#likeRange").val() && $("#likeRange").val() <= 1){
       	  $("#likeRangeResult").text( "상관 없음" );
         }else if(1 < $("#likeRange").val() && $("#likeRange").val() <= 2){
       	  $("#likeRangeResult").text( "100개 이상" );
         }else if(2 < $("#likeRange").val() && $("#likeRange").val() <= 3){
       	  $("#likeRangeResult").text( "300개 이상" );
         }else if(3 < $("#likeRange").val() && $("#likeRange").val() <= 4){
       	  $("#likeRangeResult").text( "500개 이상" );
         }else if(4 < $("#likeRange").val() && $("#likeRange").val() <= 5){
         	$("#likeRangeResult").text( "1000개 이상" );
         }else if(5 < $("#likeRange").val() && $("#likeRange").val() <= 6){
         	$("#likeRangeResult").text( "2000개 이상" );
         }else if(6 < $("#likeRange").val() && $("#likeRange").val() <= 7){
         	$("#likeRangeResult").text( "3000개 이상" );
         }else if(7 < $("#likeRange").val() && $("#likeRange").val() <= 8){
         	$("#likeRangeResult").text( "4000개 이상" );
         }else if(8 < $("#likeRange").val() && $("#likeRange").val() <= 9){
         	$("#likeRangeResult").text( "5000개 이상" );
         }else if(9 < $("#likeRange").val() && $("#likeRange").val() <= 10){
         	$("#likeRangeResult").text( "1K개 이상" );
         }
       });
      
     var filterPrice1 = 0;
 	 var filterPrice2 = 5;
 	 $(document).ready(function(){
			$("#DoubleRangePrice").slider({
				min: 1,
			    max: 5,
				range:true,
				values:[1,5],
			    slide: function( event, ui ) {
			    	filterPrice1 = ui.values[0];
			    	filterPrice2 = ui.values[1];
			    	if(ui.values[0] == 0 && ui.values[1] == 0){
			          $("#PriceRangeResult").text("1만원 이하");
			    	}else if(ui.values[0] == 5 && ui.values[1] == 5){
			    	  $("#PriceRangeResult").text("10만원 이상");
			    	}else{
			    		$("#PriceRangeResult").text(ui.values[0] + " ~ " + ui.values[1]);
			    	}
			     }
			  });
		});
 	 
      $(document).ready(function(){
  		$("#123").on('click',function(){
  	      	$.ajax({
  	         	success:function(data)
  	             {
  	         		$("#FileUpload").show();  	         		
  	         		$("#acrt_type2").show();
  	         		$("#acrt_eval").show();
  	         		$("#acrt_with").show();
  	         		$("#acrt_price").show();
  	         		$("#acrt_menu").show();
  	         		$("#acrt_tag").show();
  	         		$("#acrt_type3").hide();
  	         		$("#acrt_type4").hide();
  	        	 }	
  	      	});	 
  	  	});
  	});
      
     
  		$("#d123").on('click',function(){0
  	      	$.ajax({
  	         	success:function(data)
  	             {
  	         		$("#FileUpload").show();
  	         		$("#acrt_type2").hide();
    	         		$("#acrt_type3").css("display", "block");
    	         		$("#acrt_eval").css("width","490");
    	         		$("#acrt_with").show();
    	         		$("#acrt_price").show();
    	         		$("#acrt_menu").show();
    	         		$("#acrt_tag").show();
    	         		$("#acrt_type4").hide();
  	        	 }	
  	      	});	 
  	  	});
  

      $(document).ready(function(){
    		$("#a123").on('click',function(){
    	      	$.ajax({
    	         	success:function(data)
    	             {
    	         		$("#FileUpload").show();
      	         		$("#acrt_type4").show();
      	         		$("#acrt_eval").show();
      	         		$("#acrt_with").show();
      	         		$("#acrt_price").show();
      	         		$("#acrt_menu").show();
      	         		$("#acrt_tag").show();
      	         		$("#acrt_type3").hide();
      	         		$("#acrt_type2").hide();
    	        	 }	
    	      	});	 
    	  	});
    	});

      $(document).ready(function(){
    		$("#b123").on('click',function(){
    	      	$.ajax({
    	         	success:function(data)
    	             {
    	         		$("#FileUpload").show();
      	         		$("#acrt_type2").hide();
      	         		$("#acrt_eval").show();
      	         		$("#acrt_with").show();
      	         		$("#acrt_price").hide();
      	         		$("#acrt_menu").hide();
      	         		$("#acrt_tag").show();
      	         		$("#acrt_type3").hide();
      	         		$("#acrt_type4").hide();
    	             }
    	      	});	 
    	  	});
    	});
      
      $(document).ready(function(){
  		$("#c123").on('click',function(){
  	      	$.ajax({
  	         	success:function(data)
  	             {
  	         		$("#FileUpload").hide();
  	         		$("#acrt_type2").hide();
  	         		$("#acrt_eval").hide();
  	         		$("#acrt_with").hide();
  	         		$("#acrt_price").hide();
  	         		$("#acrt_menu").hide();
  	         		$("#acrt_tag").hide();
  	         		$("#acrt_type3").hide();
  	         		$("#acrt_type4").hide();
  	         	}	
  	      	});	 
  	  	});
  	});

   var MenuStr;
   var TagStr;
   
   $('#filterSubmit').click(function(e) {	   

	   var filterType = $(":input:radio[name=filterType]:checked").val();
	   var filterFoodType = $(":input:radio[name=AutoCompleteFoodType]:checked").val();
	   var filterColleagueList = [];
		
	   var filterTaste = $(":input:radio[name=Recommend]:checked").val();
	   var filterPrice = $("#AutoCompletePriceRange").val();
	    
		$("input[name=AutoCompleteColleague]:checked").each(function(){
				filterColleagueList.push($(this).val());
				console.log("배열 저장2");
		});
		
		if(MenuStr != "" && MenuStr[0] != "#"){
			 $("#MenuText").val("#" + MenuStr);
		 }
		if(TagStr != "" && TagStr[0] != "#"){
			 $("#TagText").val("#" + TagStr);
		 }
		MenuStr = $("#MenuText").val();
		TagStr = $("#TagText").val();
		
		var infowindow = new google.maps.InfoWindow();
        var infowindowContent = document.getElementById('infowindow-content');
        infowindow.setContent(infowindowContent);
        var name =  encodeURIComponent(infowindowContent.children['place-name'].textContent);
        var id =  infowindowContent.children['place-id'].textContent;
        var address = encodeURIComponent(infowindowContent.children['place-address'].textContent);
        var tel =  infowindowContent.children['phone-number'].textContent;
        var lat = infowindowContent.children['latitude'].textContent;
        var lng = infowindowContent.children['longitude'].textContent;
         
		var formData = new FormData();
	    formData.append("name", name);
	    formData.append("address", address);
	    formData.append("tel", tel);
	    formData.append("id", id);
	    formData.append("lat", lat);
	    formData.append("lng", lng);
	    formData.append("SaveType", filterType);
	    formData.append("AutoCompleteFoodType", filterFoodType);
	    formData.append("filterTaste", filterTaste);
	    formData.append("AutoCompleteColleague", filterColleagueList);
	    formData.append("filterPrice", filterPrice);
	    formData.append("Menu", encodeURIComponent(MenuStr));
	    formData.append("Tag", encodeURIComponent(TagStr));
	    
	    var ins = document.getElementById('Savephoto').files.length;
	    
        for (var x = 0; x < ins; x++) {
        	formData.append("files[]", document.getElementById('Savephoto').files[x]);
        }
        
	    $.ajax({
    		method: 'POST',
    		url: 'uploadFile',
    		data: formData,
    	    processData: false,
    	    contentType: false,  
    	    success: function(data){
    	    	alert("업로드 성공");
    		},
	    	error :function(xhr,status,err){
	    		alert("업로드 실패");
    			}
    		});
    	
   });
   
	$("#MenuText").on('keydown',function(event){
		  MenuStr = $("#MenuText").val();
		if(event.keyCode == 32){
			if(!event.shiftKey){
          		$.ajax({
             		success:function(data)
             		{
            	 		$("#MenuText").val(MenuStr + "   #");
             		}
          		}); 
			}
		}
  });
	
	 $("#TagText").on('keydown',function(event){
		  TagStr = $("#TagText").val();
		if(event.keyCode == 32){
			if(!event.shiftKey){
         		$.ajax({
            		success:function(data)
            		{
           	 		 $("#TagText").val(TagStr + "   #");
            		}
         		}); 
			}
		}
 });
	

	 $("#MenuText").focus(function() {
		 MenuStr = $("#MenuText").val();
		 if(MenuStr == ""){
		 	$("#MenuText").val(MenuStr + "#");
		 }
		 if(MenuStr != "" && MenuStr[0] != "#"){
			 $("#MenuText").val("#" + MenuStr);
		 }
	    });
	
	 $("#TagText").focus(function() {
		 TagStr = $("#TagText").val();
		 if(TagStr == ""){
		 	$("#TagText").val(TagStr + "#");
		 }
		 if(TagStr != "" && TagStr[0] != "#"){
			 $("#TagText").val("#" + TagStr);
		 }
	    });
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDSMQLcRfJQUkkFrYRsCxtcM7cVoac6TIc&libraries=places&callback=initMap" async defer></script>
</html>