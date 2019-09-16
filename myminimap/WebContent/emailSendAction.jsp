<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="javax.mail.*" %>
<%@ page import="java.util.Properties" %>
<%@ page import="bean.MemDAO" %>
<%@ page import="bean.SHA256" %>
<%@ page import="util.Gmail" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="memDTO" class="bean.MemDTO"/>
<jsp:setProperty name="memDTO" property="*" />
<jsp:useBean id="memDAO" class="bean.MemDAO"/>
<% 

 request.setCharacterEncoding("utf-8"); 
 response.setCharacterEncoding("utf-8");
 
 String email = (String)session.getAttribute("email");
 String Nickname = memDAO.getNickname2(email);
 String UUID = memDAO.GetUUID(email);
 String host = "http://localhost:8090/Final_Minimap/";
 String from = "minimapkr@gmail.com"; // 보낸사람
 String to = memDAO.getUserEmail(email);
 String subject = "MyMiNi 회원가입을 축하드립니다.";
 String content = "아래 링크를 누르면 이메일 인증이 완료됩니다." + "<br>" + "<a href = http://localhost:8090/Final_Minimap/Auty.jsp?email=" + email + "&UUID=" + UUID + ">활성화</a>";
 
 Properties p = new Properties();
 p.put("mail.smtp.user", from);
 p.put("mail.smtp.host", "smtp.googlemail.com");
 p.put("mail.smtp.user", "465");
 p.put("mail.smtp.starttls.enable", "true");
 p.put("mail.smtp.auth", "true");
 p.put("mail.smtp.debug", "true");
 p.put("mail.smtp.socketFactory.port", "465");
 p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 p.put("mail.smtp.socketFactory.fallback", "false");
 
 try{
	 Authenticator auth = new Gmail();
	 Session ses = Session.getInstance(p, auth);
	 ses.setDebug(true);
	 MimeMessage msg = new MimeMessage(ses);
	 msg.setSubject(subject);
	 Address fromAddr = new InternetAddress(from);
	 msg.setFrom(fromAddr);
	 Address toAddr = new InternetAddress(to);
	 msg.addRecipient(Message.RecipientType.TO, toAddr);
	 msg.setContent(content, "text/html;charset=UTF8");
	 response.sendRedirect("join_complete.jsp");
	 Transport.send(msg);
 }catch(Exception e){
	 e.printStackTrace();
     PrintWriter script = response.getWriter();
	 script.println("<script>");
	 script.println("alter('오류 발생.');");
	 script.println("history.back();");
	 script.println("</script>");
	 out.println(email + " 님 환영합니다!");
 }
	 %>
</body>
</html>