package com.priya.vehicleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priya.vehicleapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeEmail(String userEmail);

}
