package com.humber.controller;

import com.humber.model.Employee;
import com.humber.repo.EmployeeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Display the list of employees
    @GetMapping("/")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepo.getAllEmployees());
        return "home"; // home.jsp
    }

    // Show form for adding a new employee
    @GetMapping("/addEmployee")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee"; // add-employee.jsp
    }

    // Handle form submission for adding an employee
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepo.addEmployee(employee);
        return "redirect:/";
    }

    // Search employees by name or department
    @GetMapping("/searchEmployee")
    public String searchEmployee(@RequestParam String keyword, Model model) {
        model.addAttribute("employees", employeeRepo.searchEmployees(keyword));
        return "home"; // Show filtered results on home.jsp
    }

    // Load update form
    @GetMapping("/updateEmployee/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Employee employee = employeeRepo.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "update-employee"; // update-employee.jsp
        }
        return "redirect:/";
    }

    // Handle employee update
    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute Employee updatedEmployee) {
        updatedEmployee.setId(id);
        employeeRepo.updateEmployee(updatedEmployee);
        return "redirect:/";
    }

    // Delete an employee
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeRepo.removeEmployeeById(id);
        return "redirect:/";
    }
}