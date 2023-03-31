package com.revature.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.demo.Model.EmployeeModel;
import com.revature.demo.Service.EmployeeService;

@RestController
public class EmployeeLoginController {

    //Dependency Injection/implemention of IOC 
    @Autowired
    private EmployeeService employeeService; 

    @PostMapping("/Login")
    public ResponseEntity<String> employeeLogin(@RequestBody EmployeeModel employee)
    {   
        
        String response = employeeService.login(employee);
        HttpStatus status = HttpStatus.OK;

        if (response.startsWith("Unexpected database"))
        {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        else if (response.startsWith("Unexpected error"))
        {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        else if (response.startsWith("Invalid"))
        {
            status = HttpStatus.BAD_REQUEST;
        }
        else 
        {
            status = HttpStatus.ACCEPTED;
        }

        return ResponseEntity.status(status).body(response);

    }
    
}
