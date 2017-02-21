package com.cybbj.pojo;
/**
 * NewsDetail : 新闻详情内容
 * @author _Fan
 *
 */
public class NewsDetail {

	private int id;
	private int newid;		//关联新闻id	
	private String text;	//新闻内容
	private String img;		//图片
	private String imgprofile;	//图片下方简介文字
	private int sort;		//内容段序号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewid() {
		return newid;
	}
	public void setNewid(int newid) {
		this.newid = newid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getImgprofile() {
		return imgprofile;
	}
	public void setImgprofile(String imgprofile) {
		this.imgprofile = imgprofile;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "{text=" + text + ", img=" + img + ", imgprofile="
				+ imgprofile + ", sort=" + sort + "}";
	}
	
	
	
}
