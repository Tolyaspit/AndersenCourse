public class Client extends User{
    @Override
    public void printRole() {
        System.out.println("Role: Client");
    }

    @Override
    public void print() {
        System.out.println("Client details: ");
    }

    public Ticket getTicket(String id, TicketService service){
        Ticket ticket = service.getTicketById(id);
        if (ticket == null) {
            System.out.println("No ticket found with ID: " + id);
        } else {
            System.out.println("Ticket found: " + ticket);
        }
        return ticket;
    }
}
