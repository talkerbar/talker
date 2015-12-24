package com.talker.commodityManage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.commodityManage.dao.ImagesDao;
import com.talker.commodityManage.pojo.Images;

@Repository
public class ImagesDaoImpl implements ImagesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public  int[] addImages(final List<Images> images,final int cid) {
		String sql = "insert into images(path,cover,cid) values(?,?,?)";
		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, images.get(i).getPath());
				ps.setInt(2, images.get(i).getCover());
				ps.setInt(3, cid);
			}
			
			public int getBatchSize() {
				return images.size();
			}
		});
	}

	public void updateImages(final List<Images> images,final int cid) {
		String sql = "updte images set path = ? ,cover = ? where cid = ?";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, images.get(i).getPath());
				ps.setInt(2, images.get(i).getCover());
				ps.setInt(3, cid);
			}
			
			public int getBatchSize() {
				return images.size();
			}
		});
	}

	public List<Images> getImagesForCid(int id) {
		String sql = "select * from images where 1=1 and cid = ?";
		return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<Images>(Images.class));
	}

}
