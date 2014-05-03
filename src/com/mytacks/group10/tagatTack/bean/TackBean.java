package com.mytacks.group10.tagatTack.bean;

import com.mytacks.group10.tagatTack.model.FileDetails;

public class TackBean 
{
	private FileDetails tackImage;
	private String tackName;
	private String boardName;
	private String tackURL;
	private String action;
	
	
	public TackBean(FileDetails tackImage, String tackName, String boardName,
			String action) {
	
		this.tackImage = tackImage;
		this.tackName = tackName;
		this.boardName = boardName;
		this.action = action;
	}

	
	
	

	public TackBean(FileDetails tackImage, String tackName, String boardName,String tackURL, String action) 
	{
		
		this.tackImage = tackImage;
		this.tackName = tackName;
		this.boardName = boardName;
		this.tackURL = tackURL;
		this.action = action;
	}





	public TackBean() {
	
	}


	

	public FileDetails getTackImage() {
		return tackImage;
	}


	public void setTackImage(FileDetails tackImage) {
		this.tackImage = tackImage;
	}


	public String getTackName() {
		return tackName;
	}


	public void setTackName(String tackName) {
		this.tackName = tackName;
	}


	public String getBoardName() {
		return boardName;
	}


	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}





	public String getTackURL() {
		return tackURL;
	}





	public void setTackURL(String tackURL) {
		this.tackURL = tackURL;
	}
	
	
	
	
	
	
	
}
