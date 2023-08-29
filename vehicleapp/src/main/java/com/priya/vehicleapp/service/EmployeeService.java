package com.priya.vehicleapp.service;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.Employee;

public interface EmployeeService {
	
	public boolean loginEmployee(LoginDTO loginDTO);
	
	public Employee registerEmployee(Employee employee);
	
	public boolean isAdmin(String email);

}
