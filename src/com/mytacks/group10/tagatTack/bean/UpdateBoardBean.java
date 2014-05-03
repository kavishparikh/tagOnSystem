package com.mytacks.group10.tagatTack.bean;

import com.mytacks.group10.tagatTack.model.FileDetails;

public class UpdateBoardBean 
{
	private FileDetails boardImage;
	private String boardName;
	private String oldBoardName;
	private String categoryName;
	private String boardType;
	private String action;
	
	
	public UpdateBoardBean(FileDetails boardImage, String boardName, String action) 
	{
	
		this.boardImage = boardImage;
		this.boardName = boardName;
		this.action = action;
	}


	public UpdateBoardBean(FileDetails boardImage, String boardName,
			String oldBoardName, String categoryName, String boardType,
			String action) {
		super();
		this.boardImage = boardImage;
		this.boardName = boardName;
		this.oldBoardName = oldBoardName;
		this.categoryName = categoryName;
		this.boardType = boardType;
		this.action = action;
	}


	public UpdateBoardBean(FileDetails boardImage, String boardName,
			String categoryName, String action) {
	
		this.boardImage = boardImage;
		this.boardName = boardName;
		this.categoryName = categoryName;
		this.action = action;
	}




	public UpdateBoardBean()
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





	public String getOldBoardName() {
		return oldBoardName;
	}


	public void setOldBoardName(String oldBoardName) {
		this.oldBoardName = oldBoardName;
	}


	public String getBoardType() {
		return boardType;
	}


	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	
	
	
	

}
