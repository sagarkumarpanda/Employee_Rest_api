package com.sakha.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakha.ems.model.Employee;
import com.sakha.ems.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	EmployeeService es;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() throws Exception{
		return es.getAllEmployees();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable("empId") String empId) throws Exception {
		return es.getEmployee(empId);
	}
	
	@PostMapping("/employees")
	public Boolean saveEmployee(@RequestBody Employee emp) throws Exception {
		return es.save(emp);
	}
	
	@GetMapping("/demployee/{empId}")
	public Boolean delete(@PathVariable("empId") String empId) throws Exception{
		return es.delete(empId);
	}
	
	

	@PutMapping("/update")
	public  Employee updateEmployee(@RequestBody Employee emp) throws Exception {
	//  @Valid @RequestBody Employee emp) throws Exception {
		
/*		Employee emp2 = es.getEmployee(empId);

	 emp2.setEmpId(emp.getEmpId());
	 emp2.setEmpName(emp.getEmpName());
	 emp2.setDOB(emp.getDOB());
	 final boolean updatedEmployee = es.save(emp2);*/
	 return es.update(emp);
	
}
}
