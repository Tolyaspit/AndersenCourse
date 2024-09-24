public class NewTicket {
    private int id;
    private String ticketType;
    private String startDate;
    private double price;

    public NewTicket() {}

    public NewTicket(int id, String ticketType, String startDate, double price) {
        this.id = id;
        this.ticketType = ticketType;
        this.startDate = startDate;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "NewTicket{" +
                "id=" + id +
                ", ticketType='" + ticketType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", price=" + price +
                '}';
    }
}
