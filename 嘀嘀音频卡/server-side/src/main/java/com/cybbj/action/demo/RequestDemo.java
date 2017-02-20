package com.cybbj.action.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Controller;

@Controller("RequestDemo")
@Path("/test")
public class RequestDemo {

	@GET
	@Path("/text")
	public String payNotify(@Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception{
		 return "text from remote alibaba server.";
	}
}
