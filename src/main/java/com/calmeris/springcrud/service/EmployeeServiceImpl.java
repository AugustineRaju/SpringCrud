package com.calmeris.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calmeris.springcrud.dao.EmployeeDAO;
import com.calmeris.springcrud.model.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
    @Transactional
	@Override
	public List<Employee> getAll() {
	
		return employeeDAO.getAll();
	}
    @Transactional
	@Override
	public Employee get(int id) {
    	return employeeDAO.get(id);
	}
    @Transactional
	@Override
	public void save(Employee employee) {
    	employeeDAO.save(employee);;

	}
    @Transactional
	@Override
	public void delete(int id) {
    	employeeDAO.delete(id);

	}

}