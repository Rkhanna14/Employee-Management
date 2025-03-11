package com.abc.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.abc.employeemanagement.exception.ResourceNotFoundException;
import com.abc.employeemanagement.model.Employee;
import com.abc.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInf{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
//		Optional<Employee> _employee = employeeRepository.findById(id);
//		if(_employee.isPresent()) {
//			Employee emp = _employee.get();
//			emp.setName(employee.getName());
//			emp.setAddress(employee.getAddress());
//			emp.setEmail(employee.getEmail());
//			emp.setMobile(employee.getMobile());
//			emp.setPan(employee.getPan());
//			return employeeRepository.save(emp);
//		}else {
//			new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee id"+id+" not available.");
//		}
//		return employee;
		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Employee id +"+id+" not available"));
		emp.setName(employee.getName());
		emp.setAddress(employee.getAddress());
		emp.setEmail(employee.getEmail());
		emp.setMobile(employee.getMobile());
		emp.setPan(employee.getPan());
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Employee id +"+id+" not available"));
		employeeRepository.delete(employee);
	}

}
