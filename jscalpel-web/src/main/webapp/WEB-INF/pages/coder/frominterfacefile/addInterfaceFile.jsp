
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

<title>接口文档</title>

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script src="js/config.js"></script>
<script src="js/skel.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<link href="sbadmin-v2.0/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="sbadmin-v2.0/dist/css/sb-admin-2.css" rel="stylesheet">


<script type="text/javascript" src="js/lib/modernizr.min.js"></script>
<script src="sbadmin-v2.0/vendor/bootstrap/js/bootstrap.js"></script>
<script src="sbadmin-v2.0/dist/js/sb-admin-2.js"></script>

</head>

<body>
	<div>
		<!--/sidebar-->
		<div class="main-wrap,page-wrapper-coder" id="topDiv">
		
			<div class="result-wrap">
				<div class="result-content">
					<div class="panel">
						<a href="fromInterfaceFile/toAddInterfaceFile"><button type="button" class="btn btn-lg btn-success btn-block">生成代码</button></a>
                 	</div>
                 	<br>
                 	<table class="result-tab" width="100%" style="table-layout:fixed;" id="root">
						<tr>
							<th colspan="3">对象</th>
						</tr>
						<tr>
							<th>属性</th><th>类型</th><th>操作</th>
						</tr>
						<tr>
							<td>
                            	<input class="form-control" type="text"/>
                            </td>
                            <td>
                            	<select class="form-control"><option class="form-control" value="String">String</option></select>
                            </td>
                            <td>
                            	<button class="form-control" type="button" >添加</button>
                            </td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="leaf">
		<div class="field"></div><div class="dataType"></div>
	</div>
	
</body>
</html>
