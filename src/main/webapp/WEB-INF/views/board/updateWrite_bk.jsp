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
	</style>
</head>
<body>
<div class="content" id="content">
<form class="pure-form pure-form-aligned" id="updateWriteFrm" role="form" method="post">
  <fieldset>
  	<input type="hidden" value="${boardVO.boardId}" name="boardId" />
    <label for = "title">제목 : </label>
    <input type="text" name="title" size='60' value="${boardVO.title}"><br><br/>
    <label for = "title">카테고리 : </label>
    <select id="category" name="categoryId" required >
      <option value="1" >IT</option>
      <option value="2">마케팅</option>
      <option value="3">디자인</option>
      <option value="4">기타</option>
    </select>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
    <label for = "writer" >작성자 : </label>
    <input type="text" name="name" size='17' value="${boardVO.name}"></input><br><br/>
    <label for = "deadline">모집 마감일 : </label>
    <input type="text" name="dueDate" size='15' value="${boardVO.dueDate}">&nbsp;&nbsp;
    <label for= "count">모집 인원 수 : </label>
    <input type="number" name="memCount" value="${boardVO.memCount}"><br/><br/>
    <label for = "url">URL : </label>
    <input type="text" name="url" size='60' value="${boardVO.url}"><br><br/>
    <div>
    <textarea name="content" rows="13" cols="65" >${boardVO.content}</textarea>
    </div><br/>
    <div class="pure-controls">
                <button type="button" type="submit" class="pure-button button-xsmall" id="update">확인</button>
                <button type="button" class="pure-button button-xsmall" id="cancel">취소</button>
     </div>
  </fieldset>
</form>
</div>
</body>
<script>
	var formObj = $("form[role='form']");
	$("#update").on("click", function(){
		
		formObj.submit();
	});
	
	var selAttr = '${boardVO.categoryId}';
	$('#category').val(selAttr);
	
	$('#cancel').on("click", function(){
		history.back();
	});
</script>
</html>