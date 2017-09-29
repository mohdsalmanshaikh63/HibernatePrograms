package com.luv2code.hibernate.demo.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.dao.StudentDAO;
import com.luv2code.hibernate.demo.dao.StudentDAOImpl;
import com.luv2code.hibernate.demo.entity.Student;

public class StudentServiceImpl implements StudentService {

	StudentDAO studentDAO;

	public StudentServiceImpl(SessionFactory factory) {
		studentDAO = new StudentDAOImpl(factory);
	}

	@Override
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);

	}

	@Override
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	@Override
	public void deleteStudent(int id) {

		studentDAO.deleteStudent(id);

	}

	@Override
	public Student getStudentByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getColumns(List<String> columns) {		
		return studentDAO.getColumns(columns);
	}

}
