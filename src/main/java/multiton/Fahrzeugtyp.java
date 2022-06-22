package multiton;

public abstract class Fahrzeugtyp {
    private int flaeche;
    private double gebuehrenfaktor;

    protected Fahrzeugtyp(int flache, double gebuehrenfaktor) {
        this.flaeche = flache;
        this.gebuehrenfaktor = gebuehrenfaktor;
    }
}
