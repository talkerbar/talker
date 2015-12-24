$(function(){
	//得到所有学校
	$.ajax({
		type:'post',
		url:'/talker/commodity/allschoolname',
		dataType:'json',
		success:function(data){
			var htm = '<li id="" class="current-sort">全部</li>';
			for ( var int = 0; int < data.length; int++) {
				htm += '<li id="'+data[int].id+'">'+data[int].name+'</li>';
			}
			$('#all-school-name').html(htm).find('li').bind('click',function(){
				$('#all-school-name li').removeClass('current-sort');
				$(this).addClass('current-sort');
				var schoolid = $('#all-school-name').find('li.current-sort').attr('id');
				var sortid = $('#all-sort-name').find('li.current-sort').attr('id');
				loading();
				getCommodity(schoolid,sortid);
			});
		},
		error:function(){
			
		}
	});
	//得到所有分类
	$.ajax({
		type:'post',
		url:'/talker/commodity/allsortname',
		dataType:'json',
		success:function(data){
			var htm = '<li id="" class="current-sort">全部</li>';
			for ( var int = 0; int < data.length; int++) {
				htm += '<li id="'+data[int].id+'">'+data[int].name+'</li>';
			}
			$('#all-sort-name').html(htm).find('li').bind('click',function(){
				$('#all-sort-name li').removeClass('current-sort');
				$(this).addClass('current-sort');
				var schoolid = $('#all-school-name').find('li.current-sort').attr('id');
				var sortid = $('#all-sort-name').find('li.current-sort').attr('id');
				loading();
				getCommodity(schoolid,sortid);
			});
		},
		error:function(){
			
		}
	});
	//初始化商品
	getCommodity("","");
});
function getCommodity(schoolid,sortid){
	$.ajax({
		type:'post',
		url:'/talker/commodity/get',
		data:'status=1'+'&schoolid='+schoolid+'&sortid='+sortid,
		dataType:'json',
		success:function(data){
			var commoditys = data;
			var htm = '';
			for ( var int = 0; int < commoditys.length; int++) {
				htm += '<div class="commodity-list">' +
				          '<ul>' +
				            '<li class="commodity-list-img">' +
				              '<a title="'+commoditys[int].title+'" href="/talker/item?id='+commoditys[int].id+'">' +
				                '<img src="/talker/upload/'+commoditys[int].images[0].path+'" alt="">' +
				              '</a>' +
				            '</li>' +
				            '<li class="commodity-list-title">' +
				              '<a title="'+commoditys[int].title+'" href="/talker/item?id='+commoditys[int].id+'">' +
				                '<p>'+commoditys[int].title+'</p>' +
				              '</a>' +
				            '</li>' +
				            '<li class="commodity-list-price">' +
				              '<span>￥'+commoditys[int].newprice+'</span><span><s>￥'+commoditys[int].oldprice+'</s></span>' +
				            '</li>' +
				            '<li class="commodity-list-school">' +
				              '<a href="/talker/item?id='+commoditys[int].schoolid+'">' +
				                '<p>'+commoditys[int].schoolName+'</p>' +
				              '</a>' +
				              '<span>查看更多</span>' +
				            '</li>' +
				            '<li class="commodity-list-user">' +
				              '<div class="commodity-list-user-head">' +
				                '<img src="/talker/head/'+commoditys[int].userInfoOut.icon+'" alt="">' +
				              '</div>' +
				              '<div class="commodity-list-user-nickname">'+commoditys[int].userInfoOut.nickname+'</div>' +
				              '<div class="commodity-list-user-data">浏览量：'+commoditys[int].visits+'</div>' +
				            '</li>' +
				          '</ul>' +
				        '</div>';
			}
			$('.warp-commodity-list').html(htm);
		},
		error:function(){
			
		}
	});
}
function loading(){
	var htm = '<div class="loading"><img src="/talker/images/loading.gif"></div>';
	$('.warp-commodity-list').html(htm);
}