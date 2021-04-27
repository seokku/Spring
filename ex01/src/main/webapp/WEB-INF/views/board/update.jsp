<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글수정</title>

<!-- bootstrap 라이브러리 등록 CDN방식 : sitemesh에서 decorator.jsp에서 한꺼번에 해결 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){
	$(".cancelBackBtn").click(function(){
		history.back();
	});
});

</script>



</head>
<body>
<div class="container">
<h1>게시판 글수정 폼</h1>
<form action="update.do" method="post">

	<input name="page" value="${param.page }" type="hidden">
	<input name="perPageNum" value="${param.perPageNum }" type="hidden">
	<input name="key" value="${param.key }" type="hidden">
	<input name="word" value="${param.word}" type="hidden">
    <div class="form-group">
      <label for="no">번호:</label>
      <!-- required: 필수입력, placeholder : 입력의 초기 안내,
    	pattern : 정규표현식으로 유효성 검사, title : 패턴이 맞지 않을 때 메시지 -->
      <input name="no" type="text" class="form-control" id="no"
       value="${vo.no }" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="title">제목:</label>
      <!-- required: 필수입력, placeholder : 입력의 초기 안내,
    	pattern : 정규표현식으로 유효성 검사, title : 패턴이 맞지 않을 때 메시지 -->
      <input name="title" type="text" class="form-control" id="title"
      pattern=".{4,100}" maxlength="100" required="required" 
       title="4자 이상 100자이하 입력" placeholder="4자 이상 100자이하 입력" 
       value="${vo.title }">
    </div>

	<div class="form-group">
		<label for="content">내용:</label>
		<textarea name="content" class="form-control" rows="5"
		 id="content" placeholder="4자 이상 1000자이하 입력" value="${vo.content }"></textarea>
	</div>

    <div class="form-group">
      <label for="writer">작성자:</label>
      <input name="writer" type="text" class="form-control" id="writer" required="required" pattern="[A-Za-z가-힣][0-9A-Za-z가-힣]{1,19}"
       placeholder="이름은 2자부터 10자까지" title="이름은 2자부터 10자까지 첫글자를 숫자가 올수없다." value="${vo.writer }">
    </div>
    
	<div class="form-group">
      <label for="pwd">비밀번호: 본인 확인용</label>
      <input name="pw" type="password" class="form-control" id="pwd" pattern="[^가-힣ㄱ-ㅎ]{4,20}" 
      required="required" title="4-20자, 한글은 입력할 수 없습니다">
    </div>
    <button>수정</button>
    <button type="reset">새로입력</button>
    <button type="button" class="cancelBackBtn">취소</button>
    
    
  </form>

</div>
</body>
</html>