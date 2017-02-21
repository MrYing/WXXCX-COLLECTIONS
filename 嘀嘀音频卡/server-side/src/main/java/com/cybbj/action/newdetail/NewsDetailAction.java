package com.cybbj.action.newdetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.cybbj.pojo.NewsDetail;
import com.cybbj.service.newdetail.NewsDetailService;

@Controller("newsDetailAction")
@Path("/newsdetail")
public class NewsDetailAction {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private NewsDetailService newsDetailService;
	

	
	/**
	 * 根据新闻id查询新闻详细信息。
	 * @param request
	 * @return
	 */
	@GET
	@Path("/getContent.do")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<String,Object>> getNewsDetails(@Context HttpServletRequest request){
		String nid = request.getParameter("newId");	//得到要查询的新闻id.
		List<Map<String,Object>> retMap = null;
		if(StringUtils.isNotBlank(nid) && (nid != null)){
			List<NewsDetail> ndetailList = newsDetailService.getContentsByNewsId(nid);
			if(ndetailList.size() > 0){
				//封装返回的新闻内容列表
				retMap = newsDetailService.packageNewsContent(nid,ndetailList);
			}
		}
		return retMap == null ? new ArrayList<Map<String,Object>>():retMap;
	}
	
	
	
	
}
