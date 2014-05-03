package com.mytacks.group10.tagatTack.model;

public class FileDetails 
{
	private String contentType;
	private byte[] categoryImage;
	private byte[] boardImage;
	private byte[] tackImage;
	
	public FileDetails() 
	{
		
	}


	public FileDetails(String contentType, byte[] categoryImage) 
	{
	
		this.contentType = contentType;
		this.categoryImage = categoryImage;
	}

	

	public FileDetails(String contentType, byte[] categoryImage,
			byte[] boardImage) {
		
		this.contentType = contentType;
		this.categoryImage = categoryImage;
		this.boardImage = boardImage;
	}

	
	public FileDetails(String contentType, byte[] categoryImage,
			byte[] boardImage, byte[] tackImage) {
	
		this.contentType = contentType;
		this.categoryImage = categoryImage;
		this.boardImage = boardImage;
		this.tackImage = tackImage;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public byte[] getCategoryImage() {
		return categoryImage;
	}


	public void setCategoryImage(byte[] categoryImage) {
		this.categoryImage = categoryImage;
	}


	public byte[] getBoardImage() {
		return boardImage;
	}


	public void setBoardImage(byte[] boardImage) {
		this.boardImage = boardImage;
	}


	public byte[] getTackImage() {
		return tackImage;
	}


	public void setTackImage(byte[] tackImage) {
		this.tackImage = tackImage;
	}
	
	
	
	
	
	
}
