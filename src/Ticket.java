public class Ticket {
    private String id;
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxAllowedBackpackWeight;
    private double ticketPrice;

    public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, double maxAllowedBackpackWeight, double ticketPrice) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.ticketPrice = ticketPrice;
    }

    public Ticket(String concertHall, int eventCode, long time) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
    }

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxAllowedBackpackWeight=" + maxAllowedBackpackWeight +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
