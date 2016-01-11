$(function(){
	$('.submit').bind('click',function(){
		var _this = this;
		disabled(this);
		var username = $('#username').val();
		var password = $('#password').val();
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
				abled(_this);
			},
			error:function(){
				initTip("哎呀，出错啦")
				abled(_this);
			}
		});
	});
});
// 不可用
function disabled(obj){
	//设置按钮不可点击状态
	$(obj).attr("disabled","disabled");
	//设置样式
	$(obj).text("登陆中…").css({
		background:'#ddd'
	});
}
//恢复
function abled(obj){
	//设置按钮不可点击状态
	$(obj).removeAttr("disabled");
	//设置样式
	$(obj).text("登陆").css({
		background:'#ff649d'
	});
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