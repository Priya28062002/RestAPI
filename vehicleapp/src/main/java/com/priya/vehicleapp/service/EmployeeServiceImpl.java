package com.priya.vehicleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.Admin;
import com.priya.vehicleapp.model.Employee;
import com.priya.vehicleapp.repository.AdminRepository;
import com.priya.vehicleapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public boolean loginEmployee(LoginDTO loginEmployee) {
		Employee employee = employeeRepository.findByEmployeeEmail(loginEmployee.getEmailId());
		if(employee == null || !employee.getPassword().equals(loginEmployee.getPassword()))
			return false;
		return true;
	}

	@Override
	public Employee registerEmployee(Employee employee) {
		Employee findEmployee = employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail());
		if(findEmployee != null)
			return null;
		Employee employeeInsert = employeeRepository.save(employee);
		return employeeInsert;
	}

	@Override
	public boolean isAdmin(String email) {
		Admin admin = adminRepository.findByAdminEmail(email);
		if(admin == null)
			return false;
		return true;
	}

}
