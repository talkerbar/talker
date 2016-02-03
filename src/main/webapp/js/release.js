$(function() {
	//获取焦点隐藏提示
	$('.userinfo input[type=text]').bind('focus',function(){
		$(this).removeClass('errorinput').siblings('.inputTip').hide();
	});
	$('.userinfo input[type=file]').bind('click',function(){
		$('#upImage > img').removeClass('errorinput');
	});
	//失去焦点校验信息
	$('.userinfo input[type=text]').bind('blur',function(){
		if($(this).val()==''){
			$(this).addClass('errorinput').siblings('.inputTip').show();
		}
	});
    $('#warp_sortData').bind('mouseleave', function() {
        $(this).fadeOut('slow');
    });
    $('#showSort input').bind('click', function() {
    	getSort('-1');
        $('#warp_sortData').fadeIn('slow');
    });

    $('#schoolName').bind('click', function() {
    	getprovince();
        schoolShow();
    });
    $('.mask').bind('click', function() {
        schoolHide();
    });
    $('.deleteCover').bind('click', function() {
        $(this).parents('.coverImg').remove();
    });
    // 商品提交验证事件
    $('#commoditySubmit').bind('click',function(){
    	var flag = true;
    	var title = $('#title').val();
    	if(title==''){
    		$('#title').addClass('errorinput').siblings('.inputTip').show();
    		flag = false;
    	}
    	var sortid = $('#sortValue').val();
    	if(sortid==''){
    		$('#sort').addClass('errorinput').siblings('.inputTip').show();
    		flag = false;
    	}
    	var newprice = $('#newprice').val();
    	if(newprice==''){
    		$('#newprice').addClass('errorinput').siblings('.inputTip').show();
    		flag = false;
    	}
    	var oldprice = $('#oldprice').val();
    	if(oldprice==''){
    		$('#oldprice').addClass('errorinput').siblings('.inputTip').show();
    		flag = false;
    	}
    	var cellnumber = $('#cellnumber').val();
    	if(cellnumber==''){
    		$('#cellnumber').addClass('errorinput').siblings('.inputTip').show();
    		flag = false;
    	}else{
    		if(cellnumber.length!=11){
    			$('#cellnumber').addClass('errorinput').siblings('.inputTip').show();
        		flag = false;
    		}
    	}
    	var callname = $('#callname').val();
    	if(callname==''){
    		$('#callname').addClass('errorinput').siblings('.inputTip').show();
    		flag = false;
    	}
    	var schoolid = $('#schoolid').val();
    	if(schoolid==''){
    		$('#schoolName').addClass('errorinput').siblings('.inputTip').show();
    		flag = false;
    	}
    	var index4img = $('#index4img').val();  // 图片计数序列
    	if(index4img=='0'){
    		$('#upImage > img').addClass('errorinput');
    		flag = false;
    	}
    	return flag;
    });
});
// 得到分类信息
function getSort(id) {
	$.ajax({
		type : 'post',
		url : '/talker/sort/get',
		data : 'parentid=' + id,
		dataType : 'json',
		success : function(data) {
			var htm = '';
			if (id == '-1') {
				for ( var int = 0; int < data.length; int++) {
					htm += '<li data="' + data[int].id + '">' + data[int].name
							+ '<div class="nextSortDate"><ul></ul></div></li>';
				}
				$('.sortData').html(htm);
				$('.sortData > li').bind('mouseenter', function() {
					getSort($(this).attr('data'));
					$(this).find('.nextSortDate').show();
				});
				$('.sortData > li').bind('mouseleave', function() {
					$('div.nextSortDate').hide();
				});
			} else {
				for ( var int = 0; int < data.length; int++) {
					htm += '<li data="' + data[int].id + '">' + data[int].name
							+ '</li>';
				}
				$('.nextSortDate > ul').html(htm);
				$('.nextSortDate li').bind('click', function() {
					$('#sort').val($(this).text());
					$('#sortValue').val($(this).attr('data'));
					$('#warp_sortData').fadeOut('slow');
				});
			}
		},
		error : function(data) {
			alert("哎呀，出错啦");
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
	});
}