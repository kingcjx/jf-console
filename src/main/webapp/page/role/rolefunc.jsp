<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String rootPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	var rootPath ="<%= rootPath%>";
	
</script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <title>列表</title>
    <link href="<%=rootPath%>/res/extjs/resources/css/ext-all.css" rel="stylesheet" />
    <link href="<%=rootPath%>/theme/gray/css/base.css" rel="stylesheet" />
    <link href="<%=rootPath%>/theme/gray/css/ext/ext.css" rel="stylesheet" />
    <link href="<%=rootPath%>/theme/gray/css/main.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=rootPath%>/res/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <style type="text/css">
		#container {
			margin: 0 0;
			width: 900px;
		}
		#mainContent {
			height: 500px;
			margin-bottom: 5px;
		}
		#sidebar {
			float: left;
			width: 660px;
			height: 500px;
		}
		#content {
			float: right;
			width: 230px;
			height: 500px;
		}
	</style>
</head>
<body>
	<div id="container">
		<div id="mainContent">
			<div id="sidebar">
				<div class="query-head clearfix">
		            <span class="query-item">
		                        <input class="query-input" placeholder="角色名称"  id="roleName" >
		                        <input type="hidden" id="roleId" value="1">
		                    </span>
		            <span class="query-btns">
		                 <button type="submit" class="btn-search"  onclick="query()" title="查询"/>
		                 <button type="submit" class="btn-reset"  onclick ="reset()" title="重置"></button>
		                 <button type="submit"   class="submit-btn"  onclick="save()">保存</button>
		             </span>
		        </div>
		        <div class="grid-com com-line" id="queryGrid">
		        </div>
			</div>
			<div id="content">
				<div>
					<h3>选择菜单</h3>
				</div>
				<div class="zTreeDemoBackground left">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=rootPath%>/res/jquery/jquery-1.6.4.min.js"></script>
    <script src="<%=rootPath%>/res/extjs/ext-all.js"></script>
    <script src="<%=rootPath%>/res/extjs/ext-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=rootPath%>/res/ztree/js/jquery.ztree.all.js"></script>
    <script src="<%=rootPath%>/page/role/js/rolefunc.js"></script>
</body>

</html>