package com.cybbj.action.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import jodd.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cybbj.service.advice.AdviceService;

@Controller("adviceAction")
@Path(value="/advice")
public class AdviceAction {
	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private AdviceService adviceService;
	
	@POST
	@Path(value="/submit.do") 
	public int submitAdvice(@Context HttpServletRequest request, @Context HttpServletResponse response,@FormParam("advice") String advice){
		int iretval=0;
		log.info(">>>>>>>>>>>>>>>>>"+advice);
		log.info("获取小程序参数结果:>>"+advice);
		if(StringUtil.isNotBlank(advice) && advice!=null){
			iretval = adviceService.insertAdvice(advice);
		}
		log.info("操作结果（1：成功  0：失败）:>>"+iretval);
		return iretval;
	}

}
