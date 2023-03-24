package com.revature.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.demo.Model.EmployeeModel;
import com.revature.demo.Service.EmployeeService;

@RestController
public class EmployeeHistoryController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeModel> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

   
    
}
