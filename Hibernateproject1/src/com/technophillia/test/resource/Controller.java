package com.technophillia.test.resource;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.technophillia.model.ModelDao;
import com.technophillia.test.vo.MemberBean;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().contains("logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			
			System.out.println("Inside logout block------>");
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getRequestURI().contains("addAdminUser"))
		{
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			String result = ModelDao.addAdminUser(userName, password);
				
				if(result.equals("success")){
					request.setAttribute("Admin_Added_Success", "User Added Successfully");
					RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
					rd.forward(request, response);			
				}
				else{
					request.setAttribute("error", result);
					RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
					rd.forward(request, response);			
				}
			
		}
		
		if(request.getRequestURI().contains("checkAdmin")){
			System.out.println("requestURI ==>"+request.getRequestURI());
			String result = ModelDao.checkAdminUser(request.getParameter("username"),request.getParameter("password"));
			System.out.println("Lets check the value of result"+result);
			if(result.contains("success")){
				System.out.println("result is equal to success");
				HttpSession session = request.getSession(true);
				session.setAttribute("session", "valid_user");
				request.setAttribute("success", result);
				RequestDispatcher rd=request.getRequestDispatcher("Dashboard.jsp");
				rd.forward(request, response);
				
			}else if (result.contains("error")) {
				request.setAttribute("error", result);
				RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
				rd.forward(request, response);
			}
			else{			
				request.setAttribute("error", result);
				RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
				rd.forward(request, response);
			}
		
		}
		
		if(request.getRequestURI().contains("addNewMember")){
			System.out.println("requestURI ==>"+request.getRequestURI());
			
			String memberId = request.getParameter("");
			String memberName = request.getParameter("");
			String memberContact = request.getParameter("");
			String memberEmail = request.getParameter("");
			String memberAddress = request.getParameter("");
			String memberDob = request.getParameter("");
			
			
			String result = ModelDao.addNewMemberToGroup(memberId, memberName, memberContact, memberEmail, memberAddress, memberDob);
			
			
		}
		
		
		
	}

}
