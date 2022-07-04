package base;

public interface CarIF {
    int getNr();
    String getVehicleType();
    String getKundentyp();
    String getSpace();
    Ticket getTicket();
    void setParkplatzNumber(int n);
    int getTimer();
    String getColor();
    String getLicense();

    String toStringSeperatedBySlash();
}
