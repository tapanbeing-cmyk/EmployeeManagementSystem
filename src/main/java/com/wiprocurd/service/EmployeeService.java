package com.wiprocurd.service;

import com.wiprocurd.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployeeById(long employeeId, EmployeeDto employeeDto);

	EmployeeDto getEmployeeByid(long employeeId);

	List<EmployeeDto> getAllEmployee();

	void deleteEmployeeById(long employeeId);

	List<EmployeeDto> saveAll(List<EmployeeDto> employeeDtos);
}
