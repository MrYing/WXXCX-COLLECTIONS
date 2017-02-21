package com.cybbj.dao.newdetail;

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
import com.cybbj.pojo.NewsDetail;

@Repository("newsDetailDao")
public class NewsDetailDao {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * getContentsByNewsId : 根据新闻id查询新闻详情内容。
	 * @param nid
	 * @return
	 */
	public List<NewsDetail> getContentsByNewsId(String nid) {
		final List<NewsDetail> newdetailList = new ArrayList<NewsDetail>();
		String sql = "select id,newid,text,img,imgprofile,sort from t_new_content t where t.newid = ? order by t.sort";
		try{
			int iid = Integer.valueOf(nid);
			jdbcTemplate.query(sql,new RowCallbackHandler(){
				public void processRow(ResultSet rs) throws SQLException {
					NewsDetail n = new NewsDetail();
					n.setId(rs.getInt("id"));
					n.setNewid(rs.getInt("newid"));
					n.setImg(rs.getString("img"));
					n.setImgprofile(rs.getString("imgprofile"));
					n.setText(rs.getString("text"));
					n.setSort(rs.getInt("sort"));
			        newdetailList.add(n);
				}
			},iid);
		} catch (Exception e){
			log.error("根据新闻id="+nid+",查询新闻详情失败。sql:"+sql+", 错误信息:>>"+e);
		}
		return newdetailList;
	}
}
