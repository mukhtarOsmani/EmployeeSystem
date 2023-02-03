package com.rangeen.EmployeeSystem.controller;

import com.rangeen.EmployeeSystem.entity.Employee;
import com.rangeen.EmployeeSystem.service.EmployeeServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @PostMapping
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
//        return "Employee info saved successfully";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long Id) {
      return employeeService.getEmployeeById(Id);
    }

    @GetMapping("/nameAndEmail")
    public Employee getEmployeeByNameAndEmail(@RequestParam("name") String name, @RequestParam("email") String email) {
        return employeeService.getEmployeeByNameAndEmail(name, email);
    }

    @PutMapping
    public Employee updateEmployeeInfo(@RequestBody Employee employee) {
       return employeeService.updateEmployeeInfo(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long Id)
    {
        employeeService.deleteEmployee(Id);
        return "Employee data deleted successfully";
    }








}
