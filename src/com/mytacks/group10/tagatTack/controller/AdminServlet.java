package com.mytacks.group10.tagatTack.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;








import com.mytacks.group10.tagatTack.bean.BoardBean;
import com.mytacks.group10.tagatTack.bean.CategoryBean;
import com.mytacks.group10.tagatTack.manager.AdminManager;
import com.mytacks.group10.tagatTack.model.BoardMaster;
import com.mytacks.group10.tagatTack.model.CategoryMaster;
import com.mytacks.group10.tagatTack.model.FileDetails;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
    AdminManager adminManager = new AdminManager();
    
    

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	
		String action = request.getParameter("action");
		HttpSession userSession=request.getSession(false);
		System.out.println(action);

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		System.out.println("customer controller value of is multipart " +isMultipart);
		
		if(isMultipart)
		{
			System.out.println("in multipart");
			DiskFileItemFactory itemfactory = new DiskFileItemFactory();


			ServletFileUpload fileupload = new ServletFileUpload(itemfactory);

			Map<String, Object> map = new HashMap<String, Object>();
			
			try 
			{
				System.out.println("customer controllerererere try blcolsdldsflsdfl");

				List listitems =  fileupload.parseRequest(request);
				Iterator it = listitems.iterator();
					
				while(it.hasNext())
				{

					FileItem fileitem = (FileItem)it.next();


					if(fileitem.isFormField())
					{


						String name =   fileitem.getFieldName();
						String value = new String(fileitem.get());
						map.put(name, value);

					}
					else if(!fileitem.isFormField() )
					{


						BufferedImage bf = ImageIO.read(fileitem.getInputStream());
						String name = fileitem.getFieldName();
						String contenttype = fileitem.getContentType();
						System.out.println(contenttype);
						if(bf!=null && contenttype!=null && contenttype.equals("image/jpeg"))
						{


						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						ImageIO.write(bf, "jpeg", bos);
						byte[] image = bos.toByteArray();
						
						FileDetails details = new FileDetails();
						details.setContentType(contenttype);
						
						details.setCategoryImage(image);
						map.put(name, details);

						
						}

					}
			}



			CategoryBean bean = new CategoryBean();
			BoardBean bean1=new BoardBean();
			BeanUtils.populate(bean, map);
			BeanUtils.populate(bean1, map);
			
			
			if(bean.getAction().equals("addCategory"))
			{
				CategoryMaster categoryMaster=new CategoryMaster();
				categoryMaster.setCategoryName(bean.getCategoryName());
				categoryMaster.setCategoryImage(bean.getCategoryImage());
				
				boolean flag=false;
				
				flag=adminManager.addCategory(categoryMaster);
				
				if(flag==true)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/MessagePage.jsp");
					request.setAttribute("Message", "Category "+bean.getCategoryName()+" added Successfully.");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/MessagePage.jsp");
					request.setAttribute("Message", "Sorry!!! Pleas add the Category again.");
					rd.forward(request, response);				}
				
				
			}
			
			}catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(NullPointerException e)
			{
			}
	
		}	
		
		else if(action.equals("viewCategory"))
		{
			String categoryName=request.getParameter("categoryName");
			CategoryMaster categoryMaster=null;
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/viewImage.jsp");
			try {
				categoryMaster = adminManager.getCategoryDetails(categoryName);
				
				File to = new File( getServletContext().getRealPath("/images")+"/"+categoryMaster.getCategoryName()+".jpg");
				ByteArrayInputStream bis = new ByteArrayInputStream(categoryMaster.getCategoryImage().getCategoryImage());
				BufferedImage bf = ImageIO.read(bis);

				ImageIO.write(bf, "jpeg", to);

				request.setAttribute("categoryImage",categoryMaster.getCategoryName()+".jpg");
				
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			rd.forward(request, response);

		}
		
		else if(action.equals("listAllCategories"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/");
			try
			{
				request.setAttribute("RedirectFrom", "ADMINPAGE");
				ArrayList<CategoryMaster> listOfAll=new ArrayList<CategoryMaster>();
				listOfAll=adminManager.listAllCategories();
				 rd = request.getRequestDispatcher("/jsp/ListOfCategories.jsp");
				for(int i=0;i<listOfAll.size();i++)
				{
					File to = new File( getServletContext().getRealPath("/images")+"/"+listOfAll.get(i).getCategoryName()+".jpg");
					ByteArrayInputStream bis = new ByteArrayInputStream(listOfAll.get(i).getCategoryImage().getCategoryImage());
					BufferedImage bf = ImageIO.read(bis);

					ImageIO.write(bf, "jpeg", to);

					request.setAttribute("categoryImage"+i,listOfAll.get(i).getCategoryName()+".jpg");
				}
				request.setAttribute("totalcount", listOfAll.size());
			}
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			rd.forward(request, response);
			
			
		}
		
		else if(action.equals("listAllBoardsByAdmin"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/");
			try
			{
				String redirectFrom=request.getParameter("redirectFrom");
				request.setAttribute("RedirectFrom", redirectFrom);
				ArrayList<BoardMaster> listOfAll=new ArrayList<BoardMaster>();
					 listOfAll=adminManager.listAllBoards();
					 rd = request.getRequestDispatcher("/jsp/ListAllBoardsByAdmin.jsp");
				for(int i=0;i<listOfAll.size();i++)
				{
					File to = new File( getServletContext().getRealPath("/images")+"/"+listOfAll.get(i).getBoardName()+".jpg");
					ByteArrayInputStream bis = new ByteArrayInputStream(listOfAll.get(i).getBoardImage().getBoardImage());
					BufferedImage bf = ImageIO.read(bis);

					ImageIO.write(bf, "jpeg", to);

					request.setAttribute("boardImage"+i,listOfAll.get(i).getBoardName()+".jpg");
				}
				request.setAttribute("totalcount", listOfAll.size());
			}
			
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		
			
			rd.forward(request, response);
		}
		else if(action.equals("deleteBoardsByAdmin"))
		{
			String boardName=request.getParameter("boardName");
			boolean flag=false;
			flag=adminManager.deleteBoard(boardName);
			if(flag==true)
			{
			RequestDispatcher rd=request.getRequestDispatcher("/");
			try
			{
				String redirectFrom=request.getParameter("redirectFrom");
				request.setAttribute("RedirectFrom", redirectFrom);
				ArrayList<BoardMaster> listOfAll=new ArrayList<BoardMaster>();
				
				listOfAll=adminManager.listAllBoards();
				 rd = request.getRequestDispatcher("/jsp/ListAllBoardsByAdmin.jsp");
				for(int i=0;i<listOfAll.size();i++)
				{
					File to = new File( getServletContext().getRealPath("/images")+"/"+listOfAll.get(i).getBoardName()+".jpg");
					ByteArrayInputStream bis = new ByteArrayInputStream(listOfAll.get(i).getBoardImage().getBoardImage());
					BufferedImage bf = ImageIO.read(bis);

					ImageIO.write(bf, "jpeg", to);

					request.setAttribute("boardImage"+i,listOfAll.get(i).getBoardName()+".jpg");
				}
				request.setAttribute("totalcount", listOfAll.size());
			}
			
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		
			
			rd.forward(request, response);
			}
			else
				
			{
				System.out.println("Something went wrong.");
			}
			

		}
				
	}

}
