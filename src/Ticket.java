public class Ticket {
    private String id;
    private String concertHall;
    private String eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxAllowedBackpackWeight;
    private double ticketPrice;

    public Ticket(String id, String concertHall, String eventCode, long time, boolean isPromo, char stadiumSector, double maxAllowedBackpackWeight, double ticketPrice) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.ticketPrice = ticketPrice;
    }

    public Ticket(String concertHall, String eventCode, long time) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
    }

    public Ticket() {
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        if ((id.length()==4) && id.matches(("[a-zA-Z0-9]{4}"))) {
        this.id = id;
        }else {
            throw new IllegalArgumentException("ID must be exactly 4 digits");
        }
    }

    public String getConcertHall(String concertHall){
        return  concertHall;
    }

    public void setConcertHall(String concertHall){
        if (concertHall.length() <= 10){
            this.concertHall = concertHall;
        }else {
            throw new IllegalArgumentException("Concert Hall name must be max 10 characters long");
        }
    }

    public String getEventCode(){
        return eventCode;
    }

    public void setEventCode(String eventCode){
        if (eventCode.length() == 3 && eventCode.matches("\\d{3}")){
            this.eventCode = eventCode;
        }else {
            throw new IllegalArgumentException("Event code must be exactly 3 digits");
        }
    }

    public long getTime(){
        return time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector){
        if (stadiumSector >= 'A' && stadiumSector <= 'C') {
            this.stadiumSector = stadiumSector;
        } else {
            throw new IllegalArgumentException("Stadium sector must be 'A', 'B', or 'C'");
        }
    }

    public double getMaxAllowedBackpackWeight() {
        return maxAllowedBackpackWeight;
    }

    public void setMaxAllowedBackpackWeight(double maxAllowedBackpackWeight) {
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
    }

    public double getPrice() {
        return ticketPrice;
    }

    public void setPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxAllowedBackpackWeight=" + maxAllowedBackpackWeight +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
