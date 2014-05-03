package com.mytacks.group10.tagatTack.bean;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.validator.routines.UrlValidator;

public class URLTry
{
	public static void main(String[] args) throws MalformedURLException, IOException
	{
	try
	{
		System.out.println(getResponseCode("https://www.google.com/")); 
		System.out.println(getResponseCode("http://www.w3.org/Protocols/HTTP/HTRESP.html"));   
		System.out.println(getResponseCode("http://www.example.com")); 
		System.out.println(getResponseCode("https://support.google.com/webmasters/answer/40132?hl=en"));
	}	
	catch(Exception e3)
    {
    	System.out.println("GeneralUP");
    	e3.printStackTrace();
    }	
	}
	
		public static String URL = "http://www.nbc.com/Heroes/novels/downloads/";

		public static int getResponseCode(String urlString) throws MalformedURLException, IOException 
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
	
	
}
