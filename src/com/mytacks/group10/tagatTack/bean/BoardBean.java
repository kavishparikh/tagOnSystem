package com.mytacks.group10.tagatTack.bean;

import com.mytacks.group10.tagatTack.model.FileDetails;

public class BoardBean 
{
	private FileDetails boardImage;
	private String boardName;
	private String categoryName;
	private String action;
	
	
	public BoardBean(FileDetails boardImage, String boardName, String action) 
	{
	
		this.boardImage = boardImage;
		this.boardName = boardName;
		this.action = action;
	}
	
	


	public BoardBean(FileDetails boardImage, String boardName,
			String categoryName, String action) {
	
		this.boardImage = boardImage;
		this.boardName = boardName;
		this.categoryName = categoryName;
		this.action = action;
	}




	public BoardBean()
	{
	
	}


	public FileDetails getBoardImage() {
		return boardImage;
	}


	public void setBoardImage(FileDetails boardImage) {
		this.boardImage = boardImage;
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


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	
	
	
	
	

}
