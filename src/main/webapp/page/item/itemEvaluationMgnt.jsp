<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <title>列表</title>
    <!-- 日期控件CSS -->
	<script type="text/javascript">
		var rootPath = "<%=rootPath%>";
	</script>
</head>
<body>
   <div class="asideR-cont">
        <div class="query-head clearfix">
            <span class="query-item mr20">
                <label class="query-txt">审核状态</label>
                <div class="combo" id="table1">
                	<input type="hidden"  id="evaluationStatus">
                	<a href=""></a>
                </div>
            </span>
            <span class="query-item">
                <input class="query-input" id="evaluateAcount" placeholder="评论账号">
            </span>
            <span class="query-btns">
                 <button type="submit" class="btn-search" onclick="query()" title="搜索"></button>
             </span>
        </div>
        <div class="grid-com com-line" id="table">
        </div>
    </div>
   
    <!-- 日期控件JS  -->
	<script type="text/javascript" src="<%=rootPath %>/res/cui/app/datepicker/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=rootPath %>/res/cui/app/datepicker/js/dateField.js"></script>
   <script src="js/itemEvaluationMgnt.js"></script>
</body>
</html>