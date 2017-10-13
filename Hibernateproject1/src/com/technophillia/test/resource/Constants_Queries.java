package com.technophillia.test.resource;

public class Constants_Queries 
{

	public static String insertNewAdminUserToDb="INSERT INTO `project1`.`admin_users` (`sl_no`, `username`, `password`) VALUES ('1', 'root', 'toor')";
	
	public static String checkIfAdminExists="";
	
	//==================================================================================
	public static String addNewAdminHQL="insert into admin(username, password)" +
			" select bean.username, bean.password from AdminBean bean";
	
	
}
