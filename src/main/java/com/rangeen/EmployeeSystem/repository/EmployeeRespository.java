package com.rangeen.EmployeeSystem.repository;

import com.rangeen.EmployeeSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRespository extends JpaRepository<Employee, Long> {
    Employee findByNameAndEmail(String name, String email);
}
