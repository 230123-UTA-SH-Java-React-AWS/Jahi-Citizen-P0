package com.revature.demo.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.demo.Model.TicketModel;
import com.revature.demo.Repository.TicketRepository;

@Service
public class TicketService {
    
    //Dependency Injection / IOC 
    @Autowired
    TicketRepository ticketRepo; 

    public String save(TicketModel ticket)
    {
        System.out.println(ticketRepo.findByEmail(ticket.getEmail()));

        try {

            if (ticketRepo.findByEmail(ticket.getEmail()).equals(ticket.getEmail()) && ticketRepo.findByEmail(ticket.getPassword()).equals(ticket.getPassword()))
            {
                if (ticket.getAmount() != -25 && ticket.getDescription() != "null" && ticket.getAmount() > 0)
                {
                    ticketRepo.save(ticket);
                    return "Ticket successfully created!";
                }
                else 
                {
                    return "Either an amount or description was not provided";
                }

            }
            else 
            {
                return "Ticket denied, WRONG EMAIL OR PASSWORD";

            }

        }catch (Exception e) {
            return "Unexpected error, please consult customer service"; 
        }
        


    }
}
