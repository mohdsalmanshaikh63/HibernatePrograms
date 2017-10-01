package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		try (// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class).buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();) {

			
			// start the transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("******Instructor: "+instructor);

			// get course for the instructor
			System.out.println("Courses:"+ instructor.getCourses() );
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

	}

}
