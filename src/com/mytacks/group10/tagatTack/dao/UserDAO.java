package com.mytacks.group10.tagatTack.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;







import com.mytacks.group10.tagatTack.model.BoardMaster;
import com.mytacks.group10.tagatTack.model.CategoryMaster;
import com.mytacks.group10.tagatTack.model.FileDetails;
import com.mytacks.group10.tagatTack.model.TackMaster;
import com.mytacks.group10.tagatTack.model.UserMaster;
import com.mytacks.group10.tagatTack.utility.DataConnection;
import com.mytacks.group10.tagatTack.utility.MyTacksConstants;

public class UserDAO 
{
	private static final Logger log = Logger.getLogger(UserDAO.class);


	public boolean signUpUser(UserMaster userInfo)
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			con = DataConnection.getConnection();
			ps = con.prepareStatement(MyTacksConstants.ADD_USER_DETAILS_QUERY);
			
			ps.setString(1, userInfo.getEmailAddress());
			ps.setString(2, userInfo.getUserPassword());
			ps.setString(3, userInfo.getFirstName());
			ps.setString(4, userInfo.getLastName());
			ps.setString(5, userInfo.getGender());
			ps.setString(6, userInfo.getEmailAddress());
			ps.setString(7, userInfo.getPhoneNo());
			/*ps.setString(8, userInfo.getConfirmationCode());
			ps.setString(9, userInfo.getActivationStatus());*/
			ps.setString(8, userInfo.getLastLoginTime());
			
			int check = ps.executeUpdate();
			log.info("The User Master Flag is:"+check);
			if(check > 0)
			{
				flag = true;
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		
		return flag;
}
	
