<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/pureForm/pure-min.css">
<link rel="stylesheet" href="../resources/pureForm/side-menu.css">

<style>
.custom-restricted-width {
    /* To limit the menu width to the content of the menu: */
    display: inline;
    /* Or set the width explicitly: */
    width: 10em;
    
  
}

h2{ margin-left:45%; margin-top:5%;}
.content {margin-top : 1%;
       margin-left:35%;
      }

</style>
</head>

<body>
    <h2>비밀번호 변경</h2>
<div class="content">
    <form class="pure-form pure-form-aligned" id="updatePwd" action="/account/updatePasswd" method="post" onsubmit="return thisy();" >
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
                <button class="pure-button pure-button-primary" type="submit" id="update" >수정</button>
                <button class="pure-button pure-button-primary" id="cancel">취소</button>
            </div>
        </fieldset>
    </form>
</div>

</body>

    <script src="../resources/source/js/jquery.form.js"></script>
    <script src="../resources/source/js/jquery-1.10.2.min.js"></script>
    <script >
    var result = '${msg}';
    if(result == 'false') alert('현재 비밀번호가 다릅니다.');
    if(result == 'different') alert ('새 비밀번호와 새 비밀번호 확인이 다릅니다.');
    	function thisy(){
    			return true;

        }
    	
    	$("#cancel").click(function () {
        	var url = "/account/modifyInfo";

            $(location).attr('href', url);
            return false;
        });
    </script>
</html>