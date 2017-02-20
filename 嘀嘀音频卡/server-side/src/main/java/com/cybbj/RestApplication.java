/**   
 * 类名：RestApplication
 *
 */
package com.cybbj;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/** 
 * RestApplication: rest应用类测试
 * 
 * @version 1.0
 * @author 15989
 * @modified 2016-7-14 v1.0 15989 新建 
 */
public class RestApplication extends ResourceConfig {
    public RestApplication() {  

        //服务类所在的包路径  
        packages("com.cybbj.action");  
        //注册JSON转换器  
        register(JacksonJsonProvider.class);  
        register(JacksonJsonProvider.class);   
        register(JspMvcFeature.class);                                  //注册MVC支持  
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/");//jsp文件所在位置，当前JSP文件是在项目根目录下


       }  
}
