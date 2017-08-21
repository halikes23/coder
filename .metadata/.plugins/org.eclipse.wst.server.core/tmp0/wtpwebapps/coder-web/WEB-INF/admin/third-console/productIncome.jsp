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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>作品收入</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="jnwtv,剧能玩">
<meta http-equiv="description" content="JnwtvThirdConsole.ProductIncome">


<script type="text/javascript" src="js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.mypagination.js"></script>

<link href="sbadmin-v2.0/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="sbadmin-v2.0/vendor/metisMenu/metisMenu.min.css" rel="stylesheet" type="text/css">
<link href="sbadmin-v2.0/dist/css/sb-admin-2.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" >

<script type="text/javascript">
 		window.dataCount = ${pageInfo.dataCount};
		 window.currentlyPageNo = ${pageInfo.currentlyPageNo};
		 window.pageSize = ${pageInfo.pageSize};
		 $(function (){
		 	$("#name").val('${name}');
		 	$("#date").val('${date}');
		 	$("#channelName").val('${channelName}');
			var oInput = document.getElementsByTagName("input");
		 $('#mypage').mypagination( window.dataCount, window.currentlyPageNo, window.pageSize);
		 $('#pageSize').val(window.pageSize);
		});
		
		function sel(){
			var url = 'toProductIncome?pageNow=1&date=' + $("#date").val() 
			+ '&name=' + $("#name :selected").val()
			+ '&channelName=' + $("#channelName :selected").val()
			;  
        	window.location.href= url ;
			
		}
		
		function select(pageNo) {
			var pageNo = isNaN(pageNo) ? 1 : pageNo;
			var url = 'toProductIncome?pageNow='+pageNo+'&date=' + $("#date").val() 
			+ '&name=' + $("#name :selected").val()
			+ '&channelName=' + $("#channelName :selected").val()
			;  
			window.location.href = url ;
		}	
		
		
</script>
<style type="text/css">
	.model{
		background-color: #EEE;
		text-align: left;
	}
</style>

</head>

<body>
		 
		<div class="page-wrapper page-wrapper-jnwtv" >
               <div class="panel-body"  style="top:28;width:100%;padding:15px 0px">
                    <ul class="nav nav-tabs">
                         <li><a href="toIncomeSurvey" style="font-size: 20 ; ">收入概况</a>
                        </li>
                        <li class="active"><a href="toProductIncome" style="font-size: 20 ; ">作品收入</a>
                        </li>
                    </ul>
                </div>
                
				<div style="height:60px;vertical-align: middle;" class="select-panel" >
					<table style="width:769px;">
						<tr>
							<th>
								作品 ：
							</th>
							<td >
								<select id="name" name="name" style="width: 180px" value = "${name}">
									<option value=" " >所有作品</option>
									<c:forEach items="${userProductInfoList}" var="userProduct">
										<option value="${userProduct.name}" >${userProduct.name}</option>
									</c:forEach>
								</select>
							</td>
							<th>
								时间 ：
							</th>
							<td>
								<input type="text" name="date" id="date" size="12" readonly="readonly"
									class="Wdate form-input" onfocus="WdatePicker({skin:'simple',startDate:'%y-%M',dateFmt:'yyyy-MM'})" 
									 value = "${date}"/>
							</td>
							<th>
								渠道 ：
							</th>
							<td>
								<select id="channelName" name="channelName" style="width: 180px" value = "${channelName}">
									<option value="1" >所有渠道</option>
									<option value="剧能玩" >剧能玩</option>
									<option value="三方" >三方</option>
								</select>
							</td>
							<td style="width:30%;text-align: right">
								<button type="button" onclick="sel()"  >
									&nbsp;&nbsp;查询&nbsp;&nbsp;
								</button>
							</td>
						</tr>
					</table>
				</div>
				
				<div class="result-wrap,result-wrap-jnwtv">
							<table class="result-tab">
								<tr>	
									<th style="width:200px ;">作品</th>
									<th>月份</th>
									<th>收入(元)</th>
									<th>渠道</th>
								</tr>
								<c:forEach items="${pageInfo.dataList}" var="prductIncome" >
								<tr>
									<td>${prductIncome.name}</td>
									<td>${prductIncome.month}</td>
									<c:if test="${empty prductIncome.totalMonthIncome}">
										<td>0.00</td>
									</c:if>
								    <c:if test="${!empty prductIncome.totalMonthIncome}">
												<td>${prductIncome.totalMonthIncome}</td>
									</c:if>
									<td>${prductIncome.channelName}</td>
								</tr>
								</c:forEach>
							</table>
							<div id="mypage" class="page mypagination"  align="right"></div>
				</div>
         </div>
		<script type="text/javascript">
			$(function(){
				window.top.resize(680);
			});
		</script>		
</body>
</html>
