public class Multimedia {

    private double dlugosc;
    private double poczatek;
    private String nazwa;


    public Multimedia(double dlugosc, double poczatek, String nazwa) {
        this.dlugosc = dlugosc;
        this.poczatek = poczatek;
        this.nazwa = nazwa;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public double getPoczatek() {
        return poczatek;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setPoczatek(double poczatek) {
        this.poczatek = poczatek;
    }

    public void setDlugosc(double dlugosc) {
        this.dlugosc = dlugosc;
    }

    @Override
    public String toString()
    {
        return "Multimedia{" +
                "dlugosc=" + dlugosc +
                ", poczatek=" + poczatek +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
