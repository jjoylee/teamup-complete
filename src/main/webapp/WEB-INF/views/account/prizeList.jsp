<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>        
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>수상내역</title>
	</head>
	<body>

		<table id="prize" border="1" width="450" >
			<tr>
		  		<td>이름</td>
		   		<td>수상연도 </td> 
		        <td>저장/삭제</td>
		    </tr>
		    <form id="savePrizeFrm" action="/account/prizeList" method="post" >  
		    	<tr>
		        	<td><input type="text" name="title" id="title"/></td>
		        	<td><input type="text" name="year" id="year"/></td>
		        	<td><input type="button" id="save" value="저장"/></td>
		        </tr>
		    </form>
			<c:forEach items="${list}" var="PrizeVO">
				<tr>
					<td ><input type="text" value= "${PrizeVO.title}" name="title" disabled></td>  
			      	<td ><input type="text" value="${PrizeVO.year}" name="year" disabled></td>	
			      	<td><button class="delete" data-id="${PrizeVO.prizeId}">제거</button></td>
			    </tr>
			</c:forEach>       
		</table>
		<br/>
		<input type="button" value="나가기" id="exit" />
		
		<script src="../resources/js/jquery-1.10.2.min.js"></script>   
		<script src="../resources/js/jquery.form.js"></script> 
		<script src="../resources/js/jquery.validate.min.js"></script> 
		<script>
			$(".delete").on("click", function(){
				alert("삭제되었습니다.");
				var url = "/account/removePrize/" + $(this).attr("data-id");
				alert(url);
				$.getJSON(url, function (data) {
				   	if (data.result == 'fail') {
						alert(data.message);
				    } else {
						$(location).attr('href', "/account/prizeList");
					}
				});
			});
			$("#exit").click(function(){
				window.opener.location.reload();
				window.close();
			});
			$("#save").click(function(){
				if($("#title").val()=="" || $("#year").val()==""){
					alert("빈칸을 채워주세요");
					return;
				}
				$("#savePrizeFrm").ajaxForm({
					success: function (data, statusText, xhr, $form) {
						if (data.result == 'fail') {
				        	alert(data.message);
				        } else {
				            $(location).attr('href', "/account/prizeList");
				        }
				    },
				    dataType: 'json'
				});
				$("#savePrizeFrm").submit();
				return false;
			});
		</script>
	</body>
</html>