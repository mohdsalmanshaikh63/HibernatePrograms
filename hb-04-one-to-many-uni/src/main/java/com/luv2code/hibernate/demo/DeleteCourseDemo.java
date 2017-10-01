package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		try (// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class).buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();) {

			
			// start the transaction
			session.beginTransaction();
			
			// get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// delete the course
			System.out.println("Deleting course: "+ tempCourse);
			
			session.delete(tempCourse);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

	}

}
