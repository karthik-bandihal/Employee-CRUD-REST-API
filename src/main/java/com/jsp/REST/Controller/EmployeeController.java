package com.jsp.REST.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.REST.Entity.Employee;
import com.jsp.REST.Repository.EmployeeRepository;
import com.jsp.REST.Service.EmployeeService;
import com.jsp.REST.dto.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/employee")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation
	public ResponseDto save(@RequestBody Employee employee) {
		return service.save(employee);
		
	}
	@GetMapping("/employee")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch All Record")
	public ResponseDto fetchAll() {
		return service.fetchAll();
	}

	@DeleteMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@Operation(summary = "Delete Record")
	public void deleteById(@PathVariable int id) {
		 service.deleteById(id);
	}

	@GetMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch Record by Id")
	public ResponseDto featchById(@PathVariable Integer id) {
		return service.featchById(id);
	}

	@GetMapping("/employee/depeatment/{dept}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch Record by department")
	public ResponseDto featchById(@PathVariable String dept) {
		return service.featchByDepartment(dept);
	}

	@GetMapping("/employee/email/{email}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch Record by Email")
	public ResponseDto featchByEmail(@PathVariable String email) {
		return service.featchByEmail(email);

	}
	
	@PutMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Update Record Completely")
	public ResponseDto updateCompletly(@PathVariable Integer id , @RequestBody Employee employee) {
		return service.updateCompletly(id, employee);
		
		
	}
	
	@PatchMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Update Record Partially")
	public ResponseDto updatePartially(@PathVariable Integer id, @RequestBody Employee employee) {
		return service.updatePartially(id, employee);
	}
	
	
	

}











	
