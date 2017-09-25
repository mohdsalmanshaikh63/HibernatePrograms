package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";//hb_student_tracker is the name of schema
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try(Connection con = DriverManager.getConnection(url, user, pass))
		{
		System.out.println("Connecting to database: "+ url);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

