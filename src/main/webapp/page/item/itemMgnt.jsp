<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <title>列表</title>
    <link href="../../theme/gray/css/base.css" rel="stylesheet" />
    <link href="../../res/extjs/resources/css/ext-all.css" rel="stylesheet" />
    <link href="../../theme/gray/css/ext/ext.css" rel="stylesheet" />
    <link href="../../theme/gray/css/main.css" rel="stylesheet" />
</head>

<body>
    <div class="asideR-cont">
        <div class="query-head clearfix">
            <span class="query-item mr20">
                        <label class="query-txt">商品类型</label>
                        <div class="combo" id="simpleCombo"></div>
                    </span>
            <span class="query-item">
                        <input class="query-input" placeholder="供应商名称">
                    </span>
            <span class="query-item posR">
                        <input class="query-input" placeholder="门店">
                        <i class="drowlist-ico"></i>
                    </span>
            <span class="query-btns">
                        <button type="submit" class="btn-search" title="查询"></button>
                        <button type="submit" class="btn-reset" title="重置"></button>
                    </span>
        </div>
        <div class="grid-view" >
            <table>
                <thead>
                    <tr>
                        <th width="20%"><span>订单信息</span></th>
                        <th width="15%"><span>商品信息</span></th>
                        <th width="10%"><span>商品数量</span></th>
                        <th width="15%"><span>支付信息</span></th>
                        <th width="15%"><span>使用信息</span></th>
                        <th width="15%"><span>退货信息</span></th>
                        <th width="10%"><span class="bor-none">订单状态</span></th>
                    </tr>
                </thead>
            </table>
            <div class="scroll">
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <strong>订单编号：222203449290202</strong><br>
                                用户：xxxx<br>
                                手机号： xxxxx<br>
                                下单时间：2015-07-03 12:46
                            </td>
                            <td>
                            类型：优惠券<br>
                            编码：xxxxx<br>
                            名称：xxxxx
                            </td>
                            <td class="c-t">2</td>
                            <td>
                            ¥100 已付款<br>
                            支付方式：积分<br>
                            支付积分：100<br>
                            支付时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">未使用</td>
                            <td>
                            退货类型：xxx<br>
                            退货理由：xxxx<br>
                            退货时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">已退款</td>
                        </tr>
                        <tr>
                            <td>
                                <strong>订单编号：222203449290202</strong><br>
                                用户：xxxx<br>
                                手机号： xxxxx<br>
                                下单时间：2015-07-03 12:46
                            </td>
                            <td>
                            类型：优惠券<br>
                            编码：xxxxx<br>
                            名称：xxxxx
                            </td>
                            <td class="c-t">2</td>
                            <td>
                            ¥100 已付款<br>
                            支付方式：积分<br>
                            支付积分：100<br>
                            支付时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">未使用</td>
                            <td>
                            退货类型：xxx<br>
                            退货理由：xxxx<br>
                            退货时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">已退款</td>
                        </tr>
                        <tr>
                            <td>
                                <strong>订单编号：222203449290202</strong><br>
                                用户：xxxx<br>
                                手机号： xxxxx<br>
                                下单时间：2015-07-03 12:46
                            </td>
                            <td>
                            类型：优惠券<br>
                            编码：xxxxx<br>
                            名称：xxxxx
                            </td>
                            <td class="c-t">2</td>
                            <td>
                            ¥100 已付款<br>
                            支付方式：积分<br>
                            支付积分：100<br>
                            支付时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">未使用</td>
                            <td>
                            退货类型：xxx<br>
                            退货理由：xxxx<br>
                            退货时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">已退款</td>
                        </tr>
                        <tr>
                            <td>
                                <strong>订单编号：222203449290202</strong><br>
                                用户：xxxx<br>
                                手机号： xxxxx<br>
                                下单时间：2015-07-03 12:46
                            </td>
                            <td>
                            类型：优惠券<br>
                            编码：xxxxx<br>
                            名称：xxxxx
                            </td>
                            <td class="c-t">2</td>
                            <td>
                            ¥100 已付款<br>
                            支付方式：积分<br>
                            支付积分：100<br>
                            支付时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">未使用</td>
                            <td>
                            退货类型：xxx<br>
                            退货理由：xxxx<br>
                            退货时间：2015-07-03 12:46
                            </td>
                            <td class="c-t">已退款</td>
                        </tr>
                    </tbody>
                </table>
        </div>
        </div>
    </div>
    <script src="../../res/jquery/jquery-1.6.4.min.js"></script>
    <script src="../../res/extjs/ext-all.js"></script>
    <script src="../../res/extjs/ext-lang-zh_CN.js"></script>
    <script src="../../res/jquery/plugins/jquery.jscroll.js" ></script>
    <script src="../../res/apollo/common.js"></script>
    <script src="/jf-console/page/js/itemMgnt.js"></script>
</body>
</html>