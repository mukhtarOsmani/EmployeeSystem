package com.rangeen.EmployeeSystem.service;

import com.rangeen.EmployeeSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);


    Employee updateEmployeeInfo(Employee employee);

    String deleteEmployee(Long id);

    Employee getEmployeeByNameAndEmail(String name, String email);
}
