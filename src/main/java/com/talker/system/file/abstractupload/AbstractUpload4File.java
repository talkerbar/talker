package com.talker.system.file.abstractupload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractUpload4File {
	
	/**
	 * 多文件上传
	 * @param file
	 * @param request
	 * @return
	 */
	public String[] upload(MultipartFile[] file, HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("upload");
        if(file != null && file.length!=0){
        	for (MultipartFile multipartFile : file) {
        		if(!multipartFile.isEmpty()){
        			// 是否为允许的类型
        			if(typeVerify(multipartFile)){
        				return null;
        			}
        			// 尺寸是否合法
        			if(dimensionVerify(multipartFile)){
        				return null;
        			}
        			String fileName = multipartFile.getOriginalFilename();  
        			File targetFile = new File(path, fileName);  
        			if(!targetFile.exists()){  
        				targetFile.mkdirs();  
        			}  
        			try {  
        				multipartFile.transferTo(targetFile);  
        			} catch (Exception e) {  
        				e.printStackTrace();
        				return null;
        			}  
        		}
			}
        }
        return null;
	}
	
	/**
	 * 文件类型验证
	 */
	public abstract boolean typeVerify(MultipartFile multipartFile);
	
	/**
	 * 尺寸验证
	 */
	public abstract boolean dimensionVerify(MultipartFile multipartFile);
	
}
