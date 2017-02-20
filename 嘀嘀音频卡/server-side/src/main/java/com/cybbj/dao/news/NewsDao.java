package com.cybbj.dao.news;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.cybbj.pojo.News;

@Repository("newsDao")
public class NewsDao {

	private Log log = LogFactory.getLog(this.getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 分页查询新闻列表内容
	 * @param page
	 * @param perPage
	 * @return
	 */
	public List<News> getNewsListByPage(String page, String perPage) {
		int ipage = Integer.valueOf(page);
		int iperPage = Integer.valueOf(perPage);
		final List<News> newsList = new ArrayList<News>();
		String sql = "select * from t_news t order by t.time desc limit ?,?";
		try {
//			newslist = jdbcTemplate.queryForList(sql, News.class,page,perPage);
			jdbcTemplate.query(sql,new RowCallbackHandler(){
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					News n = new News();
					n.setId(rs.getInt("id"));
					n.setTitle(rs.getString("title"));
					n.setTime(rs.getString("time"));
					n.setProfile(rs.getString("profile"));
			        n.setImgurl(rs.getString("imgurl"));
			        newsList.add(n);
				}
				
			},(ipage-1) * iperPage, ipage * iperPage);
		} catch (Exception e) {
			log.error("获取新闻列表数据失败: sql >>"+sql+"  错误信息:>>" + e);
		}
		return newsList;
	}
	
	
}
