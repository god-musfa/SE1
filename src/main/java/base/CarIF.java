package base;

public interface CarIF {
    int getNr();
    String getVehicleType();
    String getKundentyp();
    int getSpace();
    Ticket getTicket();
    void setParkplatzNumber(int n);
    Long getTimer();
    String getColor();
    String getLicense();

    String toStringSeperatedBySlash();
}
