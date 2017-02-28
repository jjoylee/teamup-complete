<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../include/layout.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<style>
	
	#content
	{
		margin-top:2%;
		float:right;
		position:absolute;
		margin-left:30%;
		}
		
	textarea
	{
		margin-left:1%;
	}
	
	table { 
			border : 1px solid #d9d9d9 ;
			}
	th, td {
    padding: 5px;
	}
	textarea {width : 99%;}
	input {width : 99%;}
	</style>
</head>
<body>
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
			<select id="category" name="category" required>
		      <option value="1">IT</option>
		      <option value="2">마케팅</option>
		      <option value="3">디자인</option>
		      <option value="4">기타</option>
		    </select>
		</td>
		<td>
			작성자 :
		</td>
		<td>
			<input type="text" name="name"  readonly value="${board.name}"/>
		</td>
	</tr>
	
	<tr>
		<td>모집 마감일 : </td>
		<td><input type="text" name="dueDate"  readonly value="${board.dueDate}"/></td>
	</tr>
	
	<tr>
		<td> 모집 인원 수 : </td><td><input type="number" name="memCount" readonly value="${board.memCount}"/></td>
		<td> 현재 인원 수 : </td><td><input type="number" name="curCount" readonly value="${board.curCount}"/></td>
	
	</tr>
	
	<tr>
		<td>
	    URL :</td>
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
                <button type="button" class="pure-button button-xsmall" id="in" onclick="participate()" >IN</button>
                <button type="button" class="pure-button button-xsmall" id="out" onclick="participate_out()">OUT</button>
                <button type="button" class="pure-button button-xsmall" id="cancel">취소</button>
                <button type="button" class="pure-button button-xsmall" id="modify">수정</button>
                <button type="button" class="pure-button button-xsmall" id="delete">삭제</button>
                
     </div>
  
</form>

<form method="post" role="form" id="boardId">
<input type="hidden" value="${board.boardId}" name="boardId" />
</form>


</div>
</body>
<script>
if('${check}' == 'in') //참여가능한 상태 
{
	$('#in').attr("disabled", false); 
	$('#out').attr("disabled", true);
}

if('${check}' == 'alreadyin')
{
	$('#out').attr("disabled", false); 
	$('#in').attr("disabled", true);
	
}

$('#in').on("click", function(){
	alert("신청되었습니다.");
});

$('#out').on("click", function(){
	alert("취소되었습니다.");
});


var formObj = $("form[role='form']");
$("#modify").on("click", function(){
	formObj.attr("action", "/board/updateWrite");
	formObj.attr("method", "get");
	formObj.submit();
});


$("#memberList").on("click", function(){
	formObj.attr("action", "/board/memberList");
	formObj.attr("method", "get");
	formObj.submit();
});


$("#delete").on("click", function(){
	formObj.attr("action", "/board/delete");
	
	formObj.submit();
});

var selAttr = '${board.categoryId}';
$('#category').val(selAttr);
$('#category').attr("disabled", true); 

$('#cancel').on("click", function(){
	if(selAttr == 1) var url = "/board/itList";
	else if(selAttr == 2)var url = "/board/marketingList";
	else if(selAttr == 3)var url = "/board/designList";
	else var url = "/board/etcList";
    $(location).attr('href', url);
    return false;
});

if('${sessionid}' != '${board.memberId}'){
	$('#modify').attr("disabled", true);
	$('#delete').attr("disabled", true);
	$('#memberList').attr('disabled', true);
}


function participate() {
	
	
	if((Number('${board.memCount}')) <= (Number('${board.curCount}')))
		alert('마감되었습니다.');
	else{		
		if((Number('${board.curCount}') >= 0)){
			formObj.attr("action", "/board/participate");
			formObj.attr("method", "post");
			formObj.submit(); 
			$('#in').attr("disabled", false); 
			$('#out').attr("disabled", true);
		}
		    
	}
	
};

function participate_out(){
	
	if((Number('${board.curCount}') != 0)){
	formObj.attr("action", "/board/participate_out");
	formObj.attr("method", "post");
	formObj.submit();
	$('#out').attr("disabled", false); 
	$('#in').attr("disabled", true);
	}
}
</script>
