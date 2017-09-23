package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/Guitar",
					"Guitar!!!");

			// start a transaction
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start the transaction
			session.beginTransaction();

			// save the Instructor object
			
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			
			System.out.println("************ Saving instructor:"+tempInstructor);
			session.save(tempInstructor);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
