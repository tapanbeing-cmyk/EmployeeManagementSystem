package com.wiprocurd.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wipro_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String firstName;
	private String lastName;
	private long salary;

}
