package com.exam.dto;

public class CategoryDTO {
private long cid;
	
	
	private String title ;
	private String description;
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CategoryDto [cid=" + cid + ", title=" + title + ", description=" + description + "]";
	}
	
	
}
