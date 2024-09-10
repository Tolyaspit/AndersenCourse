public class Admin extends User{
    @Override
    public void printRole() {
        System.out.println("Role: Admin");
    }

    @Override
    public void print() {
        System.out.println("Admin details: ");
    }

    public boolean checkTicket(Ticket ticket) {
        if (ticket != null && ticket.getId() != null) {
            System.out.println("Ticket is valid.");
            return true;
        } else {
            System.out.println("Invalid ticket or ticket ID is null.");
            return false;
        }
    }
}
