package com.mytacks.group10.tagatTack.controller;

import java.io.BufferedReader;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FbServlet
 */
public class FbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		String code = request.getParameter("code");
        if (code == null || code.equals("")) {
            // an error occurred, handle this
        }

        String token = null;
        try {
            String g = "https://graph.facebook.com/oauth/access_token?client_id=241581129322350&redirect_uri=" + URLEncoder.encode("http://localhost:98/MyTacks/jsp/CategoryUser.jsp", "UTF-8") + "&client_secret=fd41f90d0401a8262ba5ee78a5d12865&code=" + code;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuffer b = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine + "\n");            
            in.close();
            token = b.toString();
            if (token.startsWith("{"))
                throw new Exception("error on requesting token: " + token + " with code: " + code);
        } catch (Exception e) {
                // an error occurred, handle this
        }

        String graph = null;
        try {
            String g = "https://graph.facebook.com/me?" + token;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuffer b = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine + "\n");            
            in.close();
            graph = b.toString();
        } catch (Exception e) {
                // an error occurred, handle this
        }

        String facebookId;
        String firstName;
        String middleNames;
        String lastName;
        String email;
        int id;
        String locale;
        int agerange;
        
        try {
            JSONObject json = new JSONObject(graph);
            facebookId = json.getString("id");
            
            firstName = json.getString("first_name");
            if (json.has("middle_name"))
               middleNames = json.getString("middle_name");
            else
                middleNames = null;
            if (middleNames != null && middleNames.equals(""))
                middleNames = null;
            lastName = json.getString("last_name");
            
            email = json.getString("email");
            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(email);

            id=json.getInt("id");
            System.out.println(id);
            locale=json.getString("locale");
            System.out.println(locale);
            
            
            
        } catch (JSONException e) {
            // an error occurred, handle this
        }

		
		
		
		
	
	
	
	
	
	}

}
