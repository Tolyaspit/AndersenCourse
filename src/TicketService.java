public class TicketService {
    public static void main(String[] args) {

        Ticket empty = new Ticket();
        Ticket limited = new Ticket("ConcertHallNum5",234,System.currentTimeMillis());
        Ticket full = new Ticket("5678", "ConcertHallNum4",234,System.currentTimeMillis(),true,'D',8.0,30.0);

        System.out.println(empty);
        System.out.println(limited);
        System.out.println(full);
    }

}
