package com.luv2code.hibernate.demo.dao;

import java.util.List;

import com.luv2code.hibernate.demo.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();
	
	public void saveStudent(Student student);
	
	public Student getStudent(int Id);
	
	public void deleteStudent(int id);
	
	public void getStudentByFirstName(String firstName);

	public List<Student> getColumns(List<String> columns);
}
