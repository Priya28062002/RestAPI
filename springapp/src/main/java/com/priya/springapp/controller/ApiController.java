package com.priya.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.springapp.model.Employee;
import com.priya.springapp.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ApiService apiService;

    @GetMapping("/")
    public List<Employee> getEmployees() {
    	List<Employee> employees = apiService.getAllEmployees();
        return employees;
    }
    
    @PostMapping("/")
    public Boolean addEmployee(@RequestBody Employee employee) {
    	boolean isEmployeeAdded = apiService.addEmployee(employee);
    	return isEmployeeAdded;
    }
    
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
    	Employee employee = apiService.getEmployeeById(id);
    	return employee;
    }
    
}

