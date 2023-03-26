package com.calmeris.springcrud.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calmeris.springcrud.model.Employee;
import com.calmeris.springcrud.service.EmployeeService;

@RestController
@RequestMapping("/springcrud")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAll();
	}

	@PostMapping("/addEmployee")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;

	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployee(@PathVariable int id) {

		Employee employee = employeeService.get(id);
		if (null == employee) {
			throw new RuntimeException("Employee id " + id + " is not found");
		}
		return employee;
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEMployee(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee object has been deleted" + id;
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
}
