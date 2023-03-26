package com.calmeris.springcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.calmeris.springcrud.model.Employee;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private EntityManager entityManger;

	@Override
	public List<Employee> getAll() {
		
		Session currentSession= entityManger.unwrap(Session.class);
		Query<Employee> query=currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list=query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession= entityManger.unwrap(Session.class);
		Employee employee=currentSession.get(Employee.class,id);
		return employee;
		
	}

	@Override
	public void save(Employee employee) {
		Session currentSession= entityManger.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		Session currentSession= entityManger.unwrap(Session.class);
		Employee employee=currentSession.get(Employee.class,id);
		currentSession.delete(employee);
		
	}

}
;;
