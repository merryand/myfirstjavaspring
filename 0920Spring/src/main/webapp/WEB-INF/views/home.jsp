<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 뷰 출력</title>
<style type="text/css">
h3:hover {
	color: teal;
}

span {
	margin: 10px;
	border: 3px Solid Green;
	border-radius: 15px;
	float: left;
	width: 200px;
	height: 80px;
	text-align: center;
}
</style>
</head>
<body>

	<form>
		<div id="msg"></div>
		아이디:<input type="text" id="id" /><br /> 비밀번호:<input type="password"
			id="pw" /><br />
	</form>

	<a href="excel.xls">엑셀로 출력</a>
	<br />
	<a href="data.pdf">PDF로 출력</a>
	<br />
	<a href="jsonview.json">jsonview를 이용한 출력</a>
	<br />
	<a href="data.csv">CSV 가져오기</a>
	<br />
	<a href="data.json">JSON 출력</a>
	<br />
	<a href="#" id="ajaxsend">AJAX를 JSON 가져오기</a>
	<br />
	<div id="display"></div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script>
	document.getElementById("ajaxsend").addEventListener("click", function() {
		$.ajax({
			url : "data.json",
			data : {},
			dataType : "json",
			success : function(data) {
				output = ""
				for (imsi in data) {
					output += "<span><h3>";
					output += data[imsi].name + "</h3>";
					output += "<p>" + data[imsi].group;
					output += "</p></span>";
				}
				document.getElementById("display").innerHTML = output;
			}
		})
	})

	var ids = document.getElementById("id");
	var msg = document.getElementById("msg");

	ids.addEventListener("blur", function() {
		$.ajax({
			url : "idCheck",
			data : {
				"id" : ids.value
			},
			dataType : "json",
			success : function(data) {
				if (data.result == "true") {
					msg.innerHTML = "사용 가능한 아이디입니다.";
					msg.style.color = "GREEN";
				} else {
					msg.innerHTML = "사용 불가능한 아이디입니다.";
					msg.style.color = "RED";
				}
			}
		})
	})
</script>
</html>