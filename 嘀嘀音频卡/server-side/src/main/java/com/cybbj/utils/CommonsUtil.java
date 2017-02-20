package com.cybbj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.ProtocolException;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
 * CommonsUtil：通用工具类
 * @author LJC
 *
 */
public class CommonsUtil {
	public static Map<String,String> session = new HashMap<String, String>();
	
	private static Logger log = Logger.getLogger(CommonsUtil.class);
	
	public static JSONObject httpsRequestToJsonObject(String requestUrl, String requestMethod, String outputStr) {
		
	    JSONObject jsonObject = null;
	    try {
	         StringBuffer buffer = httpsRequest(requestUrl, requestMethod, outputStr);
	        jsonObject = JSONObject.parseObject(buffer.toString());
	    } catch (ConnectException ce) {
	        log.error("连接超时："+ce.getMessage());
	    } catch (Exception e) {
	        log.error("https请求异常："+e.getMessage());
	    }
	    return jsonObject;
	}
	
	public static StringBuffer httpsRequest(String requestUrl, String requestMethod, String output) 
			throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException, 
			IOException, ProtocolException, UnsupportedEncodingException {
		
		URL url = new URL(requestUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod(requestMethod);
        if (null != output) {
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(output.getBytes("UTF-8"));
            outputStream.close();
        }

        // 从输入流读取返回内容
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        inputStream = null;
        connection.disconnect();
        return buffer;
    }
	
	/**
	 * create_nonce_str:获取12位随机数
	 * @return
	 */
	public static String create_nonce_str() {
		return UUID.randomUUID().toString().replace("-","");
	}
	
	/**
     * 将字节数组转换为十六进制字符串
     * 
     * @param byteArray
     * @return
     */
    public static String byteToStr(byte[] byteArray) {
    	String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
           strDigest += byteToHexStr(byteArray[i]);
           }
        return strDigest;
   }

   /**
    * 将字节转换为十六进制字符串
    * 
    * @param btyes
    * @return
    */
   public static String byteToHexStr(byte bytes) {
       char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
       char[] tempArr = new char[2];
       tempArr[0] = Digit[(bytes >>> 4) & 0X0F];
       tempArr[1] = Digit[bytes & 0X0F];

       String s = new String(tempArr);
       return s;
   }
   
   /**
    * 获取ip地址
    * @param request
    * @return
    */
   public static String getIpAddr(HttpServletRequest request) {  
       InetAddress addr = null;  
       try {  
           addr = InetAddress.getLocalHost();  
       } catch (UnknownHostException e) {  
           return request.getRemoteAddr();  
       }  
       byte[] ipAddr = addr.getAddress();  
       String ipAddrStr = "";  
       for (int i = 0; i < ipAddr.length; i++) {  
           if (i > 0) {  
               ipAddrStr += ".";  
           }  
           ipAddrStr += ipAddr[i] & 0xFF;  
       }  
       return ipAddrStr;  
   }  
   
   /**
    * create_timestamp：获取时间戳
    * @return
    */
   public static String create_timestamp(){
	   return String.valueOf(System.currentTimeMillis()/1000);
   }
}
