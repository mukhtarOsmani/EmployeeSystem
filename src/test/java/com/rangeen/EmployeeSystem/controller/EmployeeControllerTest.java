package com.rangeen.EmployeeSystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rangeen.EmployeeSystem.entity.Employee;
import com.rangeen.EmployeeSystem.service.EmployeeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl employeeService;

    Employee employee1;
    Employee employee2;
    Employee employee3;
    Employee employee4;

    List<Employee> employeeList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        employee1 = new Employee(1L, "Ahmad","+12457854","ahmad@yahoo.com" );
        employee2 = new Employee(2L, "Tahir","+194554543","Tahir@gmail.com" );
        employee3 = new Employee(3L, "Sameer","+1785454","Sameer@yahoo.com" );
        employee4 = new Employee(4L, "Rahman","+1875412","Rahman@outlook.com" );

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);


    }



    @Test
    void testSaveEmployee() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(employee1);

        when(employeeService.saveEmployee(employee1))
                .thenReturn(employee1);
        mockMvc.perform(post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());




    }

    @Test
    void testGetAllEmployees() throws Exception {

        when(employeeService.getAllEmployees()).thenReturn(employeeList);
        this.mockMvc.perform(get("/api/employee"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[1].name", is("Tahir")));

    }

    @Test
    void testGetEmployeeById() throws Exception {

        when(employeeService.getEmployeeById(1L)).thenReturn(employee1);
        this.mockMvc.perform(get("/api/employee/1"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$.name", is("Ahmad")));

    }

    @Test
    void testDpdateEmployeeInfo() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(employee1);

        when(employeeService.updateEmployeeInfo(employee1))
                .thenReturn(employee1);

        mockMvc.perform(put("/api/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteEmployee() throws Exception {
        when(employeeService.deleteEmployee(1L)).thenReturn("Deleted Successfully");
        this.mockMvc.perform(delete("/api/employee/1"))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
//                .andExpect(jsonPath("$.name", is("Ahmad")));
    }


    @AfterEach
    void tearDown() {
    }
}