package multiton;

public abstract class Kundentyp {
    private double gebuehrenfak;

    protected Kundentyp(double gebuehrenfak) {
        this.gebuehrenfak = gebuehrenfak;
    }

    public double getGebuehrenfak() {
        return gebuehrenfak;
    }
}
