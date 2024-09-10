import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        System.out.println(" Tickets have been stored! ");

        Ticket ticket = ticketService.getTicketById("H890");
        System.out.println("Retrieved Ticket: " + ticket);

        List<Ticket> ticketsFromStadiumSector = ticketService.getTicketsByStadiumSector(Ticket.StadiumSector.A);
        ticketService.printTickets(ticketsFromStadiumSector);

        User client = new Client();
        client.print();
        client.printRole();
        Ticket clientTicket = ((Client)client).getTicket("A123",ticketService);

        User admin = new Admin();
        admin.print();
        admin.printRole();
        boolean isValidTicket = ((Admin)admin).checkTicket(clientTicket);
        System.out.println("Is ticket valid: " + isValidTicket);

        clientTicket.shared("+7775-123");
        clientTicket.shared("+7775-123","tolyaspit@gmail.com");
    }
  
    private Map<String, Ticket> ticketStorage = new HashMap<>();

    public TicketService() {
        ticketStorage.put("A123", new Ticket("A123", "Concert", "123", Ticket.UnixTimePeriod.NIGHT, true, Ticket.StadiumSector.B, 5.5, 99.99));
        ticketStorage.put("B234", new Ticket("B234", "Stadium", "234", Ticket.UnixTimePeriod.AFTERNOON, false, Ticket.StadiumSector.A, 4.0, 75.00));
        ticketStorage.put("C345", new Ticket("C345", "Arena", "345", Ticket.UnixTimePeriod.MORNING, true, Ticket.StadiumSector.C, 3.2, 45.50));
        ticketStorage.put("D456", new Ticket("D456", "Hall", "456", Ticket.UnixTimePeriod.EVENING, false, Ticket.StadiumSector.B, 2.5, 60.00));
        ticketStorage.put("E567", new Ticket("E567", "Theater", "567", Ticket.UnixTimePeriod.NIGHT, true, Ticket.StadiumSector.A, 1.5, 110.75));
        ticketStorage.put("F678", new Ticket("F678", "Concert", "678", Ticket.UnixTimePeriod.AFTERNOON, false, Ticket.StadiumSector.C, 3.0, 80.20));
        ticketStorage.put("G789", new Ticket("G789", "Stadium", "789", Ticket.UnixTimePeriod.MORNING, true, Ticket.StadiumSector.B, 4.3, 95.00));
        ticketStorage.put("H890", new Ticket("H890", "Arena", "890", Ticket.UnixTimePeriod.EVENING, false, Ticket.StadiumSector.A, 2.0, 70.50));
        ticketStorage.put("I901", new Ticket("I901", "Hall", "901", Ticket.UnixTimePeriod.NIGHT, true, Ticket.StadiumSector.C, 5.0, 85.99));
        ticketStorage.put("J012", new Ticket("J012", "Theater", "012", Ticket.UnixTimePeriod.MORNING, false, Ticket.StadiumSector.B, 2.2, 55.00));
    }

    public Ticket getTicketById(String id) {
        Ticket ticket = ticketStorage.get(id);
        if (ticket != null) {
            return ticket;
        } else {
            System.out.println("Ticket with ID " + id + " does not exist.");
            return null;
        }
    }

    private List<Ticket> getTicketsByStadiumSector(Ticket.StadiumSector stadiumSector) {
        List<Ticket> sortedTickets = new ArrayList<>();
        for (Ticket ticket : ticketStorage.values()) {
            if (ticket.getStadiumSector().equals(stadiumSector) ) {
                sortedTickets.add(ticket);
            }
        }
        return sortedTickets;
    }

    private void printTickets(List<Ticket> ticketsFromStadiumSector){
        if (!ticketsFromStadiumSector.isEmpty()) {
            System.out.println("Found tickets:");
            for (Ticket item : ticketsFromStadiumSector) {
                System.out.println(item);
            }
        } else {
            System.out.println("No tickets found for the given stadium sector.");
        }
    }
}