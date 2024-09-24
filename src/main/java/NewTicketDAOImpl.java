import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewTicketDAOImpl implements NewTicketDAO {
    private static final String INSERT_TICKET =
            "INSERT INTO Ticket (ticket_type, start_date, price) VALUES (?, ?, ?)";
    private static final String SELECT_TICKET_BY_ID =
            "SELECT * FROM Ticket WHERE id = ?";
    private static final String SELECT_ALL_TICKETS =
            "SELECT * FROM Ticket";
    private static final String UPDATE_TICKET =
            "UPDATE Ticket SET ticket_type = ?, start_date = ?, price = ? WHERE id = ?";
    private static final String DELETE_TICKET =
            "DELETE FROM Ticket WHERE id = ?";

    private Connection connection;

    public NewTicketDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveTicket(NewTicket ticket) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_TICKET)) {
            ps.setInt(1, ticket.getId());
            ps.setString(2, ticket.getTicketType());
            ps.setString(3, ticket.getStartDate());
            ps.setDouble(4, ticket.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NewTicket getTicketById(int id) {
        NewTicket ticket = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_TICKET_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ticket = new NewTicket(rs.getInt("id"), rs.getString("ticket_type"),
                        rs.getString("start_date"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public List<NewTicket> getAllTickets() {
        List<NewTicket> tickets = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_TICKETS);
            while (rs.next()) {
                tickets.add(new NewTicket(rs.getInt("id"), rs.getString("ticket_type"),
                        rs.getString("start_date"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public void updateTicket(NewTicket ticket) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_TICKET)) {
            ps.setString(1, ticket.getTicketType());
            ps.setString(2, ticket.getStartDate());
            ps.setDouble(3, ticket.getPrice());
            ps.setInt(4, ticket.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicket(int id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_TICKET)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
