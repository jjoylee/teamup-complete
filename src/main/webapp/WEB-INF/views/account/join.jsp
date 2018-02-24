<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="../resources/pureForm/pure-min.css">
		<link rel="stylesheet" href="../resources/pureForm/side-menu.css">
		<style>
			.custom-restricted-width {
			    display: inline;
			    width: 10em;
			}
			a:link{color:black;}
			a:visited{text-decoration : none; color:black;}
			a{text-decoration:none; color:black;}
			h1 {margin-left : 5%; margin-top : 3%; margin-left:45%}
			#frmJoin {
				margin-top : 5%;
			    margin-left:35%;
			}
		</style>
	</head>
	<body>
		<div><h1><a href="/account/login">TEAM UP</a></h1></div>
		<form class="pure-form pure-form-aligned" role="form" id="frmJoin"  method="post" action="/account/join">
		    <fieldset>
		    	<div class="pure-control-group">
		            <label for="email">Email Address</label>
		            <input required name='email' id="email" type="email" placeholder="Email Address">
		        </div>   
		        <div class="pure-control-group">
		            <label for="name">이름</label>
		            <input required name = 'name' id="name" type="text" placeholder="이름">
		        </div>
		        <div class="pure-control-group">
		            <label for="password">비밀번호</label>
		            <input required name='password' id="password" type="password" placeholder="Password">
		        </div>
				<div class="pure-control-group">
		            <label for="passwordChk">비밀번호 확인</label>
		            <input required name = 'passwordChk' id="passwordChk" type="password" placeholder="Password">
		        </div>     
		        <div class="pure-control-group">
		       	    <label for="major">전공</label>
		            <input required name = 'major' id="major" type="text" placeholder="전공명">
		        </div>
		        <input type="hidden" id="status" type="text" name="status" value="joined">
		        <div class="pure-controls">	
		            <button class="pure-button pure-button-primary" id="btnJoin">제출</button>
		            <button class="pure-button pure-button-primary" id="btnCancel">취소</button>
		        </div>
		    </fieldset>
		</form>
		
		<script src="../resources/js/jquery-1.10.2.min.js"></script>   
		<script src="../resources/js/jquery.form.js"></script> 
		<script src="../resources/js/jquery.validate.min.js"></script> 
		<script>
		        $.ajaxSetup({ async: false });
		</script>
		<script type="text/javascript">
			$("#frmJoin").validate({
			    rules: {
			        password: {
			            minlength: 8
			        },
			        passwordChk: {
			            minlength: 8,
			            equalTo: "#password"
			        },
			        email: {
			            email: true
			        },
			    },
			    messages: {
			        password: {
			            minlength: "암호는 8자 이상이어야 합니다."
			        },
			        passwordChk: {
			            minlength: "암호는 8자 이상이어야 합니다.",
			            equalTo: "암호가 일치하지 않습니다."
			        },
			    }
			});			
			$("#btnJoin").click(function(){
				if(!$("#frmJoin").valid()) return;
				$("#frmJoin").ajaxForm({
					success: function (data, statusText, xhr, $form) {
						if (data.result == 'fail') {
				        	alert(data.message);
				        } else {
				            $(location).attr('href', "/account/login");
				        }
				    },
				    dataType: 'json'
				});
				$("#frmJoin").submit();
				return false;
			});
			
			$("#btnCancel").click(function(){
				$(location).attr('href', "/account/login");
			});
		</script>
	</body>
</html>