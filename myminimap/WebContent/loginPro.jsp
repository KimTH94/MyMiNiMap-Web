<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	%>

	<jsp:useBean id="memDTO" class="bean.MemDTO"/>
	<jsp:setProperty name="memDTO" property="*" />
	<jsp:useBean id="memDAO" class="bean.MemDAO"/>

	<%
		int result = memDAO.login(memDTO.getEmail(),memDTO.getPassword());
	    String nickname = memDAO.getNickname(memDTO);
	    int SEQ_User = memDAO.getSEQ_User(memDTO);
		if (result == 1) {
			session.setAttribute("email", memDTO.getEmail());
			session.setAttribute("nickname", nickname);
			session.setAttribute("SEQ_User", SEQ_User);
			response.sendRedirect("index.jsp");
		} else if(result == 0){
			response.sendRedirect("login_f.jsp");
		}else if(result == -2){
			response.sendRedirect("login_f.jsp");
		}
	%>

</body>
</html>