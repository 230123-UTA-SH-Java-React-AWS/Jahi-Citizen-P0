package com.revature.demo.Repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.demo.Model.TicketModel;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, Integer> {
    
    TicketModel findByEmail(String email);
}
