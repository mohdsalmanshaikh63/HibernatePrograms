package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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

			// create some courses
			Course tempCourse1 = new Course("Air Guitar - Ultimate Guide");
			Course tempCourse2 = new Course("Violin Master Class");

			// add courses to the instructor
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);

			// save the courses
			// session.save(tempCourse1);
			// session.save(tempCourse2);
			session.persist(instructor);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}

	}

}
