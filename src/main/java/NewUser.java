import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class NewUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    public NewUser() {
    }

    public NewUser(String name) {
        this.name = name;
        this.creationDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
