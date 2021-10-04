<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 정보</title>
</head>
<body>
	<h2>도서 정보</h2>
	책 제목 : ${requestScope.title }<br>
	저자 : ${requestScope.author }<br>
	출판사 : ${requestScope.publisher }<br>
</body>
</html>