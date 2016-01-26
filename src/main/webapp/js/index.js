$(function(){
	//轮播组件
	//1、主轮播
	new Swiper('.swiper-container-tab', {
        pagination: '.swiper-pagination-tab',
        paginationClickable: true,
        direction: 'horizontal',
        autoplay:5000,
        speed:1000,
        autoplayDisableOnInteraction:false,
        grabCursor : true,
        parallax : true,
    });
    //获取热门商品
    hotCommodity();
    getCommodity('');
});
function hotCommodity(){
	$.ajax({
		type:'post',
		url:'/talker/commodity/hot',
		dataType:'json',
		success:function(data){
			var htm = '<ul>';
			for ( var int = 0; int < data.length && int < 10; int++) {
				htm += '<li>' +
		                  '<a title = "'+data[int].title+'" href="/talker/item?id='+data[int].id+'">' +
			                '<img src="/talker/upload/small/'+data[int].images[0].path+'">' +
			              '</a>' +
			            '</li>';
			}
			htm += '</ul>';
			$('.hot-goods-warp-googs').html(htm);
		},
		error:function(){
			alert("获取热门商品失败");
		}
	});
}
function getCommodity(sortid){
	$.ajax({
		type:'post',
		url:'/talker/commodity/get',
		data:'status=1'+'&sortid='+sortid+'&cutSmallImg=true'+'&pageNum=1&pageSize=8',
		dataType:'json',
		success:function(data){
			var commoditys = data;
			var htm = '';
			for ( var int = 0; int < commoditys.length; int++) {
				htm += '<div class="commodity-list">' +
				          '<ul>' +
				            '<li class="commodity-list-img">' +
				              '<a title="'+commoditys[int].title+'" href="/talker/item?id='+commoditys[int].id+'">' +
				                '<img src="/talker/upload/small/'+commoditys[int].images[0].path+'" alt="">' +
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
//				            '<li class="commodity-list-user">' +
//				              '<div class="commodity-list-user-head">' +
//				                '<img src="/talker/head/'+commoditys[int].userInfoOut.icon+'" alt="">' +
//				              '</div>' +
//				              '<div class="commodity-list-user-nickname">'+commoditys[int].userInfoOut.nickname+'</div>' +
//				              '<div class="commodity-list-user-data">浏览量：'+commoditys[int].visits+'</div>' +
//				            '</li>' +
				          '</ul>' +
				        '</div>';
			}
			$('.warp-commodity-list').html(htm);
		},
		error:function(){
			alert("获取商品失败");
		}
	});
}