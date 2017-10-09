package online.technophillia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import online.technophillia.test.resource.ProjectUtil;

public class ModelDao {

	public static String addNewMemberToDB(String memId,String memName, String memContact,String memEmail,String memAddress,String dob){
		String result="";
		PreparedStatement pst =null;
		
		Connection con;
		try 
		{
			con = ProjectUtil.createJdbcConnection();
			String query1="INSERT INTO `project1`.`member_session` (`member_id`, `member_name`, `contact_number`, `email`, `address`, `dob`) VALUES ('"+memId+"', '"+memName+"', '"+memContact+"', '"+memEmail+"', '"+memAddress+"', '"+dob+"')";
		    pst=(PreparedStatement) con.prepareStatement(query1);
		
		    pst.executeUpdate();
		    result=result+"success";
		} 
		catch (SQLException e) 
		{
			result=result+"failed";
			e.printStackTrace();
		}
		
		return result;
	}

	public static void checkAdminUser(String userName, String password) 
	{
		PreparedStatement pst =null;
		
		Connection con;
		try 
		{
			con = ProjectUtil.createJdbcConnection();
		    pst=(PreparedStatement) con.prepareStatement(query1);
		
		    pst.executeUpdate();
		    
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		//String query1="INSERT INTO `project1`.`member_session` (`member_id`, `member_session_id`) VALUES ('"+memberId+"', 'ct9448fa-9dab-11d1-80b4-00c04fd430c8-619526187:3792');";
		
		
	}
	
	public static void addAdminUserToDB(){
		PreparedStatement pst =null;
		
		Connection con;
		try 
		{
			con = ProjectUtil.createJdbcConnection();
			String query="";
		    pst=(PreparedStatement) con.prepareStatement(query);
		
		    pst.executeUpdate();
		    
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
	}
	
	
}
