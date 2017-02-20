package com.cybbj.pojo;
/**
 * News : 新闻实体类
 * @author _Fan
 *
 */
public class News {

	private int id;
	private String title;	//标题
	private String time;	//时间
	private String profile;	//简介
	private String imgurl;	//预览图
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", title=" + title + ", time=" + time
				+ ", profile=" + profile + ", imgurl=" + imgurl + "]";
	}
	
	
	
}
