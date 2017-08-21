
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>小说月收入报表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.11.4.css" />
<script type="text/javascript" src="js/jquery-ui/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui-1.11.4.js"></script>
<script type="text/javascript" src="js/jquery.mypagination.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	
	$(function(){
		$("#niId").val('${niId}');
	}) ;
	
	/* 根据类型筛选审核列表 */
	function sel(){
		var url = 'queryNovelMonthIncome?niId=' + ${niId}
		;  
    	window.location.href= url ;
		
	}
	
	/* 根据类型筛选审核列表 */
	function exp(){
		var url = 'exportNovelMonthIncome?niId=' + ${niId}
		;  
    	window.location.href= url ;
		
	}
	
</script>

</head>

<body>
	
	<div>
		<!--/sidebar-->
		<div class="main-wrap" id="topDiv">
		
			<div class="result-wrap">
				<div style="height:80px;">
					<table style="width:100%;">
						</tr>
						<tr>
							<td align="left" >
								<button type="button" onclick="exp()"  >
									&nbsp;&nbsp;导出&nbsp;&nbsp;
								</button>
							</td>
							<td colspan="3"></td>
						</tr>
					</table>
				</div>	
				<div class="result-content">
						<table class="result-tab" width="100%" style="table-layout:fixed;" id="tb">
							<tr>
								<th>日期</th>
								<th>月收入(点击查看明细)</th>
								<th>结算状态</th>
							</tr>
							<c:forEach items="${novelIncomeReportVOs}" var="novel">
								<tr>
									<td>${novel.createDate }</td>
									<td><a style="color: blue;" href="queryNovelDayIncome?niId=${novel.niId}&createDt=${novel.createDate}" type="button">${novel.monthIncomeCnt }</td>
									<td>${novel.state}</td>
								</tr>
							</c:forEach>
						</table>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
