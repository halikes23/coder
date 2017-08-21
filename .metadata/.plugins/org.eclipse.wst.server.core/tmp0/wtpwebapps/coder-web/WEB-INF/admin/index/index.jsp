<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<meta charset="utf-8">
<base href="<%=basePath%>">

<title>剧能玩 三方控制台</title>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script src="js/config.js"></script>
<script src="js/skel.min.js"></script>
<link rel="shortcut icon" href="jnwtv.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/lib/modernizr.min.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="sbadmin-v2.0/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="sbadmin-v2.0/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="sbadmin-v2.0/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="sbadmin-v2.0/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="sbadmin-v2.0/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- jQuery -->
    <script src="sbadmin-v2.0/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="sbadmin-v2.0/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="sbadmin-v2.0/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="sbadmin-v2.0/dist/js/sb-admin-2.js"></script>
	<style> 
		#wrapper{ margin:0 auto;width:1100px;text-align:center} 
	</style> 
</head>

<body>

    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand"   style="color:#444 ;font-size:16;">剧能玩三方控制台</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                       <!--  <li><a href="#"><i class="fa fa-user fa-fw"></i> 个人信息</a> -->
                        </li>
                        <li><a href="toChangePsdView"><i class="fa fa-gear fa-fw"></i> 密码修改</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="loginOut"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
            </ul>
            	
            	<div class="navbar-default sidebar" role="navigation" style="width:200px;height:700px">
	                <div id="sidebar" class="sidebar-nav navbar-collapse" style="width:200px;height:700px;border-right-style: solid;border-width: 1px">
	                    <ul class="nav" id="side-menu">
	                    	 <c:if test="${PRIV_MY_HOMEPAGE_INFO==true}">
		                        <li>
		                            <a href="toMyHomePage" style="font-size: 18;" target="main"><i class="fa fa-home fa-fw"></i> 我的首页</a>
		                        </li>
		                     </c:if>
		                     <c:if test="${PRIV_INCOME_SURVEY==true}">
		                        <li>
		                            <a href="toIncomeSurvey" style="font-size: 18;" target="main"><i class="fa fa-bar-chart-o fa-fw"></i> 收入概况</a>
		                        </li>
		                    </c:if>
		                    <c:if test="${PRIV_INCOME_SURVEY==true}">
		                         <li>
		                            <a href="toProductIncome" style="font-size: 18;" target="main"><i class="fa fa-rmb fa-fw"></i> 作品收入</a>
		                        </li>
		                     </c:if>
		                     
		                   <%--  <c:if test="${PRIV_INCOME_SURVEY==true}">
		                         <li>
		                            <a href="touserInfo" style="font-size: 18;" target="main"><i class="fa fa-sitemap fa-fw"></i>账号信息</a>
		                        </li>
		                     </c:if> 
		                     
		                     <c:if test="${PRIV_INCOME_SURVEY==true}">
		                         <li>
		                            <a href="toUserInfoEdit" style="font-size: 18;" target="main"><i class="fa fa-bar-chart-o fa-fw"></i>信息修改</a>
		                        </li>
		                     </c:if> --%>
		                      
	                    </ul>
	                </div>
	                <div id="divMain" style="position: absolute;top:0px;left:0px;margin-left:200px; width:900px;padding:0px;height:900px">
	                	<iframe id="main" name="main" src="toMyHomePage" style="width:900px;height:900px" scrolling="none"></iframe>
	                </div>
            </div> 
			
        </nav>
	</div>		
	
	<script type="text/javascript">
		function resize(height){
			console.info("called");
			var $divMain = $("#divMain");
			$divMain.css("height",height);
			
			var $main = $("#main");
			$main.css("height",height);
			
			var $sidebar = $("#sidebar");
			$sidebar.css("height",height);
			
		}
		
	</script>	

</body>

</html>
