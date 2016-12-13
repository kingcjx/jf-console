<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		
		$("button").click(function(){
			window.history.back();//返回之前操作
			//window.history.forward()前进到之前操作
		});
	});
</script>
</head>
<body>
		<table border="1">
		
			<tr>
				<td>商家名称:</td>
				<td>${requestScope.evaluation.mcthName }</td>
			</tr>
			<tr>
				<td>商品名称:</td>
				<td>${requestScope.evaluation.commodityName }</td>
			</tr>
			<tr>
				<td>评价分值:</td>
				<td>${requestScope.evaluation.evaluationGrade }</td>
			</tr>
			<tr>
				<td>评价时间:</td>
				<td>${requestScope.evaluation.evaluationTime }</td>
			</tr>
			<tr>
				<td>评价内容:</td>
				<td>${requestScope.evaluation.evaluationContent }</td>
			</tr>
			<tr>
				<td>嗮图片:</td>
				<td>${requestScope.evaluation.evaluationPic }</td>
			</tr>
		</table>
		<div id="mainDiv" class="borderDiv">
		<h1>${requestScope.exception.message }</h1>
		<button>返回继续操作</button>
	</div>
</body>
</html>