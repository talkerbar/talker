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
    //图书馆
    getCommodity('71','.library');
    //车行
    getCommodity('79,80,81,82,83,84','.dealers');
    //电子城
    getCommodity('30,31,40,41,42,43,44,45,46','.electronic-city');
});
function hotCommodity(){
	$.ajax({
		type:'post',
		url:'/talker/commodity/hot',
		dataType:'json',
		success:function(data){
			var htm = '<ul>';
			for ( var int = 0; int < data.length; int++) {
				htm += '<li>' +
						  '<div class="hover-color-line">' +
							'<a title = "'+data[int].title+'" target="_blank" href="/talker/public/item?id='+data[int].id+'">' +
							'</a>' +
						  '</div>' +
			              '<img src="/talker/upload/small/'+data[int].images[0].path+'">' +
			              '<div class="hot-goods-deta">' +
			              	'<p>'+data[int].title+'</p>' +
			              	'<p>'+data[int].schoolName+'</p>' +
			              	'<p><span class="hot-goods-price">￥'+data[int].newprice+'</span><span>浏览量：'+data[int].visits+'</span></p>' +
			              '</div>' +
				        '</li>';
			}
				htm += '</ul>';
			$('.hot-goods-warp-googs').html(htm);
			//监控鼠标进入热门商品区域显示详情
		    $('.hover-color-line').bind('mouseover',function(){
		    	$(this).siblings('.hot-goods-deta').show();
		    });
		    $('.hover-color-line').bind('mouseout',function(){
		    	$(this).siblings('.hot-goods-deta').hide();
		    });
		},
		error:function(){
			alert("获取热门商品失败");
		}
	});
}
function getCommodity(sortid,dom){
	$.ajax({
		type:'post',
		url:'/talker/commodity/get',
		data:'status=1'+'&sortidmore='+sortid+'&cutSmallImg=true'+'&pageNum=1&pageSize=8',
		dataType:'json',
		success:function(data){
			var commoditys = data;
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
				              '<a href="#">' +
				                '<p>'+commoditys[int].schoolName+'</p>' +
				              '</a>' +
				              '<span>查看更多</span>' +
				            '</li>' +
				          '</ul>' +
				        '</div>';
			}
			$(dom).html(htm);
		}
	});
}