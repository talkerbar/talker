$(function(){
	/* set warp-info in center */
	$('.warp-info').css({
		marginTop:($(window).height()-$('.warp-info').height())/2-30
	});

	/* info-select input keyup事件出现选择框 */
	$('#school').bind('keyup',function(){
		autoData($(this).val(),'/talker/school/get','#auto-school');
		$(this).siblings('dl').show();
	});
	$('#professional').bind('keyup',function(){
		autoData($(this).val(),'/talker/professional/get','#auto-professional');
		$(this).siblings('dl').show();
	});
	/* info-select input 失去焦点隐藏 */
	$('body').bind('click',function(){
		$('dl').hide();
	});

	/*grade不可编辑，鼠标进入出现选择框*/
	$('.info-grade').bind('click',function(){
		$(this).find('dl').show();
		return false;
	});
	//完成事件
	$('.info-submit').bind('click',function(){
		complete();
	});
});
//完成更新
function complete(){
	var schoolid = $('#schoolId').val();
	var professionalid = $('#professionalId').val();
	var grade = $('#gradeId').val();
	if(schoolid==''){
		initTip("请在下拉框选择学校");
		return false;
	}
	if(professionalid==''){
		initTip("请在下拉框选择专业");
		return false;
	}
	if(grade==''){
		initTip("请在下拉框选择年级");
		return false;
	}
	$.ajax({
		type:'post',
		url:'/talker/userinfo/complete',
		data:{'schoolid':schoolid,'professionalid':professionalid,'grade':grade},
		dataType:'json',
		success:function(data){
			if(data.success){
				window.location.href = "/talker";
			}else{
				initTip(data.message);
			}
		},
		error:function(){
			initTip("哎呀，出错啦");
		}
	});
}
//根据关键字得到数据
function autoData(key,url,id){
	$(id).html("");
	if(key==''){
		return false;
	}
	$.ajax({
		type:'post',
		url:url,
		data:'name='+key,
		dataType:'json',
		success:function(data){
			var htm = '';
			for ( var int = 0; int < data.length&&int<8; int++) {
				htm += '<dd data-id="'+data[int].id+'">'+data[int].name+'</dd>';
			}
			$(id).html(htm);
			/* dd click */
			$('.info-select dd').bind('click',function(){
				var name = $(this).text();
				var id = $(this).attr('data-id');
				var _parents = $(this).parents('li');
				_parents.find('input[type=text]').val(name);
				_parents.find('input[type=hidden]').val(id);
				$(this).parent().hide();
				return false;
			});
		},
		error:function(){
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