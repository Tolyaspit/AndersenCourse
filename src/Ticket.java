import java.util.Objects;

public class Ticket extends AbstractNumericID{
    private String concertHall;
    private String eventCode;
    private UnixTimePeriod timePeriod;
    @NullableWarning(message = "ID is null in Ticket!")
    private long time;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private double maxAllowedBackpackWeight;
    private double ticketPrice;

    public Ticket(String id,String concertHall, String eventCode, UnixTimePeriod timePeriod, boolean isPromo, StadiumSector stadiumSector, double maxAllowedBackpackWeight, double ticketPrice) {
        super.setId(id);
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.timePeriod = timePeriod;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.ticketPrice = ticketPrice;
        saveCreationTime();
    }

    public Ticket(String id,String concertHall, String eventCode, UnixTimePeriod timePeriod) {
        super.setId(id);
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.timePeriod = timePeriod;
        saveCreationTime();
    }

    public Ticket() {
    }

    public String getConcertHall(String concertHall){
        return  concertHall;
    }

    private void setConcertHall(String concertHall){
        if (concertHall.length() <= 10){
            this.concertHall = concertHall;
        }else {
            throw new IllegalArgumentException("Concert Hall name must be max 10 characters long");
        }
    }

    public String getEventCode(){
        return eventCode;
    }

    private void setEventCode(String eventCode){
        if (eventCode.length() == 3 && eventCode.matches("\\d{3}")){
            this.eventCode = eventCode;
        }else {
            throw new IllegalArgumentException("Event code must be exactly 3 digits");
        }
    }

    public UnixTimePeriod getTimePeriod(){
        return timePeriod;
    }

    public void setTimePeriod(UnixTimePeriod timePeriod){
        this.timePeriod = timePeriod;
    }

    public long getTime(){
        return time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    private void setPromo(boolean promo) {
        isPromo = promo;
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(StadiumSector stadiumSector){
        this.stadiumSector = stadiumSector;
    }

    public double getMaxAllowedBackpackWeight() {
        return maxAllowedBackpackWeight;
    }

    private void setMaxAllowedBackpackWeight(double maxAllowedBackpackWeight) {
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
    }

    public double getPrice() {
        return ticketPrice;
    }

    private void setPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return time == ticket.time && isPromo == ticket.isPromo && Double.compare(maxAllowedBackpackWeight, ticket.maxAllowedBackpackWeight) == 0 && Double.compare(ticketPrice, ticket.ticketPrice) == 0 && Objects.equals(concertHall, ticket.concertHall) && Objects.equals(eventCode, ticket.eventCode) && timePeriod == ticket.timePeriod && stadiumSector == ticket.stadiumSector;
    }

    @Override
    public int hashCode() {
        return Objects.hash(concertHall, eventCode, timePeriod, time, isPromo, stadiumSector, maxAllowedBackpackWeight, ticketPrice);
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

    @Override
    public void print() {
        System.out.println("Ticket: ");
        System.out.println(this.toString());
    }

    private void saveCreationTime() {
        this.time = System.currentTimeMillis() / 1000;
    }
    public enum StadiumSector {
        A, B, C
    }

    public void validateId() {
        if (this.id == null) {
            System.out.println("ID is null in Ticket!");
        }
    }

    public void shared(String phone) {
        System.out.println("Ticket shared by phone: " + phone);
    }

    public void shared(String phone, String email) {
        System.out.println("Ticket shared by phone and email: " + phone + ", " + email);
    }

    public enum UnixTimePeriod{
        MORNING(1693468800),
        AFTERNOON(1693494000),
        EVENING(1693515600),
        NIGHT(1693526400);

        private final long unixTimestamp;

        UnixTimePeriod(long unixTimestamp){
            this.unixTimestamp = unixTimestamp;
        }

        public long getUnixTimestamp(){
            return unixTimestamp;
        }
    }
}