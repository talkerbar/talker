<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>淘客吧-大学生生活服务平台</title>
	<link rel="stylesheet" href="/talker/css/completeInfo.css">
</head>
<body>
	<div class="warp-info">
		<h3 class="info-head">完善资料</h3>
		<ul class="info-body">
			<li class="info-select">
				<input type="text" id="school" placeholder="学校名称" />
				<input type="hidden" id="schoolId"/>
				<dl id="auto-school">
				</dl>
			</li>
			<li class="info-select">
				<input type="text" id="professional" placeholder="专业名称" />
				<input type="hidden" id="professionalId" />
				<dl id="auto-professional">
				</dl>
			</li>
			<li class="info-select info-grade">
				<input type="text" id="grade" placeholder="年级" disabled="disabled"/>
				<input type="hidden" id="gradeId"/>
				<dl>
					<dd data-id="1">大一</dd>
					<dd data-id="2">大二</dd>
					<dd data-id="3">大三</dd>
					<dd data-id="4">大四</dd>
					<dd data-id="5">研一</dd>
					<dd data-id="6">研二</dd>
					<dd data-id="7">研三</dd>
				</dl>
			</li>
		</ul>
		<div class="info-foot">
			<a href="/talker">跳过</a>
			<button class="info-submit">完成</button>
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
</body>
<script type="text/javascript" src="/talker/js/jquery.min.js"></script>
<script type="text/javascript" src="/talker/js/completeInfo.js"></script>
</html>