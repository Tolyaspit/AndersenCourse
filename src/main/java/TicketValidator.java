import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TicketValidator {
    public Map<String, String> validate(Ticket ticket) {
        Map<String, String> violations = new HashMap<>();

        if (!isValidTicketType(ticket.getTicketType())) {
            violations.put("ticketType", "Invalid ticket type");
        }
        if (!isValidStartDate(ticket.getStartDate())) {
            violations.put("startDate", "Invalid start date (future date or malformed)");
        }
        if (!isValidPrice(ticket.getPrice())) {
            violations.put("price", "Invalid price (must be even and greater than 0)");
        }

        return violations;
    }

    private boolean isValidTicketType(String ticketType) {
        List<String> validTypes = Arrays.asList("DAY", "WEEK", "MONTH", "YEAR");
        return validTypes.contains(ticketType);
    }

    private boolean isValidStartDate(String startDate) {
        if (startDate == null){
            return false;
        }
        try {
            LocalDate date = LocalDate.parse(startDate);
            return !date.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isValidPrice(int price) {
        return price > 0 && price % 2 == 0;
    }
}
