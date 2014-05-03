package com.mytacks.group10.tagatTack.model;

public class CategoryMaster
{
	private String categoryName;
	private FileDetails categoryImage;
	
	
	public CategoryMaster(String categoryName, FileDetails categoryImage) 
	{
	
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
	}

	
	
	public CategoryMaster() 
	{
		
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public FileDetails getCategoryImage() {
		return categoryImage;
	}


	public void setCategoryImage(FileDetails categoryImage) {
		this.categoryImage = categoryImage;
	}
	
	
	
	
	
	
}
