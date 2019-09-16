<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
   <meta charset="utf-8">
   <title></title>
</head>
  <style media="screen">
html{
  margin: 0 auto;
}
#comment input{
	height: 100%;
	width: 80%;
	left: 0px;
}
    #modal{
      text-align: center;
      border: 1px solid black;
      width:940px;
      height:600px;
      position: absolute;
      overflow: hidden;

    }
    .maindiv{
      border: 1px solid black;
      width: 600px;
      height: 600px;
      float: left;
    }
    #data{
      float: right;
    }
    #profile, #view, #like, #comment{
        border: 1px solid black;
    }
    .maindiv:nth-child(2){
      width: 335px;
    }
    #profile{
      height: 75px;
    }
    #view{
      height: 400px;
    }
    #comment{
      height: 40px;
    }
    #like{
      height: 40px;
    }
    #profilepic{
      border: 1px solid black;
      float: left;
      height: 35px;
      width:35px;
      margin: 20px 10px 20px 10px;
    }
    #nickname{
      border: 1px solid black;
      float: left;
      height: 35px;
      width: 150px;
      margin: 20px 10px 20px 10px;
    }
    #followstat{
      border: 1px solid black;
      float: right;
      height: 35px;
      width:35px;
      margin: 20px 10px 20px 10px;
    }
    #comments{
      border: 1px solid black;
      float: left;
      height: 35px;
      width: 150px;
      margin: 20px 10px 20px 10px;
    }
    #likebutton{
      float: left;
      width:10%;
      height:30px;
      bottom : 0px;
    }

    #commentbutton{
      float: left;
      width:10%;
      height:30px;
      text-align: bottom;
      margin-left: 5px;
    }

    #sharebutton{
      float: left;
      width:10%;
      height:30px;
      bottom : 0px;
    }
    #savebutton{
      float: right;
      width:10%;
      height:30px;
      bottom : 0px;
    }
    #writecomment{
      float : right;
      width:20%;
      height: 50px;
    }


  </style>
  <body>
    <div id="modal">
    <div class="maindiv">pic

    </div>

    <div class="maindiv" id="data">

      <div id="profile">

        <div id="profilepic">
          pic
        </div>
        <div id="nickname">
          nick
        </div>
        <div id="followstat">
          follow
        </div>

      </div>

      <div id="view">
        <div id="profilepic">
          pic
        </div>
        <div id="comments">
          comments
        </div>
        <div id="followstat">
          follow
        </div>
      </div>
      <div id="comment">
        cadfasdfsaf
      </div>
      <div id="like">
        <div id="likebutton">
        	<img src="./img/likebutton.png">
        </div>
        <div id="commentbutton">
          <img src="./img/speechbubble.png">
        </div>
        <div id="sharebutton">
        	<!-- 공유 버튼 자리 -->
        </div>
        <div id="savebutton">
          <img src="./img/maps-and-flags.png">
        </div>
      </div>

      <div id="comment">
        <input type="text" name="" value="" >
          <button type="button" id="writecomment" name="button" value="comment"></button>

      </div>
    </div>
    </div>
  </body>
</html>