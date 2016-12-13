<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String rootPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	var rootPath = "<%=rootPath%>";
</script>
<script type="text/javascript"
   src="<%=rootPath%>/res/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript"
   src="<%=rootPath%>/res/jquery/plugins/jquery.validate.min.js"></script>
<script type="text/javascript"
   src="<%=rootPath%>/res/jquery/plugins/jquery.validate.message_cn.js"></script>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <title>添加积分供应商</title>
    <link href="<%=rootPath%>/res/extjs/resources/css/ext-all.css" rel="stylesheet" />
    <link href="<%=rootPath%>/theme/gray/css/base.css" rel="stylesheet" />
    <link href="<%=rootPath%>/theme/gray/css/ext/ext.css" rel="stylesheet" />
    <link href="<%=rootPath%>/theme/gray/css/main.css" rel="stylesheet" />
    <!-- 日期控件CSS -->
	<link rel="stylesheet" type="text/css" href="<%=rootPath%>/res/cui/app/datepicker/My97DatePicker/skinex/skinex.css" />

</head>
<body>
    <div class="asideR-cont">
        <div class="add-cnt">
            <ul class="add-lst">
            <form action="" method="post" id="fbean" enctype="multipart/form-data">
            	  <!-- 两个隐藏域的值：type(区分更新还是新增)，opId(用来区分操作的对象) -->
                  <input type="hidden" id="type" name="type" value="${type }">
                  <input type="hidden" id="opId" name="opId" value="${opId}">
                   <li>
                      <label class="lbl-txt">操作员类型：</label>
                      <span class="query-item">
                          <div class="combo" id="opKindCombo"></div>
                      </span>
                      <span class="require">*</span>
                      <input type="hidden" id="opKind" name="opKind" value="${sysOp.opKind }" />
                  </li> 
                  <li>
                      <label class="lbl-txt">操作员名称：</label>
                      <input type="text" class="input-text ver-right"  id="opName" name="opName" value="${sysOp.opName }" />
                      <span class="require">*</span>
                  </li>
                  <li>
                      <label class="lbl-txt">操作员编码：</label>
                      <input type="text" class="input-text ver-right"  id="opCode" name="opCode" value="${sysOp.opCode}" />
                      <span class="require">*</span>
                  </li>
                  <li>
                      <label class="lbl-txt">登录名：</label>
                      <input type="text" class="input-text ver-right"  id="loginCode" name="loginCode" value="${sysOp.loginCode }" />
                      <span class="require">*</span>
                  </li>
                  <li>
                      <label class="lbl-txt">密码：</label>
                      <input type="text" class="input-text ver-right"  id="loginPassword" name="loginPassword" value="${sysOp.loginPassword }" />
                      <span class="require">*</span>
                  </li>
                  <li>
                      <label class="lbl-txt">手机号：</label>
                      <input type="text" class="input-text ver-right"  id="mobileNo" name="mobileNo" value="${sysOp.mobileNo }" />
                  </li>
                  <li>
                      <label class="lbl-txt">电子邮件地址：</label>
                      <input type="text" class="input-text ver-right"  id="emailAdress" name="emailAdress" value="${sysOp.emailAdress }" />
                  </li>
                  </form>
            	<li class="bot-line"></li>
                <li>
                    <label class="lbl-txt">头像上传：</label>
                    <div class="upload-box">
                        <input type="text" class="input-text" id="path" />
                        <!-- file的标签 -->
                        <input type="file" class="file-upload" onchange="" id="uploadFile" name="uploadFile" />
                        <input type="hidden" class="input-text"  id="opPic" name="opPic" value="${sysOp.opPic }"/>
                        <button class="browse-btn">浏览</button>
                    </div>    
                    <button class="upload-btn" id="upload-btn" onclick="upload()" >上传</button>
                </li>
            </ul>
            <div class="form-aciton">
                <button class="submit-btn"   id="saveUser" onclick="save()">保存</button>
                <button class="quit-btn" onclick="cancel()">取消</button>
            </div>
        </div>
    </div>
    <script src="<%=rootPath%>/res/extjs/ext-all.js"></script>
    <script src="<%=rootPath%>/res/extjs/ext-lang-zh_CN.js"></script>
   	<!-- 日期控件JS  -->
	<script type="text/javascript" src="<%=rootPath%>/res/cui/app/datepicker/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=rootPath %>/res/jquery/plugins/jquery.ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=rootPath%>/res/cui/app/datepicker/js/dateField.js"></script>
    <script src="<%=rootPath%>/page/user/js/add.js"></script>

<script>
</body>

</html>