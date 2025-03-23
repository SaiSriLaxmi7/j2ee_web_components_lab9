package com.humber.repo;

import com.humber.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepo {

    private final List<Employee> employees = new ArrayList<>();
    private int currentId = 4;

    public EmployeeRepo() {
        employees.add(new Employee(1, "Employee1", "IT", "employee1@humber.ca", 100.0));
        employees.add(new Employee(2, "Employee2", "HR", "employee2@humber.ca", 200.0));
        employees.add(new Employee(3, "Employee3", "Finance", "employee3@humber.ca", 300.0));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employee.setId(currentId++);
        employees.add(employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateEmployee(Employee employee) {
        int index = employees.indexOf(getEmployeeById(employee.getId()));
        if (index != -1) {
            employees.set(index, employee);
        }
    }

    public void removeEmployeeById(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }

    public List<Employee> searchEmployees(String keyword) {
        return employees.stream()
                .filter(emp -> emp.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                               emp.getDepartment().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}