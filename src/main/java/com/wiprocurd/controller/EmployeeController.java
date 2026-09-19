package com.wiprocurd.controller;

import java.util.List;

import com.wiprocurd.dto.EmployeeDto;
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
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeServiceImpl.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<EmployeeDto>> saveEmployee(@RequestBody List<EmployeeDto> employeeDtos) {
        return ResponseEntity.ok(employeeServiceImpl.saveAll(employeeDtos));
    }

    @PatchMapping("update/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable long employeeId, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeServiceImpl.updateEmployeeById(employeeId, employeeDto));
    }

    @GetMapping("get/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeByid(@PathVariable long employeeId) {
        EmployeeDto employeeByid = employeeServiceImpl.getEmployeeByid(employeeId);
        return employeeByid != null ? ResponseEntity.ok(employeeByid) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        return ResponseEntity.ok(employeeServiceImpl.getAllEmployee());
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable long employeeId) {
        employeeServiceImpl.deleteEmployeeById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
