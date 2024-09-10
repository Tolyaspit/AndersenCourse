public class Admin extends User{
    @Override
    public void printRole() {
        System.out.println("Role: Admin");
    }

    @Override
    public void print() {

    }

    public void checkTicket(Ticket ticket) {
        System.out.println("Checking ticket: " + ticket.getId());
    }
}
