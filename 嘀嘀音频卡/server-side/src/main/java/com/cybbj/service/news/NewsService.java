package com.cybbj.service.news;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybbj.dao.news.NewsDao;
import com.cybbj.pojo.News;

@Service("newsService")
public class NewsService {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private NewsDao newsDao;

	/**
	 * 获取新闻列表
	 * @param page 第几页
	 * @param perPage	每页几条数据
	 * @return
	 */
	public List<News> getNewsListByPage(String page, String perPage) {
		return newsDao.getNewsListByPage(page,perPage);
	}

	/**
	 * getNewsById : 根据id查询新闻表的新闻简介信息。
	 * @param nid
	 * @return
	 */
	public News getNewsById(String nid) {
		return newsDao.getNewsById(nid);
	}
	
	
}
