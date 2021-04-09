<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  
</head>
<body>
<div class="container">
<h1>게시판 글보기</h1>

<table class="table">
	<tr class="active">
		<th>글번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<tr class="dataRow">
		<td class="danger">${vo.no }</td>
		<td class="warning">${vo.title }</td>
		<td class="warning">${vo.content }</td>
		<td class="success">${vo.writer }</td>
		<td class="info">${vo.writeDate }</td>
		<td class="active">${vo.hit}</td>
	</tr>
<!-- <tr> -->
<!-- 	<th>글번호</th> -->
<%-- 	<td>${vo.no }</td> --%>
<!-- </tr> -->
<%-- 번호 : ${vo.no }<br/>  --%>
<%-- 제목 : ${vo.title }<br/>  --%>
<%-- 내용 : ${vo.content }<br/>  --%>
<%-- 작성자 : ${vo.writer }<br/>  --%>
<%-- 작성일 : <fmt:formatDate value="${vo.writeDate }" pattern="yyyy년 MM월 dd일"/><br/>  --%>
<%-- 조회수 : ${vo.hit }<br/> --%>
<!-- </tr>  -->
</table>

<a href="list.do" class="btn btn-primary">리스트</a>
<a href="update.do?no=${vo.no }" class="btn btn-primary">글수정</a>
<a href="delete.do?no=${vo.no }" class="btn btn-primary">글삭제</a>
</div>
</body>
</html>