
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

<title>数据库表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.11.4.css" />

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui-1.11.4.js"></script>
<script type="text/javascript" src="js/jquery.mypagination.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

</head>

<body>
	
	<div>
		<!--/sidebar-->
		<div class="main-wrap,page-wrapper-coder" id="topDiv">
				
			<div class="result-wrap">	
				<div class="result-content">
					<div class="panel">
						<a href="buildCode?schema=${schema}&table=${table}"><button type="button"  class="btn btn-lg btn-success btn-block">生成代码</button></a>
                 	</div>
                 	<br>
					<table class="result-tab" width="100%" style="table-layout:fixed;" id="tb">
						<tr>
							<th style="width:50px" ><input type="checkbox" checked="checked"></th>
							<th>生成iBatis</th>
						</tr>
						<tr>
							<th style="width:50px" ><input type="checkbox" checked="checked"></th>
							<th>生成Bean</th>
						</tr>
					</table>
					<br>
					<table class="result-tab" width="100%" style="table-layout:fixed;" id="tb">
						<tr>
							<th style="width:50px" ><input type="checkbox" checked="checked"></th>
							<th>字段</th>
							<th>类型</th>
						</tr>
						<c:forEach items="${columns}" var="column">
							<tr>
								<td><input type="checkbox" checked="checked"></td>
								<td>${column.columnName}</td>
								<td>${column.dataType}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
