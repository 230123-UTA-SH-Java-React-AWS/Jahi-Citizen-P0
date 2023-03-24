package com.revature.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeModel {
      //numeric employee identifier 
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      protected int employeeID;

      //fields for the employee class 
      protected String name; 
      @Column(name = "email")
      protected String email;
      protected String userName; 
      protected String password;
      
      
      Role employeeRole = Role.Standard; 
  
      public enum Role
      {
          Standard, 
          Manager, 
          Admin
      }
      public EmployeeModel()
      {
          employeeRole = Role.Standard;
      }
  
     
      
      public int getEmployeeID() {
          return employeeID;
      }
      public void setEmployeeID(int employeeID) {
          this.employeeID = employeeID;
      }
      public String getName() {
          return name;
      }
      public void setName(String name) {
          this.name = name;
      }
      public String getEmail() {
          return email;
      }
      public void setEmail(String email) {
          this.email = email;
      }
      public String getUserName() {
          return userName;
      }
      public void setUserName(String userName) {
          this.userName = userName;
      }
      public String getPassword() {
          return password;
      }
      public void setPassword(String password) {
          this.password = password;
      }
      public Role getEmployeeRole() {
          return employeeRole;
      }
      public void setEmployeeRole(Role employeeRole) {
          this.employeeRole = employeeRole;
      }
      public Object getRole() {
          return null;
      }
    
}
