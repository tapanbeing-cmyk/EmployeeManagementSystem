package com.wiprocurd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiprocurd.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{

}
