package com.cybbj.dao.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cybbj.utils.DateUtil;

@Repository(value="adviceDao")
public class AdviceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @param sadvice
	 * @return
	 */
	public int insertAdvice(String sadvice) {
		String sql = "insert into txcx(time,text) values(?,?)";
		return jdbcTemplate.update(sql,new Object[]{DateUtil.getDateTimeStr(),sadvice});
	}
	
	
}
