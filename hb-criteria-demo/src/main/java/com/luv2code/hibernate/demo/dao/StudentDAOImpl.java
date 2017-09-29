package com.luv2code.hibernate.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.luv2code.hibernate.demo.entity.Student;

public class StudentDAOImpl implements StudentDAO {

	SessionFactory factory;

	public StudentDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> studentsList = criteria.list();
		session.getTransaction().commit();
		return studentsList;
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getStudent(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.setMaxResults(1);
		Student student = (Student) criteria.uniqueResult();
		session.getTransaction().commit();
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getStudentByFirstName(String firstName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> getColumns(List<String> columns) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Student.class).setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id").add(Projections.property("dateOfBirth"), "dateOfBirth"));
		// double time column names are needed else all null values are returned
		
		criteria.setResultTransformer(Transformers.aliasToBean(Student.class));
		@SuppressWarnings("unchecked")
		List<Student> studentList = criteria.list();
		session.getTransaction().commit();
		return studentList;
	}

}
