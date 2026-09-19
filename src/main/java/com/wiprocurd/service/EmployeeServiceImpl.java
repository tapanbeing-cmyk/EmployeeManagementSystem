package com.wiprocurd.service;

import com.wiprocurd.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.wiprocurd.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private com.wiprocurd.repo.EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    private EmployeeDto toDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);

    }

    private Employee toEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);

    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        Employee employee = toEntity(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);
        return toDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployeeById(long employeeId, EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        Employee existingEmployee = employeeRepo.findById(employeeId).orElseThrow();
        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setSalary(employeeDto.getSalary());
        Employee update = employeeRepo.save(existingEmployee);
        return toDto(update);
    }

    @Override
    public EmployeeDto getEmployeeByid(long employeeId) {
        Employee emp = employeeRepo.findById(employeeId).orElseThrow();
        return toDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        // TODO Auto-generated method stub
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDto> saveAll(List<EmployeeDto> employeeDtos) {
        List<Employee> employees = employeeDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        return employeeRepo.saveAll(employees)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

}
