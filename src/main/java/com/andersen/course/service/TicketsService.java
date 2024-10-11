package com.andersen.course.service;

import com.andersen.course.model.NewTicket;
import org.springframework.beans.factory.annotation.Autowired;
import com.andersen.course.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsService {

    private TicketRepository repo;

    @Autowired
    public TicketsService(TicketRepository repo) {
        this.repo = repo;
    }

    public List<NewTicket> getAllTickets(){
        return repo.findAll();
    }

    public NewTicket getTicketById(int id){
        return repo.findById(id).orElse(new NewTicket());
    }

    public NewTicket addTicket(NewTicket ticket){
        NewTicket newTicket;
        newTicket = repo.save(ticket);
        return newTicket;
    }
}
