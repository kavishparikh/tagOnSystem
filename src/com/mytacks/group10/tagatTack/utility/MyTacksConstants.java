package com.mytacks.group10.tagatTack.utility;

public class MyTacksConstants 
{

	public static final String  ADD_USER_DETAILS_QUERY="insert into UserMaster values(?,?,?,?,?,?,?,?,?,?)";
	
	public static final String  ACTIVATE_USER_QUERY="update UserMaster set ActivationStatus=? where ConfirmationCode=?";
	
	public static final String CHECK_LOGIN_QUERY="select * from UserMaster where UserID=? and Password=?";
	
	public static final String UPDATE_LOGIN_TIME_QUERY="update UserMaster set LastLoginTime = ? where UserID = ? && Password = ?";
	
	public static final String FORGOT_PASSWORD_QUERY="select * from UserMaster where UserID=? and ActivationStatus=?";
	
	public static final String SELECT_CATEGORYID_QUERY="select CategoryID from CategoryMaster where CategoryName=?";
	
	public static final String ADD_BOARD_QUERY="insert into BoardMaster(BoardName,BoardImage,BoardType,CategoryID,UserID) values(?,?,?,?,?)";
	
	public static final String SELECT_BOARDID_QUERY="select BoardID from BoardMaster where BoardName=?";
	
	public static final String ADD_TACK_QUERY="insert into TackMaster(TackName,TackImage,BoardID,TackURL) values(?,?,?,?)";
	
	public static final String SELECT_ALL_TACK_QUERY="select * from TackMaster where BoardID=?";
	
	public static final String VIEW_OTHERS_BOARD_QUERY="select * from BoardMaster where CategoryID=? and UserID <> ? and FollowStatus <> ? and BoardType = ?";
	
	public static final String VIEW_ALL_BOARDS_QUERY="select * from BoardMaster where UserID=?";
	
	public static final String VIEW_ALL_CATEGORIES_QUERY="select * from CategoryMaster";
	
	public static final String SELECT_CATEGORYID_FROM_BOARD_QUERY="select CategoryID from BoardMaster where BoardName=?";
	
	public static final String SELECT_CATEGORYNAME_QUERY="select CategoryName from CategoryMaster where CategoryID=?";
	
	public static final String SELECT_BOARDID_FROM_TACK_QUERY="select BoardID from TackMaster where TackName=?";
	
	public static final String SELECT_BOARDNAME_FROM_BOARD_QUERY="select BoardName from BoardMaster where BoardID=?";
	
	public static final String UPDATE_BOARD_QUERY="update BoardMaster set BoardImage=?,BoardName=?,CategoryID=?,BoardType=? where BoardName=?";
	
	public static final String UPDATE_TACK_QUERY="update TackMaster set TackImage=?,TackName=?,BoardID=?,TackURL=? where TackName=?";
	
	public static final String UPDATE_BOARD_WITHOUT_IMAGE_QUERY="update BoardMaster set BoardName=?,CategoryID=?,BoardType=? where BoardName=?";
	
	public static final String UPDATE_TACK_WITHOUT_IMAGE_QUERY="update TackMaster set TackName=?,BoardID=? where BoardName=?";
	
	public static final String COUNT_OF_LIKES_QUERY="select count(*) from LikeMaster";
	
	public static final String NO_OF_FOLLOWERS_QUERY="select count(*) from FollowMaster";
	
	public static final String DELETE_BOARD_QUERY="delete from BoardMaster where BoardID=?";
	
	public static final String SELECT_TACKID_QUERY="select TackID from TackMaster where TackName=?";
	
	public static final String DELETE_TACK_QUERY="delete from TackMaster where TackID=?";
	
	public static final String SELECT_USER_DETAILS_QUERY="select * from UserMaster where UserID=?";
	
	public static final String UPDATE_USER_DETAILS_QUERY="update UserMaster set UserID = ?, EmailAddress = ?, PhoneNo = ? where UserID = ?";
	
	public static final String UPDATE_BOARDDETAILS_ONUPDATE_PROFILE_QUERY="update BoardMaster set UserID = ? where UserID=?";
	
	public static final String GET_USER_DETAILS_QUERY="select * from  UserMaster where UserID = ? ";
	
	public static final String UPDATE_PASSWORD_QUERY="update UserMaster set Password = ? where UserID=?";
	
	public static final String SELECT_BOARDS_FOR_FOLLOW_QUERY="select BoardID,UserID from BoardMaster where BoardName=?";
	
	public static final String ADD_FOLLOW_QUERY="insert into FollowMaster(UserFollowerID,UserID,BoardID) values(?,?,?)";
	
	public static final String UPDATE_BOARD_ON_FOLLOW_QUERY="update BoardMaster set FollowStatus = ? where BoardID=?";
	
	public static final String GET_TACKDETAILS_FOR_LIKE_QUERY="select tackID,BoardID from TackMaster where TackName=?";
	
	public static final String GET_USER_FROM_BOARD_QUERY="select UserID from BoardMaster where BoardID=?";
	
	public static final String ADD_LIKE_QUERY="insert into LikeMaster(UserLikerID,UserID,TackID) values(?,?,?)";
	
	public static final String GET_TACKURL_QUERY="select TackURL from TackMaster where TackName=?";
	
	public static final String GET_BOARDID_FROM_FOLLOW_QUERY="select BoardID from FollowMaster where UserFollowerID=?";
	
	public static final String GET_BOARDDETAILS_FOR_FOLLOW_QUERY="select * from BoardMaster where BoardID=?";
	
	public static final String GET_LASTLOGIN_QUERY="select LastLoginTime from UserMaster where UserID=?";
	
	public static final String UPDATE_LASTLOGIN_FOR_USER_QUERY="update UserMaster set LastLoginTime = ? where UserID = ? ";
	
	
}
