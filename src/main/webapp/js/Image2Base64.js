/* 2015-09-28 上传图片*/
function convertImgToBase64Commodity(url, callback, outputFormat) {
	var canvas = document.createElement('CANVAS');
	var ctx = canvas.getContext('2d');
	var img = new Image;
	img.crossOrigin = 'Anonymous';
	img.onload = function() {
		var width = img.width;
		var height = img.height;
		// 压缩比例
		var max = 1500;
		var rate = (width < height ? (height>max?max/height:height/max):(width>max?max/width:width/max));
		canvas.width = width * rate;
		canvas.height = height * rate;
		ctx.drawImage(img, 0, 0, width, height, 0, 0, width * rate, height
				* rate);
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
	$('#image').bind('change', function(event) {
		var imageUrl = getObjectURL($(this)[0].files[0]);
		convertImgToBase64Commodity(imageUrl, function(base64Img) {
			var index4img = $('#index4img').val();
			index4img++;
			var htm = 
			'<div class="coverImg">' +
              '<div class="table-cell">' +
                '<img src="'+base64Img+'">' +
              '</div>' +
              '<div class="coverImg-bottom">' +
                '<p class="floatLeft"><input type="radio" name="cover" class="cover" id="'+index4img+'" /><label for="'+index4img+'">封面</label></p>' +
                '<p class="floatLeft deleteCover">删除</p>' +
                '<input type="hidden" value="'+base64Img.split(",")[1]+'" id="'+index4img+'base64'+'">' +
              '</div>' +
              '<input type="hidden" name="file" value="'+base64Img.split(",")[1]+'"/>' +
            '</div>';
            $('.showImg').append(htm);
            $('#index4img').val(index4img);
            $('.deleteCover').bind('click',function(){
	            $(this).parents('.coverImg').remove();
	        });
		});
		event.preventDefault();
	});
})
/* 2015-09-28 */