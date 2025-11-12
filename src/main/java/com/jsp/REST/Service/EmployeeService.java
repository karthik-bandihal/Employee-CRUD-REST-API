package com.jsp.REST.Service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsp.REST.Entity.Employee;
import com.jsp.REST.Error.DataExistsException;
import com.jsp.REST.Error.DataNotFoundException;
import com.jsp.REST.Repository.EmployeeRepository;
import com.jsp.REST.dto.ResponseDto;

import lombok.AllArgsConstructor;

@Service
	@AllArgsConstructor
	public class EmployeeService {
		
		private EmployeeRepository employeeRepository;
		
		public ResponseDto save(Employee employee) {
			if(employeeRepository.existsByMobileOrEmail(employee.getMobile(),employee.getEmail()))
				throw new DataExistsException("Email or Mobile Already Exists");
			employeeRepository.save(employee);
			return new ResponseDto("Data Added Success", employee);
		}
		
		public ResponseDto fetchAll() {
			List<Employee> employees = employeeRepository.findAll();
			if(employees.isEmpty())
				throw new DataNotFoundException("No Data Found");
			else 
				return new ResponseDto("Data Found", employees);
		}
		
	
		



	
	
	public void deleteById(@PathVariable Integer id) {
		employeeRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Data Not Found with Id "+id));
        employeeRepository.deleteById(id);
	
		
	}

	public ResponseDto featchById(Integer id) {
		Employee employee=employeeRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Data Not Found with Id "+id));
		return new ResponseDto("Data Found", employee);
	}

	public ResponseDto featchByDepartment(String dept) {
		List<Employee> employees=employeeRepository.findByDepartment(dept);
		return new ResponseDto("Data Found", employees);
	}

	public ResponseDto featchByEmail(String email) {
		Employee employee=employeeRepository.findByEmail(email);
		return new ResponseDto("Data Found", employee);
	}
	
	public ResponseDto updateCompletly(Integer id , Employee employee) {
		employeeRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Data Not Found with Id "+id));
		employee.setId(id);
	    employeeRepository.save(employee);
	    return new ResponseDto("data updated success", employee);
	}
    
	public ResponseDto updatePartially(Integer id , Employee employee) {
		Employee exEmployee = employeeRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Data Not Found with Id "+id));
		exEmployee.setDepartment(employee.getDepartment()== null? exEmployee.getDepartment():employee.getDepartment());
		exEmployee.setEmail(employee.getEmail()== null? exEmployee.getEmail():employee.getEmail());
		exEmployee.setMobile(employee.getMobile()== null? exEmployee.getMobile():employee.getMobile());
		exEmployee.setSalary(employee.getSalary()== null? exEmployee.getSalary():employee.getSalary());
		exEmployee.setName(employee.getName()== null? exEmployee.getName():employee.getName());
		employeeRepository.save(exEmployee);
		return new ResponseDto("Data updated Success", exEmployee);
	}
	
}

