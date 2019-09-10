package com.sakha.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sakha.ems.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("from Employee where empId=:empId")
	public Employee findByEmpId(String empId);
}
