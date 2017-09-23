 package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try
		{		
			
			// create a student object
			System.out.println("Creating new Student object...");
			
            String theDateOfBirthStr = "31/12/1998";
            LocalDate theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student tempStudent = new Student("Daimon", "Goro", "Daimon@luv2code.com", theDateOfBirth);
			
			// start the transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			factory.close();
		}

	}

}
