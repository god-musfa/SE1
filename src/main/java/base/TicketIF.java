package base;

public interface TicketIF {
    double getPrice();
    void setPrice(double price);
    String getTicketID();
    public Long getEnd();
    public void setEnd(long end);
    public long duration();
}
