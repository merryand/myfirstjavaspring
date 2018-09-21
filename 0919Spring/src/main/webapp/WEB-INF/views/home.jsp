<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작 화면</title>
</head>
<body>
	<table align="center" border="1" cellpadding="3px">
		<tr style="background: gray">
			<th width="50">아이템 번호
			<th width="150">아이템 이름
			<th width="50">아이템 레어도
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td align="center">${item.code}</td>
				<td><a href="detail?code=${item.code}">${item.itemname}</a></td>
				<td align="center">${item.rarity}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>