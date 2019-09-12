package com.ltsk.whcg.entity;

import java.util.List;

public class TreeNode {
	private String title;
	private String parentTitle;
	private String key;
	private String bg1;
	private String bg2;
	private List<TreeNode> children;
	public TreeNode(String title, String key, String bg1, String bg2,String parentTitle) {
		super();
		this.title = title;
		this.key = key;
		this.bg1 = bg1;
		this.bg2 = bg2;
		this.parentTitle=parentTitle;
	}
	public TreeNode(String title, String key, String bg1, String bg2) {
		super();
		this.title = title;
		this.key = key;
		this.bg1 = bg1;
		this.bg2 = bg2;
	}
	public TreeNode(String title, String key, String bg1, String bg2,TreeNode parent) {
		super();
		this.title = title;
		this.key = key;
		this.bg1 = bg1;
		this.bg2 = bg2;
		this.parentTitle=parent.getTitle();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getParentTitle() {
		return parentTitle;
	}
	public void setParentTitle(String parentTitle) {
		this.parentTitle = parentTitle;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getBg1() {
		return bg1;
	}
	public void setBg1(String bg1) {
		this.bg1 = bg1;
	}
	public String getBg2() {
		return bg2;
	}
	public void setBg2(String bg2) {
		this.bg2 = bg2;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
//	public String toJson() {
//		return "{title:" +"\""+ title +"\""+ ", parentTitle:" +"\""+ parentTitle +"\""+ ", key:" +"\""+ key +"\""+ ", bg1:" + bg1 + ", bg2:"
//				+ bg2 + ", children:" + children + "}";
//	}
	@Override
	public String toString() {
		return "{title:" +"\""+ title +"\""+ ", parentTitle:" +"\""+ parentTitle +"\""+ ", key:" +"\""+ key +"\""+ ", bg1:" + bg1 + ", bg2:"
				+ bg2 + ", children:" + children + "}";
	}
	public TreeNode() {
		super();
	}
	
}
