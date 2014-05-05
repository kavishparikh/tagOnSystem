package com.mytacks.group10.tagatTack.utility;

public class MyTacksConstants 
{

	public static final String  ADD_USER_DETAILS_QUERY="insert into usermaster values(?,?,?,?,?,?,?,?)";
	
	public static final String  ACTIVATE_USER_QUERY="update usermaster set ActivationStatus=? where ConfirmationCode=?";
	
	public static final String CHECK_LOGIN_QUERY="select * from usermaster where UserID=? and Password=?";
	
	public static final String UPDATE_LOGIN_TIME_QUERY="update usermaster set LastLoginTime = ? where UserID = ? && Password = ?";
	
	public static final String FORGOT_PASSWORD_QUERY="select * from usermaster where UserID=?";    //and ActivationStatus=?
	
	public static final String SELECT_CATEGORYID_QUERY="select CategoryID from categorymaster where CategoryName=?";
	
	public static final String ADD_BOARD_QUERY="insert into boardmaster(BoardName,BoardImage,BoardType,CategoryID,UserID) values(?,?,?,?,?)";
	
	public static final String SELECT_BOARDID_QUERY="select BoardID from boardmaster where BoardName=?";
	
	public static final String ADD_TACK_QUERY="insert into tackmaster(TackName,TackImage,BoardID,TackURL) values(?,?,?,?)";
	
	public static final String SELECT_ALL_TACK_QUERY="select * from tackmaster where BoardID=?";
	
	public static final String VIEW_OTHERS_BOARD_QUERY="select * from boardmaster where CategoryID=? and UserID <> ? and FollowStatus <> ? and BoardType = ?";
	
	public static final String VIEW_ALL_BOARDS_QUERY="select * from boardmaster where UserID=?";
	
	public static final String VIEW_ALL_CATEGORIES_QUERY="select * from categorymaster";
	
	public static final String SELECT_CATEGORYID_FROM_BOARD_QUERY="select CategoryID from boardmaster where BoardName=?";
	
	public static final String SELECT_CATEGORYNAME_QUERY="select CategoryName from categorymaster where CategoryID=?";
	
	public static final String SELECT_BOARDID_FROM_TACK_QUERY="select BoardID from tackmaster where TackName=?";
	
	public static final String SELECT_BOARDNAME_FROM_BOARD_QUERY="select BoardName from boardmaster where BoardID=?";
	
	public static final String UPDATE_BOARD_QUERY="update boardmaster set BoardImage=?,BoardName=?,CategoryID=?,BoardType=? where BoardName=?";
	
	public static final String UPDATE_TACK_QUERY="update tackmaster set TackImage=?,TackName=?,BoardID=?,TackURL=? where TackName=?";
	
	public static final String UPDATE_BOARD_WITHOUT_IMAGE_QUERY="update boardmaster set BoardName=?,CategoryID=?,BoardType=? where BoardName=?";
	
	public static final String UPDATE_TACK_WITHOUT_IMAGE_QUERY="update tackmaster set TackName=?,BoardID=? where BoardName=?";
	
	public static final String COUNT_OF_LIKES_QUERY="select count(*) from likemaster";
	
	public static final String NO_OF_FOLLOWERS_QUERY="select count(*) from followmaster";
	
	public static final String DELETE_BOARD_QUERY="delete from boardmaster where BoardID=?";
	
	public static final String SELECT_TACKID_QUERY="select TackID from tackmaster where TackName=?";
	
	public static final String DELETE_TACK_QUERY="delete from tackmaster where TackID=?";
	
	public static final String SELECT_USER_DETAILS_QUERY="select * from usermaster where UserID=?";
	
	public static final String UPDATE_USER_DETAILS_QUERY="update usermaster set UserID = ?, EmailAddress = ?, PhoneNo = ? where UserID = ?";
	
	public static final String UPDATE_BOARDDETAILS_ONUPDATE_PROFILE_QUERY="update boardmaster set UserID = ? where UserID=?";
	
	public static final String GET_USER_DETAILS_QUERY="select * from  usermaster where UserID = ? ";
	
	public static final String UPDATE_PASSWORD_QUERY="update usermaster set Password = ? where UserID=?";
	
	public static final String SELECT_BOARDS_FOR_FOLLOW_QUERY="select BoardID,UserID from boardmaster where BoardName=?";
	
	public static final String ADD_FOLLOW_QUERY="insert into followmaster(UserFollowerID,UserID,BoardID) values(?,?,?)";
	
	public static final String UPDATE_BOARD_ON_FOLLOW_QUERY="update boardmaster set FollowStatus = ? where BoardID=?";
	
	public static final String GET_TACKDETAILS_FOR_LIKE_QUERY="select tackID,BoardID from tackmaster where TackName=?";
	
	public static final String GET_USER_FROM_BOARD_QUERY="select UserID from boardmaster where BoardID=?";
	
	public static final String ADD_LIKE_QUERY="insert into likemaster(UserLikerID,UserID,TackID) values(?,?,?)";
	
	public static final String GET_TACKURL_QUERY="select TackURL from tackmaster where TackName=?";
	
	public static final String GET_BOARDID_FROM_FOLLOW_QUERY="select BoardID from followmaster where UserFollowerID=?";
	
	public static final String GET_BOARDDETAILS_FOR_FOLLOW_QUERY="select * from boardmaster where BoardID=?";
	
	public static final String GET_LASTLOGIN_QUERY="select LastLoginTime from usermaster where UserID=?";
	
	public static final String UPDATE_LASTLOGIN_FOR_USER_QUERY="update usermaster set LastLoginTime = ? where UserID = ? ";
	
	
}
