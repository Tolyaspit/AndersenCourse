package com.andersen.course.service;

import com.andersen.course.model.NewTicket;
import com.andersen.course.repository.TicketRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.transform.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TicketsServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketsService ticketsService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getAllTickets_PositiveCase() {
        List<NewTicket> tickets = Arrays.asList(new NewTicket(),new NewTicket());
        when(ticketRepository.findAll()).thenReturn(tickets);

        List<NewTicket> result = ticketsService.getAllTickets();

        assertNotNull(result);
        assertEquals(2,result.size());

    }

    @Test
    void getAllTickets_NegativeCase() {
        when(ticketRepository.findAll()).thenReturn(null);

        List<NewTicket> result = ticketsService.getAllTickets();
        assertNull(result);
    }

    @Test
    void getAllTickets_CornerCase() {
        when(ticketRepository.findAll()).thenReturn(Arrays.asList());

        List<NewTicket> result = ticketsService.getAllTickets();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void getTicketById_PositiveCase(){
        NewTicket ticket = new NewTicket();
        when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));

        NewTicket result = ticketsService.getTicketById(1);
        assertNotNull(result);
    }

    @Test
    void getTicketById_NegativeCase(){
        when(ticketRepository.findById(1)).thenReturn(Optional.empty());

        NewTicket result = ticketsService.getTicketById(1);
        assertNotNull(result);
    }

    @Test
    void getTicketById_CornerCase(){
        when(ticketRepository.findById(-1)).thenReturn(Optional.empty());

        NewTicket result = ticketsService.getTicketById(-1);
        assertNotNull(result);
    }
}