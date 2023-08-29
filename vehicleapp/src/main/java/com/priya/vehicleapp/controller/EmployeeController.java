package com.priya.vehicleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.Employee;
import com.priya.vehicleapp.service.EmployeeService;
import com.priya.vehicleapp.utilities.EmployeeConstants;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/login")
	public String employeeLogin(@RequestBody LoginDTO loginEmployee) {
		boolean isAvailable = employeeService.loginEmployee(loginEmployee);
		if(isAvailable) {
			return EmployeeConstants.EMP_LOGGED_IN;
		}
		return EmployeeConstants.EMP_NOT_AVAILABLE;
	}
	
	@PostMapping("/register")
	public String employeeRegister(@RequestBody Employee employee) {
		boolean isAdmin = employeeService.isAdmin(employee.getEmployerEmail());
		if(isAdmin) {
			Employee employeeAdded = employeeService.registerEmployee(employee);
			if(employeeAdded == null) {
				return EmployeeConstants.EMP_EXISTS;
			}
			return EmployeeConstants.EMP_ADDED;
		}
		return EmployeeConstants.NOT_ADMIN;
	}

}
