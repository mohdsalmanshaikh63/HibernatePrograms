package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			
			// start the transaction
			session.beginTransaction();

			// get instructor by primary key/id
			int theId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			
			System.out.println("****Found the instructor: "+ tempInstructor);
			
			// delete the instructors
			if(tempInstructor != null) {
				
				System.out.println("*****Deleting: "+ tempInstructor);
				
				// Note this will also delete the associated "details" objects
				// because of CascadeType.ALL
				
				session.delete(tempInstructor);
			}

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
