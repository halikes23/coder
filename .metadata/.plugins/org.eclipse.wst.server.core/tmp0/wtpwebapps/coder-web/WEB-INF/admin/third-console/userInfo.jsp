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

<title>账号信息</title>

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
		<div id="page-wrapper"  style="background-color: #ffffff ; position: absolute;width:900px;margin:0px; left:0px;height:600px" >
		
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" style="font-size: 24 ; ">企业信息</h1>
                </div>
            </div>
            
            <div class="row">
            
                <div class="col-lg-4">
                    <div  class="panel panel-primary">
                    	 <div class="panel-footer" style="font-size: 18 ; ">
                            	<p>合作方名称 ：</p>
                        </div>
                         <div class="panel-body" style="font-size: 18 ; ">
                            <p>${ thirdUserInfo.partnerName}</p>
                        </div>
                        <div class="panel-footer"  style="font-size: 18 ; ">
                        	<p >合作方简介：</p>
                        </div>
                        <div class="panel-body" style="font-size: 18 ; ">
                            <p >${ thirdUserInfo.partnerBrief}</p>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-12">
                    <h1 class="page-header" style="font-size: 24 ; ">企业资料</h1>
                </div>
                
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-footer">
                            <p>公司名称 ： ${ thirdUserInfo.corporateName}</p>
                        </div>
                        <div class="panel-body">
                            <p>联系人姓名：${ thirdUserInfo.contractName}</p>
                        </div>
                        <div class="panel-footer">
                             <p>身份证号：${ thirdUserInfo.idName}</p>
                        </div>
                        <div class="panel-body">
                            <p>联系手机：${ thirdUserInfo.phone}</p>
                        </div>
                        <div class="panel-footer">
                             <p>联系QQ：${ thirdUserInfo.qq}</p>
                        </div>
                        <div class="panel-body">
                            <p>联系邮箱：${ thirdUserInfo.mail}</p>
                        </div>
                        <div class="panel-footer">
                             <p>所在地区：${ thirdUserInfo.address}</p>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-12">
                    <h1 class="page-header" style="font-size: 24 ; ">支付信息</h1>
                </div>
                
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-footer">
                            <p>开户银行 ： ${ thirdUserInfo.openingBank}</p>
                        </div>
                        <div class="panel-body">
                            <p>户名：${ thirdUserInfo.accountName}</p>
                        </div>
                        <div class="panel-footer">
                            <p>银行卡号：${ thirdUserInfo.cardName}</p>
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
