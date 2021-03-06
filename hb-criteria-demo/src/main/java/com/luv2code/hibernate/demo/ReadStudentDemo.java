 package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			
			String theDateOfBirthStr = "01/02/1994";
            LocalDate theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com",theDateOfBirth);
			
			// start the transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+ tempStudent.getId());
			
			// now get a new Session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			// retrieve student based on the id: primary key
			System.out.println("\n Getting student with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
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
