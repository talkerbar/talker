package com.talker.commodityManage.dao;

import java.util.List;

import com.talker.commodityManage.pojo.Images;

public interface ImagesDao {
	
	int[] addImages(List<Images> images,int cid);
	void updateImages(List<Images> images,int cid);
	List<Images> getImagesForCid(int id);

}
