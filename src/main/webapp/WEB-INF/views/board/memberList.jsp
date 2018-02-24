<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="../include/base.jsp">
	<layout:put block="contents" type="REPLACE">
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
	</layout:put>
</layout:extends>
