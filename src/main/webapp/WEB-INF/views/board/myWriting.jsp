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
		margin-top:4%;
		float:right;
		position:absolute;
		margin-left:20%;
		}
		
	</style>
</head>
<body>
<div class="content" id="content">
	<h2 style="text-align: center;">내가 쓴 글</h2>
	<table class="pure-table pure-table-bordered" id="ItListTbl">
		<thead>
		
		<tr style="text-align:center">
			<th>번호</th>
			<th>제목</th>			
			<th>작성일</th>
			<th>모집인원</th>
			<th>모집마감일</th>
			<th>현재인원</th>		
				
		</tr>
		</thead>
		
		<tbody>
		<c:set var="count" value="0" />
		<c:forEach items="${list}" var="BoardVO">
		<tr>
			<td>${count = count+ 1}</td>
			<td><a href='/board/readWrite?boardId=${BoardVO.boardId}'>${BoardVO.title}</a></td>			
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${BoardVO.date}" /></td>
			<td>${BoardVO.memCount}</td>
			<td>${BoardVO.dueDate}</td>
			<td>${BoardVO.curCount}</td>
			
			
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<br/>
	
</div>
</body>