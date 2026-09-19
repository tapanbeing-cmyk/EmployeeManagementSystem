package com.wiprocurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiprocurd.entity.Employee;
import com.wiprocurd.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.saveEmployee(employee);
    }

    @PostMapping("/saveAll")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee) {
        return employeeServiceImpl.saveAll(employee);
    }

    @PatchMapping("update/{employeeId}")
    public Employee updateEmployeeById(@PathVariable long employeeId, @RequestBody Employee employee) {
        return employeeServiceImpl.updateEmployeeById(employeeId, employee);
    }

    @GetMapping("get/{employeeId}")
    public Employee getEmployeeByid(@PathVariable long employeeId) {
        return employeeServiceImpl.getEmployeeByid(employeeId);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeServiceImpl.getAllEmployee();
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable long employeeId) {
        employeeServiceImpl.deleteEmployeeById(employeeId);
    }
}
