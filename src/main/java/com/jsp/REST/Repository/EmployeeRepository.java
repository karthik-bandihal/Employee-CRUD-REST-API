package com.jsp.REST.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.REST.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	boolean existsByMobileOrEmail(Long mobile, String email);

	List<Employee> findByDepartment(String dept);

	Employee findByEmail(String email);

	

	

}
