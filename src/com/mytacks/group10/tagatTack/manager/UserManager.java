package com.mytacks.group10.tagatTack.manager;

import com.mytacks.group10.tagatTack.dao.UserDAO;
import com.mytacks.group10.tagatTack.model.BoardMaster;
import com.mytacks.group10.tagatTack.model.CategoryMaster;
import com.mytacks.group10.tagatTack.model.TackMaster;
import com.mytacks.group10.tagatTack.model.UserMaster;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//Extra Package
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.AddressException;

public class UserManager 
{
	UserDAO userDAO=new UserDAO();
	
	
	public boolean signUpUser(UserMaster userInfo) throws UnsupportedEncodingException
	{
		
	boolean flag=false;
	String uname=userInfo.getUserId();
	/*
	final String username="tag.tacks@gmail.com";
	final String password="tag@tacks@gmail.com";
	
	Properties props = new Properties();
	
	props.setProperty("mail.smtp.host", "smtp.gmail.com");

	props.setProperty("mail.smtp.port", "587");

	props.setProperty("mail.smtp.auth", "true");

	props.setProperty("mail.smtp.starttls.enable", "true");

	Session session = Session.getInstance(props,new javax.mail.Authenticator()
	{
		protected PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(username, password);
		}
	});
			
	try {
		
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("tag.tacks@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse(userInfo.getEmailAddress()));
		message.setSubject("Testing Subject");
		Long second=System.currentTimeMillis();
		Long third=System.currentTimeMillis()-18;
		String con1=uname.substring(0, 2)+uname.substring(uname.length()-2, uname.length());
		String unicodegen=second.toString()+con1+third;
		String body="<a href=\"http://localhost:98/MyTacks/UserServlet?action=activateUser&num="+unicodegen+"\">Click here to register</a>";
		message.setText(body, "UTF-8", "html");
		
		Transport.send(message);
		
		userInfo.setConfirmationCode(unicodegen);
		userInfo.setActivationStatus("INACTIVE");
		*/
		flag=userDAO.signUpUser(userInfo);
			
	/*	
	} 
	catch (MessagingException e) 
	{
		throw new RuntimeException(e);
	}	*/
	return flag;
	
	}
	
	public boolean activateUser(String confirmationCode)
	{
		
		boolean flag=false;
		flag= userDAO.activateUser(confirmationCode);
		
		return flag;
		
	}
	
	public String checkUserLoginDetails(UserMaster userLoginDetails)
	{
		String lastLogin="";
		lastLogin=userDAO.checkUserLoginDetails(userLoginDetails);
		
		return lastLogin;
		
	}
	
	public String updateLastLoginTimeForFacebookUser(String userID)
	{
		String lastLogin="";
		lastLogin=userDAO.updateLastLoginTimeForFacebookUser(userID);
		return lastLogin;
	}
	
