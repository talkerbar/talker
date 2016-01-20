$(function(){
	//登录事件
	$('.login').bind('click',function(){
		login(this);
	});
	//发送验证码
	$('#code').bind('click',function(){
		sendCode(120,this)
	});
	//注册事件
	$('.free_regist').bind('click',function(){
		regist(this);
	});
});
//登录
function login(obj){
	var _this = obj;
	disabled(_this,"登录中…","#ddd");
	var username = $('#username').val();
	var password = $('#password').val();
	//前端非空判断
	if(username==''){
		initTip("请输入手机号");
		abled(_this,"登录","#ff649d");
		return false;
	}
	if(password==''){
		initTip("请输入密码");
		abled(_this,"登录","#ff649d");
		return false;
	}
	$.ajax({
		type:'post',
		url:'/talker/userlogin/login',
		data:{'username':username,'password':password},
		dataType:'json',
		success:function(data){
			if(data.success){
				window.location.href = $('#returnUrl').val();
			}else{
				initTip(data.message)
			}
			abled(_this,"登录","#ff649d");
		},
		error:function(){
			initTip("哎呀，出错啦")
			abled(_this,"登录","#ff649d");
		}
	});
}
//注册
function regist(obj){
	var _this = obj;
	disabled(_this,"注册中…","#ddd");
	var username = $('#username').val();
	var security_code = $('#security_code').val();
	var password = $('#password').val();
	var repassword = $('#repassword').val();
	//前端非空判断
	if(username==''){
		initTip("请输入手机号");
		abled(_this,"注册","#ff649d");
		return false;
	}
	if(security_code==''){
		initTip("请输入验证码");
		abled(_this,"注册","#ff649d");
		return false;
	}
	if(password==''){
		initTip("请输入密码");
		abled(_this,"注册","#ff649d");
		return false;
	}
	if(repassword==''){
		initTip("请输入重复密码");
		abled(_this,"注册","#ff649d");
		return false;
	}
	if(password!=repassword){
		initTip("两次密码不一致");
		abled(_this,"注册","#ff649d");
		return false;
	}
	$.ajax({
		type:'post',
		url:'/talker/userlogin/regist',
		data:{'username':username,'password':password,'security_code':security_code,'repassword':repassword},
		dataType:'json',
		success:function(data){
			if(data.success){
				window.location.href = $('#returnUrl').val();
			}else{
				initTip(data.message)
			}
			abled(_this,"注册","#ff649d");
		},
		error:function(){
			initTip("哎呀，出错啦")
			abled(_this,"注册","#ff649d");
		}
	});
}
// 不可用
function disabled(obj,text,color){
	//设置按钮不可点击状态
	$(obj).attr("disabled","disabled");
	//设置样式
	if(text!=''){
		$(obj).text(text).css({
			background:color
		});
	}
}
//恢复
function abled(obj,text,color){
	//设置按钮不可点击状态
	$(obj).removeAttr("disabled");
	//设置样式
	if(text!=''){
		$(obj).text(text).css({
			background:color
		});
	}
}
//发送验证码倒计时
function sendCode(i,obj){
	$(obj).attr('disabled','disabled');
	if(i==0){
		$(obj).removeAttr('disabled'); 
		$(obj).text("获取验证码");
	}else{
		$(obj).text("重新发送(" + i + ")");
		i--;
		setTimeout(function() { 
			sendCode(i,obj); 
		},1000);
	}
}
//统一提示
function initTip(message){
	//设置提示信息
	$('.tip-content').html(message);
	//in
	$('.tip').css({
		'left':($(window).width()-$('.tip').width())/2
	}).animate({
		top:'0px'
	},500);
	$('.tip-mask').fadeIn("slow");
	//out
	$('.confirm button').bind('click',function(){
		$('.tip').animate({
			top:'-140px'
		},300);
		$('.tip-mask').fadeOut("slow");
	});
}