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
	//2、图书馆
    new Swiper('.swiper-container-library', {
        pagination: '.swiper-pagination-library',
        paginationClickable: true,
        direction: 'horizontal',
        autoplay:5000,
        speed:1000,
        autoplayDisableOnInteraction:false,
        grabCursor : true,
        parallax : true
    });
    //3、车行
    new Swiper('.swiper-container-vehicle', {
    	pagination: '.swiper-pagination-vehicle',
    	paginationClickable: true,
    	direction: 'horizontal',
    	autoplay:5000,
    	speed:1000,
    	autoplayDisableOnInteraction:false,
    	grabCursor : true,
    	parallax : true
    });
    //4、电子城
    new Swiper('.swiper-container-digital', {
    	pagination: '.swiper-pagination-digital',
    	paginationClickable: true,
    	direction: 'horizontal',
    	autoplay:5000,
    	speed:1000,
    	autoplayDisableOnInteraction:false,
    	grabCursor : true,
    	parallax : true
    });
    //获取热门商品
    hotCommodity();
});
function hotCommodity(){
	$.ajax({
		type:'post',
		url:'/talker/commodity/hot',
		dataType:'json',
		success:function(data){
			var htm = '';
			for ( var int = 0; int < data.length && int < 10; int++) {
				htm += '<li>' +
		                  '<a href="/talker/item?id='+data[int].id+'">' +
			                '<img src="/talker/upload/small/'+data[int].images[0].path+'" alt="'+data[int].title+'">' +
			              '</a>' +
			            '</li>';
			}
			$('.hot-goods-warp-googs > ul').html(htm);
		},
		error:function(){
			alert("获取热门商品失败");
		}
	});
}