package com.example.spring_mvc.repository;

import com.example.spring_mvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
