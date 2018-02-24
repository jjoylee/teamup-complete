<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			h2{ margin-left:45%; margin-top:5%;}
			.content {
				margin-top : 1%;
			   	margin-left:35%;
			}
		</style>
	</head>

	<body>
	    <h2>비밀번호 변경</h2>
		<div class="content">
		    <form class="pure-form pure-form-aligned" id="updatePwdFrm" action="/account/updatePasswd" method="post" >
		        <fieldset>
		            <div class="pure-control-group">
		                <label for="currentPwd">현재 비밀번호</label>
		                <input id="currentPwd" name="currentPwd" type="password" required>
		            </div> 
		
		            <div class="pure-control-group">
		                <label for="newPassword">새 비밀번호</label>
		                <input id="newPassword" name="newPassword" type="password" required>
		            </div>
		
		            <div class="pure-control-group">
		                <label for="newPasswordChk">새 비밀번호확인</label>
		                <input id="newPasswordChk" name="newPasswordChk" type="password" required />
		            </div>
		            <div class="pure-controls">
		                <button class="pure-button pure-button-primary" id="update" >수정</button>
		                <button class="pure-button pure-button-primary" id="cancel">취소</button>
		            </div>
		        </fieldset>
		    </form>
		</div>
	
		<script src="../resources/js/jquery-1.10.2.min.js"></script>   
		<script src="../resources/js/jquery.form.js"></script> 
		<script src="../resources/js/jquery.validate.min.js"></script> 
		<script>	
	        $.ajaxSetup({ async: false });
		</script>
		<script>
			$("#updatePwdFrm").validate({
			    rules: {
			    	currentPwd : {
			            minlength: 8
			        },
			        newPassword : {
			            minlength: 8
			        },
			        newPasswordChk: {
			            minlength: 8,
			            equalTo: "#newPassword"
			        },
			    },
			    messages: {
			        password: {
			            minlength: "암호는 8자 이상이어야 합니다."
			        },
			        newPassword: {
			            minlength: "암호는 8자 이상이어야 합니다."
			        },
			        newPasswordChk: {
			            minlength: "암호는 8자 이상이어야 합니다.",
			            equalTo: "암호가 일치하지 않습니다."
			        }
			    }
			});
	
			$("#update").click(function(){
				if(!$("#updatePwdFrm").valid()) return;
				$("#updatePwdFrm").ajaxForm({
					success: function (data, statusText, xhr, $form) {
						if (data.result == 'fail') {
				        	alert(data.message);
				        } else {
				        	alert("비밀번호가 변경되었습니다.");
				            $(location).attr('href', "/account/updatePasswd");
				        }
				    },
				    dataType: 'json'
				});
				$("#updatePwdFrm").submit();
				return false;
			});
		</script>    
	</body>
</html>