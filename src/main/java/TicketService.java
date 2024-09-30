import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        List<Ticket> tickets = ticketService.createTicketsFromPayload();

        ticketService.validateAndProcessTickets(tickets);

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

        CustomArraylist<Integer> list = new CustomArraylist<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Size: " + list.size());

        list.print();

        list.remove(1);
        list.print();

        System.out.println("Size: " + list.size());

        CustomHashSet<String> set = new CustomHashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // check size
        System.out.println("Size: " + set.size());

        // check contained or not
        System.out.println("Contains 'Apple': " + set.contains("Apple"));
        System.out.println("Contains 'Grapes': " + set.contains("Grapes"));

        // iterating
        set.printElements();

        // removing
        set.remove("Banana");
        set.printElements();

        System.out.println("Size: " + set.size());

        SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

        // Create DAO objects
        NewUserDAO newUserDAO = new NewUserDAOImpl(sessionFactory);
        NewTicketDAO newTicketDAO = new NewTicketDAOImpl(sessionFactory);

        // Create and save a new user
        NewUser user = new NewUser();
        user.setName("Ivan An");
        user.setCreationDate(LocalDate.now());
        newUserDAO.saveUser(user);

        // Fetch the saved user to get the assigned ID
        NewUser savedUser = newUserDAO.getUserById(user.getId());
        System.out.println("Saved User: " + savedUser);

        // Create and save a new ticket for this user
        NewTicket newTicket = new NewTicket();
        newTicket.setUser(savedUser);
        newTicket.setTicketType("Default Admission");
        newTicket.setCreationDate(LocalDate.now());
        newTicketDAO.saveTicket(newTicket);

        // Fetch the saved ticket
        NewTicket savedTicket = newTicketDAO.getTicketById(newTicket.getId());
        System.out.println("Saved Ticket: " + savedTicket);

        // Retrieve all users
        List<NewUser> users = newUserDAO.getAllUsers();
        users.forEach(System.out::println);

        // Retrieve all tickets
        List<NewTicket> newTickets = newTicketDAO.getAllTickets();
        newTickets.forEach(System.out::println);

        // Close the session factory
        sessionFactory.close();
    }

    private List<Ticket> createTicketsFromPayload() {
        List<Ticket> tickets = new ArrayList<>();

        tickets.add(new Ticket("CLA", "DAY", "2025-01-01", 0));
        tickets.add(new Ticket("CLA", "DAY", "2025-01-01", 10));
        tickets.add(new Ticket("CLA", "PRIME", null, 1000));
        tickets.add(new Ticket("STD", "DAY", "2025-01-01", 0));
        tickets.add(new Ticket("STD", "WEEK", "2020-01-01", 50));
        tickets.add(new Ticket("CLA", "YEAR", "2020-01-01", 500));
        tickets.add(new Ticket("CLA", "MONTH", "2020-01-01", 100));
        tickets.add(new Ticket("CLA", "DAY", "2020-01-01", 100));
        tickets.add(new Ticket(null, "MONTH", "2020-01-01", 100));
        tickets.add(new Ticket("STD", "MONTH", "2020-01-01", 100));
        tickets.add(new Ticket("STD", null, "2020-01-01", 1000));
        tickets.add(new Ticket("STD", "YEAR", "", 100));
        tickets.add(new Ticket("CLA", "MONTH", "2020-01-01", 99));
        tickets.add(new Ticket("STD", "PRIME", "2020-01-01", 0));
        tickets.add(new Ticket("CLA", "YEAR", null, 100));
        tickets.add(new Ticket("STD", "DAY", "2028-01-01", 100));
        tickets.add(new Ticket("CLA", "DAY", (String) null, 0));

        return tickets;
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

    private void validateAndProcessTickets(List<Ticket> tickets) {
        TicketValidator validator = new TicketValidator();
        int totalTickets = tickets.size();
        int validTickets = 0;
        Map<String, Integer> violationCounts = new HashMap<>();

        for (Ticket ticket : tickets) {
            Map<String, String> violations = validator.validate(ticket);
            if (violations.isEmpty()) {
                validTickets++;
            } else {
                for (String violationType : violations.keySet()) {
                    violationCounts.put(violationType, violationCounts.getOrDefault(violationType, 0) + 1);
                }
            }
        }

        System.out.println("Total = " + totalTickets);
        System.out.println("Valid = " + validTickets);

        String mostPopularViolation = violationCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
        System.out.println("Most popular violation = " + mostPopularViolation);
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