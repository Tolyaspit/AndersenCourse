import java.util.HashMap;
import java.util.Map;

public class TicketService {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        System.out.println(" Tickets have been stored! ");
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
}