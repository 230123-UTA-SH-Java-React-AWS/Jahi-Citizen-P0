package com.revature.demo.util;

//Importing my dependency for using regular expressions in for validation
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidator {

    public static boolean isValidEmail(String email)
    {
        boolean isValid = true; 
        
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException e)
        {
            isValid = false; 
        }

        return isValid; 
    }
    
}
