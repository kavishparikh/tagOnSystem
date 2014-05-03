package com.mytacks.group10.tagatTack.model;

public class TackMaster
{
	private String tackName;
	private FileDetails tackImage;
	private String tackURL;
	
	
	
	
	public TackMaster(String tackName, FileDetails tackImage, String tackURL) {
		
		this.tackName = tackName;
		this.tackImage = tackImage;
		this.tackURL = tackURL;
	}




	public TackMaster(String tackName, FileDetails tackImage) {
	
		this.tackName = tackName;
		this.tackImage = tackImage;
	}
	
	


	public TackMaster() {
		
	}




	public String getTackName() {
		return tackName;
	}


	public void setTackName(String tackName) {
		this.tackName = tackName;
	}


	public FileDetails getTackImage() {
		return tackImage;
	}


	public void setTackImage(FileDetails tackImage) {
		this.tackImage = tackImage;
	}




	public String getTackURL() {
		return tackURL;
	}




	public void setTackURL(String tackURL) {
		this.tackURL = tackURL;
	}
	
	
	
	
	
	
	
}
