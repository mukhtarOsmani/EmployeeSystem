package com.rangeen.EmployeeSystem.service;
import com.rangeen.EmployeeSystem.entity.Employee;
import com.rangeen.EmployeeSystem.repository.EmployeeRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRespository employeeRespository;

    @Override
    public Employee saveEmployee(Employee employee) {
       return employeeRespository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRespository.findById(id).get();

    }

    @Override
    public Employee updateEmployeeInfo(Employee employee) {
        return employeeRespository.save(employee);
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRespository.deleteById(id);
        return "Employee data Deleted Successfully";

    }

    @Override
    public Employee getEmployeeByNameAndEmail(String name, String email) {
        return employeeRespository.findByNameAndEmail(name, email);
    }


}
