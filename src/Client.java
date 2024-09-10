public class Client extends User{
    @Override
    public void printRole() {
        System.out.println("Role: Client");
    }

    @Override
    public void print() {
    }

    public Ticket getTicket(String id, TicketService service){
        return service.getTicketById(id);
    }
}
