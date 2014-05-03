package com.mytacks.group10.tagatTack.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataConnection {
	

	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/MyTacks";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	
	public static Connection getConnection(){
		Connection con = null;
		
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch (ClassNotFoundException e) {
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return con;
		
	}
	
	
	
	public static void closeConnection(Connection con){
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void closeStatement(PreparedStatement ps){
		
		
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

	
	
	
	
	

}
