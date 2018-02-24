<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="../include/base.jsp">
	<layout:put block="contents" type="REPLACE">
		<div class="content" id="content">
			<h2 style="text-align: center;">Marketing</h2>
			<table class="pure-table pure-table-bordered" id="marketingListTbl">
				<thead>
					<tr style="text-align:center">
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>모집인원</th>
						<th>모집마감일</th>
						<th>현재인원</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="BoardVO">
						<tr>
							<td><a href='/board/readWrite?boardId=${BoardVO.boardId}'>${BoardVO.title}</a></td>
							<td>${BoardVO.name}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${BoardVO.date}" /></td>
							<td>${BoardVO.memCount}</td>
							<td>${BoardVO.dueDate}</td>
							<td>${BoardVO.curCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination" >
				<c:if test="${pageMaker.prev}">
	            	<li><a href="marketingList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
	            </c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
	            	<li	<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
	                	<a href="marketingList${pageMaker.makeSearch(idx)}">${idx}</a>
	                </li>
	            </c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
	            	<li><a href="marketingList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
	            </c:if>
			</ul>
	        <button style="float:right; margin-top:3%;" class="pure-button pure-button-primary" id="writeBtn">글쓰기</button>
			<br/>
			<select name="searchType">
	        	<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
	            <option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>Title</option>
	        </select> 
	        <input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
	        <button id='searchBtn'>Search</button>
		</div>
	</layout:put>
	<layout:put block="scripts" type="REPLACE">
		<script type="text/javascript">
		$("#writeBtn").click(function (){
			var url = "/board/write";
			$(location).attr('href', url);
			return false;
		});
		
		$('#searchBtn').on("click", function(event) {
		    var url = "marketingList" + '${pageMaker.makeQuery(1)}'+ "&searchType="+ $("select option:selected").val() +
		    "&keyword=" + $('#keywordInput').val();
		    $(location).attr('href', url);
			return false;
		});
		</script>
	</layout:put>
</layout:extends>