package com.mytacks.group10.tagatTack.model;

public class BoardMaster 
{
	private String boardName;
	private FileDetails boardImage;
	private String boardType;
	
	

	

	public BoardMaster(String boardName, FileDetails boardImage,
			String boardType) {
		
		this.boardName = boardName;
		this.boardImage = boardImage;
		this.boardType = boardType;
	}


	public BoardMaster() 
	{
		
	}


	public String getBoardName() {
		return boardName;
	}


	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}


	public FileDetails getBoardImage() {
		return boardImage;
	}


	public void setBoardImage(FileDetails boardImage) {
		this.boardImage = boardImage;
	}


	public String getBoardType() {
		return boardType;
	}


	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	
	
	
	
	
	
	
}
