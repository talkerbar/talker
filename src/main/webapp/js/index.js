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
});