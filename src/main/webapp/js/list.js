$(function(){
	//得到所有学校
	getAllSchool();
	//得到所有分类
	getAllSort();
	//初始化商品
	initCommodityPage("",$('#sortidmore').val(),'1');
});
function getAllSchool(){
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
				initCommodityPage(schoolid,sortid,"1");
				$('#schoolidmore').val(schoolid);
			});
		}
	});
}
function getAllSort(){
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
				initCommodityPage(schoolid,sortid,"1");
				$('#sortidmore').val(sortid);
			});
		}
	});
}
function initCommodityPage(schoolid,sortid,page){
	loading();
	$.ajax({
		type:'post',
		url:'/talker/commodity/page',
		data:'status=1'+'&schoolid='+schoolid+'&sortidmore='+sortid+'&cutSmallImg=true'+'&pageNum='+page,
		dataType:'json',
		success:function(data){
			var commoditys = data.data;
			var htm = '';
			for ( var int = 0; int < commoditys.length; int++) {
				htm += '<div class="commodity-list">' +
				          '<ul>' +
				            '<li class="commodity-list-img">' +
				              '<a title="'+commoditys[int].title+'" href="/talker/public/item?id='+commoditys[int].id+'">' +
				                '<img src="/talker/upload/small/'+commoditys[int].images[0].path+'" alt="">' +
				              '</a>' +
				            '</li>' +
				            '<li class="commodity-list-title">' +
				              '<a title="'+commoditys[int].title+'" href="/talker/public/item?id='+commoditys[int].id+'">' +
				                '<p>'+commoditys[int].title+'</p>' +
				              '</a>' +
				            '</li>' +
				            '<li class="commodity-list-price">' +
				              '<span>￥'+commoditys[int].newprice+'</span><span><s>￥'+commoditys[int].oldprice+'</s></span>' +
				            '</li>' +
				            '<li class="commodity-list-school">' +
				              '<a href="">' +
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
			//初始化分页
			$(".tcdPageCode").createPage({
				pageCount:data.pageCount,
				current:data.pageNum
			});
		}
	});	
}
function getCommodity(schoolid,sortid,page){
	loading();
	$.ajax({
		type:'post',
		url:'/talker/commodity/page',
		data:'status=1'+'&schoolid='+schoolid+'&sortidmore='+sortid+'&cutSmallImg=true'+'&pageNum='+page,
		dataType:'json',
		success:function(data){
			var commoditys = data.data;
			var htm = '';
			for ( var int = 0; int < commoditys.length; int++) {
				htm += '<div class="commodity-list">' +
				          '<ul>' +
				            '<li class="commodity-list-img">' +
				              '<a title="'+commoditys[int].title+'" href="/talker/public/item?id='+commoditys[int].id+'">' +
				                '<img src="/talker/upload/small/'+commoditys[int].images[0].path+'" alt="">' +
				              '</a>' +
				            '</li>' +
				            '<li class="commodity-list-title">' +
				              '<a title="'+commoditys[int].title+'" href="/talker/public/item?id='+commoditys[int].id+'">' +
				                '<p>'+commoditys[int].title+'</p>' +
				              '</a>' +
				            '</li>' +
				            '<li class="commodity-list-price">' +
				              '<span>￥'+commoditys[int].newprice+'</span><span><s>￥'+commoditys[int].oldprice+'</s></span>' +
				            '</li>' +
				            '<li class="commodity-list-school">' +
				              '<a href="">' +
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
		}
	});
}
function loading(){
	var htm = '<div class="loading"><img src="/talker/images/loading.gif"></div>';
	$('.warp-commodity-list').html(htm);
}