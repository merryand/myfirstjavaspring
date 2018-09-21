<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기</title>
</head>
<body>
	<div align="center" class="body">
		<h2>제품 상세보기</h2>
		<table>
			<tr>
				<td><img src="img/${item.pictureurl}" /></td>
				<td align="center">
					<table>
						<tr>
							<td>이름</td>
							<td>${item.itemname}</td>
						</tr>
						<tr>
							<td>레어도</td>
							<td>${item.rarity}</td>
						</tr>
						<tr>
							<td>종류</td>
							<td>${item.itemtype}</td>
						</tr>
						<tr>
							<td colspan="2" align="center" width="240"><a href="./">목록으로
									돌아가기</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>