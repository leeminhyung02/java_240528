<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<p>안녕하세요. 제이름은 ${name}입니다. 나이는 ${age}살 입니다. </p>
	<p>안녕하세요. 제이름은 ${person.name}입니다. 나이는 ${person.age}살 입니다. </p>
	<a href="<%=request.getContextPath()%>?name=홍길동&age=21">이름은 홍길동, 나이는 21</a>
	<br>
	<c:if test="${user == null}">
	<a href="<c:url value="/signup"/>">회원가입</a>
	<br>
	<a href="<c:url value="/login"/>">로그인</a>
	</c:if>
	<c:if test="${user != null}">
		<a href="<c:url value="/logout"/>">로그아웃</a>
	</c:if>
</body> 
</html>