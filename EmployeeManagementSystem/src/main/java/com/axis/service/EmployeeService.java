package com.axis.service;

import java.util.List;
import com.axis.model.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	String deleteEmployeeById(long id);
	
}
