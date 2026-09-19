package com.wiprocurd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.wiprocurd.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private com.wiprocurd.repo.EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployeeById(long employeeId, Employee employee) {
		// TODO Auto-generated method stub
		Employee existingEmployee = employeeRepo.findById(employeeId).orElseThrow();
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setSalary(employee.getSalary());
		return employeeRepo.save(existingEmployee);
	}

	@Override
	public Employee getEmployeeByid(long employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public void deleteEmployeeById(long employeeId) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(employeeId);
	}

	@Override
	public List<Employee> saveAll(List<Employee> employee) {
		return  employeeRepo.saveAll(employee);
	}

}
