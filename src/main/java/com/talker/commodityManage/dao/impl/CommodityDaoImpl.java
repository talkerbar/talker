package com.talker.commodityManage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.talker.commodityManage.dao.CommodityDao;
import com.talker.commodityManage.dao.ImagesDao;
import com.talker.commodityManage.pojo.Commodity;
import com.talker.dataManage.dao.PhoneRecordsDao;
import com.talker.dataManage.dao.VisitDao;
import com.talker.sortManage.dao.SortDao;
import com.talker.sortManage.pojo.Sort;
import com.talker.userManage.dao.UserInfoDao;

@Repository
public class CommodityDaoImpl implements CommodityDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ImagesDao imagesDao;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired 
	private VisitDao visitDao;
	@Autowired
	private SortDao sortDao;
	@Autowired
	private PhoneRecordsDao phoneRecordsDao;

	public int addCommodity(final Commodity c) {
		final String sql = "insert into commodity(title,sortid,newandold,newprice,oldprice,"
				+ "dicker,cellnumber,callname,schoolid,description,userid,createdate,status) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, c.getTitle());
					ps.setInt(2, c.getSortid());
					ps.setInt(3, c.getNewandold());
					ps.setDouble(4, c.getNewprice());
					ps.setDouble(5, c.getOldprice());
					ps.setInt(6, c.getDicker());
					ps.setString(7, c.getCellnumber());
					ps.setString(8, c.getCallname());
					ps.setInt(9, c.getSchoolid());
					ps.setString(10, c.getDescription());
					ps.setInt(11, c.getUserid());
					ps.setTimestamp(12, new Timestamp(c.getCreatedate().getTime()));
					ps.setInt(13, c.getStatus());
					return ps;
				}
			}, keyHolder);
			return keyHolder.getKey().intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
    /**
     * delete方法仅仅是更新status
     */
	public boolean delCommodity(int status,int id) {
		
		boolean result = false;
		
		String sql = "update commodity set status = ? where id = ?";
		Object[] params = {status,id};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public boolean updateCommodity(Commodity c) {
		
		boolean result = false;
		
		String sql = "update commodity set title = ?, sortid = ?, newandold = ?, newprice = ?,"
				+ " oldprice = ?, disker = ?, cellnumber = ?, callname = ?, schoolid = ?,"
				+ " description = ?, updatedate = ? where id = ?";
		Object[] params = {c.getTitle(),c.getSortid(),c.getNewandold(),c.getNewprice(),c.getOldprice(),
				c.getDicker(),c.getCellnumber(),c.getCallname(),c.getSchoolid(),c.getDescription(),
				c.getUpdatedate(),c.getId()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public List<Commodity> getCommodity(Commodity c) {
		StringBuffer sql = new StringBuffer("select * from commodity where 1=1 and status <> 3");
		List<Object> params = new ArrayList<Object>();
		if(c!=null){
			if(c.getId()!=0){
				sql.append(" and id = ?");
				params.add(c.getId());
			}
			if(c.getSortid()!=null){
				sql.append(" and sortid = ?");
				params.add(c.getSortid());
			}
			if(c.getSortidmore()!=null && !c.getSortidmore().equals("")){
				sql.append(" and sortid in (");
				sql.append(c.getSortidmore());
				sql.append(")");
			}
			if(c.getCellnumber()!=null){
				sql.append(" and cellnumber = ?");
				params.add(c.getCellnumber());
			}
			if(c.getSchoolid()!=null){
				sql.append(" and schoolid = ?");
				params.add(c.getSchoolid());
			}
			if(c.getUserid()!=null){
				sql.append(" and userid = ?");
				params.add(c.getUserid());
			}
			if(c.getStatus()!=null){
				sql.append(" and status = ?");
				params.add(c.getStatus());
			}
			sql.append(" ORDER BY status,createdate DESC");
			if(c.getPageNum()!=null){
				sql.append(" limit ?,?");
				params.add(c.beginIndex());
				params.add(c.getPageSize());
			}
		}
		final List<Commodity> list = new ArrayList<Commodity>();
		jdbcTemplate.query(sql.toString(), params.toArray(), new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				Commodity c = new Commodity();
				c.setId(rs.getInt("id"));
				c.setTitle(rs.getString("title"));
				c.setSortid(rs.getInt("sortid"));
				c.setNewandold(rs.getInt("newandold"));
				c.setNewprice(rs.getDouble("newprice"));
				c.setOldprice(rs.getDouble("oldprice"));
				c.setDicker(rs.getInt("dicker"));
				c.setCellnumber(rs.getString("cellnumber"));
				c.setCallname(rs.getString("callname"));
				c.setSchoolid(rs.getInt("schoolid"));
				c.setDescription(rs.getString("description"));
				c.setUserid(rs.getInt("userid"));
				c.setCreatedate(rs.getDate("createdate"));
				c.setUpdatedate(rs.getDate("updatedate"));
				c.setStatus(rs.getInt("status"));
				c.setImages(imagesDao.getImagesForCid(c.getId()));
				c.setUserInfoOut(userInfoDao.getUserInfoForLoginId(rs.getInt("userid")));
				c.setVisits(visitDao.getVisitCountForCid(rs.getInt("id")));
				if(rs.getInt("schoolid")!=0)
					c.setSchoolName(sortDao.getSortForId("school",rs.getInt("schoolid")));
				c.setPhoneRecords(phoneRecordsDao.getPhoneRecordsCountForCid(rs.getInt("id")));
				list.add(c);
			}
		});
		return list;
	}
	public String getCellnumber(int id) {
		String sql = "select cellnumber from commodity where 1=1 and id ="+id;
		try {
			return jdbcTemplate.queryForObject(sql, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Sort> getAllSchoolName() {
		String sql = "SELECT s.* FROM school s JOIN commodity c ON s.id = c.schoolid AND c.status = 1 GROUP BY s.id";
		return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sort>(Sort.class));
	}
	public List<Sort> getAllSortName() {
		String sql = "SELECT s.* FROM sort s JOIN commodity c ON s.id = c.sortid AND c.status = 1 GROUP BY s.id";
		return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sort>(Sort.class));
	}
	public Commodity getCommodityForId(int id) {
		String sql = "select * from commodity where 1=1 and id="+id;
		List<Commodity> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Commodity>(Commodity.class));
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	public List<Commodity> getHotCommodity() {
		String sql = "SELECT c.* FROM (SELECT count(*) as count,v.cid FROM visits v GROUP BY v.cid ORDER BY count desc) temp JOIN commodity c ON temp.cid = c.id and c.status = 1 LIMIT 0,10";
		final List<Commodity> list = new ArrayList<Commodity>();
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				Commodity c = new Commodity();
				c.setId(rs.getInt("id"));
				c.setTitle(rs.getString("title"));
				c.setSortid(rs.getInt("sortid"));
				c.setNewandold(rs.getInt("newandold"));
				c.setNewprice(rs.getDouble("newprice"));
				c.setOldprice(rs.getDouble("oldprice"));
				c.setDicker(rs.getInt("dicker"));
				c.setCellnumber(rs.getString("cellnumber"));
				c.setCallname(rs.getString("callname"));
				c.setSchoolid(rs.getInt("schoolid"));
				c.setDescription(rs.getString("description"));
				c.setUserid(rs.getInt("userid"));
				c.setCreatedate(rs.getDate("createdate"));
				c.setUpdatedate(rs.getDate("updatedate"));
				c.setStatus(rs.getInt("status"));
				c.setImages(imagesDao.getImagesForCid(c.getId()));
				c.setUserInfoOut(userInfoDao.getUserInfoForLoginId(rs.getInt("userid")));
				c.setVisits(visitDao.getVisitCountForCid(rs.getInt("id")));
				if(rs.getInt("schoolid")!=0)
					c.setSchoolName(sortDao.getSortForId("school",rs.getInt("schoolid")));
				c.setPhoneRecords(phoneRecordsDao.getPhoneRecordsCountForCid(rs.getInt("id")));
				list.add(c);
			}
		});
		return list;
	}
	@SuppressWarnings("deprecation")
	public int getCount(Commodity c) {
		StringBuffer sql = new StringBuffer("select count(*) from commodity where status <> 3");
		List<Object> params = new ArrayList<Object>();
		if(c!=null){
			if(c.getId()!=0){
				sql.append(" and id = ?");
				params.add(c.getId());
			}
			if(c.getSortid()!=null){
				sql.append(" and sortid = ?");
				params.add(c.getSortid());
			}
			if(c.getSortidmore()!=null && !c.getSortidmore().equals("")){
				sql.append(" and sortid in (");
				sql.append(c.getSortidmore());
				sql.append(")");
			}
			if(c.getCellnumber()!=null){
				sql.append(" and cellnumber = ?");
				params.add(c.getCellnumber());
			}
			if(c.getSchoolid()!=null){
				sql.append(" and schoolid = ?");
				params.add(c.getSchoolid());
			}
			if(c.getUserid()!=null){
				sql.append(" and userid = ?");
				params.add(c.getUserid());
			}
			if(c.getStatus()!=null){
				sql.append(" and status = ?");
				params.add(c.getStatus());
			}
		}
		return jdbcTemplate.queryForInt(sql.toString(), params.toArray());
	}

}
