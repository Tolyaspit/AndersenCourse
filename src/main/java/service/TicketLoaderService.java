package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketLoaderService {

    private Resource ticketJson;

    @Autowired
    public TicketLoaderService(Resource ticketJson) {
        this.ticketJson = ticketJson;
    }

    public List<NewTicket> loadTicketsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            NewTicket[] tickets = objectMapper.readValue(ticketJson.getInputStream(), NewTicket[].class);
            return Arrays.asList(tickets);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
