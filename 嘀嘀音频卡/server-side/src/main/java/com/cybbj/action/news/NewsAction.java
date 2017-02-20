package com.cybbj.action.news;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cybbj.pojo.News;
import com.cybbj.service.news.NewsService;

@Controller("newsAction")
@Path(value="/news")
public class NewsAction {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private NewsService newsService;
	
	@GET
	@Path(value="/newslist.do")
	@Produces(MediaType.APPLICATION_JSON)
	public List<News> getNewsList(@Context HttpServletRequest request){
		String page = request.getParameter("page");
		String perPage = request.getParameter("perpage");
		List<News> retNewsList = null;
		if(StringUtils.isNotBlank(page) && StringUtils.isNotBlank(perPage)){
			retNewsList = newsService.getNewsListByPage(page,perPage);
		}
		return retNewsList;
	}
}
