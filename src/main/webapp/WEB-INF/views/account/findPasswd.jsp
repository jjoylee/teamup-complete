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
			h2{ margin-left:45%; margin-top:5%;}
			.content {
				margin-top : 1%;
			    margin-left:35%;
			}
		</style>
	</head>
	<body>
	    <h2>비밀번호 찾기</h2>
		<div class="content">
		    <form class="pure-form pure-form-aligned" id="frmFindPwd" method="post" action="/account/findPasswd">
		        <fieldset>
		            <div class="pure-control-group">
		                <label for="email">이메일(아이디)</label>
		                <input id="email" name="email" type="email" placeholder="Email Address" required>
		            </div>
		            <div class="pure-controls">
		                <button type="button" class="pure-button pure-button-primary" id="findPwd" >비밀번호 찾기</button>
		                <button type="button" class="pure-button pure-button-primary" id="cancel" >취소</button>
		            </div>
		        </fieldset>
		    </form>
		</div>
		
		<script src="../resources/js/jquery-1.10.2.min.js"></script>   
		<script src="../resources/js/jquery.form.js"></script> 
		<script src="../resources/js/jquery.validate.min.js"></script> 
		<script>
		    var result = '${msg}';
			$("#cancel").click(function () {
		        var url = "/account/login";
		        $(location).attr('href', url);
		        return false;
		    });
			
			$("#findPwd").click(function(){
				$("#frmFindPwd").ajaxForm({
					success: function (data, statusText, xhr, $form) {
						if (data.result == 'fail') {
				        	alert(data.message);
				        } else {
				            $(location).attr('href', "/account/findPasswdResult?memberId=" + data.message);
				        }
				    },
				    dataType: 'json'
				});
				$("#frmFindPwd").submit();
				return false;
			});
			
		</script>
	</body>
</html>