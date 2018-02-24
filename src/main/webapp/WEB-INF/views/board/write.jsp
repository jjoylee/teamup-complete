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
		</style>
	</layout:put>
	<layout:put block="contents" type="REPLACE">
		<div class="content" id="content">
			<form class="pure-form pure-form-aligned" id="writingFrm" method="post" action="/board/write">
				<fieldset>
			    	<label for = "title">제목 : </label>
			    	<input type="text" name="title" size='60'><br><br/>
			    	<label for = "category">카테고리 : </label>
			    	<select id="category" name="categoryId" required >
			      		<option value=1>IT</option>
			      		<option value=2>마케팅</option>
			      		<option value=3>디자인</option>
			      		<option value=4>기타</option>
			    	</select>
				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
				    <label for = "dueDate">모집 마감일 : </label>
				    <input type="text" name="dueDate" size='15' placeholder="yyyy-mm-dd"><br/><br/>
				    <label for= "memCount">모집 인원 수 : </label>
				    <input type="number" name="memCount"><br/><br/>
				    <label for = "url">URL : </label>
				    <input type="text" name="url" size='60' placeholder="http://"><br><br/>
					<div>
				    	<textarea name="content" rows="13" cols="65"></textarea>
				    </div>
				    <br/>
				    <div class="pure-controls">
				    	<button class="pure-button pure-button-primary" id="write">글쓰기</button>
				        <button type="button" class="pure-button pure-button-primary" id="cancel">취소</button>
				    </div>
				</fieldset>
			</form>
		</div>
	</layout:put>
	<layout:put block="scripts" type="REPLACE">
		<script type="text/javascript">
			$("#write").on("click", function(){
				$("#writingFrm").ajaxForm({
					success: function (data, statusText, xhr, $form) {
						if (data.result == 'fail') {
				        	alert(data.message);
				        } else {
				        	$(location).attr('href', getCategoryUrl($("#category").val()));
				        }
				    },
				    dataType: 'json'
				});
				$("#writingFrm").submit();
				return false;
			});
			$('#cancel').on("click", function(){
			    $(location).attr('href', '/board/itList');
			});
			function getCategoryUrl(id){
				if(id == "1") return "/board/itList";
				else if(id == "2") return "/board/marketingList";
				else if(id == "3") return "/board/designList";
				else return "/board/etcList";
			}
		</script>
	</layout:put>
</layout:extends>