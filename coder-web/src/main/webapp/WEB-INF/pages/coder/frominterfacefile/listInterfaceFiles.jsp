
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

<title>数据库</title>

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
						<a href="fromInterfaceFile/toAddInterfaceFile"><button type="button"  class="btn btn-lg btn-success btn-block">生成代码</button></a>
                 	</div>
                 	<br>
					<table class="result-tab" width="100%" style="table-layout:fixed;" id="root">
						<tr>
							<th>接口文档</th>
						</tr>
						<c:forEach items="${interfaceFiles}" var="interfaceFile">
							<tr>
								<td><a href="toListInterfaceFiles" >${interfaceFile.interfaceName}</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
