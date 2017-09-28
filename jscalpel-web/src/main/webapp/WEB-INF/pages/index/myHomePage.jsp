<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>

<html>
<head> 
<base href="<%=basePath%>">

<title>我的首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="jnwtv,剧能玩">
<meta http-equiv="description" content="JnwtvThirdConse.MyHomePage">

<link href="sbadmin-v2.0/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="sbadmin-v2.0/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<script src="sbadmin-v2.0/vendor/jquery/jquery.min.js" type="text/javascript"></script>

<style type="text/css">
	.model{
		background-color: #ffffff;
		text-align: left;
	}
	input[type=text]{
		width:300px
	}
	.panel-heading{
		height:52px;
	}
	.panel-heading .title{
		position:absolute; 
		left:15;
		top:18;
		width:50%;
		height:22px;
		font-size:16px;
		color:#ffffff;
		text-align:left;
	}
	
	
	
</style>

</head>
<body>
		<div id="page-wrapper page-wrapper-style" style="background-color: #ffffff ; position: absolute;width:900px;margin:0px; left:0px;height:600px" >
            <div class="row">
                <div style="width:90px;height:90px;position: absolute;left:70;top: 24px; border-radius: 5px">
                	<c:if test="${empty userInfo.headImg}">
                		<img   src="images/head.jpg" style="width:90px;height:90px;position: absolute;border-radius: 50%">
                	</c:if>
                	<c:if test="${!empty userInfo.headImg}">
                		<img   src="${ userInfo.headImg}" style="width:90px;height:90px;position: absolute;border-radius: 50%">
                	</c:if>
                </div>
                <div style="width:120px;height:24px;position: absolute;left:50;top:137px;text-align:center;font-size:16px;color:#666666;">${ userInfo.realName}</div>
                <div style="position:absolute; width:250px;left:200px;top:24px">
	                <div class="panel panel-red"  >
	                     <div class="panel-heading" style="height:52px;padding: 0px">
	                     	<div class="title">收入
	                     	</div>
	                     </div>
	                     <div class="panel-body" style="color:#d9534f;font-size:14px;text-align:left;">
	                         <p>昨日新增 : 
	                         	<c:if test="${empty userProductDayCount.income}">0.00</c:if>
								<c:if test="${!empty userProductDayCount.income}">${userProductDayCount.income}</c:if> 元
	                         </p>
	                         <p>总计：
	                         	<c:if test="${empty userProjectTotalCount.totalIncome}">0.00</c:if>
								<c:if test="${!empty userProjectTotalCount.totalIncome}">${userProjectTotalCount.totalIncome}</c:if> 元
	                         </p>
	                     </div>
	                 </div>
                </div>
                <div style="position:absolute; width:250px;left:490px;top:24px">
	                <div class="panel panel-primary"  >
	                      <div class="panel-heading" style="height:52px;padding: 0px">
	                     	<div class="title">阅读量
	                         </div>
	                     </div>
	                     <div class="panel-body" style="color:#337ab7">
	                         <p>昨日新增：
	                         	<c:if test="${empty userProductDayCount.readingNum}">0</c:if>
								<c:if test="${!empty userProductDayCount.readingNum}">${userProductDayCount.readingNum}</c:if> 次
	                         </p>
	                         <p>总计：
	                         	<c:if test="${empty userProjectTotalCount.readingNum}">0</c:if>
								<c:if test="${!empty userProjectTotalCount.readingNum}">${userProjectTotalCount.readingNum}</c:if> 次
	                         </p>
	                     </div>
	                 </div>
                </div>
			</div>
			
			<div style="position:absolute; left:50px;top:190px;width:800px;">
                <div class="panel panel-default"  >
                     <div class="panel-heading" >
                     	<div class="title" style="color:#333333">最新作品</div>
                     </div>
                     <div class="panel-body"  style="height:250px;padding:0px;">
						<div style="width:120px;height:160px;position: absolute;top:83px;left:30">
							<c:if test="${empty userNewProductInfo.coverImg}">
                				<img   src="images/noproduct.jpg"  style="width:120px;height:160px;">
                			</c:if>
                			<c:if test="${!empty userNewProductInfo.coverImg}">
                				<img   src="${ userNewProductInfo.coverImg}"  style="width:120px;height:160px;">
                			</c:if>
						</div>
						<div style="width:220px;height:160px;position: absolute;top:83px;left:179">
							<span style="position:absolute; top:0px;font-size:18px;color:#333333;text-align:left; width: 600; ">作品名称 : ${userNewProductInfo.name }</span>
							<span style="position:absolute;top:42px;font-size:14px;color:#333333;text-align:left;">更新至第${userNewProductInfo.updateNum}章/话</span>
							<span style="position:absolute;top:65px;font-size:14px;color:#333333;text-align:left;">共上线${ userNewProductInfoDetail.totalWordsOrPages}字/P</span>
							<span style="position:absolute;top:113px;font-size:14px;color:#777777;text-align:left;">${ userNewProductInfoDetail.addState}</span>
							<span style="position:absolute;top:135px;font-size:14px;color:#777777;text-align:left;">更新时间：${ userNewProductInfoDetail.updateDt}</span>
						</div>
						<div style="width:240px;height:160px;position: absolute;top:83px;left:450">
							<span style="position:absolute; top:73px;font-size:18px;color:#d9534f;text-align:left;">收入：
								<c:if test="${empty userNewProductCount.income}">0.00</c:if>
								<c:if test="${!empty userNewProductCount.income}">${userNewProductCount.income}</c:if> 元
							</span>
							<span style="position:absolute; top:93px;font-size:18px;color:#337ab7;text-align:left;">阅读：
								<c:if test="${empty userNewProductCount.readingNum}">0</c:if>
								<c:if test="${!empty userNewProductCount.readingNum}">${userNewProductCount.readingNum}</c:if> 次
							</span>
						</div>
                     </div>
                 </div>
			</div>
          </div>
	<script type="text/javascript">
		$(function(){
			window.top.resize(600);
		});
	</script>	
</body>
</html>
