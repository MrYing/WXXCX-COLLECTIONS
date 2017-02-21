package com.cybbj.service.newdetail;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cybbj.dao.newdetail.NewsDetailDao;
import com.cybbj.pojo.News;
import com.cybbj.pojo.NewsDetail;
import com.cybbj.service.news.NewsService;

@Service("newsDetailService")
public class NewsDetailService {
	
	private Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private NewsDetailDao newsDetailDao;
	
	@Autowired
	private NewsService newsService;
	
	/**
	 * getContentsByNewsId : 根据新闻id查询新闻详情内容。
	 * @param nid
	 * @return
	 */
	public List<NewsDetail> getContentsByNewsId(String nid) {
		return newsDetailDao.getContentsByNewsId(nid);
	}

	/**
	 * packageNewsContent : 封装处理得到新闻内容，得到指定格式内容并返回前端。
	 * @param nid
	 * @param ndetailList
	 * @return
	 */
	public List<Map<String,Object>> packageNewsContent(String nid,
			List<NewsDetail> ndetailList) {
		List<Map<String,Object>> retMap = new ArrayList<Map<String,Object>>();
		News news = newsService.getNewsById(nid);
		if(news != null){
			Map<String,Object> rawMap = new LinkedHashMap<String,Object>();
			rawMap.put("id", String.valueOf(news.getId()));
			rawMap.put("title", news.getTitle());
			rawMap.put("time", news.getTime());
			rawMap.put("content", ndetailList);
			retMap.add(rawMap);
		}
		return retMap;
	}

}
