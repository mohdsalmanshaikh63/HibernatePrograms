package com.luv2code.hibernate.demo.service;

import java.util.List;

import com.luv2code.hibernate.demo.entity.Student;

public interface StudentService {

	public List<Student> getStudents();
	
	public void saveStudent(Student theStudent);
	
	public Student getStudent(int id);
	
	public void deleteStudent(int id);
	
	public Student getStudentByFirstName(String firstName);

	public List<Student> getColumns(List<String> columns);
	
}
