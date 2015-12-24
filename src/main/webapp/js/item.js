$(function(){
	//鼠标经过切换大图事件
	$('.detail-small-img li').bind('mouseenter',function(){
		$('.detail-big-img img').attr('src',$(this).find('img').attr('src'));
	});
	//轮播组件
	var swiper = new Swiper('.swiper-container', {
        slidesPerView: 'auto',
        direction : 'vertical',
        mousewheelControl : true
    });
	//获取手机号事件
	$('.mobile').bind('click',function(){
		var _this = this;
		disabled(_this,'获取中…',"#ddd");
		$.ajax({
			type:'post',
			url:'/talker/menu/islogin',
			dataType:'json',
			success:function(data){
				if(data.success){
					//用户已登陆
					//获取联系方式
					getCellnumber();
				}else{
					//用户未登陆
					$('.tip-mask').show();
					$('.content').css({
						top:($(window).height()-$('.content').height())/2,
						left:($(window).width()-$('.content').width())/2
					}).show();
				}
				abled(_this,'获取联系方式',"#ff649d");
			}
		});
	});
	//登陆事件
	$('.confirm-login button').bind('click',function(){
		var _this = this;
		disabled(_this,'登陆中…',"#ddd");
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax({
			type:'post',
			url:'/talker/userlogin/login',
			data:{'username':username,'password':password},
			dataType:'json',
			success:function(data){
				if(data.success){
					$('.tip-mask').hide();
					$('.content').hide();
					/*//获取联系方式
					getCellnumber();*/
				}else{
					$('.login-error-tip').html(data.message);
				}
				abled(_this,'登陆',"#ff649d");
			},
			error:function(){
				$('.login-error-tip').html("哎呀，出错啦");
				abled(_this,'登陆',"#ff649d");
			}
		});
	});
	//发表留言事件
	$('.btn-post > a').bind('click',function(){
		var _this = this;
		disabled(_this,'发表中…',"#ddd");
		$.ajax({
			type:'post',
			url:'/talker/menu/islogin',
			dataType:'json',
			success:function(data){
				if(data.success){
					//用户已登陆
					//开始发表留言
					messageReply($(_this).attr('data-parent-id'));
				}else{
					//用户未登陆
					$('.tip-mask').show();
					$('.content').css({
						top:($(window).height()-$('.content').height())/2,
						left:($(window).width()-$('.content').width())/2
					}).show();
				}
				abled(_this,'发表留言',"#fff");
			}
		});
	});
	//获取留言
	getMessageReply($('#commodity-id').val());
	//
	navMianTopDesc();
	//
	navMianTopMessage();
});
/*----------------------------------------------*/
//获取联系方式
function getCellnumber(){
	disabled('.mobile','获取中…',"#ddd");
	$.ajax({
		type:'post',
		url:'/talker/commodity/cellnumber',
		data:'id='+$('#commodity-id').val(),
		dataType:'json',
		success:function(data){
			$('#7').html(data).addClass('num-big');
			abled('.mobile','获取联系方式',"#ff649d");
		},
		error:function(){
			initTip("哎呀，出错啦");
			abled('.mobile','获取联系方式',"#ff649d");
		}
	});
}
//发表留言
function messageReply(parentid){
	disabled('.btn-post > a','发表中…',"#ddd");
	var cid = $('#commodity-id').val();
	var content = $('#J_commentText').val();
	if(content!=''&&content.indexOf('[')!=-1&&content.indexOf(']')!=-1||cid!=-1){
		content = content.replace('[','<span class="record-content-tip">');
		content = content.replace(']','</span>');
	}
	$.ajax({
		type:'post',
		url:'/talker/commoditymessage/add',
		data:'cid='+cid+'&content='+content+'&parentid='+parentid,
		dataType:'json',
		success:function(data){
			initTip(data.message);
			abled('.btn-post > a','发表留言',"#fff");
			//获取留言
			getMessageReply($('#commodity-id').val());
		},
		error:function(){
			initTip("哎呀，出错啦");
			abled('.btn-post > a','发表留言',"#fff");
		}
	});
}
//获取留言
function getMessageReply(cid){
	$.ajax({
		type:'post',
		url:'/talker/commoditymessage/get',
		data:'cid='+cid,
		dataType:'json',
		success:function(data){
			var htm = '';
			if(data.success){
				var list = data.list;
				if(list.length!=0){
					for ( var int = 0; int < list.length; int++) {
					  htm +='<div class="message-record-details">' +
								'<img class="message-head-pic" src="/talker/head/'+list[int].icon+'">' +
								'<h3>' +
									'<a href="" class="nickname">'+list[int].nickname+'</a>' +
									'<span>'+list[int].create_date+'</span>' +
								'</h3>' +
								'<p class="message-record-content">'+list[int].content+'</p>' +
								'<div class="message-reply"><a href="javascript:void(0);" data-parent-id="'+list[int].id+'">回复</a></div>' +
							'</div>';
					}
				}else{
					htm += '<div class="message-record-blank">' +
							 '<span class="tanhao"></span>' +
				      		 '<p>暂无留言记录</p>' +
						   '</div>';
				}
			}else{
				htm += '<div class="message-record-blank">' +
						 '<span class="tanhao"></span>' +
			      		 '<p>暂无留言记录</p>' +
					   '</div>';
			}
			$('.message-record').html(htm);
			//鼠标经过出现回复事件
			messageReplyShow();
			//点击回复事件
			messageReplyClick();
		}
	});
}
// 不可用
function disabled(obj,message,style){
	//设置按钮不可点击状态
	$(obj).attr("disabled","disabled");
	//设置样式
	$(obj).text(message).css({
		background:style
	});
}
//恢复
function abled(obj,message,style){
	//设置按钮不可点击状态
	$(obj).removeAttr("disabled");
	//设置样式
	$(obj).text(message).css({
		background:style
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
//鼠标经过事件出现回复
function messageReplyShow(){
	$('.message-reply').bind('mouseover',function(){
		$(this).find('a').show();
	});
	
	$('.c').bind('mouseout',function(){
		$(this).find('a').hide();
	});
}
//点击回复事件
function messageReplyClick(){
	$('.message-reply > a').bind('click',function(){
		//设置回复提示
		var nickname = $(this).parents('.message-record-details').find('.nickname').text();
		$('#J_commentText').focus().val("[回复 "+nickname+"]:");
		//设置上级ID
		$('.btn-post > a').attr('data-parent-id',$(this).attr('data-parent-id'));
	});
}
//商品附加导航事件
function navMianTopDesc(){
	$('#nav-mian-top-desc').bind('click',function(){
		$(this).addClass('current').siblings().removeClass('current');
		$('.nav-mian-detail').show();
		$('.message-head').show();
	});
}
function navMianTopMessage(){
	$('#nav-mian-top-message').bind('click',function(){
		$(this).addClass('current').siblings().removeClass('current');
		$('.nav-mian-detail').hide();
		$('.message-head').hide();
	});
}