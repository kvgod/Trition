package online.technophillia.test.resource;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.technophillia.model.ModelDao;
import online.technophillia.test.vo.MemberBean;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getRequestURI().contains("checkAdmin")){
			
			ModelDao.checkAdminUser(request.getParameter("userName"),request.getParameter("password"));
			
		}
		
		if(request.getRequestURI().contains("/addNewMember"))
		{
			String membName=request.getParameter("firstName").trim()+" "+request.getParameter("middleName").trim()+" "+request.getParameter("lastName").trim();
			System.out.println("membName"+membName);
			System.out.println(request.getParameter("address"));
			System.out.println(request.getParameter("contactNumber"));
			System.out.println(request.getParameter("emailAddress"));
			System.out.println(request.getParameter("memberId"));
			System.out.println(request.getParameter("date"));
			System.out.println("addMembersToDb() starts");
			/*if(ModelDao.addNewMemberToDB(request.getParameter("memberId"), membName, request.getParameter("contactNumber"), request.getParameter("emailAddress"), request.getParameter("address"),request.getParameter("dateOfBirth")).equals("success")){
				request.setAttribute("Upload_Success", "Data Uploaded to Database Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
				rd.forward(request, response);
				
			}
			else{
				System.out.println("else part");
				request.setAttribute("Upload_Fail", "Some Error has occured");
				RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
				rd.forward(request, response);
			}*/
		}
		
		
	}

}
