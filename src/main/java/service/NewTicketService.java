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
    private NewUserDAO userDAO;

    private NewTicketDAO ticketDAO;

    @Autowired
    public NewTicketService(NewUserDAO userDAO, NewTicketDAO ticketDAO) {
        this.userDAO = userDAO;
        this.ticketDAO = ticketDAO;
    }

    public void updateUserAndCreateTicket(int userId, String ticketType) {
        NewUser user = userDAO.getUserById(userId);
        if (user != null) {
            NewTicket ticket = new NewTicket(user, ticketType);
            userDAO.updateUserAndCreateTicket(userId, ticket);
        }
    }
}
