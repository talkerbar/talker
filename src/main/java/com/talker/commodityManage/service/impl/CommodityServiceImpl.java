package com.talker.commodityManage.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talker.commodityManage.dao.CommodityDao;
import com.talker.commodityManage.dao.ImagesDao;
import com.talker.commodityManage.pojo.Commodity;
import com.talker.commodityManage.pojo.Images;
import com.talker.commodityManage.pojo.Page;
import com.talker.commodityManage.service.CommodityService;
import com.talker.sortManage.pojo.Sort;
import com.talker.system.file.ImgCut;
import com.talker.system.file.Upload4Base64;
import com.talker.util.ResponseModel;

@Service
public class CommodityServiceImpl implements CommodityService {
	
	private static final int NORMAL = 1;   //正常
//	private static final int SHELVES = 2;  //下架
//	private static final int DELETE = 3;   //删除
	
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private ImagesDao imagesDao;
	@Autowired
	private Upload4Base64 upload4Base64;
	
	@Transactional
	public ResponseModel addCommodity(String[] file,Commodity c,HttpServletRequest request) {
		boolean success = false;
		String message = "请求参数不合法！";
		if(checkCommodityParams(file,c)){
			try {
				int cid = commodityDao.addCommodity(c);
				if(cid!=0){
					List<Images> images = new Images().factory4Array2Image(upload4Base64.upload(file,"upload",request));
					int[] result = imagesDao.addImages(images, cid);
					if(result!=null && result.length!=0){
						success = true;
						message = "宝贝发布成功！";
					}else{
						message = "哎呀，宝贝添加失败，请重新提交！";
						// 事物回滚
						throw new RuntimeException();
					}
				}else{
					message = "哎呀，宝贝途中出了问题！";
				}
			} catch (Exception e) {
				e.printStackTrace();
				message = "哎呀，添加宝贝时出错啦！";
				// 事物回滚
				throw new RuntimeException();
			}
		}
		return ResponseModel.buildMessage(success, message);
	}

	public ResponseModel delCommodity(int status,int id) {
		boolean success = false;
		String message = "参数请求异常";
		if(status!=0 && id!=0){
			boolean result = commodityDao.delCommodity(status,id);
			if(result){
				success = result;
				switch (status) {
				case 1:
					message = "商品已上架";
					break;
				case 2:
					message = "商品已下架";
					break;
				case 3:
					message = "商品已删除";
					break;
				}
			}else{
				switch (status) {
				case 1:
					message = "商品上架失败";
					break;
				case 2:
					message = "商品下架失败";
					break;
				case 3:
					message = "商品删除失败";
					break;
				}
			}
		}
		
		return ResponseModel.buildMessage(success, message);
	}

	@Transactional(rollbackForClassName="RuntimeException",propagation = Propagation.REQUIRED)
	public boolean updateCommodity(String[] file,Commodity c,HttpServletRequest request) {
		commodityDao.updateCommodity(c);
		c.setImages(new Images().factory4Array2Image(upload4Base64.upload(file,"upload",request)));
		imagesDao.updateImages(c.getImages(), c.getId());
		return true;
	}

	public List<Commodity> getCommodity(HttpServletRequest request,Commodity c) {
		List<Commodity> list = commodityDao.getCommodity(c);
		for (Commodity commodity : list) {
			if(!commodity.getImages().isEmpty()){
				ImgCut.readUsingImageReader(request, commodity.getImages().get(0).getPath());
			}
		}
		return list;
	}

	public Page getCommodityPage(HttpServletRequest request, Commodity c) {
		List<Commodity> list = getCommodity(request, c);
		int pageCount = this.getPageCount(commodityDao.getCount(c), c.getPageSize());
		return Page.buildPage(c.getPageNum(), pageCount, list);
	}

	public List<Sort> getAllSchoolName() {
		return commodityDao.getAllSchoolName();
	}

	public List<Sort> getAllSortName() {
		return commodityDao.getAllSortName();
	}

	public Commodity getCommodityForId(int id) {
		if(id!=0){
			return commodityDao.getCommodityForId(id);
		}
		return null;
	}

	public List<Commodity> getHotCommodity(HttpServletRequest request) {
		List<Commodity> hotList =  commodityDao.getHotCommodity();
		for (Commodity commodity : hotList) {
			if(!commodity.getImages().isEmpty()){
				ImgCut.readUsingImageReader(request, commodity.getImages().get(0).getPath());
			}
		}
		return hotList;
	}

	public String getCellnumber(int id) {
		if(id==0){
			return null;
		}
		return commodityDao.getCellnumber(id);
	}
	
	// 添加商品参数检测
	private boolean checkCommodityParams(String[] file, Commodity c) {
		if(file==null){
			return false;
		}
		if(c==null){
			return false;
		}
		if(c.getTitle()==null){
			return false;
		}
		if(c.getSortid()==null){
			return false;
		}
		if(c.getNewandold()==null){
			return false;
		}
		if(c.getNewprice()==null){
			return false;
		}
		if(c.getDicker()==null){
			return false;
		}
		if(c.getCellnumber()==null){
			return false;
		}
		if(c.getCallname()==null){
			return false;
		}
		if(c.getSchoolid()==null){
			return false;
		}
		if(c.getDescription()==null){
			return false;
		}
		if(c.getCreatedate()==null){
			c.setCreatedate(new Date());
		}
		if(c.getStatus()==null){
			c.setStatus(NORMAL);
		}
		return true;
	}

	private int getPageCount(int commodityCount,int pageSize){
		return (commodityCount + pageSize -1)/pageSize;
	}
}
