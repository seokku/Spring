/**
 * 게시판 댓글 처리에 필요한 JS(jQuery)
 */

// 브라우저의 consol tab에 출력한다. -alert() 사용하셔도 됩니다.
console.log("Reply Module ...................");


// replyService 변수 - 타입은 Object - JSON {} - {k:v, K:v, k:func()}
var replyService = (
	function(){
		// list
		// param : JSON {no:2, repPage:1, repPerPageNum:5}
		function list(param, callback, error){
			var no = param.no;
			// param.repPage || 1 -> param.repPage의 값이 없으면 1을 사용
			var page = param.repPage || 1;	
//			// param.repPerPageNum || 5; -> param.repPerPageNum의 값이 없으면 5를 사용
			var perPageNum = param.repPerPageNum || 5;
			
			// Ajax를 이용한 데이터 가져오기 -> Ajax 해야합니다. 형식에 맞으면 Ajax를 한다.
			// Ajax 함수 : $.getJSON() - $.ajax()를 통해서 JSON 데이터를 받아오게 만든함수
			//			$(selector).load(url[, success]) - 아이디 중복 체크 시 사용
			$.getJSON(
				// ajax로 호출하는 url
				"/replies/list.do?no=" + no + "&repPage=" + page + "&repPerPageNum=" + perPageNum, 
				// success(성공) 상태일때 처리되는 함수
				// 데이터 처리가 성공해서 데이터를 가져오면 data로 넣어준다. list이므로 배열이 넘어온다.
				function(data){
//					alert(data);
					// callback : 데이터를 가져오면 처리하는 함수 
					// - 가져온 list를 HTML만듦. 지정한곳에 넣어준다.
					if(callback){
						callback(data);
					}
				}
			)
			// error(실패) 상태일때의 처리함수
			.fail(
				function(xhr, status, err){
					// 오류함수가 있으면 오류함수 실행
					if(error){
						error();
					}else{
						// 오류출력 - {}, [] 이런구조 ok, // <> - JSON 데이터가 아니므로 오류
						alert(err);
					}
			}
		); // $.getJSON().fail()의 끝
	} // list()의 끝
	
	
	// write() : 교재는 add()--------------------------------------------------
	function write(reply, callback, error){
		console.log("reply write(). ---------------------------------");
		console.log("reply data - " + JSON.stringify(reply));
		// ajax를 이용해서 데이터를 서버에 보낸다.
		$.ajax({
			// 전송 방법의 타입 : get, post, put, patch, delete, update
			type:"post",
			// 요청 URL
			url:"/replies/write.do",
			
			data : JSON.stringify(reply),
			// data : reply,
			// 전송되는 데이터의 타입과 엔코딩 방식
			contentType:"application/json; charset=utf-8",
			// 정상적으로 댓글 쓰기 성공했을 때의 처리함수 
			success : function(result, status, xhr){
				if(callback) callback(result, status);
				else alert("댓글 쓰기 성공");
			},
			// 처리 도중 오류(실패)가 난 경우 처리하는 함수 속성
			error : function(xhr, status, err){
				if(error) error(err);
				else alert("댓글 쓰기 중 오류발생");
				
			}
			
		}); // $.ajax의 끝
	}
	
	// update() : --------------------------------------------------
	// update(JSON data, 성공함수, 실패함수)
	function update(reply, callback, error){
		console.log("reply update() ---------------------------------");
		// ajax를 이용해서 데이터 넘기기
		$.ajax({
			type:"patch",
			url : "/replies/update.do",
			data : JSON.stringify(reply), 
			contentType : "application/json; charset=uft-8",
			success : function(result, status, xhr){
				if(callback) callback(result, status);
				else alert("댓글 수정 성공 - 새로고침 하세요.");
			}, 
			error : function(xhr, status, err){
				if(error) error(err, status);
				else alert(err);
			}
			
		});
	}
	
	// delete() : delete가 예약어이므로 변수나 함수로 사용불가 -> deleteReply--------------------------------------------------
	function deleteReply(reply, callback, error){
		console.log("reply deleteReply() ---------------------------------");
		
		$.ajax({
			type:"delete",
			url:"/replies/delete.do",
			data : JSON.stringify(reply), 
			contentType : "application/json; charset=uft-8",
			success : function(result, status, xhr){
				if(callback) callback(result, status);
				else alert("댓글 삭제 성공 - 새로고침 하세요.");	
			},
			error : function(xhr, status, err){
				if(error) error(err, status);
				else alert(err);
			} 
		});
		
	}
	
	return{
		// replyService.list(param, callback, error)
		list : list,
		write : write,
		update : update,
		delete : deleteReply,
		// util.js 파일에서 displyTime 함수를 찾는다. 앞에 있어야한다.
		displyTime : displyTime
		
	}
	}
	
)();
console.log(replyService);