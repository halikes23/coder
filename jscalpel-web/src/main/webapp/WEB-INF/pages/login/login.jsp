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

<title>剧能玩-三方控制台</title>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700"
	rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script src="js/config.js"></script>
<script src="js/skel.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css" />
<script type="text/javascript" src="<%=basePath %>js/lib/modernizr.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="<%=basePath %>sbadmin-v2.0/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=basePath %>sbadmin-v2.0/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=basePath %>sbadmin-v2.0/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=basePath %>sbadmin-v2.0/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="<%=basePath %>vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath %>vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=basePath %>vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=basePath %>dist/js/sb-admin-2.js"></script>

</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" style="color:green ;">请登录</h3>
                    </div>
                    <form action="login"	method="post"  id="login" name="login">
                    <div class="panel-body">
                    		 <div class="form-group">
                    			  <p style="color: red; margin-bottom: 10px;"><span>${loginError}</span></p>	
                    		 </div>	   	
                             <div class="form-group">
                                 <input class="form-control" placeholder="账号" name="userName" type="userName"  value="${userName}" autofocus>
                             </div>
                             <div class="form-group">
                                 <input class="form-control" placeholder="密码" name="pwd"  value="${pwd}" type="password"   autofocus>
                             </div>
                             <div class="form-group">
                             	<input class="form-control" placeholder="验证码" name="mobileCode" type="text" value="">
                             </div>
        			 			<input class="btn btn-lg btn-success btn-block"  type="button" id="btn"  value="获取验证码" />
                            	<input onclick="document.all.login.submit();"  class="btn btn-lg btn-success btn-block"  type="button"  value="登录" />
                    </div>
                   </form> 
                </div>
            </div>
        </div>
    </div>

 <script type="text/javascript">
	
	var wait= 60;
	var a = 1 ;
	document.getElementById("btn").disabled = false;   
	function time(o) {
        if (wait == 0) {
            o.removeAttribute("disabled");           
            o.value="获取验证码";
	         wait = 60;
        } else {
            o.setAttribute("disabled", true);
            o.value="重新发送(" + wait + ")";
            wait--;
            setTimeout(function() {
                time(o);
            },
            1000);
        };
    }
    
	function cre(){
		var d=$("#login").serialize();
		$.post("createMobileCode", d , function (res) { 
        	alert(res.message);
        	if( res.succ ){
        		time(document.getElementById("btn"));
        	}else{
        		window.location.href= "login?userName=" + res.userName
        		+ '&pwd=' + res.pwd
        		 ;
        	}
         });
	}
	
	document.getElementById("btn").onclick=function(){cre();}; 
</script> 
</body>
</html>
