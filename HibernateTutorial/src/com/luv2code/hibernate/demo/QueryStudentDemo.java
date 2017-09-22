 package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try
		{		
			
			// start the transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student", Student.class).getResultList(); // added Student.class aruement to make the warning go away
			
			// display the students
			displayStudents(theStudents);
			
			// query student: last name = 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'", Student.class).getResultList();
			
			// display the students
			System.out.println("\n\n");
			displayStudents(theStudents);
			
			// query student: last name = 'Doe' or firstName = 'Daffy'
						theStudents = session.createQuery("from Student s where s.lastName = 'Doe'"
								+ " OR firstName='Daffy'", Student.class).getResultList();
						
			// display the students
			System.out.println("\n\n");
			displayStudents(theStudents);

			// query student: email like '%luv2code.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'", Student.class).getResultList();
			
			// display the students
			System.out.println("\n\n");
			displayStudents(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
