package com.wiprocurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeServiceImpl.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<Employee>> saveEmployee(@RequestBody List<Employee> employee) {
        return ResponseEntity.ok(employeeServiceImpl.saveAll(employee));
    }

    @PatchMapping("update/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable long employeeId, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.updateEmployeeById(employeeId, employee));
    }

    @GetMapping("get/{employeeId}")
    public ResponseEntity<Employee> getEmployeeByid(@PathVariable long employeeId) {
        Employee employeeByid = employeeServiceImpl.getEmployeeByid(employeeId);
        return employeeByid != null ? ResponseEntity.ok(employeeByid) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeServiceImpl.getAllEmployee());
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable long employeeId) {
        employeeServiceImpl.deleteEmployeeById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
