<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="../resources/pureForm/pure-min.css">
		<link rel="stylesheet" href="../resources/pureForm/side-menu.css">
		<script src="<c:url value="/resources/sideMenu/js/ui.js" />"></script>
		<style>
			.custom-restricted-width {
			    display: inline;
			    width: 10em;
		    }
			#pwd{	margin-left:0%;	}
			h2{ margin-left:45%; margin-top:5%;}
			.content {
				margin-top : 1%;
		      	margin-left:35%;
		    }
		</style>
	</head>

	<body>
	    <h2>비밀번호 찾기 결과</h2>
		<div class="content">
		    <form class="pure-form pure-form-aligned" id="frmFindPwd"  method="post">
		        <fieldset>
		            <div class="pure-control-group">
			               <input type = "text" readonly id="pwd"  size="50" style="text-align:center;">
		            </div>
		            <div class="pure-controls">
		                <button type="button" class="pure-button pure-button-primary" id="findOk" onclick="Ok()">확인</button>
		            </div>
		        </fieldset>
		    </form>
		</div>	
		<script src="../resources/source/js/jquery.form.js"></script>
    	<script src="../resources/source/js/jquery-1.10.2.min.js"></script>
    	<script>
		    var result = '${member.name}'+ ' 님의 비밀번호는 ' + '${member.password}' + ' 입니다';
		    document.getElementById("pwd").value = result;
			function Ok()
			{
			    	location.href = "/account/login";
			}
		</script>
	</body>
</html>