import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewTicketDAOImpl implements NewTicketDAO {

    private Connection connection;

    public NewTicketDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveTicket(NewTicket ticket) {
        final String sql = "INSERT INTO Ticket (id, ticket_type, start_date, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        final String sql = "SELECT * FROM Ticket WHERE id = ?";
        NewTicket ticket = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        final String sql = "SELECT * FROM Ticket";
        List<NewTicket> tickets = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
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
        final String sql = "UPDATE Ticket SET ticket_type = ?, start_date = ?, price = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        final String sql = "DELETE FROM Ticket WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
