package com.abc.employeemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 3, message = "name should be min 3 characters")
	private String name;
	@Email
	private String email;
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "Invalid PAN format")
	private String pan;
	@Size(max = 100, message = "Address should not exceed 100 character")
	private String address;
	@Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "Invalid mobile format")
	private String mobile;
	
}
