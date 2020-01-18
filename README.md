## MyMiNiMap Web Version
- <h3>개요</h3>
  - 맛집과 SNS 합친 '내손안의 맛집 지도' MyMiNiMap 서비스 제작 
  
- <h3>제작과정</h3>
  - 프로젝트명: <b>MyMiNiMap</b> <br>
  - 수행기간:  2019. 01. 15 ~ 2019.04.30 <br>
  - 프로젝트 인원:  4명
  
     + 김태환(평택대학교, 컴퓨터공학) : 데이터베이스 설계, Web BE, IOS 개발 <br>
     + 정연수(건국대학교, 컴퓨터공학) : Web <br>
     + 최현건(건국대학교, 컴퓨터공학) : Android 개발 <br>
     + 이훈찬(가천대학교, 경영학과) : 기획 및 마케팅 <br>
 - 나의 기여도
     + 데이터베이스 설계 및 정규화: 80%
     + Web BE: 80%
  
- <h3>개발환경</h3>
  - DB : MySQL(8.0.12) <br>
  - JAVA8 <br>
  - 프레임 워크 : Eclipse Jee Oxygen <br>
  - 서버 : Apache Tomcat(8.5), AWS <br>
  - HTML, CSS,BootStrap, JavaScript, AJAX, Json, JQuery <br>

- <h3>사용 API 및 library</h3>
  - 구글 Map, Place API <br>
  - Apache file upload library
  
- 데이터 베이스 설계도
![데이터베이스](http://myminimap.kr/kim/minidb.png)
- <h3>메인 기능 소개</h3>
  - 메인 화면 <br>
![기능1](http://myminimap.kr/kim/main.gif)

    * 사용자들이 저장한 음식점(핀) 정보(음식 종류, 맛, 가격, 추천 메뉴 등)
  - 회원가입 <br>
![기능2](http://myminimap.kr/kim/join.gif)

    * AJAX 이용하여 닉네임, Email 중복 확인 및 이메일 발송
  - 음식점 저장 <br>
![기능3](http://myminimap.kr/kim/save.gif)

    * Apache library 이용한 멀티 파일 업로드 및, 음식점 정보 저장
  - 자동완성 검색 및 프로필 사진 업로드 <br>
![기능4](http://myminimap.kr/kim/profile.gif)
  - 개인 피드 <br>
<img src="http://myminimap.kr/kim/feed.png" width="500" height="500"><br>
  - 개인 피드 맵 <br>
<img src="http://myminimap.kr/kim/feedmap.png" width="500" height="500"><br>
  - 개인 팔로워 <br>
<img src="http://myminimap.kr/kim/feedfollwer.png" width="500" height="500"><br>

- 참고 사항 <br>
  - a로 시작되는 java class, jsp 파일은 Android 통신용 입니다.(ajax.jsp 제외)
