package com.talker.system.file;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImgCut {
	
	private static Log log = LogFactory.getLog(ImgCut.class);

	public static void readUsingImageReader(HttpServletRequest request,String src, String dest) {
		try {
			// 取得图片读入器
			Iterator<ImageReader> readers = ImageIO
					.getImageReadersByFormatName("png");
			ImageReader reader = (ImageReader) readers.next();
			// 取得图片读入流
			InputStream source = new FileInputStream(src);
			ImageInputStream iis = ImageIO.createImageInputStream(source);
			reader.setInput(iis, true);
			int width = reader.getWidth(0);
			int height = reader.getHeight(0);
			int top = 0;
			int left = 0;
			if(width>height){
				left = (width-height)/2;
			}else{
				top = (height-width)/2;
			}
			// 图片参数
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(left, top, width>height?height:width, width>height?height:width);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi,"png", new File(dest));
		} catch (Exception e) {
			log.error("剪切图片出现异常", e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception { // main方法测试用
		//readUsingImageReader("f://2.jpg", "f://3.jpg");
	}
}