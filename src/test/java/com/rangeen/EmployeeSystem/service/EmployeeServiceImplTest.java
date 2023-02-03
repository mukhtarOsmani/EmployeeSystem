package com.rangeen.EmployeeSystem.service;

import com.rangeen.EmployeeSystem.entity.Employee;
import com.rangeen.EmployeeSystem.repository.EmployeeRespository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @Mock
    private  EmployeeRespository employeeRespository;

    private EmployeeServiceImpl employeeService;

    AutoCloseable autoCloseable;
    Employee employee;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRespository);
        employee = new Employee(1L, "Ahmad","+12457854","ahmad@yahoo.com" );


    }



    @Test
    void saveEmployee() {

        mock(Employee.class);
        mock(EmployeeRespository.class);

        when(employeeRespository.save(employee)).thenReturn(employee);
        assertThat(employeeService.saveEmployee(employee)).isEqualTo(employee);
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void getEmployeeById() {
        mock(Employee.class);
        mock(EmployeeRespository.class);
        when(employeeRespository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        assertThat(employeeService.getEmployeeById(1L).getName()).isEqualTo(employee.getName());

    }

    @Test
    void getEmployeeByNameAndEmail() {
    }

    @Test
    void updateEmployeeInfo() {
    }

    @Test
    void deleteEmployee() {
    }

    @AfterEach
    void tearDown() {
    }
}