package com.wiprocurd.service;

import java.util.List;

import com.wiprocurd.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	Employee updateEmployeeById(long employeeId, Employee employee);

	Employee getEmployeeByid(long employeeId);

	List<Employee> getAllEmployee();

	void deleteEmployeeById(long employeeId);

	List<Employee> saveAll(List<Employee> employee);
}
