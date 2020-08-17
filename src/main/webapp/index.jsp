<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=path%>">
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="/toIndexServlet"></jsp:forward>
</body>
</html>