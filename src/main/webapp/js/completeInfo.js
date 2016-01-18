$(function(){
	/* set warp-info in center */
	$('.warp-info').css({
		marginTop:($(window).height()-$('.warp-info').height())/2-30
	});

	/* info-select input keyup事件出现选择框 */
	$('.info-select > input').bind('keyup',function(){
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
	/*grade不可编辑，鼠标离开出现选择框*/
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