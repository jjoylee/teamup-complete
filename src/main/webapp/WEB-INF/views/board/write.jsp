<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/layout.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../resources/source/css/pure-min.css">
	<link rel="stylesheet" href="../resources/source/css/side-menu.css">
	<style>
	
	#content
	{
		margin-top:2%;
		float:right;
		position:absolute;
		margin-left:30%;
		}
		
	textarea
	{
		margin-left:1%;
	}
	</style>
</head>
<body>
<div class="content" id="content">
<form class="pure-form pure-form-aligned" id="writingFrm" method="post">
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
    <input type="text" name="url" size='60' placeholder="http:/"><br><br/>
    <div>
    <textarea name="content" rows="13" cols="65"></textarea>
    </div><br/>
    <div class="pure-controls">
                <button  class="pure-button pure-button-primary" type="submit" id="write">글쓰기</button>
                <button type="button" class="pure-button pure-button-primary" id="cancel">취소</button>
     </div>
  </fieldset>
</form>
</div>
</body>