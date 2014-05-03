package com.mytacks.group10.tagatTack.manager;

import java.io.IOException;
import java.util.ArrayList;

import com.mytacks.group10.tagatTack.dao.AdminDAO;
import com.mytacks.group10.tagatTack.model.BoardMaster;
import com.mytacks.group10.tagatTack.model.CategoryMaster;

public class AdminManager 
{
	AdminDAO adminDAO=new AdminDAO();

	public boolean addCategory(CategoryMaster categoryMaster)
	{
		boolean flag=false;
		flag=adminDAO.addCategory(categoryMaster);
		return flag;
		
	}
	
	public CategoryMaster getCategoryDetails(String categoryName)throws IOException
	{
		CategoryMaster categoryMaster=null;
		
		try
		{
		
		categoryMaster=adminDAO.getCategoryDetails(categoryName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return categoryMaster;
	}
	public ArrayList<CategoryMaster> listAllCategories() throws IOException
	{
		ArrayList<CategoryMaster> listAll=adminDAO.listAllCategories();
		
		return listAll;
		
	}
	public ArrayList<BoardMaster> listAllBoards() throws IOException
	{
		ArrayList<BoardMaster> listOfBoards=null;
		
		listOfBoards=adminDAO.listAllBoards();
		
		return listOfBoards;
	}
	public boolean deleteBoard(String boardName)
	{
		boolean flag=false;
		flag=adminDAO.deleteBoard(boardName);
		return flag;
	}
}
