package com.cybbj.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.cybbj.util.Converts;

public class MD5Util {
	
	/**
	 * MD5加密字符串，返回加密后的16进制字符串
	 * 
	 * @param origin
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String MD5EncodeToHex(String origin) throws UnsupportedEncodingException {
		return Converts.bytesToHexString(MD5Encode(origin));
	}

	/**
	 * MD5加密字符串，返回加密后的字节数组
	 * 
	 * @param origin
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static byte[] MD5Encode(String origin) throws UnsupportedEncodingException {
		return MD5Encode(origin.getBytes("UTF-8"));
	}

	/**
	 * MD5加密字节数组，返回加密后的字节数组
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] MD5Encode(byte[] bytes) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			return md.digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return new byte[0];
		}

	}

}
