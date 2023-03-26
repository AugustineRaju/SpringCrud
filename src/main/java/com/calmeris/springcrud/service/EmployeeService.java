package com.calmeris.springcrud.service;

import java.util.List;

import com.calmeris.springcrud.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAll();

	Employee get(int id);

	void save(Employee employee);

	void delete(int id);

}
