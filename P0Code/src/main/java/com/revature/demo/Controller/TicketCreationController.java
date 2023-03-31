package com.revature.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.demo.Model.TicketModel;
import com.revature.demo.Service.TicketService;

@RestController
public class TicketCreationController {

    //Dependency injection / IOC example 
    @Autowired
    TicketService ticketServ; 

    @PostMapping("/CreateTicket")
    public ResponseEntity<String> createTicket(@RequestBody TicketModel ticket)
    {
        
        String response = ticketServ.save(ticket);
        HttpStatus status = HttpStatus.OK;

        if (response.startsWith("Unexpected error")) 
        {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        else if (response.startsWith("Ticket denied"))
        {
            status = HttpStatus.BAD_REQUEST;
        }
        else if (response.startsWith("Either an amount"))
        {
            status = HttpStatus.CONFLICT;
        }

        return ResponseEntity.status(status).body(response);
    }
    
}
