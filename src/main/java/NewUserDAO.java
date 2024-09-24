import java.util.List;

public interface NewUserDAO {
    void saveUser(NewUser user);
    NewUser getUserById(int id);
    List<NewUser> getAllUsers();
    void updateUser(NewUser user);
    void deleteUser(int id);
}
