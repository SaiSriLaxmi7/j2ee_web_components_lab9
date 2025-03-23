package com.humber.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class Employee {
	
	private int id;
	@NotEmpty(message = "Name is required")
	private String name;
	private String department;
	@Email(message = "Invalid email format")
	private String email;
	@Positive(message = "Salary must be positive")
	private double salary;
	
	public Employee() {}
	
	public Employee(int id, @NotEmpty(message = "Name is required") String name, String department,
			@Email(message = "Invalid email format") String email,
			@Positive(message = "Salary must be positive") double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.salary = salary;
	}
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}