<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
		Object member = (Object)session.getAttribute("member");
		if(member != null )response.sendRedirect("/board/itList");  
%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8" />
		<link rel="stylesheet" href="../resources/pureForm/pure-min.css">
	    <link rel="stylesheet" href="../resources/pureForm/side-menu.css">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <style>
	        .pure-form{	width :80%;	}
	        body{	margin-top : 5%;	}
	        label{	text-align:left !important;  }
	        fieldset{width : 22em; margin-left : 38%;}
	        h1{text-align : center;}
	    </style>
	</head>
	<body>
		<h1>TEAM UP</h1>
		<fieldset>
			<legend><h2>Login</h2></legend>
			<form class="pure-form" id="frmLogin" method="post" action ="/account/login">
			        <input required type="email" name ="email" placeholder="Email" id="email"><br/><br/>        
			        <input required type="password" placeholder="Password" name="password" id="password">
			        <input class="pure-button" id="btnLogin"  value="Login" type="submit"/>
			</form>
			<p>
			    <button class="pure-button pure-button-primary" id="btnJoin">회원가입</button>
			    <button class="pure-button pure-button-primary" id="btnFindPwd">비밀번호 찾기</button>   
			</p>
		</fieldset>	
		<script src="../resources/js/jquery-1.10.2.min.js"></script>   
		<script src="../resources/js/jquery.form.js"></script> 
		<script src="../resources/js/jquery.validate.min.js"></script> 
		<script>
			$("#frmLogin").validate({
			    rules: {
			        password: {
			            minlength: 3
			        },
			        email: {
			            email: true
			        },
			    },
			    messages: {
			        password: {
			            minlength: "암호는 8자 이상이어야 합니다."
			        },
			    }
			});
		
			$("#btnLogin").click(function(){
				if(!$("#frmLogin").valid()) return;
				$("#frmLogin").ajaxForm({
					success: function (data, statusText, xhr, $form) {
						if (data.result == 'fail') {
				        	alert(data.message);
				        } else {
				            $(location).attr('href', "/board/itList");
				        }
				    },
				    dataType: 'json'
				});
				$("#frmLogin").submit();
				return false;
			});
		    
			$("#btnJoin").click(function(){
				$(location).attr('href', "/account/join");
			});
		    
		    $("#btnFindPwd").click(function(){
				$(location).attr('href', "/account/findPasswd");
			});    
		</script>    
	</body>
</html>
