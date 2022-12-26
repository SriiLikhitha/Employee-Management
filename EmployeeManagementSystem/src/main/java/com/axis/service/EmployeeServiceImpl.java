package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.axis.exception.IDNotFoundException;
import com.axis.model.Employee;
import com.axis.repository.EmployeeRepository;
import com.axis.utils.AppConstants;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {

		Employee employee=null;
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent())
			employee=optional.get();
		else
			throw new IDNotFoundException(AppConstants.IDNOT_FOUND_MESSAGE);
		return employee;
	}

	@Override
	public String deleteEmployeeById(long id) {
	 Employee emp = employeeRepository.findById(id).orElseThrow(()->new IDNotFoundException(AppConstants.IDNOT_FOUND_MESSAGE));
	 employeeRepository.delete(emp);
	 return AppConstants.Employee_DELETE_MESSAGE;
		
	}

}
