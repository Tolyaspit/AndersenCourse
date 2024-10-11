package com.andersen.course.controller;

import lombok.RequiredArgsConstructor;
import com.andersen.course.model.NewTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.andersen.course.service.TicketsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class TicketController {
    private TicketsService ticketsService;

    @Autowired
    public TicketController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<NewTicket>> getAllTickets(){
        return new ResponseEntity<>(ticketsService.getAllTickets(), HttpStatus.OK);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<NewTicket> getTicketById(int id){
        NewTicket ticket = ticketsService.getTicketById(id);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tickets")
    public ResponseEntity<NewTicket> addTicket(@RequestPart NewTicket ticket){
        try {
            NewTicket newTicket = ticketsService.addTicket(ticket);
            return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new NewTicket(),HttpStatus.NOT_FOUND);
        }
    }

}
