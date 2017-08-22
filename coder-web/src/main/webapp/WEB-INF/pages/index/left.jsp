<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="container clearfix">
	<div class="sidebar-wrap">
		<div class="sidebar-title">
			<h1>菜单</h1>
		</div>
		<div class="sidebar-content">
			<ul class="sidebar-list">
				<li class="model"  name="aModel"><a><i class="icon-font">&#xe003;</i>常用操作</a>
					<ul class="sub-menu">
						<li><a href="#" id="showDoctorReviewList"><i
								class="icon-font">&#xe008;</i>账户管理</a></li>
						<li><a href=""><i class="icon-font">&#xe052;</i>意见反馈</a></li>
						<li><a href=""><i class="icon-font">&#xe033;</i>用户管理</a></li>
						<li><a href=""><i class="icon-font">&#xe017;</i>活动管理</a>
						</li>
					</ul>
				</li>
				<li class="model"  name="aModel""><a><i class="icon-font">&#xe003;</i>常用操作2</a>
					<ul class="sub-menu">
						<li><a href="#" id="showDoctorReviewList"><i
								class="icon-font">&#xe008;</i>账户管理</a></li>
						<li><a href=""><i class="icon-font">&#xe033;</i>用户管理</a></li>
						<li><a href=""><i class="icon-font">&#xe017;</i>活动管理</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>

</body>

<script type="text/javascript">

	$(function(){

		
		
		 $("[name=aModel]").each(function(){
		 	$(this).click(function(s){
		 	
				$(s.target).parents(".model").find(".sub-menu").toggle( );
		 	
		 	} ) ;
		 }) ;
		
		$(".sub-menu :not(:first)").hide() ;
		
	
		
	}) ;
		

</script>
