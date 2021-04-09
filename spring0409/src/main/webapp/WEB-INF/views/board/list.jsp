<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
  <!-- 부트스트랩 라이브러리 등록 - CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.dataRow:hover{
	background: #eee;
	cursor: pointer;

}
</style>

</head>
<body>
<div class="container">
<h1>게시판 리스트</h1>
<table class="table">
	<tr class="active">
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
<c:forEach items="${list }" var="vo">
	<tr class="dataRow" onclick="location='view.do?no=${vo.no }'">
		<td class="danger">${vo.no }</td>
		<td class="warning">${vo.title }</td>
		<td class="success">${vo.writer }</td>
		<td class="info">${vo.writeDate }</td>
		<td class="active">${vo.hit}</td>
	</tr>
</c:forEach>

	<tr>
		<td colspan="5">
			<a href="write.do" class="btn btn-primary">글쓰기</a>
			<a href="view.do" class="btn btn-primary">글보기</a>
		</td>
	</tr>
</table>
</div>



</body>
</html>