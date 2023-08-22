package com.priya.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.springapp.Repository.EmployeeRepository;
import com.priya.springapp.model.Employee;

@Service
public class ApiService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepo.findAll();
		return employees;
	}
	
	public Boolean addEmployee(Employee employee) {
		Employee employeeFind = getEmployeeById(employee.getId());
		if(employeeFind != null)
			return false;
		employeeRepo.save(employee);
		return true;
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		return employee.orElse(null);
	}

}

