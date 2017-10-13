package com.thbs.HibernateBike;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controller extends HttpServlet {
	/*private static final long serialVersionUID = 1L;
	private static Bikes oldBean =null;
    
	protected void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("in process of process");
		String uri=request.getRequestURI();
		System.out.println("uri ="+uri);
	
		
		
		if(uri.equals("/HibernateBike/"))
		{
			System.out.println("inside /");
	
			List<Bikes> result = Model.getBikeslist();
			ArrayList<String> nameList = new ArrayList<String>();
			for(Bikes b : result)
			{
				nameList.add(b.getName());
			}
			request.setAttribute("list", nameList);
			RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
			rd.forward(request,response);
			return;
		}
		
		
		
		if(uri.contains("/loginAdmin"))
		{
			System.out.println("In /loginAdmin of process");
			String result = Model.login(request.getParameter("email") , request.getParameter("pass"));
			if(result.equals(Constants.SUCCESS))
			{
				request.getSession(true);
				RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin.jsp");
				rd.forward(request,response);
			}
			else {
				PrintWriter pw = response.getWriter();
				System.out.println(result+"........................");
				pw.write(result);
			}
			return;
		}
		
		
		
		
		
		if(uri.contains("/compareBikes")){
			System.out.println("inside /compareBikes");
			
			if(request.getSession(false)==null){
				response.getWriter().write("<html><h1 align=\"center\">You are not Login </h1></html>");
				return;
			}
			String bike1 =  request.getParameter("bike_one");
			String bike2 =  request.getParameter("bike_two");
			String compare =  request.getParameter("compareType");
			
			System.out.println("to compare, bike1: "+bike1+" bike2: "+bike2);
			
			List<String> bikeNames = new ArrayList<String>(2);
			bikeNames.add(bike1);
			bikeNames.add(bike2);
			
			List<Bikes> bikeList = Model.getBikes(bikeNames);
			
			HttpSession httpSession = request.getSession(false);
			httpSession.setAttribute("compBikes", bikeList);
			httpSession.setAttribute("bike_one", bike1);
			httpSession.setAttribute("bike_two", bike2);
			
			if(compare!=null){
				String result ="";
				if(compare.equals("Engine")){
					
					String e1 = bikeList.get(0).engine;
					String e2 = bikeList.get(1).engine;
					if (Long.parseLong(e1.substring(0, e1.length()-2))==Long.parseLong(e2.substring(0, e2.length()-2))) {
						result = " Both has same engine power " +Long.parseLong(e2.substring(0, e1.length()-2));	
					} else if(Long.parseLong(e1.substring(0, e1.length()-2))>Long.parseLong(e2.substring(0, e2.length()-2))){
						result = bikeList.get(0).name +" has more engine power " ;	
					}else {
						result = bikeList.get(1).name +" has more engine power " ;	
					}
				}else if (compare.equals("Mileage")) {
					
					String m1 = bikeList.get(0).mileage;
					String m2 = bikeList.get(1).mileage;
					if (Long.parseLong(m1)==Long.parseLong(m2)) {
						result = " Both has same engine power ";	
					} else if(Long.parseLong(m1)>Long.parseLong(m2)){
						result = bikeList.get(0).name +" has more mileage ";	
					}else {
						result = bikeList.get(1).name +" has more mileage ";	
					}
				}else if (compare.equals("Price")) {
					String p1 = bikeList.get(0).price;
					String p2 = bikeList.get(1).price;
					if (Long.parseLong(p1)==Long.parseLong(p2)) {
						result = " Both has same price ";	
					} else if(Long.parseLong(p1)<Long.parseLong(p2)){
						result = bikeList.get(0).name +" has less price";	
					}else {
						result = bikeList.get(1).name +" has less price";	
					}
				}
					
				request.setAttribute("result",result );
			}
			RequestDispatcher rd = request.getRequestDispatcher("BikesCompareView.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		
		if(uri.contains("/openLoginView"))
		{
			System.out.println("inside /openLoginView");
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request,response);
			return;
		}
		if(uri.contains("/openBikesView"))
		{
			if(request.getSession(false)==null)
			{
				response.getWriter().write("<html><h1 align=\"center\">You are not Login </h1></html>");
				return;
			}
			List<Bikes> result = Model.getBikeslist();
			if(result!=null)
			{
				request.getSession(false).setAttribute("bikeList", result);
				RequestDispatcher rd=request.getRequestDispatcher("BikesListView.jsp");
				rd.forward(request,response);
			}
			else {
				PrintWriter printWriter = response.getWriter();
				System.out.println(result+"........................");
				printWriter.write("data empty");
			}
			return;
		}
		
		
		
		
		
		
		if(uri.contains("editBike"))
		{
			System.out.println("request for /OpenEditContact.do");
			if(request.getSession(false)==null){
				response.getWriter().write("<html><h1 align=\"center\">You are not Login </h1></html>");
				return;
			}
			oldBean=new Bikes();
			oldBean.setBike_id(Integer.parseInt(request.getParameter("id")));
			oldBean.setName(request.getParameter("name"));
			oldBean.setEngine(request.getParameter("engine"));
			oldBean.setPrice(request.getParameter("price"));
			oldBean.setMileage(request.getParameter("mileage"));
			
			System.out.println("OldBean = "+oldBean);
			
			RequestDispatcher rd =request.getRequestDispatcher("EditBike.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		
		
		if(uri.contains("/updateBike"))
		{
			System.out.println("inside /updateBike");
			if(request.getSession(false)==null){
				response.getWriter().write("<html><h1 align=\"center\">You are not Login </h1></html>");
				return;
			}
			Bikes b = new Bikes();
			b.setBike_id(Integer.parseInt(request.getParameter("id")));
			b.setName(request.getParameter("name"));
			b.setEngine(request.getParameter("engine"));
			b.setPrice(request.getParameter("price"));
			b.setMileage(request.getParameter("mileage"));
			Model.updateBike(b);
			request.getSession(false).setAttribute("bikeList", Model.getBikeslist());
			RequestDispatcher rd =request.getRequestDispatcher("BikesListView.jsp");
			rd.forward(request, response);
			return;
		}
	
		
		
		
		
		if(uri.contains("/deleteBike"))
		{
			System.out.println("inside /deleteBike");
			if(request.getSession(false)==null){
				response.getWriter().write("<html><h1 align=\"center\">You are not Login </h1></html>");
				return;
			}
			Bikes b = new Bikes();
			b.setBike_id(Integer.parseInt(request.getParameter("id")));
			b.setName(request.getParameter("name"));
			b.setEngine(request.getParameter("engine"));
			b.setPrice(request.getParameter("price"));
			b.setMileage(request.getParameter("mileage"));
			System.out.println("deleting bike: "+Model.deleteBike(b));
			request.getSession(false).setAttribute("bikeList", Model.getBikeslist());
			RequestDispatcher rd =request.getRequestDispatcher("BikesListView.jsp");
			rd.forward(request, response);
			return;
		}
		
	
		
		
		
		if(uri.contains("/openAddBikeView"))
		{
			System.out.println("inside /openAddBikeView");
			if(request.getSession(false)==null){
				response.getWriter().write("<html><h1 align=\"center\">You are not Login </h1></html>");
				RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
				rd.forward(request, response);
			}
			RequestDispatcher rd=request.getRequestDispatcher("AddBike.jsp");
			rd.forward(request, response);
		}
	
		
		
		
		/*if(uri.contains("/addBike"))
		{
			if(request.getSession(false)==null){
				response.getWriter().write("<h1>You are not Login </h1>");
				return;
			}
			Bikes b=new Bikes();
			System.out.println("``````````````````````````````````````````");
			String imgPath=request.getParameter("Bike");
			System.out.println(imgPath);
			//File file = new File("C://Users//narendra_kumar//Desktop//Bikes//splender.JPG");
			//File file = new File("C:\Users\narendra_kumar\workspace\HibernateBike1\WebContent\WEB-INF\pics"+imgPath);
			System.out.println("``````````````````````````````````````````");

			System.out.println(file);
	        byte[] bFile = new byte[(int) file.length()];
	        
	        try {
	            FileInputStream fileInputStream = new FileInputStream(file);
	            fileInputStream.read(bFile);
	            fileInputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
			b.setName(request.getParameter("name"));
			b.setEngine(request.getParameter("engine"));
			b.setMileage(request.getParameter("mileage"));
			b.setPrice(request.getParameter("price"));
			b.setImage(bFile);
			System.out.println("ADD this bike" +b);
			String msg=Model.addBike(b);
			if(msg.equals(Constants.SUCCESS))
			{
				request.setAttribute("addSuccess", "bike added");
				RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin.jsp");
				rd.forward(request, response);
			}
		}
	*/
		
		/*
		
		
		if(uri.contains("/logout"))
		{
			if(request.getSession(false)==null){
				RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.getSession(false).invalidate();
				RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
				rd.forward(request, response);
			}
		}
	}
	
	
	
	public Controller() {
        super();
       System.out.println("In no arg of Contoller");
       
    }

	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doget() of controller");
		process(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost() of controller");
		process(request,response);
	}
*/
}
