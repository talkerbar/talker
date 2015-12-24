$(function(){
	//获取焦点隐藏提示
	$('.userinfo input[type=text]:not("#professionalName"):not("#birthday"),.userinfo input[type=password]').bind('focus',function(){
		$(this).removeClass('errorinput').siblings('.inputTip').hide();
	});
	$('.userinfo input[type=radio]').bind('click',function(){
		$(this).removeClass('errorinput').siblings('.inputTip').hide();
	});
	//失去焦点校验信息
	$('.userinfo input[type=text]:not("#professionalName"):not("#birthday"),.userinfo input[type=password]').bind('blur',function(){
		if($(this).val()==''){
			$(this).addClass('errorinput').siblings('.inputTip').show();
		}
	});
	//选择学校
	$('#schoolName').bind('click', function() {
    	getprovince();
        schoolShow();
    });
    /*$('.mask').bind('click', function() {
        schoolHide();
    });*/
    //选择专业
    //选择学校
	$('#professionalName').bind('click', function() {
    	getparent();
    	professionalShow();
    });
    /*$('.mask').bind('click', function() {
    	professionalHide();
    });*/
	//基本信息提交事件
	$('#userinfo').bind('click',function(){
		var flag = true;
		//准备数据
		var nickname = $('#nickname').val();
		var realname = $('#realname').val();
		var gender = $('input[name=gender]:checked').val();
		var grade = $('#grade').val();
		var telephone = $('#telephone').val();
		var schoolid = $('#schoolid').val();
		var professionalid = $('#professionalid').val();
		//校验数据
		if(nickname==''){
			$('#nickname').addClass('errorinput').siblings('.inputTip').show();
			flag = false;
		}
		if(realname==''){
			$('#realname').addClass('errorinput').siblings('.inputTip').show();
			flag = false;
		}
		if(gender==undefined){
			$('input[name=gender]').siblings('.inputTip').show();
			flag = false;
		}
		if(telephone==''){
			$('#telephone').addClass('errorinput').siblings('.inputTip').show();
			flag = false;
		}
		if(schoolid==''){
			$('#schoolName').addClass('errorinput').siblings('.inputTip').show();
			flag = false;
		}
		if(flag){
			//为true提交
			$.ajax({
				type:'post',
				url:'/talker/userinfo/update',
				data:'nickname='+nickname+'&realname='+realname+'&gender='+gender+'&grade='+grade+'&telephone='+telephone+'&schoolid='+schoolid+'&professionalid='+professionalid,
				dataType:'json',
				success:function(data){
					initTip(data.message)
				},
				error:function(error){
					initTip("哎呀，出错啦")
				}
			});
		}
	});
	//密码提交事件
	$('#userlogin').bind('click',function(){
		var flag = true;
		//准备数据
		var oldpassword = $('#oldpassword').val();
		var password = $('#password').val();
		var repassword = $('#repassword').val();
		//校验数据
		if(oldpassword==''){
			$('#oldpassword').addClass('errorinput').siblings('.inputTip').show();
			flag = false;
		}
		if(password==''){
			$('#password').addClass('errorinput').siblings('.inputTip').show();
			flag = false;
		}
		if(repassword==''){
			$('#repassword').addClass('errorinput').siblings('.inputTip').show();
			flag = false;
		}
		if(flag){
			//为true提交
			$.ajax({
				type:'post',
				url:'/talker/userlogin/update',
				data:'password='+password+'&repassword='+repassword+'&oldpassword='+oldpassword,
				dataType:'json',
				success:function(data){
					initTip(data.message)
				},
				error:function(error){
					initTip("哎呀，出错啦")
				}
			});
		}
	});
});
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