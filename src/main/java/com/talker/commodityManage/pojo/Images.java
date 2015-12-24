package com.talker.commodityManage.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Images implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String path;
	private int cover;
	private int cid;
	public Images() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Images(String path, int cover, int cid) {
		super();
		this.path = path;
		this.cover = cover;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getCover() {
		return cover;
	}
	public void setCover(int cover) {
		this.cover = cover;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Images [id=" + id + ", path=" + path + ", cover=" + cover
				+ ", cid=" + cid + "]";
	}
	
	public List<Images> factory4Array2Image(String[] imagePaths){
		List<Images> list = new ArrayList<Images>();
		for (String imagePath : imagePaths) {
			Images images = new Images(imagePath, 0, cid);
			list.add(images);
		}
		return list;
	}
}
