package com.mytacks.group10.tagatTack.bean;

import com.mytacks.group10.tagatTack.model.FileDetails;

public class CategoryBean
{
	private FileDetails categoryImage;
	private String categoryName;
	private String action;
	
	
	
	public CategoryBean() {
	
	}

	public CategoryBean(FileDetails categoryImage, String action) 
	{
	
		this.categoryImage = categoryImage;
		this.action = action;
	}

	public FileDetails getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(FileDetails categoryImage) {
		this.categoryImage = categoryImage;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	
	
	
}
