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
	<form id="editUserInfoForm" name="editUserInfoForm" enctype="multipart/form-data" >
		<div id="page-wrapper"  style="background-color: #ffffff ; position: absolute;width:900px;margin:0px; left:0px;height:600px" >
		
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" style="font-size: 24 ; ">企业信息</h1>
                </div>
            </div>
            
            <div class="row">
            
                <div class="col-lg-4">
                    <div  class="panel panel-primary" >
                    	 <div class="panel-footer" style="font-size: 16 ; ">
                            	<strong >* 合作方名称 : <input id="partnerName" name="partnerName" type="text" value="${ thirdUserInfo.partnerName}" /></strong>
                        </div>
                        <div class="panel-footer" style="font-size: 16 ;">
                        	<strong >合作方简介 : </strong>
                        </div>
                        <div class="panel-body" style="font-size: 14 ; font-weight: bold ;">
                        	<textarea id="partnerBrief1" name="partnerBrief"  rows="2" cols="108">${ thirdUserInfo.partnerBrief}</textarea>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-12">
                    <h1 class="page-header" style="font-size: 24 ; ">企业资料</h1>
                </div>
                
                <div class="col-lg-4">
                    <div class="panel panel-primary" >
                        <div class="panel-footer" style="font-weight:blod; " >
                            <strong >* 公司名称 : <input id="corporateName" name="corporateName" type="text" value="${ thirdUserInfo.corporateName}" /></strong>
                        </div>
                        <div class="panel-body">
                            <strong >* 联系人姓名 : <input id="contractName" name="contractName" type="text" value="${ thirdUserInfo.contractName}" /></strong>
                        </div>
                        <div class="panel-footer">
                             <strong >* 身份证号 : <input id="idName" name="idName" type="text" value="${ thirdUserInfo.idName}" /></strong>
                        </div>
                        <div class="panel-body">
                            <strong >* 联系手机 : <input id="phone" name="phone" type="text" value="${ thirdUserInfo.phone}" /></strong>
                        </div>
                        <div class="panel-footer">
                             <strong >联系QQ : <input id="qq" name="qq" type="text" value="${ thirdUserInfo.qq}" /></strong>
                        </div>
                        <div class="panel-body">
                            <strong >联系邮箱 : <input id="mail" name="mail" type="text" value="${ thirdUserInfo.mail}" /></strong>
                        </div>
                        <div class="panel-footer">
                             <strong >所在地区 : <input id="address" name="address" type="text" value="${ thirdUserInfo.address}" /></strong>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-12">
                    <h1 class="page-header" style="font-size: 24 ; ">支付信息</h1>
                </div>
                
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-footer">
                            <strong >* 开户银行 : <input id="openingBank" name="openingBank" type="text" value="${ thirdUserInfo.openingBank}" /></strong>
                        </div>
                        <div class="panel-body">
                            <strong >* 户名 : <input id="accountName" name="accountName" type="text" value="${ thirdUserInfo.accountName}" /></strong>
                        </div>
                        <div class="panel-footer">
                            <strong >* 银行卡号 : <input id="cardName" name="cardName" type="text" value="${ thirdUserInfo.cardName}" /></strong>
                        </div>
                    </div>
                </div>
                
                  <li  style="font-weight: bold ; text-align: right ;">温馨提示：所带星号标记为必填项！</li>
                  
                 <div class="col-lg-4">
                    <div>
                        <div class="panel-body">
                            <input style="font-size: 18 ;font-weight: bold ;" id="btnSub" type="button" value="提交">
                        </div>
                    </div>
                </div>
                
                
           	</div>
           </div>
        </form>		
<script type="text/javascript">
		$(function(){
			window.top.resize(600);
		});
	
	$(function(){
		$("#btnSub").click(function(){
			if(!confirm("确认提交？")){
				return ;
			}
			var phone = $("#phone").val();
			var cardName = $("#cardName").val(); 
			
			if (isNaN(phone) || isNaN(cardName)) {
				alert("手机号或者银行卡号请输入数字！") ;
				return ;
			}
			
			var d=$("#editUserInfoForm").serialize();
	        $.post("editUserInfo", d , function(data) { 
	        	alert(data.codeMsg);
	        	if(data.code == '0'){
	        		window.location.href = "touserInfo"  ;
		        	};	 
	         });	
		});
	});
	
	
</script>	
</body>
</html>
