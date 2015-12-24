function professionalShow() {
    $('.mask').show();
    $('.warp_professionalDate').css({
        'left': ($(window).width() - $('.warp_professionalDate').width()) / 2,
        'top': ($(window).height() - $('.warp_professionalDate').height()) / 2
    }).show();
}

function professionalHide() {
    $('.mask').hide();
    $('.warp_professionalDate').hide();
}
//得到省
function getparent(){
	$.ajax({
		type:'post',
		url:'/talker/professional/get',
		data:'parentid=-1',
		dataType:'json',
		success:function(data){
			var htm = '';
			for ( var int = 0; int < data.length; int++) {
				if(data[int].id=='8'){
					htm += '<li class="professionalCurrent" data="'+data[int].id+'">'+data[int].name+'</li>';
				}else{
					htm += '<li data="'+data[int].id+'">'+data[int].name+'</li>';
				}
			}
			$('.warp_parent > ul').html(htm);
			getprofessional('8')
			$('.warp_parent li').bind('click',function(){
				$('.warp_parent li').removeClass();
				$(this).addClass('professionalCurrent');
				getprofessional($(this).attr('data'));
			});
		},
		error:function(){
			alert("哎呀，出错啦");
		}
	});
}
//得到省所在的学校
function getprofessional(id){
	$.ajax({
		type:'post',
		url:'/talker/professional/get',
		data:'parentid='+id,
		dataType:'json',
		success:function(data){
			var htm = '';
			for ( var int = 0; int < data.length; int++) {
				htm += '<li data="'+data[int].id+'">'+data[int].name+'</li>';
			}
			$('.warp_professional > ul').html(htm);
			$('.warp_professional li').bind('click', function() {
		        $('#professionalName').val($(this).text());
		        professionalHide();
		        $('#professionalid').val($(this).attr('data'));
		    });
		},
		error:function(){
			alert("哎呀，出错啦");
		}
	});
}