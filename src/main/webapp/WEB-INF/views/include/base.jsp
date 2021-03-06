<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
		Object member = (Object)session.getAttribute("member");
		if(member == null )response.sendRedirect("/account/login");  
%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!doctype html>
	<head>
		<link rel="stylesheet" href="../resources/pureForm/pure-min.css">
		<link rel="stylesheet" href="../resources/pureForm/side-menu.css">
		<link rel="stylesheet" href="../resources/pureForm/bootstrap.css">
		<layout:block name="styles"/>
		<style>
			.custom-restricted-width {
			    display: inline-block;
			    width: 12em; 
			}
			#content{
				margin-top:4%;
				float:right;
				position:absolute;
				margin-left:20%;
			}
			.dropbtn {
			    background-color: #4CAF50;
			    color: white;
			    padding: 16px;
			    font-size: 16px;
			    border: none;
			    cursor: pointer;
			}		
			.dropdown {
			    position: relative;
			    display: inline-block;
			}		
			.dropdown-content {
			    display: none;
			    position: relative;
			    background-color: #f9f9f9;
			    min-width: 12em;
			    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
			}
			.dropdown-content a {
			    color: black;
			    padding: 12px 16px;
			    text-decoration: none;
			    display: block;
			}
			.dropdown-content a:hover {background-color: #99d6ff;}
			.dropdown:hover .dropdown-content {  display: block;	}
			.dropdown:hover .dropbtn {  background-color: #3e8e41;	}
			#logout{ background-color: #ccc;}
		</style>
	</head>
	<body>
		<div class="pure-menu custom-restricted-width">
		    <span class="pure-menu-heading">Team UP</span>
		    <ul class="pure-menu-list">
		        <li class="pure-menu-item"><a href="/board/itList" class="pure-menu-link">IT</a></li>
		        <li class="pure-menu-item"><a href="/board/marketingList" class="pure-menu-link">마케팅</a></li>
		        <li class="pure-menu-item"><a href="/board/designList" class="pure-menu-link">디자인</a></li>
		        <li class="pure-menu-item"><a href="/board/etcList" class="pure-menu-link">기타</a></li>
		        <div class="dropdown">
		        	<li class="pure-menu-item"><a href="#" class="pure-menu-link"  >나의 계정&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▼</a></li>
		 			<div class="dropdown-content">
		 				<li class="pure-menu-item"><a href="/board/myWriting" class="pure-menu-link">내가 쓴 게시글</a></li>
		 				<li class="pure-menu-item"><a href="/board/myParticipation" class="pure-menu-link">내가 참가한 글</a></li> 		
		        		<li class="pure-menu-item"><a href="/account/modifyInfo" class="pure-menu-link">프로필</a></li>        
		       		</div>
		       </div>    
		       <li class="pure-menu-item" id="logout"><a href="#" class="pure-menu-link">로그아웃</a></li>
		    </ul>
		</div>
		<layout:block name="contents"/>
		<script src="../resources/js/jquery-1.10.2.min.js"></script>   
		<script src="../resources/js/jquery.form.js"></script> 
		<script src="../resources/js/jquery.validate.min.js"></script> 
		<script>	
		        $.ajaxSetup({ async: false });
		</script>
		<script type ="text/javascript">
			$("#logout").click(function(){
				var url ="/account/logout";
				$(location).attr('href', url);
				return false;
			});
		</script>
		<layout:block name="scripts"/>
	</body>
</html>