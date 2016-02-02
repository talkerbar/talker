<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>会员登录-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
    <script src="/talker/js/login.js"></script>
    <link rel="stylesheet" href="/talker/css/login.css">
</head>
<body>
	<div class="warp-login">
		<div class="warp-login-head">
			<a href="" class="logo">
				<img src="" alt="logo">
			</a>
			<a href="talker/index" class="index">
				<span>返回首页</span>
			</a>
		</div>
		<div class="warp-login-body">
			<div class="warp-content">
				<div class="content">
					<ul>
						<li class="desc">
							<span>登录</span>
							<span><a href="/talker/public/regist">免费注册</a></span>
						</li>
						<li class="username info">
							<span class="icon-username icon"></span>
							<input type="tel" name="username" id="username" maxlength="11" placeholder="手机号"/>
						</li>
						<li class="password info">
							<span class="icon-password icon"></span>
							<input type="password" name="password" id="password" placeholder="6-18位密码"/>
						</li>
						<li class="help">
							<a href="">忘记密码？</a>
						</li>
						<li class="confirm-login">
							<button class="submit login">登陆</button>
						</li>
						<li class="other">
							
						</li>
					</ul>
				</div>
			</div>
		</div>
	    <!-- 提示  -->
	    <div class="tip">
	    	<div class="tip-content"></div>
	    	<div class="confirm">
	    		<button>确认</button>
	    	</div>
	    </div>
	    <div class="tip-mask"></div>
	    <!-- 提示  -->
		<input type="hidden" id="returnUrl" value="${returnUrl }"/>
		<div class="warp-login-foot">
			<p class="talker-link">
				<a href="">首页</a>
				<a href="">关于淘客</a>
				<a href="">隐私声明</a>
				<a href="">合作专区</a>
				<a href="">友情链接</a>
				<a href="">加入我们</a>
				<a href="">联系我们</a>
			</p>
			<p class="talker-info">
				 Copyright © 2015, 版权所有 talkerbar.com 豫ICP备09213115号-1 
			</p>
		</div>
	</div>
</body>
</html>