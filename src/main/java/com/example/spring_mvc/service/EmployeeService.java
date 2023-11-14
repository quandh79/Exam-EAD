package com.example.spring_mvc.service;

import com.example.spring_mvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee employee);
    List<Employee> findAllEmployees();
}
