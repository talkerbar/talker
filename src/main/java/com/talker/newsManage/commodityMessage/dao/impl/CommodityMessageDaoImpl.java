package com.talker.newsManage.commodityMessage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.newsManage.commodityMessage.dao.CommodityMessageDao;
import com.talker.newsManage.commodityMessage.pojo.CommodityMessage;
import com.talker.userManage.dao.UserInfoDao;

@Repository
public class CommodityMessageDaoImpl implements CommodityMessageDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserInfoDao userInfoDao;

	public boolean addCommodityMessage(CommodityMessage cm) {
		boolean result = false;
		String sql = "insert into commoditymessage(cid,content,createdate,post_userid,received_userid,parentid) values(?,?,?,?,?,?)";
		Object[] params = {cm.getCid(),cm.getContent(),cm.getCreateDate(),cm.getPost_userid(),cm.getReceived_userid(),cm.getParentid()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public List<CommodityMessage> getCommodityMessageForCid(int cid) {
		String sql = "SELECT c.*,u.nickname,u.icon FROM commoditymessage c JOIN userinfo u ON c.post_userid = u.userloginid AND cid ="+cid+" order by c.createdate desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CommodityMessage>(CommodityMessage.class));
	}
	
	public List<CommodityMessage> getReceivedMessage(int userid) {
		String sql = "SELECT c.*,u.nickname,u.icon FROM commoditymessage c JOIN userinfo u ON c.post_userid = u.userloginid AND c.received_userid ="+userid+" order by c.createdate desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CommodityMessage>(CommodityMessage.class));
	}

	public List<CommodityMessage> getPostMessage(int userid) {
		String sql = "SELECT c.*,u.nickname,u.icon FROM commoditymessage c JOIN userinfo u ON c.post_userid = u.userloginid AND c.post_userid ="+userid+" order by c.createdate desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CommodityMessage>(CommodityMessage.class));
	}

	public CommodityMessage getCommodityMessageForId(int id) {
		String sql = "select * from commoditymessage where 1=1 and id ="+id;
		List<CommodityMessage> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CommodityMessage>(CommodityMessage.class));
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
