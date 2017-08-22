<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>剧能玩后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<script type="text/javascript" src="js/lib/modernizr.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="container clearfix">
		<!--/sidebar-->
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font">&#xe06b;</i><span>欢迎登陆剧能玩后台</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>快捷操作</h1>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>系统基本信息</h1>
				</div>
				<div class="result-content">
					<ul class="sys-info-list">
						<li><label class="res-lab">数据库信息</label><span class="res-info">${dbUrl}</span>
						</li>
						<li><label class="res-lab">操作系统</label><span class="res-info">WINDOWS</span>
						</li>
						<li><label class="res-lab">运行环境</label><span class="res-info">Apache/2.2.21
								(Win64/32) /5.3.10</span></li>
						<li><label class="res-lab">版本</label><span
							class="res-info">v-0.1</span></li>
						<li><label class="res-lab">上传附件限制</label><span
							class="res-info">5M</span></li>
						<li><label class="res-lab">北京时间</label><span class="res-info">2016年01月31日
								00:00:00</span></li>
						<li><label class="res-lab">服务器域名/IP</label><span
							class="res-info">jnwtv.com</span></li>
						<li><label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
						</li>
					</ul>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>联系我们</h1>
				</div>
				<div class="result-content">
					<ul class="sys-info-list">
						<li><label class="res-lab">电话：</label><span
							class="res-info"><a href="http://www.tamukeji.com/"
								target="_blank">010 - </a>
						</span></li>
						<li><label class="res-lab">邮箱：</label><span
							class="res-info"><a class="qq-link" target="_blank"
								href="qihui.liu@jnwtv.com">jingkun.chen@jnwtv.com
							</a> </span></li>
					</ul>
				</div>
				</div>
			</div>
		</div>
</body>
</html>