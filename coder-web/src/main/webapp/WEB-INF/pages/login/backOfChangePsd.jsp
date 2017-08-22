
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>修改密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700"
	rel="stylesheet" />
<script src="js/jquery.min.js"></script>
<script src="js/config.js"></script>
<script src="js/skel.min.js"></script>
<script type="text/javascript" src="js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>

</head>

<script type="text/javascript">
	$(function() {
	var oInput = document.getElementsByTagName("input");
	});

	var errMsg=[	'密码必须多于或等于 6 个字符。',
					'密码必须多于或等于 6 个字符。',
		            '重复密码与原密码不一致！' 
		            ] ; 
		            
		var pattern=[ /^[\w]{6,18}$/ , 
						/^[\w]{6,18}$/ , 
		            	'' , 
		            ];
		function showMsg(strName, strText){
			//strText = arguments[1];
			strName.parentNode.getElementsByTagName("span")[0].innerHTML='';
			strName.parentNode.getElementsByTagName("span")[0].innerHTML+=strText;
		}
		 
		function clearMsg(strId){
			strId.parentNode.getElementsByTagName("span")[0].innerHTML='';
		}
		function regCheck(oThis){
		  	nType=arguments[1];
			if (nType==2) {
				
			 	strCon = !(document.getElementsByName('newPassWord')[0].value==document.getElementsByName('rePassWord')[0].value);
			 }
			else {
			  strCon = !pattern[nType].test(oThis.value);
			 }
			 
			if ( strCon ){
				//alert(errMsg[nType]);
				showMsg(oThis, errMsg[nType]);
				var $input = $($(".input" )[nType]); 
				var val = $input.val();
				setTimeout(function(){$input.focus();},0);
				return false ;
			} else {
				clearMsg(oThis);
			return true;
			}
		}
		function validateform(){
			var oSpan   = document.getElementsByTagName("span");
			var bIsTrue = true;
			for (var i=0;i<oSpan.length;i++){
			  if(bIsTrue==false){ 
				// alert('输入有错，请重新检查');
				  oSpan[i-1].parentNode.getElementsByTagName("input")[0].focus();
				  return false;
			  }
			  oInput = oSpan[i].parentNode.getElementsByTagName("input");
			  bIsTrue=regCheck(oInput[oInput.length-1],i)&&bIsTrue;
			}
			if (bIsTrue==true) {
			 	 return true;
			}
		}
		
		function changePsd(){
			if(1==1) {
		        var d=$("#changePsdForm").serialize();
		        $.post("changePsd", d, function (result) { 
		        	alert( result.message);
		        	if(result.succ){
		        		window.location.href = "homepage"  ;
		        	}	        	
		         });
			}
		}
		
		$(function(){
			$("#btnChangePsd").click(function(){
				$.post("");
			})
		}) ;
		
		
		
		
</script>

<body>
	<div class="container clearfix">

		<!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<span>修改密码</span>
				</div>
			</div>
			<div class="result-wrap" style="background-color: gray; height: 75%">
				<div class="result-content">
					<form  method="post" id="changePsdForm" name="changePsdForm"
						enctype="multipart/form-data" >
						<div align="center" style="margin-top: 35px">
							 <div class="row half">
								<div class="row half" style="margin-top: 35px">
									<div class="12u">
									<label> 管&nbsp;理员：</label>
										<input class="input" type="text" name="adminName" id="adminName"
											value="${sessionScope.loginUser.userName }" disabled="disabled"> <span
											style="color: red;"></span>
									</div>
								</div>
								<div class="row half" style="margin-top: 35px">
									<div class="12u">
									<label> 原始密码：</label>
										<input class="input" type="password" name="oldPassWord" id="oldPassWord"
											onchange="regCheck(this,0)"
											placeholder=" 输入原始密码 "> <span
											style="color: red;"></span>
									</div>
								</div>
								<div class="row half" style="margin-top: 35px">
									<div class="12u">
										<label>新的密码：</label>
										<input class="input" type="password" name="newPassWord" id="newPassWord"
											onchange="regCheck(this,1)"
											placeholder=" 新的密码  *6~18位字母或数字"> <span
											style="color: red;"></span>
									</div>
								</div>
								
								<div class="row half" style="margin-top: 35px">
									<div class="12u">
										<label>重复密码：</label>
										<input class="input" type="password" name="rePassWord" id="rePassWord"
											onchange="regCheck(this,2)" placeholder="确认密码"> <span
											style="color: red;"></span>
									</div>
								</div>
							</div>
							<div class="row half"  style="margin-top: 35px;" align="center" >
								<div class="12u">
									<button id="btnChangePsd">确定</button>
									<input  onclick=" " type="button"  value="返回"> 	
								</div>
							</div>

					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
