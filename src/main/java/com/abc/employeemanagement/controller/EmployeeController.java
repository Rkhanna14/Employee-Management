package com.abc.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.employeemanagement.model.Employee;
import com.abc.employeemanagement.service.EmployeeServiceInf;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/employee")
@Tag(name = "Employee Controller", description = "Employee CRUD")
public class EmployeeController {
	@Autowired
	private EmployeeServiceInf employeeServiceInf;
	
	//Create Employee
	@PostMapping
	@Operation(summary = "Post Employee", description = "create new employee")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Employee created successfully"),
		@ApiResponse(responseCode = "400", description = "BadRequest")
	})
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
		Employee savedEmployee = employeeServiceInf.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}
	
	//Get All  Employees
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Employees",
		content = @Content(array = @ArraySchema(schema = @Schema(implementation = Employee.class))))
	})
	@GetMapping
	@Operation(summary = "Get All Employees", description = "Get All Employees in the form of list")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeServiceInf.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	
	//Update Employee by Id
	@PutMapping("/{id}")
	@Operation(summary = "Update Employee By ID", description = "Update Employee details using employee id")
	public ResponseEntity<Employee> updateEmployee(
			@Parameter(description = "Integer Id for update", example = "1") @PathVariable int id,@Valid @RequestBody Employee employee) {
		Employee updatedEmployee = employeeServiceInf.updateEmployee(id,employee);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
	}
	
	//Delete Employee by Id
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Employee By ID", description = "Delete Employee details using employee id")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		employeeServiceInf.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
}
