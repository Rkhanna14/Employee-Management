package com.abc.employeemanagement.service;

import java.util.List;

import com.abc.employeemanagement.model.Employee;

public interface EmployeeServiceInf {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee updateEmployee(int id, Employee employee);

	void deleteEmployee(int id);

}
