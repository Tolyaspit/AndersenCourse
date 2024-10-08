package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.NewTicketDAO;
import dao.NewUserDAO;
import model.NewTicket;
import model.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class NewTicketService {
    @Autowired
    private NewUserDAO userDAO;

    @Autowired
    private NewTicketDAO ticketDAO;

    @Autowired
    private Resource ticketJson;

    public void updateUserAndCreateTicket(int userId, String ticketType) {
        NewUser user = userDAO.getUserById(userId);
        if (user != null) {
            NewTicket ticket = new NewTicket(user, ticketType);
            userDAO.updateUserAndCreateTicket(userId, ticket);
        }
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
