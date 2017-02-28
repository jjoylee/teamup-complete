<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
a:link{color:black;}
a:visited{text-decoration : none; color:black;}
a{text-decoration:none; color:black;}

h1 {margin-left : 5%; margin-top : 3%; margin-left:45%}
#frmJoin {margin-top : 5%;
       margin-left:35%;
      }

</style>
</head>

<body>
<div><h1><a href="/account/login">TEAM UP</a></h1></div>
<form class="pure-form pure-form-aligned" role="form" id="frmJoin"  method="post" >
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
        
        <input type="hidden" id="major" type="text" name="status" value="joined">

        <div class="pure-controls">
           

            <button type="submit" class="pure-button pure-button-primary" id="btnJoin"  >제출</button>
            <button  class="pure-button pure-button-primary" id="btnCancel" onclick ="cancel()">취소</button>
        </div>
    </fieldset>
</form>

</body>
<script src="../resources/source/js/jquery.validate.min.js"></script>
    <script src="../resources/source/js/jquery.form.js"></script>
    <script src="../resources/source/js/jquery-1.10.2.min.js"></script>
    
    <script type="text/javascript">
    
    	var result = '${msg}';
    	
    	if(result == 'failed')
    	{
    		alert("이미 가입되어있는 이메일입니다.");
    	}
    	if(result =='different')
    	{
    		alert('비밀번호와 비밀번호 확인이 다릅니다.');
    	}
    	
    	
    	function cancel()
    	{
    	    	location.href = "/account/login";
    	}
        
        
    </script>
</html>


