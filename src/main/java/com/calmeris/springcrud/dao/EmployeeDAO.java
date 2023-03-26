package com.calmeris.springcrud.dao;

import java.util.List;

import com.calmeris.springcrud.model.Employee;

public interface EmployeeDAO {

	List<Employee> getAll();

	Employee get(int id);

	void save(Employee employee);

	void delete(int id);

}
