import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewUserDAOImpl implements NewUserDAO {
    private static final String INSERT_USER =
            "INSERT INTO User (name, email) VALUES (?, ?)";
    private static final String SELECT_USER_BY_ID =
            "SELECT * FROM User WHERE id = ?";
    private static final String SELECT_ALL_USERS =
            "SELECT * FROM User";
    private static final String UPDATE_USER =
            "UPDATE User SET name = ?, email = ? WHERE id = ?";
    private static final String DELETE_USER =
            "DELETE FROM User WHERE id = ?";

    private Connection connection;

    public NewUserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveUser(NewUser user) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_USER)) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NewUser getUserById(int id) {
        NewUser user = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new NewUser(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<NewUser> getAllUsers() {
        List<NewUser> users = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL_USERS);
            while (rs.next()) {
                users.add(new NewUser(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(NewUser user) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_USER)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_USER)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
