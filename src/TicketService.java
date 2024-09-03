public class TicketService {
    public static void main(String[] args) {

        Ticket emptyTicket = new Ticket("", "", "", Ticket.UnixTimePeriod.EVENING, false, Ticket.StadiumSector.A, 0.0, 0.0);
        Ticket fullTicket = new Ticket("A123", "Concert", "123", Ticket.UnixTimePeriod.AFTERNOON,
                true, Ticket.StadiumSector.B, 5.9, 78.99);
        Ticket limitedTicket = new Ticket("Arena", "456", Ticket.UnixTimePeriod.EVENING);

        System.out.println("Empty Ticket: " + emptyTicket);
        System.out.println("Full Ticket: " + fullTicket);
        System.out.println("Limited Ticket: " + limitedTicket);

        System.out.println("Full Ticket Creation Time (seconds since epoch): " + fullTicket.getTime());
    }
}