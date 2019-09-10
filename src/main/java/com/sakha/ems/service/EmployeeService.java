package com.sakha.ems.service;

import java.util.List;

import com.sakha.ems.model.Employee;

public interface EmployeeService {
	
	public boolean validateEmployee(Employee emp) throws Exception;
	public String generateId(String empName) throws Exception;
	public boolean save (Employee emp) throws Exception;
	public boolean delete (String empId) throws Exception;
    public Employee update(Employee emp) throws Exception;
    public Employee getEmployee(String empId) throws Exception;
    public List<Employee>getAllEmployees() throws Exception;
	
}
