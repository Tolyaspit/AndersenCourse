import java.util.List;

public interface NewTicketDAO {
    void saveTicket(NewTicket ticket);
    NewTicket getTicketById(int id);
    List<NewTicket> getAllTickets();
    void updateTicket(NewTicket ticket);
    void deleteTicket(int id);
}
