package com.revature.daos;

import java.sql.Connection;
import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	  // define some CRUD (Create, Read, Update, Delete) operations here
	  public List<Employee> getAllEmployees(Connection conn);
//	  public List<Employee> getEmployeesByLocation(String location);
//	  public void updateEmployeeById(int id);
	  public boolean deleteEmployeeById(int id);
	  public boolean addEmployee(Connection conn, String name, int salary, String jobTitle);
	}
