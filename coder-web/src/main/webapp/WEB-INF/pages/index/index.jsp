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

<title>CODER</title>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script src="js/config.js"></script>
<script src="js/skel.min.js"></script>

<link rel="shortcut icon" href="jnwtv.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<link href="sbadmin-v2.0/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="sbadmin-v2.0/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="sbadmin-v2.0/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="sbadmin-v2.0/vendor/morrisjs/morris.css" rel="stylesheet">
<link href="sbadmin-v2.0/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="js/lib/modernizr.min.js"></script>
<script src="sbadmin-v2.0/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="sbadmin-v2.0/vendor/metisMenu/metisMenu.min.js"></script>
<script src="sbadmin-v2.0/dist/js/sb-admin-2.js"></script>
<style> 
#wrapper{ margin:0 auto;width:1300px;text-align:center} 
</style> 
</head>

<body>

    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand"   style="color:#444 ;font-size:16;">CODER</a>
            </div>
           	<div class="navbar-default sidebar" role="navigation" style="height:700px">
                <div id="sidebar" class="sidebar-nav navbar-collapse" style="width:150px;height:700px;border-right-style: solid;border-width: 1px">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="toListDatabases" style="font-size: 18;" target="main"><i class="fa fa-home fa-fw"></i> 数据结构</a>
                        </li>
                    </ul>
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="toListDatabases" style="font-size: 18;" target="main"><i class="fa fa-home fa-fw"></i> 接口文档</a>
                        </li>
                    </ul>
                </div>
                <div id="divMain" style="position: absolute;top:0px;left:0px;margin-left:200px; width:1100px;padding:0px;height:900px">
                	<iframe id="main" name="main" src="toListDatabases" style="width:1100px;height:900px" scrolling="none"></iframe>
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
