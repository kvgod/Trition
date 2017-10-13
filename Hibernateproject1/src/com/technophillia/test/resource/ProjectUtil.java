package com.technophillia.test.resource;

import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ProjectUtil 
{
	public static SessionFactory getSessionFactory()
	{
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually
			e.printStackTrace();
			if(sessionFactory!=null)
			sessionFactory.close();
		}
		return  sessionFactory;
		
	}

	public static Connection createJdbcConnection(){
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	public static Connection createAdminJdbcConnection(){
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment?autoReconnect=true&useSSL=false","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	public static String checkIfEmpty(String var){
		if(checkIfNull(var).equals("notNull"))
		{
			if(var.length()==0){
			return "empty";	
			}
			return "notEmpty";
		}
		return "error";
	}
	
	public static String checkIfNull(String var){
		if(var!=null){
			
			return "notNull";
		}
		return "null";
	}
	
	public static String generateSessionId(String memberId){
		Random random =new Random();
		String sessionId = "ct9448fa-9dab-11d1-80b4-00c04fd430c8"+"-"+Math.abs(random.nextInt())+ ":" +memberId.trim();
		System.out.println(sessionId+"      soaTransactionID");
		return sessionId;
	}
	
	public static void encryptText(String text) 
    {
        try 
        {
            String key = "Bar12349Bar12349"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b: encrypted) {
                sb.append((char)b);
            }

            // the encrypted String
            String enc = sb.toString();
            System.out.println("encrypted:" + enc);

            // now convert the string to byte array
            // for decryption
            byte[] bb = new byte[enc.length()];
            for (int i=0; i<enc.length(); i++) {
                bb[i] = (byte) enc.charAt(i);
            }

            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(bb));
            System.err.println("decrypted:" + decrypted);

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
	
}
