<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="../include/base.jsp">
	<layout:put block="styles" type="REPLACE">
		<style>
			* {font-family:'Malgun Gothic'}
			#outer, table {
				margin-left:30%; 
				margin-top:2%; 
				margin-bottom:2em; 
				position: absolute; 
				float:right;
				width:40em; 
			}
			#inner {font-size : 2em;}
			#save, #inner {display : inline;}		
			#myInfo {margin-top : 5%;}
			#save {margin-left : 20em;}	
			th, td { padding:1em; border-bottom: 1px solid #ddd;}
			.odd {background-color : #ddd;}
		</style>
	</layout:put>
	<layout:put block="contents" type="REPLACE">
		<table id="memberInfo">
			<tr>
	        	<td rowspan="3" width="100" height="150" style="background-color:#ccc;"><img src="../resources/images.png" ></td>
	            <td width="100">이름</td>
	            <td><input type="text" disabled name = "name" value= "${memberVO.name}" ></td>            
	        </tr>
	        <tr>
	        	<td>학교</td>
	            <td><input type="text" disabled name = "school" value= "${memberVO.school}" ></td>    
	        </tr>  
	         <tr>
	        	<td>전공</td>
	            <td><input type="text" disabled name = "major" value= "${memberVO.major}" ></td>    
	        </tr>   
	        <tr>          	          
	            <td colspan="3" class="odd">나의 포트폴리오 </td>                  
	        </tr>
	        <tr>
	        	<td colspan="2">
		        	<c:choose>
		    				<c:when test="${memberVO.portfolio==null}">포트폴리오 보기 </c:when>    
		            		<c:otherwise>
		            			<a href="/account/download?memberId=${memberVO.memberId}">포트폴리오 보기</a>
		            		</c:otherwise>
					</c:choose>
				</td>
	       </tr>
	       <tr>
	      	   <td colspan="3" class="odd">수상경력</td>
	       </tr>
		   <tr>
	  		  <td>이름</td>
	   		  <td >수상내역</td>
	       </tr>        
	       <c:forEach items="${list}" var="PrizeVO">
				<tr>
		      		<td><input type="text" value= "${PrizeVO.title}" disabled></td>  
		      		<td><input type="text" value="${PrizeVO.year}" disabled></td>
		      		<td></td>
		    	</tr>
		   </c:forEach>   
		</table>
	</layout:put>
	<layout:put block="scripts" type="REPLACE">
		<script type="text/javascript">
		</script>
	</layout:put>
</layout:extends>