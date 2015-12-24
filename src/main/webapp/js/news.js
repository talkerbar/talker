$(function(){
	//我收到的留言
	$('#received-message').bind('click',function(){
		$(this).addClass('warp-msg-current').siblings().removeClass('warp-msg-current');
		//获取我收到的留言
		getReceivedMessage();
	});
	//我发布的留言
	$('#post-message').bind('click',function(){
		$(this).addClass('warp-msg-current').siblings().removeClass('warp-msg-current');
		//隐藏回复框
		$('.message-post').hide();
		//获取我发布的留言
		getPostMessage();
	});
	//获取我收到的留言
	getReceivedMessage();
	//发表留言事件
	$('.btn-post > a').bind('click',function(){
		var _this = this;
		messageReply($(_this).attr('data-parent-id'),$(_this).attr('data-c-id'));
	});
});
//我收到的留言
function getReceivedMessage(){
	$.ajax({
		type:'post',
		url:'/talker/commoditymessage/getReceivedMessage',
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
								'<div class="message-reply"><a href="javascript:void(0);" data-parent-id="'+list[int].id+'" data-c-id="'+list[int].cid+'">回复</a></div>' +
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
//我发布的留言
function getPostMessage(){
	$.ajax({
		type:'post',
		url:'/talker/commoditymessage/getPostMessage',
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
						'</div>';
					}
				}else{
					htm += '<div class="message-record-blank">' +
					'<span class="tanhao"></span>' +
					'<p>暂无发布记录</p>' +
					'</div>';
				}
			}else{
				htm += '<div class="message-record-blank">' +
				'<span class="tanhao"></span>' +
				'<p>暂无发布记录</p>' +
				'</div>';
			}
			$('.message-record').html(htm);
		}
	});
}
//回复留言
function messageReply(parentid,cid){
	disabled('.btn-post > a','回复中…',"#ddd");
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
			abled('.btn-post > a','回复留言',"#fff");
			//获取留言
			getReceivedMessage();
		},
		error:function(){
			initTip("哎呀，出错啦");
			abled('.btn-post > a','回复留言',"#fff");
		}
	});
}
//鼠标经过事件出现回复
function messageReplyShow(){
	$('.message-reply').bind('mouseover',function(){
		$(this).find('a').show();
	});
	
	$('.message-reply').bind('mouseout',function(){
		$(this).find('a').hide();
	});
}
//点击回复事件
function messageReplyClick(){
	$('.message-reply > a').bind('click',function(){
		//显示回复框
		$('.message-post').show();
		//设置回复提示
		var nickname = $(this).parents('.message-record-details').find('.nickname').text();
		$('#J_commentText').focus().val("[回复 "+nickname+"]:");
		//设置上级ID
		$('.btn-post > a').attr('data-parent-id',$(this).attr('data-parent-id'));
		//设置CID
		$('.btn-post > a').attr('data-c-id',$(this).attr('data-c-id'));
	});
}
//不可用
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