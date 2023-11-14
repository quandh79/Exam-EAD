package com.example.spring_mvc.service.implement;

import com.example.spring_mvc.entity.Employee;
import com.example.spring_mvc.repository.EmployeeRepository;
import com.example.spring_mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void createEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
