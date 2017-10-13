package com.technophillia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import com.technophillia.test.resource.ProjectUtil;
import com.technophillia.test.vo.AdminBean;
import com.technophillia.test.vo.MemberBean;

public class ModelDao {

	public static String addNewMemberToGroup(String memberId,String memberName, String memberContactNumber,String memberEmailId,String memberAddress,String memberDOB){
		
		System.out.println("<-----ModelDao addNewMemberToGroup()---->");
		
		System.out.println("Input Params: \n"+"memberId :"+memberId+"\n memberName: "+memberName);
		System.out.println("Input Params: \n"+"memberContactNumber :"+memberContactNumber+"\n memberEmailId: "+memberEmailId);
		System.out.println("Input Params: \n"+"memberAddress :"+memberAddress+"\n memberDOB: "+memberDOB);
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try 
		{
			sessionFactory = ProjectUtil.getSessionFactory();

			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else 
			{
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				System.out.println("session established");
				MemberBean bean = new MemberBean();
				bean.setMemberId(memberId);
				bean.setMemberName(memberName);
				bean.setMemberAddress(memberAddress);
				bean.setMemberContactNumber(memberContactNumber);
				bean.setMemberDOB(memberDOB);
				bean.setMemberEmailId(memberEmailId);
				
				
				System.out.println("loaded values to bean "+bean);
				
				session.persist(bean);
				tx.commit();
				
				return "success";
				
			}
		}
		catch(TransactionException e){
			System.out.println(">>>>>>>>>>>>>addAdminUser exception occured"+e.getMessage());
			return "error:"+e.getMessage();
		}
		catch(RuntimeException e){
			System.out.println(">>>>>>>>>>>>>addAdminUser exception occured"+e.getMessage());
			return "error:"+e.getMessage();
		}
		finally{
			
			if(session!=null)
				session.close();			
		}
	}

	/*public static void checkAdminUser(String userName, String password) 
	{
		PreparedStatement pst =null;
		
		Connection con;
		try 
		{
			con = ProjectUtil.createAdminJdbcConnection();
		    pst=(PreparedStatement) con.prepareStatement("");
		
		    pst.executeUpdate();
		    
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		//String query1="INSERT INTO `project1`.`member_session` (`member_id`, `member_session_id`) VALUES ('"+memberId+"', 'ct9448fa-9dab-11d1-80b4-00c04fd430c8-619526187:3792');";
		
		
	}*/
	
	public static String addAdminUser(String userName, String password){
		
		System.out.println("<-----ModelDao addAdminUser()---->");
		System.out.println("Input Params: \n"+"username :"+userName+"\n password: "+password);
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try 
		{
			sessionFactory = ProjectUtil.getSessionFactory();

			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else 
			{
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				System.out.println("session established");
				AdminBean bean = new AdminBean();
				bean.setUserName(userName);
				bean.setPassword(password);
				
				System.out.println("loaded values to bean "+bean);
				
				session.persist(bean);
				tx.commit();
				
				return "success";
				
			}
		}
		catch(TransactionException e){
			System.out.println(">>>>>>>>>>>>>addAdminUser exception occured"+e.getMessage());
			return "error:"+e.getMessage();
		}
		catch(RuntimeException e){
			System.out.println(">>>>>>>>>>>>>addAdminUser exception occured"+e.getMessage());
			return "error:"+e.getMessage();
		}
		finally{
			
			if(session!=null)
				session.close();			
		}
		
	}
	
	public static String checkAdminUser(String username,String password){
		
		System.out.println("Entering checkAdminUser:\n"+"username: "+username+" \n password: "+password);
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try 
		{
			sessionFactory = ProjectUtil.getSessionFactory();

			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else {
				session = sessionFactory.openSession();
				System.out.println("session established");
				tx=session.beginTransaction();
				
				Query query = session.createQuery("select bean from AdminBean as bean where username=:value1").setParameter("value1", username);
				List<AdminBean> result=query.list();
				System.out.println("u:"+username+" P:"+password);
				System.out.println("<------------------->"+result);
				if(result.size()!=0)
				{
					if(result.get(0).getPassword().equals(password)&& result.get(0).getUserName().equals(username))
					{
						System.out.println(result.get(0));
						return "success: User validated Successfully";
					}
					return "error: Some error has occured";
				}
				else{
					return "error: user was not found";
				}
			
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Oops something bad happened msg = " + e.getMessage());
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	
	
	}
	
	
}
