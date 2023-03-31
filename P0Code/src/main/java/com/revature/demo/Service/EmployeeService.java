package com.revature.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.demo.Model.EmployeeModel;
import com.revature.demo.Repository.EmployeeRepository;

import com.revature.demo.util.EmailValidator;

@Service
public class EmployeeService {
    
  @Autowired 
  private EmployeeRepository employeeRepository; 

  public List<EmployeeModel> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public String save(EmployeeModel employee)
  {

    if (!EmailValidator.isValidEmail(employee.getEmail()))
    {
        return "Please enter a valid email address";
    }


    try {
        if (employeeRepository.findByEmail(employee.getEmail()) != null) {
            return "Email is already in use";
            
        } else {
            employeeRepository.save(employee);
            return "Success! You have been registered.";
        }
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
}

    public String login(EmployeeModel employeeInput)
    {
        EmployeeModel employee = employeeRepository.findByEmail(employeeInput.getEmail());
        
        try 
        {
            if (employee != null && employee.getPassword().equals(employeeInput.getPassword()))
            {
                return "success, welcome to the portal" + employee.getName() + "!"; 
            }
            else 
            {
                return "Invalid email or password, please try again.";
            }

        }catch (DataAccessException ex) {

            return "Unexpected database error occured. Please contact customer service";

        }catch (Exception e){

            //Handling any errors that occur 
            return "Unexpected error, please consult customer service"; 
        }


       
    }
}

  
    

