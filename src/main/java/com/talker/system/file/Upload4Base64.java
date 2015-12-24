package com.talker.system.file;

import org.springframework.stereotype.Component;

import com.talker.system.file.abstractupload.AbstractUpload4Base64;
import com.talker.util.StringHelper;

@Component
public class Upload4Base64 extends AbstractUpload4Base64{

	@Override
	public String getImageName() {
		return StringHelper.getUUID()+".jpg";
	}

}
