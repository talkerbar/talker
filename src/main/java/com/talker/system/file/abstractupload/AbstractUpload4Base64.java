package com.talker.system.file.abstractupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
public abstract class AbstractUpload4Base64 {
	
	/**
	 * 多文件上传
	 * @param file
	 * @param request
	 * @return
	 */
	public String[] upload(String[] file,String paths,HttpServletRequest request){
		if(file!=null && file.length!=0){
			String path = request.getSession().getServletContext().getRealPath(paths);
			Base64 base64 =  new Base64();
			String[] imageNames = new String[file.length];
			if(file != null && file.length!=0){
				int index = 0;
				for (String base64Str : file) {
					byte[] byteArray = base64.decode(base64Str);
					for (byte b : byteArray) {
						if(b<0)
							b+=256;
					}
					String imageName = this.getImageName();
					try {
						OutputStream out = new FileOutputStream(path+File.separator+imageName);
						out.write(byteArray);
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
						return imageNames;
					}
					imageNames[index] = imageName;
					index ++ ;
				}
			}
			return imageNames;
		}
		return null;
	}
	
	/**
	 * 根据系统规则得到图片名称
	 */
	public abstract String getImageName();
	
}
