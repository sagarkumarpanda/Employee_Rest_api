package com.sakha.ems.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakha.ems.model.*;
import com.sakha.ems.repo.*;

import java.sql.*;
import java.time.*;
import com.sakha.ems.util.*;
import com.sakha.ems.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo dao;
	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		LocalDate dob = emp.getDOB();
		boolean res = true;
		if(emp.getEmpName().length()<4||emp.getEmpName().length()>15) {
			res = false;
			throw new InvalidLengthException("Invalid Name");
		}
	
if(dob.isAfter(LocalDate.of(1995, 12, 31)) || dob.isBefore(LocalDate.of(1900, 1, 1))) {
			
			throw new InvalidDateException("Dob must be in range 1-1-1900 to 31-12-1995 ");
		}
		
		
		
		
		if((emp.getBasicSalary()<20000f)||(emp.getBasicSalary()>80000f)) {
			res = false;
			throw new InvalidSalaryException("Salary not in range");
		}
		
		
		
		return res;
	}

	@Override
	public String generateId(String empName) throws Exception{
		Random rand=new Random();
		String id = String.format("%04d", rand.nextInt(10000));
		String empCode = empName.substring(0, 2)+id;
		return empCode;
		
	}

	@Override
	public boolean save(Employee emp) throws Exception{
		if(validateEmployee(emp)) {
			emp.setEmpId(generateId(emp.getEmpName()));
			dao.save(emp);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String empId) throws Exception {
			Employee emp=dao.findByEmpId(empId);
			 dao.delete(emp);
			 return true;
	}

	@Override
	public Employee update(Employee emp) throws Exception {
		
			 Employee empUp=dao.findByEmpId(emp.getEmpId());
			 empUp.setBasicSalary(emp.getBasicSalary());
			 empUp.setDOB(emp.getDOB());
			 empUp.setEmpName(emp.getEmpName());
			 return dao.save(empUp);
			 
		}
	
	

	@Override
	public Employee getEmployee(String empId) throws Exception {
		return dao.findByEmpId(empId);	}

	@Override
	public List<Employee> getAllEmployees()  throws Exception{
		
			return dao.findAll();
	}


}
