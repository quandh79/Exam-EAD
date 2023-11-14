package com.example.spring_mvc.controller;

import com.example.spring_mvc.entity.Employee;
import com.example.spring_mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/formCreateEmployee")
    public String getFormCreate(ModelMap modelMap){
        String view = "formCreateEmployee";
        try {
            Employee employee= new Employee();
            modelMap.addAttribute("employee", employee);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;

    }

    @PostMapping("createEmployee")
    public String saveCreateOrUpdate(Employee employee){
        String view = "redirect:/employee/findAllEmployees";
        try {
            employeeService.createEmployee(employee);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }

    @GetMapping("/findAllEmployees")
    public String getAll(ModelMap modelMap){
        String view = "listEmployees";
        try {
            List<Employee> employees = employeeService.findAllEmployees();
            modelMap.addAttribute("employees", employees);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }
}