	public boolean activateUser(String confirmationCode)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.ACTIVATE_USER_QUERY);
			ps.setString(1, "ACTIVE");
			ps.setString(2, confirmationCode);
			
			int j=ps.executeUpdate();
			if(j>0)
			{
				flag=true;
			}
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		
		return flag;
		
	}

	public String checkUserLoginDetails(UserMaster userLoginDetails)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		String lastLogin=null;
		String updateLastLogin=null;
		PreparedStatement statement = null;
		try
		{
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.CHECK_LOGIN_QUERY);
			ps.setString(1, userLoginDetails.getUserId());
			ps.setString(2, userLoginDetails.getUserPassword());
			System.out.print(ps);
			ResultSet rs=ps.executeQuery();
			System.out.print(rs);
			if(rs.next())
			{
				if(rs.getString(8).equals("ACTIVE"))
				{
					flag=true;
				}
				lastLogin = rs.getString("LastLoginTime");
				System.out.println("last"+lastLogin);
			}
			
			statement = con.prepareStatement(MyTacksConstants.UPDATE_LOGIN_TIME_QUERY);
			statement.setTimestamp(1, date);
			statement.setString(2, userLoginDetails.getUserId());
			statement.setString(3, userLoginDetails.getUserPassword());
			
			int i=statement.executeUpdate();
			if(i>0)
			{
				System.out.println("Updated.");
			}
			else
			{
				System.out.println("Not Updated.");
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		
		return lastLogin;
		
	}
	
	public String updateLastLoginTimeForFacebookUser(String userID)
	{
		String lastLogin="";
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try
		{
			
			
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			con=DataConnection.getConnection();
			
			ps1=con.prepareStatement(MyTacksConstants.GET_LASTLOGIN_QUERY);
			ps1.setString(1, userID);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
			lastLogin=rs.getString(1);
			}
			
			
			ps=con.prepareStatement(MyTacksConstants.UPDATE_LASTLOGIN_FOR_USER_QUERY);
			ps.setTimestamp(1, date);
			ps.setString(2, userID);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
		log.info("Updated.");
				
			}
			else
			{
				log.info("Not Updated.");
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}
		return lastLogin;
	}
	
	
	public UserMaster sendOldPassword(String userID)
	{
		UserMaster userDetails=null;
		Connection con=null;
		PreparedStatement ps=null;
		
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.FORGOT_PASSWORD_QUERY);
			ps.setString(1, userID);
			//ps.setString(2, "ACTIVE");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{	
				userDetails=new UserMaster();
				userDetails.setUserId(rs.getString(1));
				userDetails.setUserPassword(rs.getString(2));
				//userDetails.setFirstName(rs.getString(3));
				//userDetails.setLastName(rs.getString(4));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		return userDetails;
		
	}
	
	public boolean addBoard(BoardMaster boardMaster,String categoryName,String userID)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		boolean flag=false;
		int categoryID=0;
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_CATEGORYID_QUERY);
			ps.setString(1, categoryName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			categoryID=rs.getInt(1);	
			}
			
			ps1=con.prepareStatement(MyTacksConstants.ADD_BOARD_QUERY);
			ps1.setString(1,boardMaster.getBoardName());
			ByteArrayInputStream bas1 = new ByteArrayInputStream(boardMaster.getBoardImage().getBoardImage());
			ps1.setBinaryStream(2, bas1, boardMaster.getBoardImage().getBoardImage().length);
			ps1.setString(3,boardMaster.getBoardType());
			ps1.setInt(4, categoryID);
			ps1.setString(5, userID);
		
			int i=ps1.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
			
		}
		return flag;
		
		
	}
	

	public boolean addTack(TackMaster tackMaster,String boardName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		boolean flag=false;
		int boardID=0;
		
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_BOARDID_QUERY);
			ps.setString(1, boardName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			boardID=rs.getInt(1);	
			}
			
			ps1=con.prepareStatement(MyTacksConstants.ADD_TACK_QUERY);
			ps1.setString(1,tackMaster.getTackName());
			ByteArrayInputStream bas1 = new ByteArrayInputStream(tackMaster.getTackImage().getTackImage());
			ps1.setBinaryStream(2, bas1, tackMaster.getTackImage().getTackImage().length);
			ps1.setInt(3,boardID);
			ps1.setString(4,tackMaster.getTackURL());
		
			int i=ps1.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
			
		}
		return flag;
		
		
	}
	
	public ArrayList<TackMaster> listAllTacks(String boardName) throws IOException
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ArrayList<TackMaster> listOfTacks=null;
		int boardID=0;
		try
		{
			listOfTacks=new ArrayList<TackMaster>();
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_BOARDID_QUERY);
			ps.setString(1, boardName);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				boardID=rs.getInt(1);
			}
			
			ps1=con.prepareStatement(MyTacksConstants.SELECT_ALL_TACK_QUERY);
			ps1.setInt(1, boardID);
			
			
			ResultSet rs1=ps1.executeQuery();
			
			while(rs1.next())
			{
				ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
				TackMaster tackMaster=new TackMaster();
				InputStream img1 = rs1.getBinaryStream(3);
				BufferedImage bf1 = ImageIO.read(img1);
				ImageIO.write(bf1, "jpeg", bos1);
				byte[] data1 = bos1.toByteArray();
				FileDetails fd1 = new FileDetails();
				fd1.setTackImage(data1);
				tackMaster.setTackImage(fd1);
				tackMaster.setTackName(rs1.getString(2));
				tackMaster.setTackURL(rs1.getString(5));
				listOfTacks.add(tackMaster);
				
			}	
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.getConnection();
			DataConnection.closeStatement(ps);
		}
		return listOfTacks;
	}
	
	public ArrayList<BoardMaster> listAllBoardsByCategory(String categoryName,String userID) throws IOException
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ArrayList<BoardMaster> listOfBoards=null;
		int categoryID=0;
		try
		{
			listOfBoards=new ArrayList<BoardMaster>();
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_CATEGORYID_QUERY);
			ps.setString(1, categoryName);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				categoryID=rs.getInt(1);
			}
			
			ps1=con.prepareStatement(MyTacksConstants.VIEW_OTHERS_BOARD_QUERY);
			ps1.setInt(1, categoryID);
			ps1.setString(2, userID);
			ps1.setString(3, "FOLLOWING");
			ps1.setString(4, "PUBLIC");
			ResultSet rs1=ps1.executeQuery();
			
			while(rs1.next())
			{
				ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
				BoardMaster boardMaster=new BoardMaster();
				InputStream img1 = rs1.getBinaryStream(3);
				BufferedImage bf1 = ImageIO.read(img1);
				ImageIO.write(bf1, "jpeg", bos1);
				byte[] data1 = bos1.toByteArray();
				FileDetails fd1 = new FileDetails();
				fd1.setBoardImage(data1);
				boardMaster.setBoardImage(fd1);
				boardMaster.setBoardName(rs1.getString(2));
				listOfBoards.add(boardMaster);
				
			}	
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.getConnection();
			DataConnection.closeStatement(ps);
		}
		return listOfBoards;
	}

	
	
	
	public ArrayList<BoardMaster> listAllBoards(String userID) throws IOException
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<BoardMaster> listOfBoards=null;
		
		try
		{
			listOfBoards=new ArrayList<BoardMaster>();
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.VIEW_ALL_BOARDS_QUERY);
			ps.setString(1, userID);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
				BoardMaster boardMaster=new BoardMaster();
				InputStream img1 = rs.getBinaryStream(3);
				BufferedImage bf1 = ImageIO.read(img1);
				ImageIO.write(bf1, "jpeg", bos1);
				byte[] data1 = bos1.toByteArray();
				FileDetails fd1 = new FileDetails();
				fd1.setBoardImage(data1);
				boardMaster.setBoardImage(fd1);
				boardMaster.setBoardName(rs.getString(2));
				listOfBoards.add(boardMaster);
				
			}	
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.getConnection();
			DataConnection.closeStatement(ps);
		}
		
		return listOfBoards;
		
		
	}

	public ArrayList<CategoryMaster> listAllCategories() throws IOException
	{
		
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<CategoryMaster> listOfCategories=null;
		
		try
		{
			listOfCategories=new ArrayList<CategoryMaster>();
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.VIEW_ALL_CATEGORIES_QUERY);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
				CategoryMaster categoryMaster=new CategoryMaster();
				InputStream img1 = rs.getBinaryStream(3);
				BufferedImage bf1 = ImageIO.read(img1);
				ImageIO.write(bf1, "jpeg", bos1);
				byte[] data1 = bos1.toByteArray();
				FileDetails fd1 = new FileDetails();
				fd1.setCategoryImage(data1);
				categoryMaster.setCategoryImage(fd1);
				categoryMaster.setCategoryName(rs.getString(2));
				listOfCategories.add(categoryMaster);
				
			}	
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.getConnection();
			DataConnection.closeStatement(ps);
		}
		
		return listOfCategories;
		
		
	}
	
	public String getCategoryName(String boardName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		String categoryName="";
		int categoryID=0;
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_CATEGORYID_FROM_BOARD_QUERY);
			ps.setString(1, boardName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			categoryID=rs.getInt(1);	
			}
			ps1=con.prepareStatement(MyTacksConstants.SELECT_CATEGORYNAME_QUERY);
			ps1.setInt(1, categoryID);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				categoryName=rs1.getString(1);
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}
		return categoryName;
		
		
	}
	
	public String getBoardName(String tackName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		String boardName="";
		int boardID=0;
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_BOARDID_FROM_TACK_QUERY);
			ps.setString(1, tackName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			boardID=rs.getInt(1);	
			}
			ps1=con.prepareStatement(MyTacksConstants.SELECT_BOARDNAME_FROM_BOARD_QUERY);
			ps1.setInt(1, boardID);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				boardName=rs1.getString(1);
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}
		return boardName;
		
		
	}
	
	
	public boolean updateBoardDetails(BoardMaster boardMaster,String categoryName,String oldBoardName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		boolean flag=false;
		int categoryID=0;
		try
		{
			con=DataConnection.getConnection();
			ps1=con.prepareStatement(MyTacksConstants.SELECT_CATEGORYID_QUERY);
			ps1.setString(1, categoryName);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				categoryID=rs.getInt(1);
			}
			
			ps=con.prepareStatement(MyTacksConstants.UPDATE_BOARD_QUERY);
			ByteArrayInputStream bas1 = new ByteArrayInputStream(boardMaster.getBoardImage().getBoardImage());
			ps.setBinaryStream(1, bas1, boardMaster.getBoardImage().getBoardImage().length);
			ps.setString(2, boardMaster.getBoardName());
			ps.setInt(3, categoryID);
			ps.setString(4, boardMaster.getBoardType());
			ps.setString(5, oldBoardName);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				flag=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		return flag;
	}
	
	public boolean updateTackDetails(TackMaster tackMaster,String boardName,String oldTackName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		boolean flag=false;
		int boardID=0;
		try
		{
			con=DataConnection.getConnection();
			ps1=con.prepareStatement(MyTacksConstants.SELECT_BOARDID_QUERY);
			ps1.setString(1, boardName);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				boardID=rs.getInt(1);
			}
			ps=con.prepareStatement(MyTacksConstants.UPDATE_TACK_QUERY);
			ByteArrayInputStream bas1 = new ByteArrayInputStream(tackMaster.getTackImage().getTackImage());
			ps.setBinaryStream(1, bas1, tackMaster.getTackImage().getTackImage().length);
			ps.setString(2, tackMaster.getTackName());
			ps.setInt(3, boardID);
			ps.setString(4,tackMaster.getTackURL());
			ps.setString(5, tackMaster.getTackName());
			
			int i=ps.executeUpdate();
			log.info("The value is"+i);
			
			if(i>0)
			{
				flag=true;
			}	
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}
		return flag;
	}
	
	
	
		
	public boolean updateBoardDetailsWithoutImage(BoardMaster boardMaster,String categoryName,String oldBoardName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		boolean flag=false;
		int categoryID=0;
		try
		{
			con=DataConnection.getConnection();
			ps1=con.prepareStatement(MyTacksConstants.SELECT_CATEGORYID_QUERY);
			ps1.setString(1, categoryName);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				categoryID=rs.getInt(1);
			}
			
			ps=con.prepareStatement(MyTacksConstants.UPDATE_BOARD_WITHOUT_IMAGE_QUERY);
			ps.setString(1, boardMaster.getBoardName());
			ps.setInt(2, categoryID);
			ps.setString(3, boardMaster.getBoardType());
			ps.setString(4, oldBoardName);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				flag=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		return flag;
	}
	
	public boolean updateTackDetailsWithoutImage(TackMaster tackMaster,String boardName,String oldTackName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		boolean flag=false;
		int boardID=0;
		try
		{
			con=DataConnection.getConnection();
			ps1=con.prepareStatement(MyTacksConstants.SELECT_BOARDID_QUERY);
			ps1.setString(1, boardName);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				boardID=rs.getInt(1);
			}
			
			ps=con.prepareStatement(MyTacksConstants.UPDATE_TACK_WITHOUT_IMAGE_QUERY);
			ps.setString(1, tackMaster.getTackName());
			ps.setInt(2, boardID);
			ps.setString(3, oldTackName);
			ps.setString(3,tackMaster.getTackURL());
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				flag=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		return flag;
	}
	
	
	

	public int noOfLikesForPin()
	{
		Connection con=null;
		PreparedStatement ps=null;
		int counterForLikes=0;
		
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.COUNT_OF_LIKES_QUERY);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				counterForLikes=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			
		}

		return counterForLikes;
	}
	
	
	public int noOfFollowersForBoard()
	{
		Connection con=null;
		PreparedStatement ps=null;
		int counterFollowers=0;
		
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.NO_OF_FOLLOWERS_QUERY);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				counterFollowers=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			
		}

		return counterFollowers;
	}
	
	
	
	
	
	public boolean deleteBoard(String boardName)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		int boardID=0;
		
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_BOARDID_QUERY);
			ps.setString(1, boardName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				boardID=rs.getInt(1);
			}
			
			ps1=con.prepareStatement(MyTacksConstants.DELETE_BOARD_QUERY);
			ps1.setInt(1, boardID);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}

		return flag;
	}

	public boolean deleteTack(String tackName)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		int tackID=0;
		
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_TACKID_QUERY);
			ps.setString(1, tackName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				tackID=rs.getInt(1);
			}
			
			ps1=con.prepareStatement(MyTacksConstants.DELETE_TACK_QUERY);
			ps1.setInt(1, tackID);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}

		return flag;
	}
	
	
	public UserMaster viewDetailsForUpdate(String userId)
	{
		UserMaster viewUserDetails = new UserMaster();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		
		con = DataConnection.getConnection();
		try 
		{
			statement = con.prepareStatement(MyTacksConstants.SELECT_USER_DETAILS_QUERY);
			statement.setString(1, userId);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				viewUserDetails.setFirstName(resultSet.getString("FirstName"));
				viewUserDetails.setLastName(resultSet.getString("LastName"));
				viewUserDetails.setGender(resultSet.getString("Gender"));
				viewUserDetails.setEmailAddress(resultSet.getString("EmailAddress"));
				viewUserDetails.setPhoneNo(resultSet.getString("PhoneNo"));
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(statement);
		}
		return viewUserDetails;
	}
	
	public boolean updateProfile(UserMaster userDetails, String userId)
	{
		boolean flag= false;
		Connection con = null;
		PreparedStatement prpStmnt = null;
		PreparedStatement statement=null;
		
		con = DataConnection.getConnection();
		try 
		{
		prpStmnt = con.prepareStatement(MyTacksConstants.UPDATE_USER_DETAILS_QUERY);
		prpStmnt.setString(1, userDetails.getUserId());
		prpStmnt.setString(2, userDetails.getEmailAddress());
		prpStmnt.setString(3, userDetails.getPhoneNo());
		prpStmnt.setString(4, userId);
		
		int check = prpStmnt.executeUpdate();
		
		statement = con.prepareStatement(MyTacksConstants.UPDATE_BOARDDETAILS_ONUPDATE_PROFILE_QUERY);
		statement.setString(1, userDetails.getUserId());
		statement.setString(2, userId);
		
		int check1 = statement.executeUpdate();
		System.out.print(check+" "+check1);
		
		if(check > 0 /*&& check1 > 0 */)
		{
			flag = true;
		}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(prpStmnt);
			DataConnection.closeStatement(statement);
		}
		
		return flag;
	}
	
	public boolean changePassword(String oldPassword,String NewPassword, String userId )
	{
		boolean flag=false;
		Connection con = null;
		PreparedStatement statement=null;
		PreparedStatement preparedStatement=null;
		String checkPwd = null;
		
		con= DataConnection.getConnection();
		
		try 
		{
			statement = con.prepareStatement(MyTacksConstants.GET_USER_DETAILS_QUERY);
			statement.setString(1, userId);
			ResultSet result = statement.executeQuery();
			 
			while(result.next())
			{
				checkPwd = result.getString("Password");
			
			if(checkPwd.equals(oldPassword))
			{
				preparedStatement = con.prepareStatement(MyTacksConstants.UPDATE_PASSWORD_QUERY);
				preparedStatement.setString(1, NewPassword);
				preparedStatement.setString(2, userId);
				
				int check = preparedStatement.executeUpdate();
				
				if(check>0)
				{
					flag = true;
				}
			}
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(statement);
			DataConnection.closeStatement(preparedStatement);
		}
		return flag;
	}
	
	
	public int getResponseCode(String urlString) throws MalformedURLException, IOException
	{
		HttpURLConnection huc= null;
		try
	    {
		
		URL u = new URL(urlString); 
	    huc =  (HttpURLConnection) u.openConnection();  
	    
	    huc.setRequestMethod("GET"); 
	    huc.connect(); 
	    
	    }
		catch(Exception e3)
	    {
	    	System.out.println("General");
	    	e3.printStackTrace();
	    }
		
	    return huc.getResponseCode();
	
	}
	
	public boolean followBoard(String boardName,String userFollowerID)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		int boardID=0;
		String userOwnerID="";
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.SELECT_BOARDS_FOR_FOLLOW_QUERY);
			ps.setString(1, boardName);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				boardID=rs.getInt(1);
				userOwnerID=rs.getString(2);
			}
			
			ps1=con.prepareStatement(MyTacksConstants.ADD_FOLLOW_QUERY);
			ps1.setString(1, userFollowerID);
			ps1.setString(2,userOwnerID);
			ps1.setInt(3, boardID);
			
			ps2=con.prepareStatement(MyTacksConstants.UPDATE_BOARD_ON_FOLLOW_QUERY);
			ps2.setString(1, "FOLLOWING");
			ps2.setInt(2, boardID);
			int j=ps2.executeUpdate();

			
			int i=ps1.executeUpdate();
			if(i>0 && j>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}
		return flag;
	}
	
	public boolean likeTack(String tackName,String userLikerID)
	{
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		int tackID=0;
		String userOwnerID="";
		int boardID=0;
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.GET_TACKDETAILS_FOR_LIKE_QUERY);
			ps.setString(1, tackName);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				tackID=rs.getInt(1);
				boardID=rs.getInt(2);
			}
			
			ps2=con.prepareStatement(MyTacksConstants.GET_USER_FROM_BOARD_QUERY);
			ps2.setInt(1, boardID);
			
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				userOwnerID=rs2.getString(1);
			}
			
			ps1=con.prepareStatement(MyTacksConstants.ADD_LIKE_QUERY);
			ps1.setString(1, userLikerID);
			ps1.setString(2,userOwnerID);
			ps1.setInt(3, tackID);
			
			int i=ps1.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}
		return flag;
		
	}
	
	public String getTackURLFromTackName(String tackName)
	{
		Connection con=null;
		PreparedStatement ps=null;
		String tackURL="";
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.GET_TACKURL_QUERY);
			ps.setString(1, tackName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				tackURL=rs.getString(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
		}
		return tackURL;
	}
	
	public ArrayList<BoardMaster> listAllFollowedBoards(String userID) throws IOException
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		ArrayList<BoardMaster> listAllFollowedBoards=new ArrayList<BoardMaster>();
		String boardIDS="";
		try
		{
			con=DataConnection.getConnection();
			ps=con.prepareStatement(MyTacksConstants.GET_BOARDID_FROM_FOLLOW_QUERY);
			ps.setString(1, userID);
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
			boardIDS=boardIDS+rs.getInt(1)+",";	
			}
			String[] listBoards=boardIDS.split(",");
			
			con.setAutoCommit(false);
			for(int i=0;i<listBoards.length;i++)
			{
				
				ps1=con.prepareStatement(MyTacksConstants.GET_BOARDDETAILS_FOR_FOLLOW_QUERY);
				ps1.setInt(1, new Integer(listBoards[i]).intValue());
				ResultSet rs1=ps1.executeQuery();
				
				while(rs1.next())
				{
					ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
					BoardMaster boardMaster=new BoardMaster();
					InputStream img1 = rs1.getBinaryStream(3);
					BufferedImage bf1 = ImageIO.read(img1);
					ImageIO.write(bf1, "jpeg", bos1);
					byte[] data1 = bos1.toByteArray();
					FileDetails fd1 = new FileDetails();
					fd1.setBoardImage(data1);
					boardMaster.setBoardImage(fd1);
					boardMaster.setBoardName(rs1.getString(2));
					listAllFollowedBoards.add(boardMaster);
					
				}
			
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		finally
		{
			DataConnection.closeConnection(con);
			DataConnection.closeStatement(ps);
			DataConnection.closeStatement(ps1);
		}
		return listAllFollowedBoards;
		
	}
	
	
	
}
