function schoolShow() {
    $('.mask').show();
    $('.warp_schoolDate').css({
        'left': ($(window).width() - $('.warp_schoolDate').width()) / 2,
        'top': ($(window).height() - $('.warp_schoolDate').height()) / 2
    }).show();
}

function schoolHide() {
    $('.mask').hide();
    $('.warp_schoolDate').hide();
}
//得到省
function getprovince(){
	$.ajax({
		type:'post',
		url:'/talker/area/get',
		data:'parentid=1',
		dataType:'json',
		success:function(data){
			var htm = '';
			for ( var int = 0; int < data.length; int++) {
				if(data[int].id=='410000'){
					htm += '<li class="schoolCurrent" data="'+data[int].id+'">'+data[int].name+'</li>';
				}else{
					htm += '<li data="'+data[int].id+'">'+data[int].name+'</li>';
				}
			}
			$('.warp_province > ul').html(htm);
			getSchool('河南省');
			$('.warp_province li').bind('click',function(){
				$('.warp_province li').removeClass();
				$(this).addClass('schoolCurrent');
				getSchool($(this).attr('data'));
			});
		},
		error:function(){
			alert("哎呀，出错啦");
		}
	});
}
//得到省所在的学校
function getSchool(province){
	$.ajax({
		type:'post',
		url:'/talker/school/get',
		data:'province='+province,
		dataType:'json',
		success:function(data){
			var htm = '';
			for ( var int = 0; int < data.length; int++) {
				htm += '<li data="'+data[int].id+'">'+data[int].name+'</li>';
			}
			$('.warp_school > ul').html(htm);
			$('.warp_school li').bind('click', function() {
		        $('#schoolName').val($(this).text());
		        schoolHide();
		        $('#schoolid').val($(this).attr('data'));
		    });
		},
		error:function(){
			alert("哎呀，出错啦");
		}
	});
}