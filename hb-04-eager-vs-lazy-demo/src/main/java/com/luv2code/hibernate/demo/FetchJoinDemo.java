package com.luv2code.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

@SuppressWarnings("deprecation")
public class FetchJoinDemo {

	
	public static void main(String[] args) {

		SessionFactory factory = null;
		
		try
				 {
			
			// create session factory
			factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class).buildSessionFactory();

			// create session
			Session session = factory.getCurrentSession();
			
			// start the transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId", Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute the query and get the instructor
			
			Instructor instructor = query.getSingleResult();
			System.out.println("******Instructor: "+instructor);
						
			// commit the transaction
			session.getTransaction().commit();
			
			// closing session manually
			session.close();
			
			System.out.println("The session is now closed");
			
			// get course for the instructor
						System.out.println("******Courses:"+ instructor.getCourses() );
			
			System.out.println("******Done!");
		}
		finally {
			factory.close();
		}

	}

}
