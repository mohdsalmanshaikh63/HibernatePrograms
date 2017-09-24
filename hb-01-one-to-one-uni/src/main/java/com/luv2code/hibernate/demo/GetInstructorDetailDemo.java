package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory

		// create session

		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
				Session session = factory.getCurrentSession();) {

			// start the transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("***tempInstructorDetail " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("*******The associated instructor:" + tempInstructorDetail.getInstructor());

			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
