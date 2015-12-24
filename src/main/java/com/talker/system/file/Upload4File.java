package com.talker.system.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.talker.system.file.abstractupload.AbstractUpload4File;

@Component
public class Upload4File extends AbstractUpload4File {

	@Override
	public boolean typeVerify(MultipartFile multipartFile) {
		return false;
	}

	@Override
	public boolean dimensionVerify(MultipartFile multipartFile) {
		return false;
	}

}