	public boolean sendldOldPassword(String userID)
	{
		boolean flag=false;
		
		UserMaster userDetails=new UserMaster();
		userDetails=userDAO.sendOldPassword(userID);
		
		//userpwd=edao.getForgotPassword(uemail);
		if(userDetails.getUserPassword().length()>1)
		{
			flag=true;
		}
		
		//Email Send Code Starts///////////////////////////////////////////////////
	
	final String username="tagon203project@gmail.com";
	final String password="Tagon203";
	Properties props = new Properties();
	props.setProperty("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.user", username);
    props.put("mail.smtp.password", password);
	props.setProperty("mail.smtp.port", "587");
	props.put("mail.smtp.debug", "true");
	props.setProperty("mail.smtp.auth", "true");

	props.setProperty("mail.smtp.starttls.enable", "true");
	
	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("tagon203project@gmail.com", "");
				}
			  });
			
	try {
		
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userDetails.getUserId()));
		message.setSubject("Forgotten Password");
		String body=userDetails.getUserPassword();
		message.setText(body, "UTF-8", "html");
		
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com",username,password);
		Transport.send(message, username, password);
		transport.close();
	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
	//Email Code Ends/////////////////////////////////////////////////////////
		
		return flag;
	
	}
	
	public boolean addBoard(BoardMaster boardMaster,String categoryName,String userID)
	{
		boolean flag=false;
		
		flag=userDAO.addBoard(boardMaster, categoryName, userID);
		
		return flag;
	
	}
	
	public boolean addTack(TackMaster tackMaster,String boardName)
	{
		boolean flag=false;
		
		flag=userDAO.addTack(tackMaster, boardName);
		
		return flag;
	}
	
	public ArrayList<BoardMaster> listAllBoards(String userID) throws IOException
	{
		ArrayList<BoardMaster> listOfBoards=null;
		
		listOfBoards=userDAO.listAllBoards(userID);
		
		return listOfBoards;
	}
	public ArrayList<CategoryMaster> listAllCategories() throws IOException
	{
		ArrayList<CategoryMaster> listAll=userDAO.listAllCategories();
		
		return listAll;
		
	}

	public String getCategoryName(String boardName)
	{
		String categoryName="";
		categoryName=userDAO.getCategoryName(boardName);
		return categoryName;
	}
	public String getBoardName(String tackName)
	{
		String boardName="";
		boardName=userDAO.getBoardName(tackName);
		return boardName;
	}
	public boolean updateBoardDetails(BoardMaster boardMaster,String categoryName,String oldBoardName)
	{
		boolean flag=false;
		flag=userDAO.updateBoardDetails(boardMaster,categoryName,oldBoardName);
		return flag;
	}
	public boolean updateTackDetails(TackMaster tackMaster,String boardName,String oldTackName)
	{
		boolean flag=false;
		flag=userDAO.updateTackDetails(tackMaster, boardName, oldTackName);
		return flag;
	}
	public boolean updateBoardDetailsWithoutImage(BoardMaster boardMaster,String categoryName,String oldBoardName)
	{
		boolean flag=false;
		flag=userDAO.updateBoardDetailsWithoutImage(boardMaster,categoryName,oldBoardName);
		return flag;
	}
	public boolean updateTackDetailsWithoutImage(TackMaster tackMaster,String boardName,String oldTackName)
	{
		boolean flag=false;
		flag=userDAO.updateTackDetailsWithoutImage(tackMaster, boardName, oldTackName);
		return flag;
	}

	public ArrayList<TackMaster> listAllTacks(String boardName) throws IOException
	{
		ArrayList<TackMaster> listOfTacks=new ArrayList<TackMaster>();
		listOfTacks=userDAO.listAllTacks(boardName);
		return listOfTacks;
	}
	public boolean deleteBoard(String boardName)
	{
		boolean flag=false;
		flag=userDAO.deleteBoard(boardName);
		return flag;
	}
	public boolean deleteTack(String tackName)
	{
		boolean flag=false;
		flag=userDAO.deleteTack(tackName);
		return flag;
	}
	
	
	public UserMaster viewDetailsForUpdate(String userId)
	{
		UserMaster viewUserDetails = new UserMaster();
		viewUserDetails = userDAO.viewDetailsForUpdate(userId);
		return viewUserDetails;
	}
	
	public boolean updateProfile(UserMaster userDetails, String userId)
	{
		boolean flag =  false;
		flag = userDAO.updateProfile(userDetails, userId);
		return flag;
	}
	public boolean changePassword(String oldPassword,String NewPassword, String userId )
	{
		boolean flag = false;
		flag = userDAO.changePassword(oldPassword, NewPassword, userId);
		return flag;
	}
	
	public ArrayList<BoardMaster> listAllBoardsByCategory(String categoryName,String userID) throws IOException
	{
		ArrayList<BoardMaster> listOfBoards=new ArrayList<BoardMaster>();
		 listOfBoards=userDAO.listAllBoardsByCategory(categoryName, userID);
		 return listOfBoards;
		
	}
	public int getResponseCode(String urlString) throws MalformedURLException, IOException
	{
		int responseCode=0;
		responseCode=userDAO.getResponseCode(urlString);
		return responseCode;
	}
	public boolean followBoard(String boardName,String userFollowerID)
	{
		boolean flag=false;
		flag=userDAO.followBoard(boardName, userFollowerID);
		return flag;
	}
	public boolean likeTack(String tackName,String userLikerID)
	{
		boolean flag=false;
		flag=userDAO.likeTack(tackName, userLikerID);
		return flag;
	}
	public String getTackURLFromTackName(String tackName)
	{
		String tackURL="";
		tackURL=userDAO.getTackURLFromTackName(tackName);
		return tackURL;
	}
	public ArrayList<BoardMaster> listAllFollowedBoards(String userID) throws IOException
	{
		ArrayList<BoardMaster> listAllFollowedBoards=userDAO.listAllFollowedBoards(userID);
		return listAllFollowedBoards;
	}
	
}

