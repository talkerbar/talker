$(function(){
	/* set warp-info in center */
	$('.warp-info').css({
		marginTop:($(window).height()-$('.warp-info').height())/2-30
	});

	/* info-select input keyup�¼�����ѡ��� */
	$('.info-select > input').bind('keyup',function(){
		$(this).siblings('dl').show();
	});
	/* info-select input ʧȥ�������� */
	$('body').bind('click',function(){
		$('dl').hide();
	});

	/*grade���ɱ༭�����������ѡ���*/
	$('.info-grade').bind('click',function(){
		$(this).find('dl').show();
		return false;
	});
	/*grade���ɱ༭������뿪����ѡ���*/
	/*$('.info-grade').bind('mouseout',function(){
		$(this).find('dl').hide();
	});*/

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
});