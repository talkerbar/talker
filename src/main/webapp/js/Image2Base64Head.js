/* 2015-09-28 上传图片*/
function convertImgToBase64(url, selection, callback, outputFormat) {
	var canvas = document.createElement('CANVAS');
	var ctx = canvas.getContext('2d');
	var img = new Image;
	img.crossOrigin = 'Anonymous';
	img.onload = function() {
		var width = img.width;
		var height = img.height;
		//放大比率
		var rate = (width < height ? height/400 : width/400);
		canvas.width = selection.width;
		canvas.height = selection.height;
		ctx.drawImage(img, selection.x1*rate, selection.y1*rate, selection.width*rate, selection.height*rate, 0, 0, selection.width, selection.height);
		var dataURL = canvas.toDataURL(outputFormat || 'image/png');
		callback.call(this, dataURL);
		canvas = null;
	};
	img.src = url;
}

function getObjectURL(file) {
	var url = null;
	if (window.createObjectURL != undefined) { // basic
		url = window.createObjectURL(file);
	} else if (window.URL != undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file);
	} else if (window.webkitURL != undefined) { // web_kit or chrome
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
}
$(function(){
	//加入HTML
	var preHtm = '<div class="preview-head">' +
					'<ul>' +
						'<li class="preview-head-title">' +
							'<h3>自定义头像</h3>' +
						'</li>' +
						'<li class="preview-head-reselect">' +
							'<input type="file" class="select-head"/>' +
							'<button>重新选择</button>' +
							'<span>支持jpg、png 图片,宽、高不小于200像素</span>' +
						'</li>' +
						'<li class="preview-head-content">' +
							'<div class="preview-head-area">' +
								'<img src="" id="head-area">' +
							'</div>' +
							'<div class="preview-head-sure">' +
								'<img alt="头像预览" id="pre-head-base64">' +
							'</div>' +
						'</li>' +
						'<li class="preview-head-confirm">' +
							'<a href="javascript:void(0);" class="head-pre-save">确认</a>' +
							'<a href="javascript:void(0);" class="head-pre-close">取消</a>' +
						'</li>' +
					'</ul>' +
				'</div>';
	$('body').append(preHtm);
	//加入HTML
	//首次选择头像事件
	$('#first-head-select').bind('change', function(event) {
		var imageUrl = getObjectURL($(this)[0].files[0]);
		//设置预览
		$('#head-area').attr('src',imageUrl);
		//初始化剪切区域
		$('#head-area').imgAreaSelect({
			aspectRatio: '1:1', 
			x1:0,
			y1:0,
			x2:200,
			y2:200,
			minWidth:200,
			handles: true,
			fadeSpeed:200,
			onSelectEnd:function(img, selection){
				convertImgToBase64(imageUrl, selection, function(base64Img) {
					$('#pre-head-base64').attr('src',base64Img);
				});
			}
		});
		$('.mask').show();
		//设置预览区域居中
		$('.preview-head').css({
			top:($(window).height()-$('.preview-head').height())/2,
			left:($(window).width()-$('.preview-head').width())/2
		}).show();
	});
	//再次选择头像事件
	$('.select-head').bind('change', function(event) {
		var imageUrl = getObjectURL($(this)[0].files[0]);
		//设置预览
		$('#head-area').attr('src',imageUrl);
		//初始化剪切区域
		$('#head-area').imgAreaSelect({
			aspectRatio: '1:1', 
			x1:0,
			y1:0,
			x2:200,
			y2:200,
			minWidth:200,
			handles: true,
			fadeSpeed:200,
			onSelectEnd:function(img, selection){
				convertImgToBase64(imageUrl, selection, function(base64Img) {
					$('#pre-head-base64').attr('src',base64Img);
				});
			}
		});
	});
	//确认提交时间
	$('.head-pre-save').bind('click',function(){
		var base64 = ($('#pre-head-base64').attr('src')).split(",")[1];
		$.ajax({
			type:'post',
			url:'/talker/userinfo/updateicon',
			data:{'file':base64},
			dataType:'json',
			success:function(data){
				preHeadHide();
				initTip(data.message);
			},
			error:function(){
				initTip("出错啦");
			}
		});
	});
	//取消事件
	$('.head-pre-close').bind('click',function(){
		$('#head-area').imgAreaSelect({hide:true});
		preHeadHide();
	});
})
function preHeadHide(){
	$('#head-area').imgAreaSelect({hide:true});
	$('.mask').hide();
	$('.preview-head').hide();
}
/* 2015-09-28 */