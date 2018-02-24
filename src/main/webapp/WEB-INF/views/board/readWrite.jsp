<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="../include/base.jsp">
	<layout:put block="styles" type="REPLACE">
		<style>
			#content{
				margin-top:2%;
				float:right;
				position:absolute;
				margin-left:30%;
			}	
			textarea{	margin-left:1%;	}			
			table {	border : 1px solid #d9d9d9;}
			th, td { padding: 5px;	}
			textarea {width : 99%;}
			input {width : 99%;}
		</style>
	</layout:put>
	<layout:put block="contents" type="REPLACE">
		<div class="content" id="content" >
			<form class="pure-form pure-form-aligned" id="readWriteFrm">
				<table id="table">
					<tr>
						<td >제목 : </td>
						<td colspan="3"><input type="text" name="title"  readonly value="${board.title}"/></td>
					</tr>
					<tr>
						<td>카테고리 :</td>
						<td>
							<select id="category" name="category">
						      <option value="1">IT</option>
						      <option value="2">마케팅</option>
						      <option value="3">디자인</option>
						      <option value="4">기타</option>
						    </select>
						</td>
						<td>작성자 :</td>
						<td><input type="text" name="name"  readonly value="${board.name}"/></td>
					</tr>
					<tr>
						<td>모집 마감일 : </td>
						<td><input type="text" name="dueDate"  readonly value="${board.dueDate}"/></td>
					</tr>
					<tr>
						<td> 모집 인원 수 : </td>
						<td><input type="number" name="memCount" readonly value="${board.memCount}"/></td>
						<td> 현재 인원 수 : </td>
						<td><input type="number" name="curCount" readonly value="${board.curCount}"/></td>
					</tr>
					<tr>
						<td>URL :</td>
			    		<td><input type="button" class="pure-button button-xsmall" value="${board.url}" onClick="window.open('${board.url}')"></td>
						<td colspan="2">
			    			<input type="button" id="memberList" class="pure-button button-xsmall" value="참가현황" />
			    		</td>
					</tr>
					<tr>
						<td colspan="4"><textarea name="content" rows="13" cols="65" readonly>${board.content}</textarea></td>
					</tr>
				</table>
				<input type="hidden" value="${board.curCount}" name="curCount" />
	    		<input type="hidden" value="${board.boardId}" name="boardId" />
				<div class="pure-controls">
		        	<button type="button" class="pure-button button-xsmall" id="in">IN</button>
		            <button type="button" class="pure-button button-xsmall" id="out">OUT</button>
		            <button type="button" class="pure-button button-xsmall" id="cancel">취소</button>
		            <button type="button" class="pure-button button-xsmall" id="modify">수정</button>
		            <button type="button" class="pure-button button-xsmall" id="delete">삭제</button>
		     	</div>
			</form>
		</div>
	</layout:put>
	<layout:put block="scripts" type="REPLACE">
		<script type="text/javascript">
			setDefault();
			
			$('#in').on("click", function(){
				participateProcess("in", "신청되었습니다.");
			});
			
			$('#out').on("click", function(){
				participateProcess("out","취소되었습니다.");
			});
			
			function setDefault(){
				if('${msg}' == 'success') 
				{
					$('#in').attr("disabled", false); 
					$('#out').attr("disabled", true);
				}else{
					$('#out').attr("disabled", false); 
					$('#in').attr("disabled", true);
				}
				
				if((Number('${board.memCount}')) == (Number('${board.curCount}'))) $('#in').attr("disabled", true);
				
				if('${sessionid}' != '${board.memberId}'){
					$('#modify').attr("disabled", true);
					$('#delete').attr("disabled", true);
					$('#memberList').attr('disabled', true);
				}
				
				$('#category').val('${board.categoryId}');
				$('#category').attr("disabled", true); 
			}
			
			function participateProcess(type,msg){
				alert(msg);
				var url = "/board/participate/" + '${board.boardId}';
				if(type == "out") url = "/board/participate_out/" + '${board.boardId}';
				$.getJSON(url, function (data) {
				   	if (data.result == 'fail') {
						alert(data.message);
				    } else {
						$(location).attr('href', "/board/readWrite?boardId=" + '${board.boardId}');
					}
				});
			}
			
			function getCategoryUrl(id){
				if(id == 1) return "/board/itList";
				else if(id == 2) return "/board/marketingList";
				else if(id == 3) return "/board/designList";
				else return "/board/etcList";
			}
			
			$("#modify").on("click", function(){
				$(location).attr('href', "/board/updateWrite?boardId=" + '${board.boardId}');
			});
			
			
			$("#memberList").on("click", function(){
				$(location).attr('href', "/board/memberList?boardId=" + '${board.boardId}');
			});
			
			
			$("#delete").on("click", function(){
				alert("삭제되었습니다.");
				var url = "/board/delete/" + '${board.boardId}';
				$.getJSON(url, function (data) {
				   	if (data.result == 'fail') {
						alert(data.message);
				    } else {
						$(location).attr('href', getCategoryUrl('${board.categoryId}'));
					}
				});
			});
			
			$('#cancel').on("click", function(){
			    $(location).attr('href', getCategoryUrl('${board.categoryId}'));
			});
		</script>
	</layout:put>
</layout:extends>