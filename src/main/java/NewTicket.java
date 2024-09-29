import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class NewTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private NewUser user;

    @Column(name = "ticket_type", nullable = false)
    private String ticketType;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    public NewTicket() {
    }

    public NewTicket(NewUser user, String ticketType, LocalDate creationDate) {
        this.user = user;
        this.ticketType = ticketType;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NewUser getUser() {
        return user;
    }

    public void setUser(NewUser user) {
        this.user = user;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "NewTicket{" +
                "id=" + id +
                ", user=" + user +
                ", ticketType='" + ticketType + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
