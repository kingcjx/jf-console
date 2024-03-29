<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
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
<link rel="stylesheet" type="text/css"
	href="<%=rootPath%>/res/cui/app/datepicker/My97DatePicker/skinex/skinex.css" />
</head>

<body>
	<div class="asideR-cont">
		<div class="add-cnt">
			<ul class="add-lst">
				<li><label class="lbl-txt">商品形态：</label> <span
					class="form-input"> <label class="mr30"><input
							type="radio" name="s" /> 实体商品</label> <label><input type="radio"
							name="s" /> 虚拟商品</label>
				</span> <span class="require">*</span></li>
				<li><label class="lbl-txt">积分供应商名称：</label> <input type="text"
					class="input-text ver-error" /> <span class="require">*</span>
					<p class="error-tip">请输入正确的名称</p></li>
				<li><label class="lbl-txt">积分供应商名称：</label> <textarea
						class="textarea"></textarea> <span class="require">*</span>
					<p class="error-tip">请输入正确的名称</p></li>
				<li><label class="lbl-txt">积分供应商名称：</label> <textarea
						class="textarea textarea-lg"></textarea> <span class="require">*</span>
					<p class="error-tip">请输入正确的名称</p></li>
				<li><label class="lbl-txt">别名：</label> <input type="text"
					class="input-text ver-right" /> <span class="require">*</span></li>
				<li><label class="lbl-txt">积分供应商类型：</label> <span
					class="query-item">
						<div class="combo" id="simpleCombo2"></div>
				</span> <span class="require">*</span></li>
				<li class="bot-line"></li>
				<li><label class="lbl-txt">积分兑换比率：</label> <input type="text"
					class="input-text" /> <span class="require">*</span>例如100联通积分兑换1积分币，填写100
				</li>
				<li><label class="lbl-txt">积分兑换费率：</label> <input type="text"
					class="input-text" /> <span class="require">*</span> 兑换1积分币需要供应商积分
				</li>
				<li class="bot-line"></li>
				<li><label class="lbl-txt">结算周期：</label> <span
					class="query-item">
						<div class="combo" id="simpleCombo"></div>
				</span> <span class="require">*</span></li>
				<li><label class="lbl-txt">结算方式：</label> <span
					class="query-item">
						<div class="combo" id="simpleCombo3"></div>
				</span> <span class="require">*</span></li>
				<li class="bot-line"></li>
				<li><label class="lbl-txt">企业营业执照：</label>
					<div class="upload-box">
						<input type="text" class="input-text" /> <input type="file"
							class="file-upload" onchange="uploadImage(this)" /> <span
							class="require">*</span>
						<button class="browse-btn">浏览</button>
					</div>
					<button class="upload-btn">上传</button></li>
				<li><label class="lbl-txt">合同扫描件：</label>
					<div class="upload-box">
						<input type="text" class="input-text" /> <input type="file"
							class="file-upload" /> <span class="require">*</span>
						<button class="browse-btn">浏览</button>
					</div>
					<button class="upload-btn">上传</button></li>

				<li class="bot-line"></li>
				<li><label class="lbl-txt">地址：</label> <span
					class="query-item mr10">
						<div class="combo" id="simpleCombo4"></div>
				</span> <span class="query-item">
						<div class="combo" id="simpleCombo5"></div>
				</span></li>
				<li><label class="lbl-txt">详细地址：</label> <input type="text"
					class="input-text-lg" value="详细地址，如成都市成华区荆翠中路120号" /></li>
				<li><label class="lbl-txt">联系人：</label> <input type="text"
					class="input-text" /></li>
				<li><label class="lbl-txt">电话：</label> <input type="text"
					class="input-text" value="如80478980或80478980-2380" /></li>
				<li><label class="lbl-txt">手机号码：</label> <input type="text"
					class="input-text" value="如13688411889" /></li>
				<li><label class="lbl-txt">起止时间：</label> <span class="posR">
						<input readonly="readonly" id="startDate" name="startDate"
						type="text" class="input-text"> <i class="cal-ico"
						id="startDateBox"></i> <span class="require">*</span>
				</span> - <span class="posR"> <input readonly="readonly"
						id="endDate" name="endDate" type="text" class="input-text">
						<i class="cal-ico" id="endDateBox"></i> <span class="require">*</span>
				</span></li>
				<li><label class="lbl-txt"></label> <span class="form-input">
						<label><input type="checkbox" /> 全部</label>
				</span></li>
				<li><label class="lbl-txt">购买须知：</label> <textarea
						class="textarea textarea-lg" id="text">
					详有效期：
					2015-05-08至2015-12-16
					规则提醒：
					全场通用、可与其他优惠券叠加使用，全场通用、可与其他优惠券叠加使用全场通用、可与
                    </textarea> <span class="require">*</span>
					<p class="error-tip">请输入正确的名称</p></li>
				<li><label class="lbl-txt">xxxxx：</label>
					<div class="form-grid wd565" id="otherGrid"></div></li>
			</ul>
			<div class="form-aciton">
				<button class="submit-btn">确认提交</button>
				<button class="quit-btn">取消</button>
				<button class="btn-appro">审批通过</button>
				<button class="btn-unappro">审批不通过</button>
			</div>
		</div>
	</div>
	<script src="<%=rootPath%>/res/jquery/jquery-1.6.4.min.js"></script>
	<script src="<%=rootPath%>/res/extjs/ext-all.js"></script>
	<script src="<%=rootPath%>/res/extjs/ext-lang-zh_CN.js"></script>
	<!-- 日期控件JS  -->
	<script type="text/javascript"
		src="<%=rootPath%>/res/cui/app/datepicker/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=rootPath%>/res/cui/app/datepicker/js/dateField.js"></script>
	<script src="<%=rootPath%>/page/marchant/js/addMarchant.js"></script>
</body>

</html>