package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.service.StudentService;
import com.luv2code.hibernate.demo.service.StudentServiceImpl;

public class CriteriaDemo {

	public static void main(String[] args) {

		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
				) {

			StudentService studentService = new StudentServiceImpl(factory);

			
			// getting all records
			System.out.println("Select all students from Student table");

			// create sessionFactory execute methods and close sessionFactory

			List<Student> studentList = studentService.getStudents();

			for (Student student : studentList) {
				System.out.println(student);
			}
			
			// getting a particular student with particular id
			System.out.println("Getting student with  id 4");
			Student student1 = studentService.getStudent(4);
			System.out.println(student1);
			
			
			// getting only firstName and dateOfBirth
			System.out.println("Getting only firstName and date of Birth");
			List<String> columns = new ArrayList<>();
			columns.add("firstName");
			columns.add("dateOfBirth");
			
			List<Student> studentList2 = studentService.getColumns(columns);
			for (Student student : studentList2) {
				System.out.println(student);
			}

		}
	}
}
