$(function(){
	//初始化商品
	getMeCommodity("1");
});

function getMeCommodity(pageNum){
	$.ajax({
		type:'post',
		url:'/talker/commodity/me',
		data:'pageNum='+pageNum+'&pageSize=10',
		dataType:'json',
		success:function(data){
			var htm = '';
			var list = data.data;
			for(var i = 0;i<list.length;i++){
			htm += '<div class="warp-commodity-list floatLeft">' +
			            '<div class="warp-commodity-list-img floatLeft">' +
				            '<a title="'+ list[i].title +'" href="/talker/public/item?id='+ list[i].id +'"><img src="/talker/upload/'+ list[i].images[0].path +'"></a>' +
			            '</div>' +
			            '<div class="warp-commodity-list-onfo floatLeft">' +
			              '<p class="title"><a title="'+ list[i].title +'" href="/talker/public/item?id='+ list[i].id +'">'+ list[i].title +'</a></p>' +
			              '<p class="price"><b class="opacity">￥</b><b class="color">'+ list[i].newprice +'</b></p>' +
			              '<p class="viewinfo"><span>浏览：'+ list[i].visits +'</span><span>电话：'+ list[i].phoneRecords +'</span><span>留言：0</span></p>' +
			            '</div>' +
			            '<div class="warp-commodity-list-operat floatLeft">';
							if(list[i].status == 1){
								htm += '<p class="down" id="'+ list[i].id +'">下架</p>';
							}else{
								htm += '<p class="up" id="'+ list[i].id +'">上架</p>';
							}
							htm += '<p class="del" id="'+ list[i].id +'">删除</p>' +
			            '</div>' +
			        '</div>';
			}
			$('.warp-center-content').html(htm);
			//初始化分页
			$(".tcdPageCode").createPage({
				pageCount:data.pageCount,
				current:data.pageNum
			});
			//上架事件
			$('.up').bind('click',function(){
				del("1",this);
			});
			//下架事件
			$('.down').bind('click',function(){
				del("2",this);
			});
			//删除事件
			$('.del').bind('click',function(){
				del("3",this);
			});
		}
	});
}

function getCommodity(schoolidmore,sortidmore,pageNum){
	$.ajax({
		type:'post',
		url:'/talker/commodity/me',
		data:'pageNum='+pageNum+'&pageSize=10',
		dataType:'json',
		success:function(data){
			var htm = '';
			var list = data.data;
			for(var i = 0;i<list.length;i++){
				htm += '<div class="warp-commodity-list floatLeft">' +
				'<div class="warp-commodity-list-img floatLeft">' +
				'<a title="'+ list[i].title +'" href="/talker/public/item?id='+ list[i].id +'"><img src="/talker/upload/'+ list[i].images[0].path +'"></a>' +
				'</div>' +
				'<div class="warp-commodity-list-onfo floatLeft">' +
				'<p class="title"><a title="'+ list[i].title +'" href="/talker/public/item?id='+ list[i].id +'">'+ list[i].title +'</a></p>' +
				'<p class="price"><b class="opacity">￥</b><b class="color">'+ list[i].newprice +'</b></p>' +
				'<p class="viewinfo"><span>浏览：'+ list[i].visits +'</span><span>电话：'+ list[i].phoneRecords +'</span><span>留言：0</span></p>' +
				'</div>' +
				'<div class="warp-commodity-list-operat floatLeft">';
				if(list[i].status == 1){
					htm += '<p class="down" id="'+ list[i].id +'">下架</p>';
				}else{
					htm += '<p class="up" id="'+ list[i].id +'">上架</p>';
				}
				htm += '<p class="del" id="'+ list[i].id +'">删除</p>' +
				'</div>' +
				'</div>';
			}
			$('.warp-center-content').html(htm);
			//上架事件
			$('.up').bind('click',function(){
				del("1",this);
			});
			//下架事件
			$('.down').bind('click',function(){
				del("2",this);
			});
			//删除事件
			$('.del').bind('click',function(){
				del("3",this);
			});
		}
	});
}

function del(status,obj){
	$.ajax({
		type:'post',
		url:'/talker/commodity/del',
		data:'status='+status+'&id='+$(obj).attr('id'),
		dataType:'json',
		success:function(data){
			initTip(data.message);
		},
		error:function(){
			initTip("哎呀，出错啦");
		}
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
		window.location.reload();
	});
}