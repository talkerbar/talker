<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员注册-大学生生活服务平台</title>
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
			<a href="/talker" class="index">
				<span>返回首页</span>
			</a>
		</div>
		<div class="warp-login-body">
			<div class="warp-content">
				<div class="content">
					<ul>
						<li class="desc">
							<span>免费注册</span>
							<span><a href="/talker/public/login">登录</a></span>
						</li>
						<li class="regist info">
							<span class="icon-username icon"></span>
							<input type="text" name="username" id="username" maxlength="11" placeholder="手机号"/>
						</li>
						<li class="regist security_code">
							<input type="text" name="security_code" id="security_code" maxlength="6" placeholder="验证码"/>
							<button id="code">获取验证码</button>
						</li>
						<li class="regist info">
							<span class="icon-password icon"></span>
							<input type="password" name="password" id="password" placeholder="6-18位密码"/>
						</li>
						<li class="regist info">
							<span class="icon-password icon"></span>
							<input type="password" name="repassword" id="repassword" placeholder="再次输入密码"/>
						</li>
						<li class="confirm-regist">
							<button class="submit free_regist">免费注册</button>
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