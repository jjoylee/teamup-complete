<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="../include/layout.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/pureForm/bootstrap.css">
	<link rel="stylesheet" href="../resources/pureForm/bootstrap.css">
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
	<h2 style="text-align: center;">참여자 명단</h2>
	<table class="pure-table pure-table-bordered" id="MemberListTbl">
		<thead>
		
		<tr style="text-align:center">
			<th>참여자 이름</th>
			<th>참여자 이메일</th>
		</tr>
		
		</thead>
		<tbody>
		
		<c:forEach items="${list}" var="MemberVO">
		<tr>
			<td><a href = '/board/readMember?memberId=${MemberVO.memberId}'>${MemberVO.name}</a></td>
			<td>${MemberVO.email}</td>
		</tr>
		</c:forEach>
		
		</tbody>
	</table>
	<br/>
	<div>

</html>
