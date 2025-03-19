package com.abc.employeemanagement.model;

import com.abc.employeemanagement.validation.Mobile;
import com.abc.employeemanagement.validation.Pan;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Employee entity representation")
public class Employee {
	@Id
	@GeneratedValue
	@Schema(description = "Unique id for employee", example = "1")
	private int id;
	
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 3, message = "name should be min 3 characters")
	@Schema(description = "Employee name", example = "Bsk")
	private String name;
	
	@Email
	@NotBlank
	@Schema(description = "Employee email", example = "bsk@gmail.com")
	private String email;
	//@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "Invalid PAN format")
	@Pan
	@Schema(description = "Employee PAN", example = "ASDK2828K")
	private String pan;
	
	@Size(max = 100, message = "Address should not exceed 100 character")
	@Schema(description = "Employee Address", example = "Telangana")
	private String address;
	
	//@Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "Invalid mobile format")
	@Mobile(message = "Mobile Should strt 6-9 and  10 digit")
	@Schema(description = "Employee Mobile", example = "9889898989")
	private String mobile;
	
}
