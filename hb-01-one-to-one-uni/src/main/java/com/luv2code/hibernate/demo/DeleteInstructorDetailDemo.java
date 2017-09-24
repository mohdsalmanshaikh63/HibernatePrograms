package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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

			// now let's delete the instructor detail
			System.out.println("******Deleting tempInstructorDetail:  " + tempInstructorDetail);

			// we need to remove the associated object reference
			// to break the bi-directional link else you would get the following error
			// 2017-09-24 15:36:50 ERROR ExceptionMapperStandardImpl:39 - HHH000346: Error
			// during managed flush [deleted object would be re-saved by cascade (remove
			// deleted object from associations):
			// [com.luv2code.hibernate.demo.entity.InstructorDetail#2]]
			tempInstructorDetail.getInstructor().setInstructorDetail(null);

			session.delete(tempInstructorDetail);

			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
