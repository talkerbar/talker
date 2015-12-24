$(function(){
	//获取头像
	getIcon();
});
function getIcon(){
	$.ajax({
		type:'post',
		url:'/talker/userinfo/geticon',
		success:function(data){
			var src = '/talker/head/'+data;
			$('.head-img > img').attr('src',src);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
}