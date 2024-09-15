import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TicketValidator {
    public Map<String, String> validate(Ticket ticket) {
        Map<String, String> violations = new HashMap<>();

        if (!isValidTicketType(ticket.getTicketType())) {
            violations.put("ticketType", "Invalid ticket type");
        }
        if (!isValidStartDate(ticket.getStartDate(), ticket.getTicketType())) {
            violations.put("startDate", "Invalid start date");
        }
        if (!isValidPrice(ticket.getPrice())) {
            violations.put("price", "Invalid price");
        }

        return violations;
    }

    private boolean isValidTicketType(String ticketType) {
        List<String> validTypes = Arrays.asList("DAY", "WEEK", "MONTH", "YEAR");
        return ticketType != null && validTypes.contains(ticketType);
    }

    private boolean isValidStartDate(String startDate, String ticketType) {
        if (ticketType == null) {
            return true;
        }
        if (Arrays.asList("DAY", "WEEK", "YEAR").contains(ticketType)) {
            if (startDate == null || startDate.isEmpty()) {
                return false;
            }
            try {
                LocalDate date = LocalDate.parse(startDate);
                return !date.isAfter(LocalDate.now());
            } catch (DateTimeParseException e) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPrice(Integer price) {
        return price != null && price > 0 && price % 2 == 0;
    }
}
