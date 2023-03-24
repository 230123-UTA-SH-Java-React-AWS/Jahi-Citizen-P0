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
public class EmployRegistrationController {

    //Dependency injection 
    @Autowired
    private EmployeeService employeeService; 

    @PostMapping("/Registration")
    public ResponseEntity<String> register(@RequestBody EmployeeModel employee )
    {
        String response = employeeService.save(employee);
        HttpStatus status = HttpStatus.OK;

        if (response.startsWith("Error:")) 
        {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        else if (response.startsWith("Please enter"))
        {
            status = HttpStatus.BAD_REQUEST;
        }
        else if (response.startsWith("Email is already"))
        {
            status = HttpStatus.CONFLICT;
        }

        return ResponseEntity.status(status).body(response);

    }
}
