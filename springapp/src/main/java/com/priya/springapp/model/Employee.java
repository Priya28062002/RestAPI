package com.priya.springapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(name = "emp_name")
    private String employeeName;
	@Column(name = "emp_Age")
    private int employeeAge;
	@Column(name = "salary")
    private long salary;
	
	public Employee() {
		
	}
    
    public Employee(int id, String employeeName, int employeeAge, long salary) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge + ", salary="
				+ salary + "]";
	}
    
}
