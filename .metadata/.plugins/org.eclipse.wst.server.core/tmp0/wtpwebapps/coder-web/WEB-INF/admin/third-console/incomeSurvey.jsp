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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>收入概况</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="jnwtv,剧能玩">
<meta http-equiv="description" content="JnwtvThirdConsole.IncomeSurvey">

<script type="text/javascript" src="js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.mypagination.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>


<link href="sbadmin-v2.0/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="sbadmin-v2.0/vendor/metisMenu/metisMenu.min.css" rel="stylesheet" type="text/css">
<link href="sbadmin-v2.0/dist/css/sb-admin-2.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" >

<script type="text/javascript">
		 window.dataCount = ${pageInfo.dataCount};
		 window.currentlyPageNo = ${pageInfo.currentlyPageNo};
		 window.pageSize = ${pageInfo.pageSize};
		 $(function (){
		 	$("#date").val('${date}');
			var oInput = document.getElementsByTagName("input");
		 $('#mypage').mypagination( window.dataCount, window.currentlyPageNo, window.pageSize);
		 $('#pageSize').val(window.pageSize);
		});	
		
		function sel(){
			var url = 'toIncomeSurvey?date=' + $("#date").val() 
			;  
        	window.location.href= url ;
		}
		
		function select(pageNo) {
			var pageNo = isNaN(pageNo) ? 1 : pageNo;
			var url = 'toIncomeSurvey?pageNow='+pageNo+'&date=' + $("#date").val()  
			;  
        	window.location.href= url ;
		}
</script>

<style type="text/css">
	.model{
		background-color: #EEE;
		text-align: left;
	}
	input[type=text]{
		width:300px
	}
	.summary{
		position:absolute;
		width:161px;
		font-size:14px;
		color:#666666;
		text-align:left;
	}
	
</style>

</head>

<body>
		<div class="page-wrapper page-wrapper-jnwtv">
               <div class="panel-body" style="top:28; width:100%;padding:15px 0px">
                    <ul class="nav nav-tabs" style="width:100%">
                        <li class="active"><a href="toIncomeSurvey" style="font-size: 20 ; ">收入概况</a>
                        </li>
                        <li><a href="toProductIncome" style="font-size: 20 ; ">作品收入</a> 
                        </li>
                    </ul>
               </div> 
                <div style="position:absolute;top:76; height:63px;width:100px;padding:0px;">
                	<span class="summary" style="position:absolute;top:0px">昨日收入： 
                		<c:if test="${empty incomeMap.yesterdayIncome}">0.00</c:if>
						<c:if test="${!empty incomeMap.yesterdayIncome}">${incomeMap.yesterdayIncome}</c:if> 元</span>
                	<span class="summary" style="top:21px">本月收入：
                		<c:if test="${empty incomeMap.monthIncome}">0.00</c:if>
						<c:if test="${!empty incomeMap.monthIncome}">${incomeMap.monthIncome}</c:if> 元</span>
                	<span class="summary" style="top:42px">累计收入：
                		<c:if test="${empty incomeMap.totalIncome}">0.00</c:if>
						<c:if test="${!empty incomeMap.totalIncome}">${incomeMap.totalIncome}</c:if> 元</span>
                </div>
                 <div style="position:absolute; top:156;width:100%;padding:0px">
                         <h1 class="page-header" style="font-size:18px;color:#666666;text-align:left;margin:0px">月度收入</h1>
	             </div>
	             <div style="position:absolute;top:210px;height:60px;" class="select-panel">
	             	<table  style="width:769px;">
	             		<tr>
	             			<th>时间：</th>
	             			<td><input type="text" name="date" id="date" size="12" readonly="readonly" 
						class="Wdate" onfocus="WdatePicker({skin:'simple',startDate:'%y-%M',dateFmt:'yyyy-MM'})"  value = "${date}"/>
							</td>
							<td style="width:80%;text-align: right;"><button type="button" onclick="sel()">查询</button></td>
	             		</tr>
	             	</table>
	             </div>
	             <div class="result-wrap,result-wrap-jnwtv" style="position:absolute;top:270px;">
		             <table class="result-tab">
		             	<tr>	
							<th>月份</th>
							<th>总收入(元)</th>
							<th>订阅收入(元)</th>
							<th>第三方平台收入(元)</th>
							<th>保底金(元)</th>
						</tr>
						<c:forEach items="${pageInfo.dataList}" var="income" >
		             	<tr>
		             		<c:if test="${empty income.month}"> 
										<td>0.00</td>
							</c:if>
						    <c:if test="${!empty income.month}">
										<td>${income.month}</td>
							</c:if>
							<c:if test="${empty income.totalMonthIncome}">
										<td>0.00</td>
							</c:if>
						    <c:if test="${!empty income.totalMonthIncome}">
										<td>${income.totalMonthIncome}</td>
							</c:if>
							<c:if test="${empty income.monthIncome}">
										<td>0.00</td>
							</c:if>
						    <c:if test="${!empty income.monthIncome}">
										<td>${income.monthIncome}</td>
							</c:if>
							<c:if test="${empty income.cartoonChannelIncome}">
										<td>0.00</td>
							</c:if>
						    <c:if test="${!empty income.cartoonChannelIncome}">
										<td>${income.cartoonChannelIncome}</td>
							</c:if>
							<c:if test="${empty income.baseMoney}">
										<td>0.00</td>
							</c:if>
						    <c:if test="${!empty income.baseMoney}">
										<td>${income.baseMoney}</td>
							</c:if>
							
		             	</tr>
		             	</c:forEach>
		             </table>
		             <div id="mypage" class="page mypagination" align="right"></div>
		             <br>
		             <li style="color: #494e8f ; font-size: 18 ; ">总收入 , 订阅收入均已按照收入分配比进行结算</li>
	             </div>
         </div>
		<script type="text/javascript">
			$(function(){
				window.top.resize(900);
			});
		</script>		
</body>
</html>
